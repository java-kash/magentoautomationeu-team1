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

    @FindBy(xpath = "//*[text()='Add New Address']")     // bu element 2 tal chikiwaldi.
    WebElement addNewAddressButton;

    @FindBy(id = "_item1street0")
    WebElement streetAddressField;

    @FindBy(id= "_item1city")
    WebElement cityField;

    @FindBy(css = "select[id=\"_item1country_id\"]")
    WebElement countryField;

    @FindBy(css = "input[id=\"_item1postcode\"]")
    WebElement zipCodeField;

    @FindBy(css = "input[id=\"_item1telephone\"]")
    WebElement telephoneField;

    @FindBy(xpath = "//button[@title='Save Customer'][1]")
    WebElement saveCustomerButton;

    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement successMassage;
    @FindBy(id = "customerGrid_filter_name")
    WebElement nameFilter;

    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchButton;
    @FindBy(css = ".even")
    WebElement selectCustomer;
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailAddressFilter;


    public void selectCustomer(String email){
//        int randomNumber=1 + (int)(Math.random() * ((allCustomers.size() - 1) + 1));
//        WebElement randomCustomer=customerDriver.findElement(By.xpath("//table[@id=\"customerGrid_table\"]/tbody/tr["+randomNumber+"]/td[@class=\" last\"]/a"));
//        functionPage.waitForElement(randomCustomer);
//        randomCustomer.click();
        functionPage.waitForElement(emailAddressFilter);
        emailAddressFilter.sendKeys(email);
        functionPage.sleep(2);
        searchButton.click();
        functionPage.sleep(2);
        selectCustomer.click();



    }

    public void addNewAddress(){
        functionPage.waitForElement(addressesLink);
        addressesLink.click();
        System.out.println("addres link success");
        functionPage.waitForElement(addNewAddressButton);
        addNewAddressButton.click();
        System.out.println("click addnewaddress success");
        functionPage.sleep(5);
        streetAddressField.clear();
        streetAddressField.sendKeys(functionPage.generateStreetName());
        functionPage.waitForElement(cityField);
        cityField.clear();
        cityField.sendKeys(functionPage.generateCityName());
        select=new Select(countryField);
        select.selectByVisibleText("Netherlands");
        System.out.println("inpuit success");
        zipCodeField.sendKeys(functionPage.generateZipCode());
        telephoneField.sendKeys(functionPage.generateTelephoneNumber());
        functionPage.sleep(3);
        saveCustomerButton.click();
        functionPage.sleep(3);
    }


    public boolean verifyAddAddress(){
        functionPage.waitForElement(successMassage);
        successMassage.isDisplayed();
        return true;
    }




}
