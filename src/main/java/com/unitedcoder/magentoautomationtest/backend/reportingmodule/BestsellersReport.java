package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestsellersReport {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    String configFile = "config-qa.properties";

    public BestsellersReport(WebDriver driver){
        this.driver=driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);
        actions=new Actions(driver);
    }
    @FindBy(xpath="//*[@id=\"nav\"]/li[3]/a/span")
    WebElement reportsButton;
    @FindBy(xpath="//*[@id=\"nav\"]/li[3]/ul/li[3]/a/span")
    WebElement productsButton;
    @FindBy(xpath="//*[@id=\"nav\"]/li[3]/ul/li[3]/ul/li[1]/a/span")
    WebElement bestsellersButton;
    @FindBy(css = "#sales_report_from")
    WebElement fromDateBox;
    @FindBy(css = "#sales_report_to")
    WebElement toDateBox;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;
    @FindBy(xpath = "//*[@class=\"data\"]/tfoot/tr")
    WebElement totalTable;

    public void showBestsellersPage(){
        functionPage.waitForElement(reportsButton);
        reportsButton.click();
        functionPage.waitForElement(productsButton);
        productsButton.click();
        functionPage.waitForElement(bestsellersButton);
        bestsellersButton.click();
    }

    public void reportsPage(){
        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(TestBase.readFromConfigProperties(configFile,"fromdate"));
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(TestBase.readFromConfigProperties(configFile,"todate"));
        functionPage.waitForElement(showReportButton);
        showReportButton.click();

    }
    public boolean verifyReportsPage(){
        functionPage.waitForElement(totalTable);
        if(totalTable.isDisplayed())
            return true;
        else
            return false;
    }


}
