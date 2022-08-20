package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomersBynumberOfOrders {

    WebDriver driver;
    FunctionPage functionPage;
    ReportingModuleDashBoard dashBoard;

    public CustomersBynumberOfOrders(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        dashBoard = new ReportingModuleDashBoard(driver);
    }

//    @FindBy(xpath = "//span[text()='Reports']")
//    WebElement reportsLink;
//
//    @FindBy(xpath = "(//span[text()='Customers'])[1]")
//    WebElement CustomersLink;
//    @FindBy(xpath = "//span[text()='Customers by number of orders']")
//    WebElement numOfOrdersLink;

    @FindBy(css = "input[id=\"period_date_from\"]")
    WebElement fromDateBox;
    @FindBy(css = "input[id=\"period_date_to\"]")
    WebElement toDateBox;

    @FindBy(xpath = "//span[text()='Refresh']")
    WebElement refreshBtn;

    @FindAll(@FindBy (css = ".data>tbody>tr"))
    List<WebElement> customersOrderedReportTable;

    public void showReportsOfCustomers(String fromDate,String toDate){


        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(fromDate);
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(toDate);
//
        functionPage.clickWithJS(refreshBtn);
//
    }

    public boolean verifyCustomersByNumberOfOrdered(){
        if (customersOrderedReportTable.size()>0)
            return true;
        else
            return false;
    }











}
