package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProductReview {
    WebDriver driver;
    FunctionPage functionPage;

    public MyProductReview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(linkText = "My Product Reviews")
    WebElement myProductReviewLink;
    @FindBy(id = "my-reviews-table")
    WebElement myReviewsTable;
    public boolean productReviewLinkVisible(){
        functionPage.waitForElement(myProductReviewLink);
        if (myProductReviewLink.isDisplayed()){
            System.out.println("My Product Reviews link is visible");
            return true;
        }else
            System.out.println("My Product Reviews link is not visible");
        return false;
    }
    public boolean productReviewContentIsVisible(){
        functionPage.waitForElement(myReviewsTable);
        if (myReviewsTable.isDisplayed()){
            System.out.println("Review content is visible");
           return true;
        }
        else
            System.out.println("Review content is not visible");
        return false;
    }



}
