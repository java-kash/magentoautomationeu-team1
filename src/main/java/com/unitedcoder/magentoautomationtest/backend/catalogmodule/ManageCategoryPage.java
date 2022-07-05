package com.unitedcoder.magentoautomationtest.backend.catalogmodule;
import com.github.javafaker.Faker;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageCategoryPage {

    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;


    public ManageCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions = new Actions(driver);

    }

    @FindBy(xpath ="//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath ="//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(css = "#add_root_category_button")
    WebElement addRootCategory;
    @FindBy(xpath = "//*[@id=\"group_4name\"]")
    WebElement rootCatNameField;
    @FindBy(css = "#group_4is_active")
    WebElement isActive;
    @FindBy(css = "#group_4description")
    WebElement descriptionField;
    @FindBy(xpath = "//div[@id='category-edit-container']//p//button[2]")
    WebElement saveCategoryButton;
    @FindBy(xpath = "//*[contains(text(),'The category has been saved.')]")
    WebElement successMessage;
    @FindBy(xpath = "(//select[@id='store_switcher'])[1]")
    WebElement storeSwitcher;





    public void manageCategoriesLink() {
        functionPage.waitForElement(catalogLink);
        actions.moveToElement(catalogLink).click(manageCategoriesLink).perform();
        functionPage.waitForElement(rootCatNameField);
        rootCatNameField.sendKeys("Team1Test");
        functionPage.waitForElement(isActive);
        Select sel = new Select(isActive);
        sel.selectByIndex(1);
        functionPage.waitForElement(descriptionField);
        descriptionField.sendKeys("This is our Team1 Add Root Category Test");
        //saveCategoryButton.click();



    }

        public boolean verifySuccessMessage () {
            functionPage.waitForElement(successMessage);
            return successMessage.isDisplayed();
        }



    }
