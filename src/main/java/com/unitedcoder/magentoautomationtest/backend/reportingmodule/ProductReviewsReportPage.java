package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductReviewsReportPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public ProductReviewsReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions=new Actions(driver);
    }
    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsLink;
    @FindBy(xpath = "//span[text()='Reviews']")
    WebElement reviewsOption;
    @FindBy(xpath = "//span[text()='Products Reviews']")
    WebElement productsReviewsOption;
    @FindAll(@FindBy(css = "table[id=\"gridProducts_table\"]>tbody>tr"))
    List<WebElement>  productReviewReportTable;


   public void seeProductReviewsReport(){
       functionPage.waitForElement(reportsLink);
       reportsLink.click();
       functionPage.waitForElement(reviewsOption);
       actions.moveToElement(reviewsOption).perform();
       functionPage.waitForElement(productsReviewsOption);
       productsReviewsOption.click();
   }
   public boolean verifyProductReviewsReport(){

       if (productReviewReportTable.size() > 0);
       return true;
}
}
