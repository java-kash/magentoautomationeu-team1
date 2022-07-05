package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

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
    @FindBy(id = "customerGrid_massaction-select")
    WebElement actionsSelect;
    @FindBy(xpath = "//*[@title='Submit']")
    WebElement submitButton;
    @FindAll(
            @FindBy(css = ".massaction-checkbox"))
    List<WebElement> customerCheckBox;
    @FindAll(
            @FindBy(xpath = "//div[@class='hor-scroll']//tbody/tr"))
    List<WebElement> testElement;

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
    public void deleteCustomer(){
//        String test=testElement.get(1).getText();
//        String[] test2=test.split("\\s+");
//        System.out.println(test2[4]);
//        int checkBoxSize=customerCheckBox.size();
//        System.out.println(checkBoxSize);

        for (int i=0;i<3;i++){
            WebElement customer=customerCheckBox.get(i);
            functionPage.waitForElement(customer);
            customer.click();

        }



//        functionPage.waitForElement(firstListCustomer);
//        firstListCustomer.click();

        Select select=new Select(actionsSelect);
        functionPage.waitForElement(actionsSelect);
        actionsSelect.click();
        select.selectByVisibleText(CustomerDropDownSelect.Delete.name());
        functionPage.waitForElement(submitButton);
        submitButton.click();



    }
}
