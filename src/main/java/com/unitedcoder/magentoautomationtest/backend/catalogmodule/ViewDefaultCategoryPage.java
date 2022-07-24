package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewDefaultCategoryPage extends TestBase {
    //Catalog Manager can view all categories under each Default Category.
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    String configFile = "config-qa.properties";


    public ViewDefaultCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Catalog\")]")
    WebElement catalogTab;
    @FindBy(xpath = "//span[contains(text(),\"Manage Categories\")]")
    WebElement manageCategoriesOption;
    @FindBy(xpath = "//span[contains(text(),'Default Category (1)')]")
    WebElement defaultCategoryLink;
    @FindBy(xpath = "//a[contains(text(),'Expand All')]")
    WebElement expandAllLink;
    @FindBy(xpath = "//span[contains(text(),'zibuzinnet')]")
    WebElement zibuzinnetLink;
    @FindBy(xpath = "//h3[contains(text(),'zibuzinnet (ID: 6)')]")
    WebElement verifyMessage;

    public void viewDefaultCategory() {
        functionPage.waitForElement(catalogTab);
        actions.moveToElement(catalogTab).perform();
        functionPage.waitForElement(manageCategoriesOption);
        manageCategoriesOption.click();
        functionPage.waitForElement(expandAllLink);
        expandAllLink.click();
        functionPage.waitForElement(zibuzinnetLink);
        zibuzinnetLink.click();
    }

    public boolean verifyManagerCanViewAllDefaultCategories() {
        functionPage.waitForElement(verifyMessage);
        if (verifyMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
