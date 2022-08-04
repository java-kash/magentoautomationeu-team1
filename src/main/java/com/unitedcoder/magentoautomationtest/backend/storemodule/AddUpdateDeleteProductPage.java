package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUpdateDeleteProductPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public AddUpdateDeleteProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
    }
    @FindBy(xpath="//*[@id=\"nav\"]/li[2]/a/span")
    WebElement catalogButton;

    @FindBy(xpath="//*[@id=\"nav\"]/li[2]/ul/li[1]/a/span")
    WebElement manageProductButton;

    @FindBy(xpath="//span[text()='Add Product']")
    WebElement addProductButton;

/*    @FindBy(xpath="//*[@id=\"attribute_set_id\"]/option[6]")
    WebElement selectAttributeSet;

    @FindBy(xpath= "//*[@id=\"product_type\"]/option[1]")
    WebElement selectProductType;*/

    @FindBy(xpath="//*[@title=\"Continue\"]/span")
    WebElement ContinueButton;

    @FindBy(id="name")
    WebElement productNameField;

    @FindBy(id="description")
    WebElement descriptionField;

    @FindBy (id="short_description")
    WebElement shortDescriptionField;

    @FindBy (id="sku")
    WebElement productSKUField;

    @FindBy(id="weight")
    WebElement productWeightField;

    @FindBy (xpath="//*[@id=\"status\"]")
    WebElement selectProductStatus;

    @FindBy (xpath="//*[@id=\"status\"]/option[2]")
    WebElement enabled;

    @FindBy (xpath="//*[@id=\"visibility\"]")
    WebElement selectProductVisibility;

    @FindBy (xpath="//*[@id=\"visibility\"]/option[5]")
    WebElement catalogSearch;

    @FindBy (id="price")
    WebElement priceField;

    @FindBy (xpath="//*[@id=\"tax_class_id\"]")
    WebElement selectTaxClass;

    @FindBy (xpath="//*[@id=\"tax_class_id\"]/option[5]")
    WebElement typeDropdown;

    @FindBy (css="button[title='Save']")
    WebElement saveButton;

    @FindBy(xpath="//*[@id=\"messages\"]/ul/li")
    WebElement successMessage;

    @FindBy(xpath="//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[3]")
    WebElement Levis;

    @FindBy(xpath="//*[@title=\"Delete\"]/span/span/span")
    WebElement deleteIcon;

    @FindBy(xpath="//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement deleteSuccess;

    public void managerProductLink(){
        functionPage.waitForElement(catalogButton);
        catalogButton.click();
        functionPage.waitForElement(manageProductButton);
        manageProductButton.click();

    }
    public void addProduct(String name1,String description1, String shortDescription1, String SKU1, String Weight1, String Price1){
        functionPage.waitForElement(addProductButton);
        addProductButton.click();

        functionPage.waitForElement(ContinueButton);
        ContinueButton.click();

        functionPage.waitForElement(productNameField);
        productNameField.click();
        productNameField.sendKeys(name1);
        functionPage.sleep(1);
        functionPage.waitForElement(descriptionField);
        descriptionField.sendKeys(description1);
        functionPage.sleep(1);
        functionPage.waitForElement(shortDescriptionField);
        shortDescriptionField.sendKeys(shortDescription1);
        functionPage.sleep(1);
        functionPage.waitForElement(productSKUField);
        productSKUField.sendKeys(SKU1);
        functionPage.sleep(1);
        functionPage.waitForElement(productWeightField);
        productWeightField.sendKeys(Weight1);
        functionPage.sleep(1);
        functionPage.waitForElement(selectProductStatus);
        selectProductStatus.click();
        functionPage.sleep(1);
        functionPage.waitForElement(enabled);
        enabled.click();
        functionPage.sleep(1);
        functionPage.waitForElement(selectProductVisibility);
        selectProductVisibility.click();
        functionPage.sleep(1);
        functionPage.waitForElement(catalogSearch);
        catalogSearch.click();
        functionPage.waitForElement(saveButton);
        saveButton.click();
        functionPage.waitForElement(priceField);
        priceField.sendKeys(Price1);
        functionPage.sleep(1);
        functionPage.waitForElement(selectTaxClass);
        selectTaxClass.click();
        functionPage.waitForElement(typeDropdown);
        typeDropdown.click();
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }
    public boolean verifyAddProduct(){
        functionPage.waitForElement(successMessage);
        if (successMessage.isDisplayed())
            return true;
        else
            return false;
    }
    public void updateProduct(String sku){
        functionPage.waitForElement(Levis);
        Levis.click();
        functionPage.waitForElement(productSKUField);
        productSKUField.sendKeys(sku);
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }
    public void deleteProduct(){
        functionPage.waitForElement(Levis);
        Levis.click();
        functionPage.waitForElement(deleteIcon);
        deleteIcon.click();
        Alert alert = driver.switchTo().alert();
        functionPage.waitForAlertPresent();
        alert.accept();
    }
    public boolean verifyDeleteProduct(){
        functionPage.waitForElement(deleteSuccess);
        if (deleteSuccess.isDisplayed())
            return true;
        else
            return false;
    }

}

