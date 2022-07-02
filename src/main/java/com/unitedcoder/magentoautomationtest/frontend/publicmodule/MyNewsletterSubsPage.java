package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyNewsletterSubsPage {
    WebDriver driver;
    FunctionPage functionPage;

    @FindBy(xpath ="//a[contains(text(),'Newsletter Subscriptions')] ")
    WebElement newsletterSubscriptionsLink;
    @FindBy(xpath = "//*[@id=\"subscription\"]")
    WebElement generalSubsIsChecked;


public MyNewsletterSubsPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
    functionPage = new FunctionPage(driver);
}

    public void clickOnNewsLetterSubs() {
        functionPage.waitForElement(newsletterSubscriptionsLink);
        newsletterSubscriptionsLink.click();
    }

    public boolean generalSubsIsChecked(){
        functionPage.waitForElement(generalSubsIsChecked);
        if (generalSubsIsChecked.isEnabled()) {
            Log4j.info("General Subscription is Checked");
            return true;
        }else
        {
            Log4j.info("General Subscription is Not Checked");
            return false;
        }
    }


}
