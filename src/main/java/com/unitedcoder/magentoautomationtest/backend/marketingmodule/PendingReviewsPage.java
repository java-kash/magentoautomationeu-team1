package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class PendingReviewsPage {

    WebDriver marketingDriver;
    FunctionPage functionPage;


    public PendingReviewsPage(WebDriver marketingDriver) {
        this.marketingDriver = marketingDriver;
        PageFactory.initElements(marketingDriver, this);
        functionPage = new FunctionPage(marketingDriver);
    }

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
