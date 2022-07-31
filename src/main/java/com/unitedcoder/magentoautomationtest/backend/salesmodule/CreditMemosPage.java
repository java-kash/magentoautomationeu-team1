package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-07-31-10:55 AM
 */
public class CreditMemosPage {

    WebDriver driver;
    String memosNumber;
    FunctionPage functionPage;

    public CreditMemosPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    public String getMemosNumber() {
        return memosNumber;
    }

    public void setMemosNumber(String memosNumber) {
        this.memosNumber = memosNumber;
    }

    public void getNumber(){
        WebElement number = driver.findElement(By.xpath("//*[@class='wrapper']//*[@class='icon-head head-sales-order-invoice']"));
        System.out.println("Order number is: " + number.getText());
        System.out.println("Order number is: " + number.getText().replace("New Invoice for Order #",""));
        setMemosNumber(number.getText().replace("New Invoice for Order #",""));
    }

    public void fillNumberField(){
        WebElement orderField = driver.findElement(By.cssSelector("#sales_creditmemo_grid_filter_order_increment_id"));
        orderField.sendKeys(getMemosNumber());
    }


    public boolean verifyCanSeeCreditMemos(){
        WebElement valueOfOrderField = driver.findElement(By.cssSelector("#sales_creditmemo_grid_filter_order_increment_id"));
        WebElement creditMemosListTable = driver.findElement(By.cssSelector("#sales_creditmemo_grid_table tbody"));
        return creditMemosListTable.getText().contains(valueOfOrderField.getAttribute("value"));
    }
}
