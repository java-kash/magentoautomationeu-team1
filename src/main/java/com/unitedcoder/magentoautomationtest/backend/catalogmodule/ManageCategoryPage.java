package com.unitedcoder.magentoautomationtest.backend.catalogmodule;
import com.github.javafaker.Faker;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageCategoryPage {

    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    String configFile = "config-qa.properties";


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
    @FindBy(css = "#add_root_category_button")// we are already in the category page so we do not need to click again
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
    @FindBy(xpath = "//span[contains(text(),'Delete Category')]")
    WebElement deleteRootCatButton;
    @FindBy(xpath = "//span[normalize-space()='The category has been deleted.']")
    WebElement successDeleteMsg;
    @FindBy(xpath = "//*[@id=\"group_4meta_title\"]")
    WebElement editPageTitle;
    @FindBy(xpath = "//*[@id=\"extdd-176\"]")
    WebElement selectCategory;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement editSaveCatButton;
    @FindBy(xpath = "//*[contains(text(), 'Team1test-Zulfikar')]")
    WebElement allStores;
    @FindBy(xpath = "//span[text()='Add Subcategory']")
    WebElement addSubCategoryLink;
    @FindBy(css = "input[name='general[name]']")
    WebElement subcategoryName;
    @FindBy(id = "group_4is_active")
    WebElement isActiveSub;
    @FindBy(id = "group_4meta_title")
    WebElement pageTitleField;
    @FindBy(id = "group_4meta_keywords")
    WebElement metaKeywordsField;
    @FindBy(css = "#group_4include_in_menu")
    WebElement includeInNavigationField;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategorySub;
    @FindBy(css = "#messages")
    WebElement successMessageField;
    @FindBy(xpath ="//span[text()='Display Settings']" )
    WebElement displaySettingsLink;
    @FindBy(id = "group_5landing_page")
    WebElement cmsBlockField;
    @FindBy(xpath = "//span[text()='Delete Category']")
    WebElement deleteCategoryIcon;
    @FindBy(xpath = "//*[@id='ext-gen322']")
    WebElement subCategoryButton;





    public void addRootCategory() {
        functionPage.waitForElement(catalogLink);
        actions.moveToElement(catalogLink).click(manageCategoriesLink).perform();
        functionPage.sleep(1);
        rootCatNameField.sendKeys(TestBase.readFromConfigProperties(configFile, "addRootName"));
        functionPage.waitForElement(isActive);
        Select sel = new Select(isActive);
        sel.selectByValue("1");
        descriptionField.sendKeys(TestBase.readFromConfigProperties(configFile, "addRootDescription"));
        saveCategoryButton.click();

    }

    public boolean verifySuccessMessage(){
        functionPage.waitForElement(successMessage);
        if(successMessage.isDisplayed()){
            Log4j.info("Test Passed");
            return true;

        }else
            Log4j.error("Test Failed!!!");
           return false;

    }

    public void editRootCategory(){
        functionPage.waitForElement(catalogLink);
        actions.moveToElement(catalogLink).click(manageCategoriesLink).perform();
        functionPage.sleep(1);
        functionPage.waitForElement(allStores);
        allStores.click();
        functionPage.sleep(1);
        editPageTitle.clear();
        editPageTitle.sendKeys(TestBase.readFromConfigProperties(configFile,"pageTitle"));
        editSaveCatButton.click();


    }

    public boolean verifyEditSuccessMessage(){
        functionPage.waitForElement(successMessage);
        if(successMessage.isDisplayed()){
            Log4j.info("Test Passed");
            return true;

        }else
            Log4j.error("Test Failed!!!");
        return false;

    }

    public void deleteRootCategory(){
        functionPage.waitForElement(catalogLink);
        actions.moveToElement(catalogLink).click(manageCategoriesLink).perform();
        functionPage.sleep(1);
        functionPage.waitForElement(allStores);
        allStores.click();
        functionPage.sleep(1);
        deleteRootCatButton.click();
        functionPage.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        functionPage.sleep(1);

    }

    public boolean verifyDeleteSuccessMsg(){
        functionPage.waitForElement(successDeleteMsg);
        if(successDeleteMsg.isDisplayed()){
            Log4j.info("Test Passed");
            return true;

        }else
            Log4j.error("Test Failed!!!");
        return false;

    }





    public boolean addSubcategory() throws InterruptedException {
        WebElement rootCategoriesLink=driver.findElement
                (By.xpath(String.format("//span[contains(text(),'%s (0)')]",TestBase.readFromConfigProperties(configFile,"rootcategory-name"))));
        functionPage.waitForElement(rootCategoriesLink);
        rootCategoriesLink.click();
        functionPage.waitForElement(addSubCategoryLink);
        actions.moveToElement(addSubCategoryLink).click().perform();
        Thread.sleep(3000);
        functionPage.waitForElement(subcategoryName);
        subcategoryName.sendKeys(TestBase.readFromConfigProperties(configFile, "subcategory_name"));
        functionPage.waitForElement(isActiveSub);
        Select selectIsActive = new Select(isActiveSub);
        selectIsActive.selectByIndex(1);
        functionPage.waitForElement(descriptionField);
        descriptionField.sendKeys(TestBase.readFromConfigProperties(configFile, "subcategory_description"));
        functionPage.waitForElement(pageTitleField);
        descriptionField.sendKeys(TestBase.readFromConfigProperties(configFile, "subcategory_pagetitle"));
        functionPage.waitForElement(metaKeywordsField);
        descriptionField.sendKeys(TestBase.readFromConfigProperties(configFile, "subcategory_metakeyword"));
        functionPage.waitForElement(saveCategorySub);
        saveCategorySub.click();
        functionPage.waitForElement(successMessageField);
        if (successMessageField.getText().contains("The category has been saved."))
            return true;
        else
            return false;

    }

    public boolean editSubCategory() {

        WebElement subCategoryButton = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", TestBase.readFromConfigProperties(configFile, "subcategory_name"))));
        functionPage.waitForElement(subCategoryButton);
        subCategoryButton.click();
      functionPage.sleep(5);
        functionPage.waitForElement(displaySettingsLink);
        actions.click(displaySettingsLink).perform();
        Select cmsSlect = new Select(cmsBlockField);
        cmsSlect.selectByVisibleText("Home & Decor");
        functionPage.waitForElement(saveCategorySub);
        saveCategorySub.click();
        functionPage.waitForElement(successMessageField);
        if (successMessageField.getText().contains("The category has been saved."))
            return true;
        else
            return false;

    }
public boolean deleteSubcategory(){
    WebElement subCategoryButton = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s (0)')]", TestBase.readFromConfigProperties(configFile, "subcategory_name"))));
    functionPage.waitForElement(subCategoryButton);
    subCategoryButton.click();
    functionPage.waitForElement(deleteCategoryIcon);
    deleteCategoryIcon.click();
    functionPage.waitForAlertPresent();
Alert alert=driver.switchTo().alert();
alert.accept();
functionPage.sleep(3);

    if (successMessageField.getText().contains("The category has been deleted.")){
        return true;
    }else
        return false;
}



    }
