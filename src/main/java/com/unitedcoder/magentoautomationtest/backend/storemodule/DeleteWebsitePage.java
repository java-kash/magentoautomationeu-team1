package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteWebsitePage {
    WebDriver driver;

    FunctionPage functionPage;

    public DeleteWebsitePage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(xpath = "(//td[@class='a-left'])[1]//a")
    WebElement existingWebsite;
    @FindBy(xpath = "(//span[text()='Delete Website'])[1]")
    WebElement deleteWebsiteIcon;
    @FindBy(xpath = "//span[text()='The website has been deleted.']")
    WebElement deleteVerification;

    public void deleteWebsite() throws InterruptedException {

        functionPage.waitForElement(existingWebsite);
        Thread.sleep(2000);
        existingWebsite.click();
        functionPage.waitForElement(deleteWebsiteIcon);
        Thread.sleep(2000);
        deleteWebsiteIcon.click();
    }

    public boolean verifyDeleteWebsite() {
        functionPage.waitForElement(deleteVerification);
        return deleteVerification.isDisplayed();
    }

}
