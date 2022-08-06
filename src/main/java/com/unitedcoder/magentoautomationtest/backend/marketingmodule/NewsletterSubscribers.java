package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterSubscribers {

    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public NewsletterSubscribers(WebDriver driver){
        this.driver=driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);
        actions=new Actions(driver);
    }
    @FindBy(xpath="//span[text()='Newsletter']")
    WebElement newsletterButton;
    @FindBy(xpath="//span[text()='Newsletter Subscribers']")
    WebElement newsletterSubscribers;
    @FindBy(xpath="(//h3[text()='Newsletter Subscribers'])[1]")
    WebElement newslettersSubscribersPage;

    public void newslettersSubscribersPage(){
        functionPage.waitForElement(newsletterButton);
        newsletterButton.click();
        functionPage.waitForElement(newsletterSubscribers);
        newsletterSubscribers.click();

    }
    public boolean verifyNewslettersSubscribersPage(){
        functionPage.waitForElement(newslettersSubscribersPage);
        if(newslettersSubscribersPage.isDisplayed())
            return true;
        else
            return false;
    }


}
