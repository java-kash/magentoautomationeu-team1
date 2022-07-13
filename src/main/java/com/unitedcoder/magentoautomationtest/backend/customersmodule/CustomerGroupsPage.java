package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestDataHolder;
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
    WebElement addNewCustomerGroupButton;
    @FindBy(css = "#customer_group_code")
    WebElement groupNameField;
    @FindBy(css = "#tax_class_id")
    WebElement taxClassDropDown;
    @FindBy(xpath = "(//button[@class='scalable save']/span/span/span)[1]")
    WebElement saveCustomerGroupButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessage;
    @FindBy(xpath = "(//button[@class='scalable delete']/span/span/span)[1]")
    WebElement deleteCustomerGroupButton;

    public void clickOnAddNewCustomerGroup(TestDataHolder testDataHolder){
        functionPage.waitForElement(addNewCustomerGroupButton);
        addNewCustomerGroupButton.click();
        functionPage.waitForElement(groupNameField);
        groupNameField.sendKeys(testDataHolder.getCustomerGroupName());
        functionPage.waitForElement(taxClassDropDown);
        taxClassDropDown.click();
        Select select=new Select(taxClassDropDown);
        select.selectByIndex(2);
        functionPage.waitForElement(saveCustomerGroupButton);
        saveCustomerGroupButton.click();

    }
    public boolean verifyAddNewCustomerGroups(){
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")){
            return true;

        }else
            return false;

    }
    public void updateExistingCustomerGroups(TestDataHolder testDataHolder){
        WebElement existingGroupName=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",
                testDataHolder.getCustomerGroupName())));
        functionPage.waitForElement(existingGroupName);
        existingGroupName.click();
        functionPage.waitForElement(taxClassDropDown);
        taxClassDropDown.click();
        Select select=new Select(taxClassDropDown);
        select.selectByIndex(3);
        functionPage.waitForElement(saveCustomerGroupButton);
        saveCustomerGroupButton.click();

    }
    public boolean verifyUpdateExistingCustomerGroups(){
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")){
            return true;
        }else
            return false;
    }
    public void deleteExitingCustomerGroups(TestDataHolder testDataHolder){
        WebElement existingGroupName=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",
                testDataHolder.getCustomerGroupName())));
        functionPage.waitForElement(existingGroupName);
        existingGroupName.click();
        functionPage.waitForElement(deleteCustomerGroupButton);
        deleteCustomerGroupButton.click();
        functionPage.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    public boolean verifyDeleteExistingCustomerGroups(){
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("deleted")){
            return true;
        }else
            return false;
    }

}
