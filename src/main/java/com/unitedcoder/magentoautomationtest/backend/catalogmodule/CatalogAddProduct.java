package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogAddProduct {
    WebDriver driver;
    FunctionPage functionPage;

    public CatalogAddProduct(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);

    }
    @FindBy(xpath="//*[@class='scalable add']")
    WebElement Addproductbutton;
    @FindBy(xpath ="//*[@id=\"attribute_set_id\"]/option[5]")
    WebElement AttributeSet;
    @FindBy(xpath = "//*[@id=\"product_type\"]/option[1]")
    WebElement Producttype;
    @FindBy(xpath = "//*[text()='Continue']")
    WebElement Continuebutton;
    @FindBy(id="name")
    WebElement nameinput;
    @FindBy(id="description")
    WebElement descriptioninput;
    @FindBy(id="short_description")
    WebElement shortdescriptioninput;
    @FindBy(id="sku")
    WebElement SKUinput;
    @FindBy(id="weight")
    WebElement Weightinput;
    @FindBy(xpath = "//*[@id=\"status\"]/option[3]")
    WebElement statusslect;
    @FindBy(xpath = "//*[@id=\"visibility\"]/option[3]")
    WebElement visibilityselect;
    @FindBy(xpath = "//*[text()='Prices']")
    WebElement Pricestup;
    @FindBy(id="price")
    WebElement priceInput;
    @FindBy(xpath = "//*[@id=\"tax_class_id\"]/option[4]")
    WebElement TaxClassOption;
    @FindBy(id="product_info_tabs_inventory")
    WebElement Inventoryoption;
    @FindBy(id="inventory_qty")
    WebElement QtyInput;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement SaveButton;
    @FindBy(xpath = "//*[text()=\"The product has been saved.\"]")
    WebElement succesMassage;
    public void Addproduct(){
        functionPage.waitForElement(Addproductbutton);
        Addproductbutton.click();

    }





}
