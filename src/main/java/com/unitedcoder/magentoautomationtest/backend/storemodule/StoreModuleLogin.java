package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreModuleLogin {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";

    public StoreModuleLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(css="#username")
    WebElement usernameField;
    @FindBy(css = "#login")
    WebElement passwordField;
    @FindBy(css = ".form-button")
    WebElement loginButton;
    @FindBy(css = ".link-logout")
    WebElement logOutButton;

    public boolean verifyLoginPageOpened() {
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public void login(){
        functionPage.waitForElement(usernameField);
        usernameField.click();
        usernameField.sendKeys(TestBase.readFromConfigProperties(configFile,"store_username"));
        functionPage.waitForElement(passwordField);
        passwordField.click();
        passwordField.sendKeys(TestBase.readFromConfigProperties(configFile,"store_password"));
        functionPage.waitForElement(loginButton);
        loginButton.click();
    }
public boolean verifyLogin(){
        functionPage.waitForElement(logOutButton);
        if(logOutButton.isDisplayed()){
            return true;
        }else
            return false;
}

}
