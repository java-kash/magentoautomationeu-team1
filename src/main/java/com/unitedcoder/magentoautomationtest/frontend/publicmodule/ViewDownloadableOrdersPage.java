package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDownloadableOrdersPage {

    //public module -- A user should be able to view his/her downloadable orders.

    WebDriver publicDriver;
    FunctionPage functionPage;

    public ViewDownloadableOrdersPage(WebDriver publicDriver) {
        this.publicDriver = publicDriver;
        PageFactory.initElements(publicDriver,this);
        functionPage=new FunctionPage(publicDriver);
    }


    @FindBy(xpath = "//h1[contains(text(),\"My Downloadable Products\")]")
    WebElement myDownloadableOrders;

    public boolean verifyDownloadableOrders(){
        functionPage.waitForElement(myDownloadableOrders);
        myDownloadableOrders.isDisplayed();
        return true;
    }




}
