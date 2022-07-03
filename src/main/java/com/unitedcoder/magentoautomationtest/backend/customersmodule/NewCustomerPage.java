package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(id="_accountfirstname")
    WebElement firstName;

    @FindBy(id = "_accountlastname")
    WebElement lastName;

    @FindBy(id="_accountemail")
    WebElement emailField;

    @FindBy(id = "_accountpassword")
    WebElement managementPassword;

    @FindBy(xpath = " //div[@id='anchor-content']//p/button[3]")
    WebElement saveButton;
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement successfullyMessages;

    public void addNewCustomerPage(){
        functionPage.waitForElement(firstName);
        firstName.click();
        firstName.sendKeys(functionPage.generateFirstName());
        functionPage.waitForElement(lastName);
        lastName.click();
        lastName.sendKeys(functionPage.generateLastName());
        functionPage.waitForElement(emailField);
        emailField.click();
        emailField.sendKeys(functionPage.generateEmail());
        functionPage.waitForElement(managementPassword);
        managementPassword.click();
        managementPassword.sendKeys( TestBase.readFromConfigProperties(configFile,"customer_password"));
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }
    public boolean verifyAddNewCustomer(){
         functionPage.waitForElement(successfullyMessages);
        if (successfullyMessages.isDisplayed()){
            return true;
        }else
            return false;

    }
}
