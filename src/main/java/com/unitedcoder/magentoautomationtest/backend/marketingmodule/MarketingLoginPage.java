package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MarketingLoginPage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";


    public MarketingLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "login")
    WebElement passwordField;
    @FindBy(css = ".form-button")
    WebElement loginButton;
    @FindBy(css = ".link-logout")
    WebElement logOutButton;

    public void login(){
        functionPage.waitForElement(usernameField);
        usernameField.sendKeys(readFromConfigProperties(configFile,"marketing_username"));
        functionPage.waitForElement(passwordField);
        passwordField.sendKeys(readFromConfigProperties(configFile,"marketing_password"));
        functionPage.waitForElement(loginButton);
        loginButton.click();
    }
    public boolean verify(){
        functionPage.waitForElement(logOutButton);
        if(logOutButton.isDisplayed()){
            Log4j.info("Login ");
            return true;
        }
        Log4j.error("Login");
           return false;



    }
}
