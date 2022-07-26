package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllReviews {
    WebDriver driver;
    FunctionPage functionPage;
    public ViewAllReviews(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/table/tbody/tr/td[1]/h3")
    WebElement pagetxt;

    public boolean verifyRiewsPage(){
        functionPage.waitForElement(pagetxt);
        if (pagetxt.isDisplayed()) {
            return true;
        }   else
                return false;

    }
}
