package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class EditOrdersWithInStorePickup {

//Sales Manager should be able to edit orders with in store pickup

    WebDriver salesDriver;
    FunctionPage functionPage;
    Select select;
    Actions actions;
    Random random;
    JavascriptExecutor javascriptExecutor;

    public EditOrdersWithInStorePickup(WebDriver salesDriver) {
        this.salesDriver = salesDriver;
        PageFactory.initElements(salesDriver,this);
        functionPage=new FunctionPage(salesDriver);
        actions=new Actions(salesDriver);
        javascriptExecutor=(JavascriptExecutor)salesDriver;
    }

//    @FindBy(xpath = "//ul[@id=\"nav\"]//li[@class=\"parent level0\"]//span[contains(text(),\"Sales\")]")
//    @FindBy(xpath = "//div[@class=\"nav-bar\"]//li[@class=\"parent level0\"]/a/span[contains(text(),\"Sales\")]")
//    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/a/span")
    @FindBy(xpath = "//span[contains(text(),\"Sales\")]")
    WebElement salesTab;


//    @FindBy(xpath = "//li[@class=\"  level1\"]//span[contains(text(),\"Orders\")]")
    @FindBy(xpath = "//div[@class=\"nav-bar\"]//li[@class=\"  level1\"]/a/span[contains(text(),\"Orders\")]")
    WebElement ordersOption;

//    @FindBy(css = "select[id=\"sales_order_grid_filter_status\"]")
//    WebElement selectStatus;
//
//    @FindBy(css = "[title=\"Search\"][class=\"scalable task\"]")
//    WebElement searchButton;

//    @FindAll(@FindBy(css = "table[id=\"sales_order_grid_table\"]>tbody>tr"))
//    List<WebElement> totalOrders;

    @FindBy(css = "#sales_order_grid_filter_real_order_id")
    WebElement orderNumberField;

    @FindBy(xpath = "//a[contains(text(),\"View\")]")
    WebElement viewButton;

    @FindBy(css = "[title=\"Edit\"][class=\"scalable \"]")
    WebElement editButton;

    @FindBy(css = "input[class=\"input-text item-qty\"]")          //bu element din 2 si chikiwaldi.
    WebElement quantityField;

    @FindBy(xpath = "//span[contains(text(),\"Update Items and Qty's\")]")  //bu element dinmu 2 si chikiwaldi.
    WebElement updateItemsAndQtyButton;

//    @FindBy(css = "#order-shipping-method-summary>a")
    @FindBy(xpath = "//a[contains(text(),\"Get shipping methods and rates\")]")
    WebElement shippingMethod;

    @FindBy(css = "#s_method_freeshipping_freeshipping")
    WebElement freeShipping;

    @FindBy(css = "#p_method_purchaseorder")
    WebElement inStorePickupPayment;

    @FindBy(css = "#po_number")
    WebElement orderNumber;

    @FindBy(css = "#anchor-content>div>.content-header>p>#submit_order_top_button")
//    @FindBy(xpath = "//div[@class=\"middle\"]/div/div[@class=\"content-header\"]/p/button[@id=\"submit_order_top_button\"]")
//    @FindBy(xpath = "//span[contains(text(),\"Submit Order\")]")
    WebElement submitOrder;

    @FindBy(xpath = "//span[contains(text(),\"The order has been created.\")]")
    WebElement editSuccessMassage;


    public void edit(){
        functionPage.waitForElement(salesTab);
        salesTab.click();
        functionPage.waitForElement(ordersOption);
        ordersOption.click();

        functionPage.waitForElement(orderNumberField);
        orderNumberField.sendKeys("145000146");
        orderNumberField.sendKeys(Keys.ENTER);

        functionPage.waitForElement(viewButton);
        javascriptExecutor.executeScript("arguments[0].click()",viewButton);
//        viewButton.click();


        functionPage.waitForElement(editButton);
        editButton.click();
        functionPage.alertAccept();

        functionPage.waitForElement(quantityField);
        quantityField.clear();
        random=new Random();
        int x=random.nextInt(10);

        quantityField.sendKeys(String.valueOf(x));
        functionPage.waitForElement(updateItemsAndQtyButton);
        updateItemsAndQtyButton.click();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        functionPage.sleep(2);

        functionPage.waitForElement(shippingMethod);
//        shippingMethod.click();
        javascriptExecutor.executeScript("arguments[0].click()",shippingMethod);
        functionPage.waitForElement(freeShipping);
//        freeShipping.click();
        javascriptExecutor.executeScript("arguments[0].click()",freeShipping);
        functionPage.sleep(2);
        functionPage.waitForElement(inStorePickupPayment);
        inStorePickupPayment.click();
        functionPage.waitForElement(orderNumber);
        orderNumber.clear();
        orderNumber.sendKeys("12345");
        functionPage.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        functionPage.sleep(2);

        functionPage.waitForElement(submitOrder);
        javascriptExecutor.executeScript("arguments[0].click()",submitOrder);
 //       submitOrder.click();
//        actions.doubleClick(submitOrder).build().perform();
    }

    public boolean editVerify(){
        functionPage.waitForElement(editSuccessMassage);
        editSuccessMassage.isDisplayed();
        return true;
    }




}
