package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-11-7:42 PM
 */
public class ManageCurrencyRatesPage {
    WebDriver driver;
    FunctionPage functionPage;

    public ManageCurrencyRatesPage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "System")
    WebElement systemTab;

    @FindBy(linkText = "Manage Stores")
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
}
