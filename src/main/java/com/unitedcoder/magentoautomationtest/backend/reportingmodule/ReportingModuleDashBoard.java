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


    public void openTargetPages(WebElement element1,WebElement element2,WebElement element3){
    actions.moveToElement(element1).moveToElement(element2).moveToElement(element3).click().perform();

    }
    public void openOrdersPage(){
        openTargetPages(reportsLink,salesLink,ordersLink);
    }
    public void openRefundsPage(){
        openTargetPages(reportsLink,salesLink,refundsLink);
    }

}
