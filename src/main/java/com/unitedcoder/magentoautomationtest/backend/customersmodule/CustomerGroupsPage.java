package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerGroupsPage {
    WebDriver driver;
    FunctionPage functionPage;
    String config="config-qa.properties";

    public CustomerGroupsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "(//div[@class='content-header']//button)[1]")
    WebElement addNewCustomerGroupLink;

    @FindBy(css = "#customer_group_code")
    WebElement customerGroupNameField;

    @FindBy(css = "#tax_class_id")
    WebElement taxClassDropDown;




    public void clickOnAddCustomerGroupButton(){
        functionPage.waitForElement(addNewCustomerGroupLink);
        addNewCustomerGroupLink.click();
    }
    public void clickOnCustomerGroupNameField(){
        functionPage.waitForElement(customerGroupNameField);
        customerGroupNameField.sendKeys(config,"master");
    }
}


