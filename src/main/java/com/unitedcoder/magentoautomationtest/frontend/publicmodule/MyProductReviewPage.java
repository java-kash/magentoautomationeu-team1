package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProductReviewPage {
    WebDriver driver;
    FunctionPage functionPage;

    public MyProductReviewPage(WebDriver driver) {
        this.driver = driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "my-reviews-table")
    WebElement myReviewsTable;

    public boolean productReviewContentIsVisible() {
        functionPage.waitForElement(myReviewsTable);
        if (myReviewsTable.isDisplayed()) {
            Log4j.info("Review content is visible");
            return true;
        } else
        Log4j.error("Review content is not visible");
        return false;
    }


}
