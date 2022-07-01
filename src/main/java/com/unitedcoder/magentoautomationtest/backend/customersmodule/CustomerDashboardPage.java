package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {
    WebDriver driver;
    FunctionPage functionPage;

    public CustomerDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

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



}
