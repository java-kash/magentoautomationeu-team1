package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagerLogin {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";

    @FindBy(css = "#username")
    WebElement usernameField;
    @FindBy(css = "#login")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;

    public CustomerManagerLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    public boolean verifyLoginPageOpened(){
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()){

        }
        return true;
    }
    public void login(){
        functionPage.waitForElement(usernameField);
        usernameField.click();
        usernameField.sendKeys(configFile,"customer_username");
        functionPage.waitForElement(passwordField);
        passwordField.click();
        passwordField.sendKeys(configFile,"customer_password");
        functionPage.waitForElement(loginButton);
        loginButton.click();
    }
}
