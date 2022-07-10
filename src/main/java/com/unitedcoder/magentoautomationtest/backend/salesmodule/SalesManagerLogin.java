package com.unitedcoder.magentoautomationtest.backend.salesmodule;


import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesManagerLogin {
WebDriver driver;
FunctionPage functionPage;
String configFile="config-qa.properties";

    public SalesManagerLogin(WebDriver driver) {
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
    WebElement logoutButton;
    public void login(String username,String password){
       functionPage.waitForElement(usernameField);
       usernameField.sendKeys(username);
       functionPage.waitForElement(passwordField);
       passwordField.sendKeys(password);
       functionPage.waitForElement(loginButton);
       loginButton.click();
    }
    public boolean verifyLogin(){
        functionPage.waitForElement(logoutButton);
        if (logoutButton.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void logout(){
        functionPage.waitForElement(logoutButton);
        logoutButton.click();
    }
}
