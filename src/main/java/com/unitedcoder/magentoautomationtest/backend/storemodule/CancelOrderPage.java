package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CancelOrderPage {

//Store Manager can cancel orders

    WebDriver storeDriver;
    FunctionPage functionPage;
    Select select;

    public CancelOrderPage(WebDriver storeDriver) {
        this.storeDriver = storeDriver;
        PageFactory.initElements(storeDriver,this);
        functionPage=new FunctionPage(storeDriver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Sales\")]")
    WebElement salesTab;

    @FindBy(xpath = "//span[contains(text(),\"Orders\")]")
    WebElement ordersOption;

    @FindBy(css = "#sales_order_grid_filter_real_order_id")
    WebElement orderField;

    @FindBy(css = "#sales_order_grid_filter_status")
    WebElement status;

    @FindBy(css = ".middle>div>div>div[id=\"sales_order_grid\"]>table>tbody>tr>td[class=\"filter-actions a-right\"]>button[class=\"scalable task\"]>span>span>span")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),\"View\")]")
    WebElement viewLink;

    @FindBy(css = "div[class=\"main-col-inner\"]>.content-header>p>button[title=\"Cancel\"]>span>span>span")
    WebElement cancelButton;

    @FindBy(xpath = "//span[contains(text(),\"The order has been cancelled.\")]")
    WebElement successMassage;


    public void findOrder(){
        functionPage.waitForElement(salesTab);
//        actions.moveToElement(salesTab);
        salesTab.click();
        functionPage.waitForElement(ordersOption);
        ordersOption.click();
        functionPage.waitForElement(status);
        select=new Select(status);
        select.selectByVisibleText("Pending");
        functionPage.waitForElement(searchButton);
        searchButton.click();

        functionPage.waitForElement(viewLink);
        functionPage.sleep(3);
        viewLink.click();
    }

    public void cancelOrder(){
        functionPage.waitForElement(cancelButton);
        cancelButton.click();
        functionPage.alertAccept();
    }

    public boolean verify(){
        functionPage.waitForElement(successMassage);
        if (successMassage.isDisplayed())
            return true;
        else
            return false;
    }


}
