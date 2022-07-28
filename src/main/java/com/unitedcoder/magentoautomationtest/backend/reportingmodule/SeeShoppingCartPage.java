package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeeShoppingCartPage {

//Reporting Manager should be able to see Shopping Cart - Abandoned carts Report

    WebDriver reportingDriver;
    FunctionPage functionPage;

    public SeeShoppingCartPage(WebDriver reportingDriver) {
        this.reportingDriver = reportingDriver;
        PageFactory.initElements(reportingDriver,this);
        functionPage=new FunctionPage(reportingDriver);
    }


    @FindBy(xpath = "//ul[@id=\"nav\"]/li/a/span[contains(text(),\"Reports\")]")
    WebElement reportsTab;

    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul/li/a/span[contains(text(),\"Shopping Cart\")]")
    WebElement shoppingCartOption;

    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul/li/ul/li[@class=\"  last level2\"]/a/span[contains(text(),\"Abandoned carts\")]")
    WebElement abandonedCarts;

    @FindAll(@FindBy(css = "table[id=\"gridAbandoned_table\"]>tbody>tr"))
    List<WebElement> totalAbandonedCarts;

    public void viewAbandonedCartsReport(){
        functionPage.waitForElement(reportsTab);
        reportsTab.click();
        functionPage.waitForElement(shoppingCartOption);
        shoppingCartOption.click();
        functionPage.waitForElement(abandonedCarts);
        abandonedCarts.click();
    }

    public boolean verify(){
       if (totalAbandonedCarts.size() > 0);
        return true;
    }




}
