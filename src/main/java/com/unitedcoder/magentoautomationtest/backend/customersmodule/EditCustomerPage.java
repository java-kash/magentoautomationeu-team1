package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
    WebDriver driver;
    FunctionPage functionPage;
    @FindBy(xpath = "//a[@id='customer_info_tabs_account' and @class='tab-item-link'][1]")
    WebElement accountInformation;
    @FindBy(xpath = "//input[@id='_accountmiddlename'][1]")
    WebElement middleNameField;
    @FindBy(xpath = "//*[text()='Save and Continue Edit'][1]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement successMessages;
    public EditCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    public boolean editCustomerInformation(){
        functionPage.waitForElement(accountInformation);
        accountInformation.click();
        functionPage.waitForElement(middleNameField);
        middleNameField.clear();
        middleNameField.sendKeys(functionPage.generateMiddleName());
        functionPage.waitForElement(saveAndContinueButton);
        saveAndContinueButton.click();

        functionPage.waitForElement(successMessages);
        if(successMessages.isDisplayed()){
            Log4j.info("Edit Customer");
            return true;

        }else
            Log4j.error("Edit Customer");
            return false;
    }
}
