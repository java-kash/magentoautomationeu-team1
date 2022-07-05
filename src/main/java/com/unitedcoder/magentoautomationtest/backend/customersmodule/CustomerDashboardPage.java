package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CustomerDashboardPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public CustomerDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
    }
    @FindBy(css = "(//span[text()='Add New Customer'])[1]")
    WebElement aadNewCustomerButton;

    @FindBy(xpath ="//span[text()='Customers']" )
    WebElement CustomersLink;

    @FindBy(xpath ="//span[text()='Manage Customers']")
    WebElement manageCustomersLink;

    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;

    @FindBy(xpath = "//span[text()='Online Customers']")
    WebElement onlineCustomersLink;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement ReportsLink;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesLink;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsLink;

    @FindBy(xpath = "//img[@alt='Magento Logo']")
    WebElement customerMagentoDashboard;
    @FindBy(id = "anchor-content")
    WebElement manageCustomersTable;
    @FindAll(
        @FindBy(xpath = "//a[text()='Edit']")
    )
    List<WebElement> cutomerEditIcon;
    @FindBy(xpath = "//*[text()='Customer Information'][1]")
    WebElement editPageTitle;

    //kerim
    @FindBy(xpath ="//a[text()='Select All']")
    WebElement SelectAll;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportBtn;
    public void exportCustomers(){
        functionPage.waitForElement(SelectAll);
        SelectAll.click();
        functionPage.waitForElement(exportBtn);
        exportBtn.click();

    }
    public boolean verifyExportCustpmers(){
        if(exportBtn.isEnabled()){
            return true;
        }
        else
            return false;
    }

    public void clickOnAddNewCustomerButton(){
        functionPage.waitForElement(aadNewCustomerButton);
        aadNewCustomerButton.click();
    }
    public boolean clickOnMagentoLogoBackDashboard(){
        functionPage.waitForElement(customerMagentoDashboard);
        customerMagentoDashboard.click();
        functionPage.waitForElement(manageCustomersTable);
        if(manageCustomersTable.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void clickCustomerGroupsLink(){
        functionPage.waitForElement(CustomersLink);
        actions.moveToElement(CustomersLink).perform();
        functionPage.waitForElement(customerGroupsLink);
        customerGroupsLink.click();

        }

    // i need verify Add
    public boolean clickOnCustomerEditIcon() {
        WebElement firstListCustomer = cutomerEditIcon.get(1);
        functionPage.waitForElement(firstListCustomer);
        firstListCustomer.click();
        if (editPageTitle.isDisplayed()) {
            return true;
        } else
            return false;
    }


            }
