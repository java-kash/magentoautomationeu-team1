package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;

public class MyWishPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    Object object;
    @FindBy(css = "h3.product-name>a")
    WebElement onTheMyWishListProduct;
    @FindBy(css = ".nav-primary>.level0.nav-3.parent>a")
    WebElement navSaleDrownList;
    @FindBy(xpath = "//a[text()='View All Sale']")
    WebElement viewAllSale;
    @FindBy(css = ".add-to-links>li>a")
    WebElement addToLinks;


    public MyWishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions = new Actions(driver);

    }

    public void addMyWishList() {
        functionPage.waitForElement(navSaleDrownList);
        actions.moveToElement(navSaleDrownList).click(viewAllSale).perform();
        List<WebElement> list = Collections.singletonList(addToLinks);
        list.get(0).click();
    }

    public boolean myWishList() {
        addMyWishList();

        List<WebElement> links = Collections.singletonList(onTheMyWishListProduct);
        if (links.size() > 0) {
            Log4j.info("User able to view My Wish list ");
            return true;

        } else
            Log4j.error("Test Failed");
        return false;
    }


}
