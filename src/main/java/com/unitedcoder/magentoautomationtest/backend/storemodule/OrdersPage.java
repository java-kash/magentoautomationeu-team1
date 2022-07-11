package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-11-7:44 PM
 */
public class OrdersPage {
    WebDriver driver;
    FunctionPage functionPage;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }
}
