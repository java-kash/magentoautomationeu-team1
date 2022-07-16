package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditOrderPage {

 //Store Manager can edit orders

    WebDriver storeDriver;
    FunctionPage functionPage;
    Actions actions;
    Select select;

    public EditOrderPage(WebDriver storeDriver) {
        this.storeDriver = storeDriver;
        PageFactory.initElements(storeDriver,this);
        functionPage=new FunctionPage(storeDriver);
        actions=new Actions(storeDriver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Sales\")]")
    WebElement salesTab;

    @FindBy(xpath = "//span[contains(text(),\"Orders\")]")
    WebElement ordersOption;

    @FindBy(css = "#sales_order_grid_filter_status")
    WebElement status;

    @FindBy(css = ".middle>div>div>div[id=\"sales_order_grid\"]>table>tbody>tr>td[class=\"filter-actions a-right\"]>button[class=\"scalable task\"]>span>span>span")
    WebElement searchButton;

    @FindBy(css = "#sales_order_grid_filter_real_order_id")
    WebElement orderField;

    @FindBy(css = "td[class=\" last\"]>a")
    WebElement viewLink;

    @FindBy(xpath = "//span[contains(text(),\"Edit\")]")
    WebElement editButton;

    @FindBy(css = "input[class=\"input-text item-qty\"]")
    WebElement quantityField;

    @FindBy(css = "#order-shipping-method-summary>a")
    WebElement shippingMethod;

    @FindBy(css = "#s_method_freeshipping_freeshipping")
    WebElement freeShipping;

    @FindBy(xpath = "//span[contains(text(),\"Update Items and Qty's\")]")
    WebElement updateItemsAndQuantityButton;

    @FindBy(css = ".middle>div>.content-header>p>#submit_order_top_button>span>span>span")
    WebElement submitOrderButton;

    @FindBy(xpath = "//span[contains(text(),\"The order has been created.\")]")
    WebElement successMassage;


    public void findOrder(){
        functionPage.waitForElement(salesTab);
        salesTab.click();
        functionPage.waitForElement(ordersOption);
        ordersOption.click();
        functionPage.waitForElement(status);
        select=new Select(status);
        select.selectByVisibleText("Pending");
        functionPage.waitForElement(searchButton);
        searchButton.click();
        functionPage.sleep(3);
        functionPage.waitForElement(viewLink);
        viewLink.click();
    }

    public void editOrder(){
        functionPage.waitForElement(editButton);
        editButton.click();
        functionPage.alertAccept();
        functionPage.sleep(3);
        functionPage.waitForElement(quantityField);
        quantityField.clear();
        quantityField.sendKeys("4");
        functionPage.waitForElement(updateItemsAndQuantityButton);
        updateItemsAndQuantityButton.click();
        functionPage.waitForElement(shippingMethod);
        shippingMethod.click();
        functionPage.waitForElement(freeShipping);
        freeShipping.click();
        functionPage.sleep(3);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        functionPage.sleep(2);
        actions.click(submitOrderButton).build().perform();
    }

    public boolean verify(){
        functionPage.waitForElement(successMassage);
        if (successMassage.isDisplayed())
        return true;
        else
            return false;
    }



}
