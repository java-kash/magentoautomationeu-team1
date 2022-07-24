package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class EditCustomerPage {
    WebDriver driver;
    FunctionPage functionPage;
    @FindBy(xpath = "//a[@id='customer_info_tabs_account' and @class='tab-item-link'][1]")
    WebElement accountInformation;
    @FindBy(xpath = "//input[@id='_accountmiddlename'][1]")
    WebElement middleNameField;
    @FindBy(xpath = "//div[@id='anchor-content']//p/button[4]")
    WebElement saveButton;
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement successMessages;
    @FindBy(id = "customerGrid_massaction-select")
    WebElement actionsSelect;
    @FindBy(xpath = "//*[@title='Submit']")
    WebElement submitButton;
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailAddressFilter;
    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@name='customer']")
    WebElement checkBox;
    @FindBy(xpath = "//span[contains(text(),'were deleted.')]")
    WebElement deleteSuccessMessage;



    public EditCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }


    public boolean editCustomerInformation(String middleName){
        functionPage.waitForElement(accountInformation);
        accountInformation.click();
        functionPage.waitForElement(middleNameField);
        middleNameField.clear();
        middleNameField.sendKeys(middleName);
        functionPage.waitForElement(saveButton);
        saveButton.click();
        functionPage.sleep(3);

        functionPage.waitForElement(successMessages);
        if(successMessages.isDisplayed()){
            return true;

        }else
            return false;
    }
    public void deleteCustomer(String customerEmail){
//        String test=testElement.get(1).getText();
//        String[] test2=test.split("\\s+");
//        System.out.println(test2[4]);
//        int checkBoxSize=customerCheckBox.size();
//        System.out.println(checkBoxSize);
        functionPage.waitForElement(emailAddressFilter);
        emailAddressFilter.clear();
        emailAddressFilter.click();
        emailAddressFilter.sendKeys(customerEmail);
        functionPage.waitForElement(searchButton);
        searchButton.click();
        functionPage.sleep(3);
        functionPage.waitForElement(checkBox);
        checkBox.click();
        Select select=new Select(actionsSelect);
        functionPage.waitForElement(actionsSelect);
        actionsSelect.click();
        select.selectByVisibleText(CustomerDropDownSelect.Delete.name());
        functionPage.waitForElement(submitButton);
        submitButton.click();
        functionPage.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public boolean deleteVerify(){
        functionPage.waitForElement(deleteSuccessMessage);
        if(deleteSuccessMessage.isDisplayed()){
            return true;
        }
        return false;

    }
}
