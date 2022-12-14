package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingModuleDashBoard {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public ReportingModuleDashBoard(WebDriver driver) {
        this.driver = driver;
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
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
    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashBoardLink;
    @FindBy(xpath = "(//span[text()='Customers'])[1]")
    WebElement CustomersLink;
    @FindBy(xpath = "//span[text()='Customers by number of orders']")
    WebElement numOfOrdersLink;


public void clickOnDashBoardLink(){
    functionPage.waitForElement(dashBoardLink);
    dashBoardLink.click();
}
    public void openTargetPages(WebElement element1,WebElement element2,WebElement element3){
    actions.moveToElement(element1).moveToElement(element2).moveToElement(element3).click().perform();

    }
    public void openOrdersPage(){
        openTargetPages(reportsLink,salesLink,ordersLink);
    }
    public void openRefundsPage(){
        openTargetPages(reportsLink,salesLink,refundsLink);
    }


    public void openCustomersReportPage(){openTargetPages(reportsLink,CustomersLink,numOfOrdersLink);


    }

}
