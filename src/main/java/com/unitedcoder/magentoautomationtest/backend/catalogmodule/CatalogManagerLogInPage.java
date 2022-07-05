package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogManagerLogInPage {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";

    public CatalogManagerLogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(css = "#login")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;
    @FindBy(css = ".link-logout")
    WebElement logOutButton;

    public boolean verifyLoginPageOpened() {
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()) {
            Log4j.info("Login Page Opened Successfully");
            return true;
        } else {
            Log4j.error("Login Page Opened Fail");
            return false;
        }
    }

    public boolean login() {
        functionPage.waitForElement(usernameField);
        usernameField.click();
        usernameField.sendKeys(TestBase.readFromConfigProperties(configFile,"catalog_username"));
        functionPage.waitForElement(passwordField);
        passwordField.click();
        passwordField.sendKeys(TestBase.readFromConfigProperties(configFile,"catalog_password"));
        functionPage.waitForElement(loginButton);
        loginButton.click();
        functionPage.waitForElement(logOutButton);
        if (logOutButton.isDisplayed()){
            Log4j.info("Admin Panel Opened Successfully");
            return true;
        }else
            Log4j.error("Admin Panel Failed to open");
        return false;

    }
}