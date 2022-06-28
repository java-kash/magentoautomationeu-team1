package com.unitedcoder.magentoautomationtest.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
     public static WebDriver driver;
     public static String browserName="chrome";


     public static void browserSetUp(String url){
         if((driver)==null){
             if(browserName.equalsIgnoreCase("Chrome")){
                 WebDriverManager.chromedriver().setup();
                 driver=new ChromeDriver();
                 driver.manage().window().maximize();
                 driver.get(url);
             }else if (browserName.equalsIgnoreCase("FireFox")){
                 WebDriverManager.firefoxdriver().setup();
                 driver=new FirefoxDriver();
                 driver.manage().window().maximize();
                 driver.get(url);
             }
         }
     }
     public static void closeBrowser(){
         driver.close();
         driver.quit();
     }
    public static String readFromConfigProperties(String fileName, String key) {
        Properties properties=new Properties();
        String workingDirectory=System.getProperty("user.dir");
        String value;
        try {
            properties.load(new FileInputStream(workingDirectory+ File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        value=properties.getProperty(key);
        System.out.println(String.format("%s=%s",key,value));
        return value;
    }



    }

