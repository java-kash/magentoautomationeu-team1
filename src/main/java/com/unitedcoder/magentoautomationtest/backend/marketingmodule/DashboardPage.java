package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;
    FunctionPage functionPage;
   Actions actions;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
       actions=new Actions(driver);
    }
    @FindBy(xpath = "//*[text()='Promotions']")
    WebElement promotionsTab;
    @FindBy(xpath = "//*[text()='Catalog Price Rules']")
    WebElement catalogPriceRulesOption;
    @FindBy(xpath = "//*[text()='Catalog']")
    WebElement catalogTeb;
    @FindBy(xpath = "(//*[@class='parent last level1']//span)[1]")
    WebElement tagsOption;
    @FindBy(xpath = "//*[text()='Pending Tags']")
    WebElement pendingTagsOption;
    @FindBy(xpath = "//*[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingsOption;
    @FindBy(xpath = "//*[text()='Customer Reviews']")
    WebElement customerReviewsOption;
    @FindBy(xpath = "//*[text()='Pending Reviews']")
    WebElement pendingReviewsOption;





   public void clickOnCatalogPriceRulesOption(){
       functionPage.waitForElement(promotionsTab);
       functionPage.sleep(3);
       promotionsTab.click();
       functionPage.waitForElement(catalogPriceRulesOption);
      catalogPriceRulesOption.click();

   }

   public void clickAllReviewsOption(){
       functionPage.waitForElement(catalogTeb);
       actions.moveToElement(catalogTeb).perform();
       functionPage.waitForElement(reviewsAndRatingsOption);
       reviewsAndRatingsOption.click();
       functionPage.waitForElement(customerReviewsOption);
       customerReviewsOption.click();
       functionPage.waitForElement(pendingReviewsOption);
       pendingReviewsOption.click();


   }


}

