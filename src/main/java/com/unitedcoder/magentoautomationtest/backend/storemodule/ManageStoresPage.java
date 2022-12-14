package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-11-7:46 PM
 */
public class ManageStoresPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public ManageStoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions=new Actions(driver);
    }
    @FindBy(id= "//*[@id=\"nav\"]/li[3]/a/span")
    WebElement systemTab;
    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement manageStoresOption;
    @FindBy(xpath = "//span[text()='Create Store']")
    WebElement createStoreButton;
    @FindBy(id= "group_website_id")
    WebElement websiteDropDown;
    @FindBy(id = "group_name")
    WebElement storeNameField;
    @FindBy(id = "group_root_category_id")
    WebElement rootCategoryDropDown;
    @FindBy(xpath = "//span[text()='Save Store']")
    WebElement saveStoreButton;
    @FindBy(css = ".success-msg>ul li span")
    WebElement successMessage;
    @FindBy(xpath = "(//*[@title='Id: 22'])[1]")
    WebElement existingStoreName;

    public void CreateStore(String storeName){
//        functionPage.waitForElement(systemTab);
//        actions.moveToElement(systemTab).perform();
//        functionPage.waitForElement(manageStoresOption);
//        manageStoresOption.click();
        functionPage.waitForElement(createStoreButton);
        createStoreButton.click();
        functionPage.waitForElement(websiteDropDown);
        websiteDropDown.click();
        Select select=new Select(websiteDropDown);
        select.selectByIndex(5);
        functionPage.waitForElement(storeNameField);
        storeNameField.sendKeys(storeName);
        functionPage.waitForElement(rootCategoryDropDown);
        rootCategoryDropDown.click();
        Select select1=new Select(rootCategoryDropDown);
        select1.selectByIndex(1);
        functionPage.waitForElement(saveStoreButton);
        saveStoreButton.click();

    }
    public boolean verifyCreateStore(){
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")){
            return true;

        }else
            return false;

    }

    public void editStore(){
        actions.moveByOffset(0,600).build().perform();
        functionPage.sleep(3);
        functionPage.waitForElement(existingStoreName);
        existingStoreName.click();
        functionPage.waitForElement(rootCategoryDropDown);
        rootCategoryDropDown.click();
        Select select=new Select(rootCategoryDropDown);
        select.selectByIndex(6);
        functionPage.waitForElement(saveStoreButton);
        saveStoreButton.click();

    }
    public boolean verifyEditStore() {
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("saved")) {
            return true;

        } else
            return false;

    }
}
