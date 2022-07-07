package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyOrdersPage {
    WebDriver driver;
    FunctionPage functionPage;

    public MyOrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindAll(
            @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr")
    )
    List<WebElement> ordersNumber;

    @FindBy(xpath ="//*[@id=\"my-orders-table\"]")
    WebElement allOrderTable;

    @FindBy(xpath ="//*[@class='number']")
    WebElement viewOrder;

    @FindBy (id="my-orders-table")
    List<WebElement> myOrdersTable;

    public boolean checkOutOrders() {
        functionPage.waitForElement(allOrderTable);
        if (ordersNumber.size() > 0) {
            return true;

        } else

        return false;
    }
    public boolean viewOrder() {
        functionPage.waitForElement(viewOrder);
        viewOrder.click();
        if (myOrdersTable.size() > 0) {
            return true;
        } else
            return false;
    }
}



