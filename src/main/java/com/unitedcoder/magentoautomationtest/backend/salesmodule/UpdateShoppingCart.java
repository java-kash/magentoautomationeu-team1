package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateShoppingCart {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    public UpdateShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//span[text()='Customers'])[1]")
    WebElement customerButton;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement managerCustomer;
    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[12]/a")
    WebElement editButton;
    @FindBy(xpath = "//*[@title=\"Shopping Cart\"]/span")
    WebElement shoppingCartLink;
    @FindBy(xpath = "//*[@id=\"customer_cart_grid0_filter_name\"]")
    WebElement productNameField;
    @FindBy(xpath = "(//span[text()='Save Customer'])[1]")
    WebElement saveCustomer;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement updateSuccessMessage;

    public void manageCustomersLink() {
        functionPage.waitForElement(customerButton);
        customerButton.click();
        functionPage.waitForElement(managerCustomer);
        managerCustomer.click();
    }

    public void UpdateShoppingCart() {
        functionPage.waitForElement(editButton);
        editButton.click();
        functionPage.waitForElement(shoppingCartLink);
        shoppingCartLink.click();
        functionPage.waitForElement(productNameField);
        productNameField.click();
        productNameField.sendKeys("Catty");
        functionPage.waitForElement(saveCustomer);
        saveCustomer.click();
    }

    public boolean verifyUpdateShoppingCart() {
        functionPage.waitForElement(updateSuccessMessage);
        if (updateSuccessMessage.isDisplayed())
            return true;
        else
            return false;
    }
}

