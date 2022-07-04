package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublicLogin {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    public PublicLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(css = ".skip-link.skip-account")
    WebElement accountButton;

    @FindBy(xpath = "//a[@title='Log In']")
    WebElement loginLink;

    @FindBy(css = "#email")
    WebElement emailAddressField;

    @FindBy(css = "#pass")
    WebElement passWordField;
    @FindBy(css = "#send2")
    WebElement loginButton;
    @FindBy(xpath = "//a[text()='Log Out']")
    WebElement logOutButton;

    public boolean verifyLoginPageOpened() {
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()) {

            Log4j.info("Login page Opened Successfully");
            return true;
        } else {
            Log4j.error("Login page Opened Fail");
            return false;
        }
    }
    public void login(){
        functionPage.waitForElement(accountButton);
        accountButton.click();
        functionPage.waitForElement(loginLink);
        loginLink.click();
        verifyLoginPageOpened();
        functionPage.waitForElement(emailAddressField);
        emailAddressField.sendKeys(TestBase.readFromConfigProperties(configFile,"public_userEmail"));
        functionPage.waitForElement(passWordField);
        passWordField.sendKeys(TestBase.readFromConfigProperties(configFile,"public_password"));
        functionPage.waitForElement(loginButton);
        loginButton.click();
    }
    // I need verify
    public boolean logOut(){
        functionPage.waitForElement(accountButton);
        accountButton.click();
        functionPage.waitForElement(logOutButton);
        logOutButton.click();
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()){
            return true;
        }else
            return false;
        }

}
