package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PendingReviewsPage {

    WebDriver marketingDriver;
    FunctionPage functionPage;


    public PendingReviewsPage(WebDriver marketingDriver) {
        this.marketingDriver = marketingDriver;
        PageFactory.initElements(marketingDriver, this);
        functionPage = new FunctionPage(marketingDriver);
    }

    @FindBy(xpath="//span[text()='Catalog']")
    WebElement catalogButton;
    @FindBy(xpath="//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingsButton;
    @FindBy(xpath="//span[text()='Customer Reviews']")
    WebElement customerReviews;
    @FindBy(xpath="//span[text()='Pending Reviews']")
    WebElement pendingReviews;
    @FindBy(xpath="(//h3[text()='Pending Reviews'])[1]")
    WebElement pendingReviewsPage;

    @FindBy(id = "status_id")
    WebElement statusDropDown;
    @FindBy(xpath = "//*[text()='Save Review']")
    WebElement saveReview;
    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessage;
    @FindBy(id = "reviwGrid_filter_nickname")
    WebElement nickNameField;
    @FindBy(xpath = "//td[contains(text(),\"team1\")]")
    WebElement team1;

    public void pendingReviewsPage(){
        functionPage.waitForElement(catalogButton);
        catalogButton.click();
        functionPage.waitForElement(reviewsAndRatingsButton);
        reviewsAndRatingsButton.click();
        functionPage.waitForElement(customerReviews);
        customerReviews.click();
        functionPage.waitForElement(pendingReviews);
        pendingReviews.click();
    }
    public boolean verifyPendingReviewsPage(){
        functionPage.waitForElement(pendingReviewsPage);
        if(pendingReviewsPage.isDisplayed())
            return true;
        else
            return false;
    }

    public void updatePendingReviews() {
        functionPage.waitForElement(nickNameField);
        nickNameField.sendKeys("team1");
        functionPage.waitForElement(team1);
        team1.click();
        functionPage.waitForElement(statusDropDown);
        statusDropDown.click();
        Select select = new Select(statusDropDown);
        select.selectByIndex(1);
        functionPage.waitForElement(saveReview);
        saveReview.click();

    }

    public boolean verifyUpdatePendingReviews() {
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")) {
            return true;

        } else
            return false;
    }
}
