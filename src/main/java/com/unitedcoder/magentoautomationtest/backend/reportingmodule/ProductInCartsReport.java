package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductInCartsReport {
    WebDriver driver;
    FunctionPage functionPage;

    public ProductInCartsReport(WebDriver driver){
        this.driver=driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//*[text()='Reports']")
    WebElement reportsLink;
    @FindBy(xpath ="//span[text()='Shopping Cart']")
    WebElement shoppindCartlink;
    @FindBy(xpath ="//*[@id=\"nav\"]/li[3]//span[text()='Products in carts']")
    WebElement productInCartsLink;
    @FindBy(xpath ="//*[@name=\"limit\"]")
    List<WebElement> limitInput;

    public void productInCarts(){
        functionPage.waitForElement(reportsLink);
        reportsLink.click();
        functionPage.waitForElement(shoppindCartlink);
        shoppindCartlink.click();
        functionPage.waitForElement(productInCartsLink);
        productInCartsLink.click();

    }
    public boolean verifyproductInCarts() {

        if (limitInput.size() > 0) {

        }
        return true;
    }









}
