package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-11-7:45 PM
 */
public class CategoriesAndNewRootCategoryFormPage {
    WebDriver driver;
    FunctionPage functionPage;
    String useFullName;

    public CategoriesAndNewRootCategoryFormPage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUseFullName() {
        return useFullName;
    }

    public void setUseFullName(String useFullName) {
        this.useFullName = useFullName;
    }

    public By categoryInformationTabs = By.xpath("//*[@id='category_info_tabs']/li");

    @FindBy(css = "#group_4name")
    WebElement nameField;
    @FindBy(css = "#group_4is_active")
    WebElement isActiveDropDown;
    @FindBy(css = "#group_4description")
    WebElement descriptionField;
    @FindBy(css = "#group_4meta_title")
    WebElement pageTitleField;
    @FindBy(css = "#group_4meta_keywords")
    WebElement metaKeywordsField;
    @FindBy(css = "#group_4meta_description")
    WebElement metaDescriptionField;
    @FindBy(css = ".scalable.save")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id='messages']//span")
    WebElement successMessage;
    @FindBy(css = "#category_tab_content")
    WebElement generalInformationForm;
    @FindBy(css = "#group_4include_in_menu")
    WebElement includeInNavigationMenuDropDown;
    @FindBy(css = ".scalable.delete")
    WebElement deleteButton;

    public void fillGeneralInformationForm(String name, String section, String description, String pageTitle,
                                           String metaKeywords, String metaDescription) {
        //functionPage.waitForElement(nameField);
        nameField.sendKeys(name);
        setUseFullName(name);
        //functionPage.waitForElement(isActiveDropDown);
        Select select = new Select(isActiveDropDown);
        select.selectByVisibleText(section);
        //functionPage.waitForElement(descriptionField);
        descriptionField.sendKeys(description);
        //functionPage.waitForElement(pageTitleField);
        pageTitleField.sendKeys(pageTitle);
        //functionPage.waitForElement(metaKeywordsField);
        metaKeywordsField.sendKeys(metaKeywords);
        //functionPage.waitForElement(metaDescriptionField);
        metaDescriptionField.sendKeys(metaDescription);
    }

    public void clickSaveButton() {
        //functionPage.waitForElement(saveButton);
        saveButton.click();
    }

    public String getSuccessMessage() {
        functionPage.waitForElement(successMessage);
        return successMessage.getText();
    }

    public boolean verifyCreatedCategory() {
        WebElement cratedCategory = driver.findElement(By.xpath("//div[@class='categories-side-col']//span[contains(text(),'" + getUseFullName() + "')]"));
        functionPage.waitForElement(cratedCategory);
        return cratedCategory.isDisplayed();
    }

    public boolean verifyGeneralInformationForm() {
        functionPage.waitForElement(generalInformationForm);
        return generalInformationForm.isDisplayed();
    }

    public void clickOnCategoryFolder() {
        WebElement cratedCategory = driver.findElement(By.xpath("//div[@class='categories-side-col']//span[contains(text(),'" + getUseFullName() + "')]"));
        functionPage.waitForElement(cratedCategory);
        cratedCategory.click();
    }

    public void selectNoInIncludeInNavigationMenu() {
        functionPage.waitForElement(includeInNavigationMenuDropDown);
        Select select = new Select(includeInNavigationMenuDropDown);
        select.selectByVisibleText("No");
    }

    public void clickOnDeleteButton() {
        //functionPage.waitForElement(deleteButton);
        deleteButton.click();
    }
}
