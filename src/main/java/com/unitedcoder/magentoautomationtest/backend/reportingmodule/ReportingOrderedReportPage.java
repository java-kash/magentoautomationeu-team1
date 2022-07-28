package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReportingOrderedReportPage {
    WebDriver driver;
    FunctionPage functionPage;
    ReportingModuleDashBoard dashBoard;

    public ReportingOrderedReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        dashBoard = new ReportingModuleDashBoard(driver);
    }

    @FindBy(css = "#sales_report_from")
    WebElement fromDateBox;
    @FindBy(css = "#sales_report_to")
    WebElement toDateBox;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;
    @FindAll(@FindBy (css = ".data>tbody>tr"))
    List<WebElement> orderReportTable;

    public void fillFilterInfo(String fromDate, String toDate) {
        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(fromDate);
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(toDate);
        functionPage.waitForElement(showReportButton);
        showReportButton.click();
    }

    public boolean reportIsVisible() {
        functionPage.waitForElement(orderReportTable.get(1));
        if (orderReportTable.get(1).isDisplayed()) {
            return true;
        } else
            return false;

    }


}
