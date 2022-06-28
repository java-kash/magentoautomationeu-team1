package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
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

    public boolean verifyLoginPageOpened() {
        functionPage.waitForElement(loginButton);
        if (loginButton.isDisplayed()) {
            System.out.println("login ok");
            return true;
        } else {
            System.out.println("Logen not ok");
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
}
