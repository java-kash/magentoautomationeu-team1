package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupsPage {

   WebDriver driver;
   FunctionPage functionPage;

    public CustomerGroupsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    @FindBy(xpath = "(//div[@class='content-header']//button)[1]")
    WebElement addNewCustomerGroupLink;

    @FindBy(css = "#customer_group_code")
    WebElement customerGroupNameField;

    @FindBy(css = "#tax_class_id")
    WebElement taxClassDropDown;

    @FindBy(xpath = "(//button[@class='scalable save']/span/span/span)[1]")
    WebElement saveCustomerGroupsButton;

    @FindBy(xpath ="//span[text()='The customer group has been saved.']")
    WebElement successMessage;

    @FindBy(xpath = "(//button[@class='scalable delete']/span/span/span)[1]")
    WebElement deleteCustomerGroupButton;



    public void clickOnAddNewCustomerGroupButton(){
        functionPage.waitForElement(addNewCustomerGroupLink);
        addNewCustomerGroupLink.click();
    }
    public void clickOnCustomerGroupNameField(TestHelper testHelper){
        functionPage.waitForElement(customerGroupNameField);
        customerGroupNameField.sendKeys(testHelper.getCustomerGroupName());
    }
    public void clickOnTexClassDropDown(){
        functionPage.waitForElement(taxClassDropDown);
        taxClassDropDown.click();
    }
    public void selectTexClassDropDownList(int index){
       Select select=new Select(taxClassDropDown);
        select.selectByIndex(index);

    }
    public void clickOnSaveCustomerGroupsButton(){
        functionPage.waitForElement(saveCustomerGroupsButton);
        saveCustomerGroupsButton.click();

    }

    public void addNewCustomerGroups(TestHelper testHelper){
        clickOnAddNewCustomerGroupButton();
        clickOnCustomerGroupNameField(testHelper);
        clickOnTexClassDropDown();
        selectTexClassDropDownList(2);
        clickOnSaveCustomerGroupsButton();

    }
    public void clickOnExistingCustomerGroup(TestHelper testHelper){
        WebElement existingGroupName=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",testHelper.getCustomerGroupName())));
        functionPage.waitForElement(existingGroupName);
        existingGroupName.click();
    }
    public void clickOnDeleteCustomerGroupButton() {
        functionPage.waitForElement(deleteCustomerGroupButton);
        deleteCustomerGroupButton.click();
        functionPage.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyAddNewCustomerGroups(){
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")){
            System.out.println("Customer Manager Add New Customer Groups Test Passed!");
            return true;
        }else {
            System.out.println("Customer Manager Add New Customer Groups Test Failed!");
            return false;
        }
    }
    public void updateExistingCustomerGroups(TestHelper testHelper) {
        clickOnExistingCustomerGroup(testHelper);
        clickOnTexClassDropDown();
        selectTexClassDropDownList(2);
       clickOnSaveCustomerGroupsButton();
    }

    public boolean verifyUpdateExistingCustomerGroups() {
      functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")) {
            System.out.println("Customer Manager update existing customer groups Test Passed! ");
            return true;
        } else {
            System.out.println("Customer Manager update existing customer groups Test Failed! ");
            return false;
        }
    }

    public void deleteExistingCustomerGroups(TestHelper testHelper) {
        clickOnExistingCustomerGroup(testHelper);
        clickOnDeleteCustomerGroupButton();
    }

    public boolean verifyDeleteExistingCustomerGroups() {
       functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("deleted")) {
            System.out.println("Customer Manager delete existing customer groups Test Passed! ");
            return true;
        } else {
            System.out.println("Customer Manager delete existing customer groups Test Failed! ");
            return false;
        }
    }
}



