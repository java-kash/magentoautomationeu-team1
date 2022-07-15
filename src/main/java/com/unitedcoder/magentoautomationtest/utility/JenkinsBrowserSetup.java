package com.unitedcoder.magentoautomationtest.utility;


import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Locale;

public class JenkinsBrowserSetup {
    public boolean serHeadlessModelIfLinux(ChromeOptions chromeOptions){
        System.out.println("User is Linux");
        String osname=System.getProperty("os.name");
        if(osname.toLowerCase().contains("linux")){
            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
            System.out.println("Using headless browser mode");
            chromeOptions.addArguments(Arrays.asList("--headless","--disable-gpu"));
            chromeOptions.addArguments("window-size=1200,1100");
            return true;
        }
        else
            return false;
    }
}
