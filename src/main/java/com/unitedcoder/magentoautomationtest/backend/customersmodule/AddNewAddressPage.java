package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AddNewAddressPage {


//customer module -- Customer Manager can add a new address for a customer

    WebDriver customerDriver;
    FunctionPage functionPage;
    Select select;

    public AddNewAddressPage(WebDriver customerDriver) {
        this.customerDriver = customerDriver;
        PageFactory.initElements(customerDriver,this);
        functionPage=new FunctionPage(customerDriver);
    }


    @FindAll(@FindBy(css = "#customerGrid_table>tbody>tr"))
    List<WebElement> allCustomers;


    @FindBy(css = "a[name=\"addresses\"]")              // bu element  2 tal chikiwaldi.
    WebElement addressesLink;

    @FindBy(xpath = "//*[contains(text(),\"Add New Address\")]")     // bu element 2 tal chikiwaldi.
    WebElement addNewAddressButton;

    @FindBy(css = "input[id=\"_item1street0\"]")
    WebElement streetAddressField;

    @FindBy(css = "input[id=\"_item1city\"]")
    WebElement cityField;

    @FindBy(css = "select[id=\"_item1country_id\"]")
    WebElement countryField;

    @FindBy(css = "input[id=\"_item1postcode\"]")
    WebElement zipCodeField;

    @FindBy(css = "input[id=\"_item1telephone\"]")
    WebElement telephoneField;

    @FindBy(xpath = "//span[contains(text(),\"Save Customer\")]")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//span[contains(text(),\"The customer has been saved.\")]")
    WebElement successMassage;


    public void selectCustomer(){
        int randomNumber=1 + (int)(Math.random() * ((allCustomers.size() - 1) + 1));
        WebElement randomCustomer=customerDriver.findElement(By.xpath("//table[@id=\"customerGrid_table\"]/tbody/tr["+randomNumber+"]/td[@class=\" last\"]/a"));
        functionPage.waitForElement(randomCustomer);
        randomCustomer.click();
    }

    public void addNewAddress(){
        functionPage.waitForElement(addressesLink);
        addressesLink.click();
        functionPage.waitForElement(addNewAddressButton);
        addNewAddressButton.click();
        streetAddressField.sendKeys(functionPage.generateStreetName());
        cityField.sendKeys(functionPage.generateCityName());
        select=new Select(countryField);
        select.selectByVisibleText("Netherlands");
        zipCodeField.sendKeys(functionPage.generateZipCode());
        telephoneField.sendKeys(functionPage.generateTelephoneNumber());
        saveCustomerButton.click();
    }


    public boolean verifyAddAddress(){
        functionPage.waitForElement(successMassage);
        successMassage.isDisplayed();
        return true;
    }




}
