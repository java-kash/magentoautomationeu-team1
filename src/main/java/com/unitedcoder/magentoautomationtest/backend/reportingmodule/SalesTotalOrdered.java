package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalesTotalOrdered {

    WebDriver driver;
    FunctionPage functionPage;
    ReportingModuleDashBoard dashBoard;

    public SalesTotalOrdered(WebDriver driver) {
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
    List<WebElement> orderedReportTable;

    public void showReports(String fromDate,String toDate){


        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(fromDate);
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(toDate);
//
        functionPage.clickWithJS(showReportButton);
//
    }

    public boolean orderedReportIsVisible() {
        if (orderedReportTable.size()>0)
            return true;
        else
            return false;


    }

}
