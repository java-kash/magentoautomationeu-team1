package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrderPage{

//Store Manager can create a new order

    WebDriver storeDriver;
    FunctionPage functionPage;
    Actions actions;
    Select select;

    public CreateNewOrderPage(WebDriver storeDriver) {
        this.storeDriver = storeDriver;
        PageFactory.initElements(storeDriver,this);
        functionPage=new FunctionPage(storeDriver);
        actions=new Actions(storeDriver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Sales\")]")
    WebElement salesTab;

    @FindBy(xpath = "//span[contains(text(),\"Orders\")]")
    WebElement ordersOption;

    @FindBy(css = "div[id=\"page:main-container\"]>div[class=\"content-header\"]>table>tbody>tr>td[class=\"form-buttons\"]>button>span>span>span")
    WebElement createNewOrderButton;

    @FindBy(css = "#sales_order_create_customer_grid_filter_entity_id")
    WebElement customerIDField;

    @FindBy(css = "#sales_order_create_customer_grid_filter_name")
    WebElement customerNameField;

    @FindBy(xpath = "//td[contains(text(),\"team1 Test\")]")
    WebElement selectedCustomer;

    @FindBy(css = "input[id=\"store_1\"]")
    WebElement store;

    @FindBy(xpath = "//span[contains(text(),\"Add Products\")]")
    WebElement addProductsButton;

    @FindBy(xpath = "//span[contains(text(),\"Product Name\")]")
    WebElement productName;

    @FindBy(xpath = "//tr[4]/td[@class=\"a-center \"]/input")
    WebElement selectedProduct;

    @FindBy(css = "input[id=\"sales_order_create_search_grid_filter_entity_id\"]")
    WebElement productIDField;

    @FindBy(xpath = "//input[@class=\"checkbox\"]")
    WebElement selectBox;

    @FindBy(xpath = "//span[contains(text(),\"Add Selected Product(s) to Order\")]")
    WebElement addSelectedProductToOrder;

    @FindBy(css = "#order-billing_address_firstname")
    WebElement firstNameField;

    @FindBy(css = "#order-billing_address_lastname")
    WebElement lastNameField;

    @FindBy(css = "#order-billing_address_street0")
    WebElement streetAddress;

    @FindBy(css = "#order-billing_address_city")
    WebElement cityField;

    @FindBy(css = "#order-billing_address_country_id")
    WebElement countryField;

    @FindBy(css = "#order-billing_address_postcode")
    WebElement zipCode;

    @FindBy(css = "#order-billing_address_telephone")
    WebElement telephoneField;

    @FindBy(css = "select[id=\"order-billing_address_customer_address_id\"]")
    WebElement selectAddress;

    @FindBy(css = "#order-shipping-method-summary>a")
    WebElement shippingMethod;

    @FindBy(css = "#s_method_freeshipping_freeshipping")
    WebElement freeShipping;

    @FindBy(css = "#p_method_cashondelivery")
    WebElement cashOnDelivery;

    @FindBy(xpath = "//span[contains(text(),\"Submit Order\")]")
    WebElement submitOrder;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(xpath = "//span[contains(text(),\"The order has been created.\")]")
    WebElement successMassage;


    public void selectCustomer(){
        functionPage.waitForElement(salesTab);
//        actions.moveToElement(salesTab);
        salesTab.click();
        functionPage.waitForElement(ordersOption);
        ordersOption.click();
        functionPage.waitForElement(createNewOrderButton);
        createNewOrderButton.click();

        functionPage.waitForElement(customerNameField);
        customerNameField.sendKeys("team1 Test");
        customerNameField.sendKeys(Keys.ENTER);

        functionPage.waitForElement(selectedCustomer);
        functionPage.sleep(3);
        selectedCustomer.click();
    }

    public void createOrder(){
        functionPage.waitForElement(store);
        store.click();
        functionPage.waitForElement(addProductsButton);
        addProductsButton.click();
        functionPage.waitForElement(productName);
        productName.click();

        functionPage.waitForElement(productIDField);
        productIDField.sendKeys("394");
        productIDField.sendKeys(Keys.ENTER);

        functionPage.sleep(4);

        functionPage.waitForElement(selectBox);
        functionPage.sleep(1);
        selectBox.click();
    }

    public void fillTheForm(){
        functionPage.waitForElement(addSelectedProductToOrder);
        addSelectedProductToOrder.click();

        functionPage.waitForElement(firstNameField);
        firstNameField.sendKeys(functionPage.generateFirstName());
        functionPage.waitForElement(lastNameField);
        lastNameField.sendKeys(functionPage.generateLastName());
        functionPage.waitForElement(streetAddress);
        streetAddress.sendKeys(functionPage.generateStreetName());
        functionPage.waitForElement(cityField);
        cityField.sendKeys(functionPage.generateCityName());
        functionPage.waitForElement(countryField);
        select=new Select(countryField);
        select.selectByVisibleText("Netherlands");
        functionPage.waitForElement(zipCode);
        zipCode.sendKeys(functionPage.generateZipCode());
        functionPage.waitForElement(telephoneField);
        telephoneField.sendKeys(functionPage.generateTelephoneNumber());
        functionPage.sleep(3);
        functionPage.waitForElement(shippingMethod);
        shippingMethod.click();
        functionPage.waitForElement(freeShipping);
        freeShipping.click();
        functionPage.sleep(3);
        functionPage.waitForElement(cashOnDelivery);
        cashOnDelivery.click();
        functionPage.waitForElement(emailField);
        emailField.clear();
        emailField.sendKeys(functionPage.generateEmail());
        functionPage.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        functionPage.waitForElement(submitOrder);
        functionPage.sleep(2);
        submitOrder.click();
    }

    public boolean verify(){
        functionPage.waitForElement(successMassage);
        if (successMassage.isDisplayed())
             return true;
        else
            return false;
    }


}
