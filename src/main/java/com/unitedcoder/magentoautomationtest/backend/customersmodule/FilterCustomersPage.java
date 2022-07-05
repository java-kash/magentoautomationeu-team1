package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterCustomersPage {
    WebDriver driver;
    FunctionPage functionPage;
    public FilterCustomersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

        @FindBy (xpath ="//*[@id='customerGrid_filter_group'][1]")
        WebElement Groups;
        @FindBy(xpath="//*[text()='Search']")
        WebElement clickonSearch;

    public void ManagerFilter(){
        functionPage.waitForElement(Groups);
        Groups.click();
        Select select=new Select(Groups);
        select.selectByVisibleText("Private");
        functionPage.waitForElement(clickonSearch);
        clickonSearch.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }





}
