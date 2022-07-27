package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsSalesRefundsPage {
    WebDriver driver;
    FunctionPage functionPage;
    ReportingModuleDashBoard dashBoard;

    public ReportsSalesRefundsPage(WebDriver driver) {
        this.driver = driver;
        functionPage=new FunctionPage(driver);
        dashBoard=new ReportingModuleDashBoard(driver);
    }
    @FindBy(css = "#sales_report_from")
    WebElement fromDateBox;
    @FindBy(css= "#sales_report_to")
    WebElement toDateBox;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;
    @FindBy(css = ".data>tbody")
    WebElement orderReportTable;

    public boolean refundedReportIsVisible(String fromDate,String toDate){
        dashBoard.openRefundsPage();
        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(fromDate);
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(toDate);
        functionPage.waitForElement(showReportButton);
        showReportButton.click();
        functionPage.waitForElement(orderReportTable);
        if (orderReportTable.isDisplayed()){
            return true;
        }else
            return false;
    }
}
