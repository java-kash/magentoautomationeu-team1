package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.CustomerDropDownSelect;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogProductPage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";
    Actions actions;
    String name;



    public CatalogProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions=new Actions(driver);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @FindBy(xpath="//*[@class='scalable add']")
    WebElement addproductbutton;
    @FindBy(xpath ="//*[@id='attribute_set_id']")
    WebElement attributeSet;
    @FindBy(xpath = "//*[@id=\"product_type\"]/option[1]")
    WebElement producttype;
    @FindBy(xpath = "//*[text()='Continue']")
    WebElement continuebutton;
    @FindBy(id="name")
    WebElement nameinput;
    @FindBy(id="description")
    WebElement descriptioninput;
    @FindBy(id="short_description")
    WebElement shortdescriptioninput;
    @FindBy(id="sku")
    WebElement sKUinput;
    @FindBy(id="weight")
    WebElement weightinput;
    @FindBy(xpath = "//*[@id=\"status\"]/option[3]")
    WebElement statusslect;
    @FindBy(xpath = "//*[@id=\"visibility\"]/option[3]")
    WebElement visibilityselect;
    @FindBy(xpath = "//ul[@id='product_info_tabs']//li[2]/a")
    WebElement pricestUp;
    @FindBy(id="price")
    WebElement priceInput;
    @FindBy(xpath = "//*[@id=\"tax_class_id\"]/option[4]")
    WebElement taxClassOption;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement saveButton;
    @FindBy(css=".success-msg>ul li span")
    WebElement succesMassage;
    @FindBy(xpath = "//*[@id=\"apparel_type\"]/option[3]")
    WebElement typeInput;
    @FindBy(xpath = "//ul[@id='product_info_tabs']//li[8]/a")
    WebElement clothingLink;
//    @FindBy(xpath = "//table[@id='productGrid_table']//tr[@class='even pointer']//td[contains(text(),'"+getName+"')]")
//    WebElement productName;
    @FindBy(xpath = "//div[@id=\"group_fields7\"]//tbody//tr//td[@class='value']//select[@id=\"country_of_manufacture\"]")
    WebElement country;
    @FindBy(xpath = "//span[text()='Save and Continue Edit']")
    WebElement saveEditButton;
    @FindBy(xpath = "//span[text()='The product has been saved.']")
    WebElement succesMassageEdit;
    @FindBy(xpath = "//span[text()='Delete']")
    WebElement deleteButton;
    @FindBy(xpath = "//div[@id='messages']//li/span")
    WebElement deleteMessage;


    public void Addproduct(){
        functionPage.waitForElement(addproductbutton);
        addproductbutton.click();
        functionPage.waitForElement(attributeSet);
        attributeSet.click();
        Select select=new Select(attributeSet);
        select.selectByVisibleText(CustomerDropDownSelect.Default.name());


        functionPage.waitForElement(producttype);
        producttype.click();
        functionPage.waitForElement(continuebutton);
        continuebutton.click();
        functionPage.sleep(2);
        functionPage.waitForElement(descriptioninput);
        descriptioninput.sendKeys(readFromConfigProperties(configFile,"description"));
        functionPage.waitForElement(shortdescriptioninput);
        shortdescriptioninput.sendKeys(readFromConfigProperties(configFile,"Short-description"));
        functionPage.waitForElement(sKUinput);
        sKUinput.sendKeys(readFromConfigProperties(configFile,"SKU")+System.currentTimeMillis());
        functionPage.waitForElement(weightinput);
        weightinput.sendKeys(readFromConfigProperties(configFile,"product-weight"));
        functionPage.waitForElement(statusslect);
        statusslect.click();
        functionPage.waitForElement(visibilityselect);
        visibilityselect.click();
        functionPage.waitForElement(nameinput);
        String clothing=readFromConfigProperties(configFile,"name")+System.currentTimeMillis();
        nameinput.sendKeys(clothing);
        setName(clothing);
        //nameinput.sendKeys(readFromConfigProperties(configFile,"name"));
       //driver.findElement(By.xpath("//ul[@id='product_info_tabs']//li[2]/a")).click();
        functionPage.waitForElement(pricestUp);
        pricestUp.click();
        functionPage.sleep(2);
        functionPage.waitForElement(priceInput);
        priceInput.sendKeys(readFromConfigProperties(configFile,"product-price"));
        functionPage.waitForElement(taxClassOption);
        taxClassOption.click();
        functionPage.sleep(2);
//        clothingLink.click();
//       functionPage.sleep(2);
//        functionPage.waitForElement(typeInput);
//        typeInput.click();
    //    functionPage.sleep(2);
        functionPage.waitForElement(saveButton);
        saveButton.click();


    }
    public boolean verifyAddproduct(){
        functionPage.sleep(2);
        functionPage.waitForElement(succesMassage);
        if(succesMassage.getText().contains("The product has been saved.")){

            return true;
        }else
        return false;


    }
    public void editProduct(){
        functionPage.sleep(3);
        WebElement p=driver.findElement(By.xpath("//*[contains(text(),'"+getName()+"')]"));
        functionPage.waitForElement(p);
        p.click();
        functionPage.waitForElement(country);
        country.click();
        Select select=new Select(country);
        select.selectByVisibleText(CustomerDropDownSelect.Turkey.name());
        functionPage.sleep(2);
        functionPage.waitForElement(saveEditButton);
        saveEditButton.click();
    }
    public boolean verifyEdit(){
        functionPage.sleep(2);
        functionPage.waitForElement(succesMassageEdit);
        if(succesMassageEdit.getText().contains("The product has been saved.")){
            return true;
        }else
            return false;
    }
    public void deleteProduct(){
        functionPage.sleep(2);
        WebElement d=driver.findElement(By.xpath("//*[contains(text(),'"+getName()+"')]"));
        functionPage.waitForElement(d);
        d.click();
        functionPage.waitForElement(deleteButton);
        deleteButton.click();
        functionPage.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }
    public boolean verifyDeleted(){
        functionPage.waitForElement(deleteMessage);
        if(deleteMessage.getText().contains("The product has been deleted.")){
            return true;
        }else
            return false;
    }








}
