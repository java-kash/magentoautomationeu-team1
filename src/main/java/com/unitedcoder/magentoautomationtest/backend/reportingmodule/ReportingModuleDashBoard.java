package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingModuleDashBoard {
    WebDriver driver;
    FunctionPage functionPage;

    public ReportingModuleDashBoard(WebDriver driver) {
        this.driver = driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsLink;
    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesLink;
    @FindBy(xpath = "//span[text()='Orders']")
    WebElement ordersLink;
    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement refundsLink;


    public void openOrdersPage(){
        functionPage.waitForElement(reportsLink);

        functionPage.waitForElement(salesLink);

        functionPage.waitForElement(ordersLink);


    }

}
