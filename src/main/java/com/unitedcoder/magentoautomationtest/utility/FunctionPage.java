package com.unitedcoder.magentoautomationtest.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class FunctionPage {
    WebDriver driver;
    static  String  configFile="config-qa.properties";
    public static int timeout=Integer.parseInt(TestBase.readFromConfigProperties(configFile,"timeout"));

    public FunctionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
