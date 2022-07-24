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

    @FindBy(xpath ="//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(css = ".logo")
    WebElement magentoLogoBackDashboard;
    @FindBy(xpath = "(//h3[text()='Manage Products'])[1]")
    WebElement managerProductsTitle;



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
    public void clickOnManageCategories()  {
        functionPage.waitForElement(catalogLink);
        catalogLink.click();
        functionPage.waitForElement(manageCategoriesLink);
        manageCategoriesLink.click();
    }
    public void backToDashboardPage(){
        functionPage.waitForElement(magentoLogoBackDashboard);
        magentoLogoBackDashboard.click();

    }
    public boolean dashboardVerify() {
        functionPage.waitForElement(managerProductsTitle);
        if (managerProductsTitle.isDisplayed()) {
            return true;
        }
        return false;
    }

}
