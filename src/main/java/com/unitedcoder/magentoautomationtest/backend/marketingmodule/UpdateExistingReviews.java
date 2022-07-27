package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class UpdateExistingReviews {
    WebDriver marketingDriver;
    FunctionPage functionPage;


    public UpdateExistingReviews(WebDriver marketingDriver) {
        this.marketingDriver = marketingDriver;
        PageFactory.initElements(marketingDriver, this);
        functionPage = new FunctionPage(marketingDriver);
    }


    @FindBy(xpath = "//a[text()='Edit']")
    WebElement Editbtn;
   // nickname
   @FindBy(css = "input[id=\"nickname\"]")
   WebElement namefeild;
    @FindBy(css = "select[id=\"status_id\"]")
    WebElement statusDropDown;
    @FindBy(css = "input[id=\"title\"")
    WebElement Tiltefeild;

    @FindBy(xpath = "//*[text()='Save Review']")
    WebElement saveReview;
    //*[text()='The review has been saved.']
    @FindBy(xpath = "//*[text()='The review has been saved.']")
    WebElement Successmsg;



    public void updateReview(){
        functionPage.waitForElement(Editbtn);
        Editbtn.click();
        functionPage.waitForElement(statusDropDown);
        statusDropDown.click();
        Select select = new Select(statusDropDown);
        select.selectByIndex(0);
        functionPage.waitForElement(namefeild);
        namefeild.click();
        namefeild.sendKeys(functionPage.generateFirstName().toLowerCase(Locale.ROOT));
        functionPage.waitForElement(Tiltefeild);
        Tiltefeild.sendKeys(functionPage.generateMiddleName());
        functionPage.waitForElement(saveReview);
        saveReview.click();





    }

    public boolean verifyUpdateReview(){
        if(Successmsg.isDisplayed()){
            return true;

        }
        else
            return false;

    }


}

