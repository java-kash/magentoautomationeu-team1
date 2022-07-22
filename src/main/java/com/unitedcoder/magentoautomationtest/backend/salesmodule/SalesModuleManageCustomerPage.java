package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SalesModuleManageCustomerPage {
    WebDriver driver;
    FunctionPage functionPage;

    public SalesModuleManageCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(xpath = "//*[text()='Customers']")
    WebElement customersLink;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindAll(@FindBy(xpath = "//table[@id='customerGrid_table']/tbody/tr"))
    List<WebElement> customersList;
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartLink;
    @FindBy(xpath = "//table[@id='customer_cart_grid0_table']")
    WebElement shoppingCartTable;

    public void clickOnManageCustomersLink(){
        functionPage.waitForElement(customersLink);
        customersLink.click();
        functionPage.waitForElement(manageCustomersLink);
        manageCustomersLink.click();
    }
public boolean shoppingCartIsVisible(){
        int listSize=customersList.size();
          Random r=new Random();
          int randomValue= r.nextInt(listSize);
          functionPage.waitForElement(customersList.get(randomValue));
          customersList.get(randomValue).click();
          functionPage.waitForElement(shoppingCartLink);
          shoppingCartLink.click();
          functionPage.waitForElement(shoppingCartTable);
          if (shoppingCartTable.isDisplayed()){
              return true;
          }else
              return false;

}
}