package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.CustomerDropDownSelect;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewAllStorePage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    public ViewAllStorePage(WebDriver driver){
        this.driver=driver;
        functionPage=new FunctionPage(driver);
        PageFactory.initElements(driver,this);
        actions=new Actions(driver);
    }

        @FindBy(xpath = "//span[text()='Catalog']")
        WebElement catalogLink;
        @FindBy(xpath = "//*[@class=\"icon-head head-products\"]")
        WebElement titelPage;
        @FindBy(xpath = "//span[contains(text(),\"Manage Products\")]")
        WebElement manageProducts;

    public void clickViewStore(){
    functionPage.waitForElement(catalogLink);
    catalogLink.click();
    functionPage.waitForElement(manageProducts);
    manageProducts.click();
    functionPage.sleep(2);
//    Select select=new Select(catalogLink);
//    select.selectByVisibleText(CustomerDropDownSelect.Manage_Products.name());

      }
      public boolean verifyStorePage(){
        functionPage.waitForElement(titelPage);
        if (titelPage.isDisplayed())
            return true;
        else
            return false;
      }


}
