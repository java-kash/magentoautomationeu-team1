package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-31-10:50 AM
 */
public class OrdersPage {

    private WebDriver driver;
    FunctionPage functionPage;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }


    public void selectPendingOrProcessingRandomly(){
        int idx = new Random().nextInt(SectionValues.values().length);
        Select status = new Select(driver.findElement(By.cssSelector("#sales_order_grid_filter_status")));
        status.selectByVisibleText(String.valueOf(SectionValues.values()[idx]));
    }

    public void clickOnAnyOrder(){
        functionPage.randomSelect("//*[@class='data']/tbody/tr");
    }
}
