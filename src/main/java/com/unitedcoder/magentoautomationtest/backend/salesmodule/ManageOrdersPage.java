package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageOrdersPage {

    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    Select select;

    public ManageOrdersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
    }
    @FindBy(xpath = "(//*[text()='Sales'])[1]")
    WebElement salesTeb;
    @FindBy(xpath = "//*[text()='Orders']")
    WebElement orderesTeb;

    @FindBy(xpath = "(//*[text()=\"Create New Order\"])[1]")
    WebElement createNeworder;

    @FindBy(xpath = "//div[@class=\"hor-scroll\"]//tbody//td[1]")
    WebElement selsctcustomer;

    @FindBy(css = "input[id=\"store_7\"")
    WebElement store;

    @FindBy(xpath = "//*[text()='Add Products']")
    WebElement addproduct;

    @FindBy(xpath = "//td[contains(text(),'878')]")
    WebElement product;
    @FindBy(xpath = "//span[contains(text(),'Add Selected Product(s) to Order')]")
    WebElement addProductToOrder;
    @FindBy(css = "input[id=\"order-billing_address_firstname\"")
    WebElement firstnamefeild;

    @FindBy(css = "input[id=\"order-billing_address_lastname\"")
    WebElement lasttnamefeild;

    @FindBy(css = "input[id=\"order-billing_address_street0\"")
    WebElement streetfeild;

    @FindBy(css = "input[id=\"order-billing_address_city\"")
    WebElement cityfeild;

    @FindBy(css = "select[id=\"order-billing_address_region_id\"")
    WebElement statefeild;

    @FindBy(css = "input[id=\"order-billing_address_postcode\"")
    WebElement postalcodefeild;
    @FindBy(css = "input[id=\"order-billing_address_telephone\"")
    WebElement telephonefeild;

    //a[contains(text(),'Get shipping methods and rates')]

    @FindBy(xpath = "//a[contains(text(),'Get shipping methods and rates')]")
    WebElement getlink;
    @FindBy(xpath= "//input[@id='p_method_checkmo']")
    WebElement paymant;
    //*[text()='Cash On Delivery']


    @FindBy(xpath= "//input[@value='freeshipping_freeshipping']")
    WebElement shipping;
    //input[@value='freeshipping_freeshipping']
    //input[@id='s_method_flatrate_flatrate']


    @FindBy(xpath = "//span[text()=\"The order has been created.\" ]")
    WebElement successmsg;
    @FindBy(xpath = "(//*[text()='Submit Order'])[2]")
    WebElement submitorder;

    @FindBy(css = "#sales_order_grid_filter_status")
    WebElement status;

    @FindBy(xpath = "//*[text()='Search']")
    WebElement search;

    @FindBy(xpath = "//a[contains(text(),\"View\")]")
    WebElement selsctExistOrder;

    @FindBy(xpath = "(//*[text()='Cancel'])[2]")
    WebElement cancel;

    @FindBy(xpath = "//span[text()=\"The order has been cancelled.\" ]")
    WebElement successCancelmsg;


    public void createOrder(){
        functionPage.waitForElement(salesTeb);
        salesTeb.click();
        functionPage.waitForElement(orderesTeb);
        orderesTeb.click();
        functionPage.waitForElement(createNeworder);
        createNeworder.click();
        functionPage.waitForElement(selsctcustomer);
        selsctcustomer.click();
        functionPage.waitForElement(store);
        store.click();
        functionPage.waitForElement(addproduct);
        addproduct.click();
        functionPage.waitForElement(product);
        product.click();
        functionPage.waitForElement(addProductToOrder);
        addProductToOrder.click();
        functionPage.waitForElement(firstnamefeild);
        firstnamefeild.sendKeys(functionPage.generateFirstName());
        functionPage.waitForElement(lasttnamefeild);
        lasttnamefeild.sendKeys(functionPage.generateLastName());
        functionPage.waitForElement(streetfeild);
        streetfeild.sendKeys(functionPage.generateStreetName());
        functionPage.waitForElement(cityfeild);
        cityfeild.sendKeys(functionPage.generateCityName());
        functionPage.waitForElement(statefeild);
        Select select=new Select(statefeild);
        select.selectByIndex(5);
        functionPage.waitForElement(postalcodefeild);
        postalcodefeild.sendKeys(functionPage.generateZipCode());
        functionPage.waitForElement(telephonefeild);
        telephonefeild.sendKeys(functionPage.generateTelephoneNumber());
        functionPage.waitForElement(getlink);
        getlink.click();
        functionPage.sleep(2);
        functionPage.waitForElement(paymant);
        paymant.click();

        functionPage.waitForElement(shipping);
        shipping.click();
        functionPage.sleep(5);
        functionPage.waitForElement(submitorder);
        submitorder.click();
        functionPage.sleep(2);



    }
public boolean verifyCreateOrder(){
        if (successmsg.isDisplayed()){
            return true;
        }else
            return false;
}

public void deleteOrder(){
    functionPage.waitForElement(salesTeb);
    salesTeb.click();
    functionPage.waitForElement(orderesTeb);
    orderesTeb.click();
    functionPage.waitForElement(status);
    select=new Select(status);
    select.selectByVisibleText("Pending");
    functionPage.waitForElement(search);
    search.click();
    functionPage.waitForElement(selsctExistOrder);
    functionPage.sleep(3);
    selsctExistOrder.click();
    functionPage.waitForElement(cancel);
    cancel.click();
    functionPage.alertAccept();



}
public boolean verifyCancelOrder(){
        if (successCancelmsg.isDisplayed()){
            return true;
        }else
            return false;

}
















}
