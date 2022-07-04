package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class AddShoppingCartPage {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";

    @FindBy(id = "search")
    WebElement searchBox;
    @FindBy(css = "button[title='Search']")
    WebElement clickSearchButton;
    @FindAll(
            @FindBy(xpath = "//button[@title=\"Add to Cart\"]")
    )
    List<WebElement> addToCartButton;

    @FindAll(
            @FindBy(xpath ="//ul[@class='products-grid products-grid--max-3-col first last odd']//li[@class='item last']" )

    )
    List<WebElement> dropdownOptions;
    @FindBy(xpath = "//span[text()='Retro Chic Eyeglasses was added to your shopping cart.']")
    WebElement actualResultWebElement;

    @FindBy(xpath = "(//a[text()='Retro Chic Eyeglasses'])[2]")
    WebElement expectProductName;
    @FindBy(css = "li.success-msg")
    WebElement addSuccessMessage;
    public AddShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }
    public void addToShoppingCart() {
        functionPage.waitForElement(searchBox);
        searchBox.click();
        searchBox.sendKeys(TestBase.readFromConfigProperties(configFile,"public_search_name"));
        functionPage.waitForElement(clickSearchButton);
        clickSearchButton.click();
        WebElement addButton=addToCartButton.get(1);
        functionPage.waitForElement(addButton);
        addButton.click();
    }




    public boolean verification()  {
          if (addSuccessMessage.isDisplayed()){
              return true;
          }else
              return false;


//        String expectedResult = expectProductName.getText().toLowerCase() + " was added to your shopping cart.";
//        System.out.println(expectedResult);
//        String actualResult = actualResultWebElement.getText().toLowerCase();
//        System.out.println(actualResult);
//        Assert.assertEquals(expectedResult,actualResult);

    }

}
