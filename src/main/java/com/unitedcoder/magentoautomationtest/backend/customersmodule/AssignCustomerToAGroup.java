package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignCustomerToAGroup {
    WebDriver driver;
    FunctionPage functionPage;

    public AssignCustomerToAGroup(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(xpath="//*[@id=\"customerGrid_massaction-select\"]/option[5] ")
    WebElement assignACustomerGroupOptions;

    @FindBy(xpath="//*[@id=\"visibility\"]/option[3]")
    WebElement groupListOptions;

    @FindBy(xpath="//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement checkBoxButton;

    @FindBy(xpath="//*[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath="//*[@id=\"messages\"]/ul/li")
    WebElement successMessage;

    public void assignGroup(){
        functionPage.waitForElement(assignACustomerGroupOptions);
        assignACustomerGroupOptions.click();
        functionPage.waitForElement(groupListOptions);
        groupListOptions.click();
        functionPage.waitForElement(checkBoxButton);
        checkBoxButton.click();
        functionPage.waitForElement(submitButton);
        submitButton.click();
    }
    public boolean verifyAssignCustomerToAGroup(){
        functionPage.waitForElement(successMessage);
        if(successMessage.isDisplayed()){
            return true;
        }else
            return false;
    }
}
