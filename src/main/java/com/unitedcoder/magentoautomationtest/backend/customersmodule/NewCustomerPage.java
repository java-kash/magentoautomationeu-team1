package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import com.unitedcoder.magentoautomationtest.utility.TestDataHolder;
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
    WebElement firstNameField;

    @FindBy(id = "_accountlastname")
    WebElement lastNameField;

    @FindBy(id="_accountemail")
    WebElement emailField;

    @FindBy(id = "_accountpassword")
    WebElement managementPassword;

    @FindBy(xpath = " //div[@id='anchor-content']//p/button[3]")
    WebElement saveButton;
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement successfullyMessages;

    public void addNewCustomerPage(String firstName,String lastName,String emailAddress){
        functionPage.waitForElement(firstNameField);
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        functionPage.waitForElement(lastNameField);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        functionPage.waitForElement(emailField);
        emailField.click();
        emailField.sendKeys(emailAddress);
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
