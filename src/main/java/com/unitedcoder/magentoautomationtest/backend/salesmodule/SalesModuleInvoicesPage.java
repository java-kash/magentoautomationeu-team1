package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesModuleInvoicesPage {
    WebDriver driver;
    FunctionPage functionPage;

    public SalesModuleInvoicesPage(WebDriver driver) {
        this.driver = driver;
    PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    @FindBy(xpath = "(//a[text()='View'])[1]")
    WebElement InvoicesViewIcon;
    @FindBy(xpath = "(//*[text()='Sales'])[1]")
    WebElement salesTeb;
    @FindBy(xpath = "//*[text()='Invoices']")
    WebElement invoicesOption;


}
