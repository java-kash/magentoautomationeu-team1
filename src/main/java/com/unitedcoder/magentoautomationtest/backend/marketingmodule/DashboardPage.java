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
  //  Actions actions;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    //    actions=new Actions(driver);
    }
    @FindBy(xpath = "//*[text()='Promotions']")
    WebElement promotionsTab;
    @FindBy(xpath = "//*[text()='Catalog Price Rules']")
    WebElement catalogPriceRulesOption;

   public void clickOnCatalogPriceRulesOption(){
       functionPage.waitForElement(promotionsTab);
       functionPage.sleep(3);
       promotionsTab.click();
       functionPage.waitForElement(catalogPriceRulesOption);
      catalogPriceRulesOption.click();

   }


}

