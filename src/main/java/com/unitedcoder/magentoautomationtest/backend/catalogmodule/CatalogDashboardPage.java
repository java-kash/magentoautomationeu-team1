package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogDashboardPage {
    WebDriver driver;
    FunctionPage functionPage;

    public CatalogDashboardPage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath ="//span[text()='Manage Products']")
    WebElement manageProductsLink;

    @FindBy(xpath ="//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;

    @FindBy(xpath ="//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingsLink;

    @FindBy(xpath ="//span[text()='Customer Reviews']")
    WebElement customerReviewsLink;

    @FindBy(xpath ="//span[text()='Reports']")
    WebElement reportsLink;

    @FindBy(xpath ="//span[text()='Sales']")
    WebElement salesLink;

    @FindBy(xpath ="//span[text()='Orders']")
    WebElement salesOrdersLink;

    @FindBy(xpath ="//span[text()='Shopping Cart']")
    WebElement shoppingCartLink;

    @FindBy(xpath ="//span[text()='Products in carts']")
    WebElement productsInCartsLink;

    @FindBy(xpath ="//*[@id=\"nav\"]/li[2]/ul/li[3]/a/span")
    WebElement productsLink;

    @FindBy(xpath ="//span[text()='Products Ordered']")
    WebElement productsOrderedLink;

    @FindBy(xpath ="//*[@id=\"nav\"]/li[2]/ul/li[4]/a/span")
    WebElement customersLink;

    @FindBy(xpath ="//span[text()='New Accounts']")
    WebElement customersNewAccountsLink;

    @FindBy(xpath ="//span[text()='Reviews']")
    WebElement reviewsLink;

    @FindBy(xpath ="//span[text()='Customers Reviews']")
    WebElement customersReviewsLink;

    @FindBy(xpath ="//span[text()='Products Reviews']")
    WebElement productsReviewsLink;

    //Kadirdan
    @FindBy(xpath = "//*[@class='active']")
    WebElement catalogTab;
    @FindBy(linkText = "Attributes")
    WebElement attributesOption;
    @FindBy(linkText = "Manage Attributes")
    WebElement manageAttributesOption;

    //Kadirdan
    public void navigateToManageAttributesPage() {
        Actions actions = new Actions(driver);
        functionPage.waitForElement(catalogTab);
        actions.moveToElement(catalogTab).perform();
        functionPage.waitForElement(attributesOption);
        actions.moveToElement(attributesOption).perform();
        functionPage.waitForElement(manageAttributesOption);
        actions.moveToElement(manageAttributesOption).click().perform();
    }

}
