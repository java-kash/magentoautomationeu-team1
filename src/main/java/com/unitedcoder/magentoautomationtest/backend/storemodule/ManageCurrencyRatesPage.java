package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-11-7:42 PM
 */
public class ManageCurrencyRatesPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    @FindBy(xpath= "//span[text()='System']")
    WebElement systemTab;
    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement manageStoresOption;
    @FindBy(linkText = "Catalog")
    WebElement catalogTab;
    @FindBy(linkText = "Manage Products")
    WebElement manageProductsOption;
    @FindBy(linkText = "Manage Categories")
    WebElement manageCategoriesOption;
    @FindBy(linkText = "Sales")
    WebElement salesTab;
    @FindBy(linkText = "Orders")
    WebElement ordersOption;

    public ManageCurrencyRatesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
       actions=new Actions(driver);

    }
    public void clickManageStore(){
        functionPage.waitForElement(systemTab);
        functionPage.sleep(3);
        systemTab.click();
//        actions.moveToElement(systemTab).perform();
        functionPage.waitForElement(manageStoresOption);
        manageStoresOption.click();
    }
}
