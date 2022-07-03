package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {
    WebDriver driver;
    FunctionPage functionPage;

    public AccountInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy( xpath ="//*[@class='legend']")
     WebElement pageTitle;
    public boolean verifypage(){
        functionPage.waitForElement(pageTitle);
        if (pageTitle.isEnabled()){
            Log4j.info("Account Information is display");
            return true;
        }
        else{
            Log4j.error("Account Information not display");
            return false;
        }
    }






}
