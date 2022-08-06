package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductsMostViewedReportPage {

    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    public ProductsMostViewedReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions=new Actions(driver);

    }
    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsLink;
    @FindBy(xpath =" (//span[text()='Products'])[1]" )
    WebElement productsOption;
    @FindBy(xpath ="//span[text()='Most Viewed']" )
    WebElement mostViewed;
    @FindBy(css = "#sales_report_from")
    WebElement fromDateBox;
    @FindBy(css = "#sales_report_to")
    WebElement toDateBox;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton;
    @FindAll(@FindBy (css = "table.data>tbody>tr"))
    List<WebElement> mostViewedReportTable;



    public void mostViewedPage () {

        functionPage.waitForElement(reportsLink);
        reportsLink.click();
        functionPage.waitForElement(productsOption);
        actions.moveToElement(productsOption).perform();
        functionPage.waitForElement(mostViewed);
        actions.moveToElement(mostViewed).perform();
        mostViewed.click();
    }
    public void showReport(String fromDate,String toDate){


        functionPage.waitForElement(fromDateBox);
        fromDateBox.sendKeys(fromDate);
        functionPage.waitForElement(toDateBox);
        toDateBox.sendKeys(toDate);
//        functionPage.waitForElement(showReportButton);
        functionPage.clickWithJS(showReportButton);
//        showReportButton.click();
    }

    public boolean mostViewedReportIsVisible() {
        if (mostViewedReportTable.size() > 0);
        return true;

    }
}
