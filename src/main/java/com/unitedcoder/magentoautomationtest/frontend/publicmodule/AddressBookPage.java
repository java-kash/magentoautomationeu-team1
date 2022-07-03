package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AddressBookPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;

    @FindBy(xpath= "//a[text()='Manage Addresses']")
    WebElement manageAddressLink;

    @FindBy(xpath = "//a[text()='Change Billing Address']")
    WebElement changeAddressLink;
    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(css = ".buttons-set > button")
    WebElement saveAddressButton;
    @FindBy(css = ".success-msg span")
    WebElement successMsg;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        actions = new Actions(driver);

    }
//    public static String getRandomString(int size) {
//
//        String rand = "";
//        String chars = "qwertyuiopQWERTYUIOPasdfghjklASDFGHJKLzxcvbnmZXCVBNM";
//        for (int i = 0; i < size; i++) {
//            rand += chars.toCharArray()[new Random().nextInt(chars.length())];
//        }
//        return rand;
//    }

    public void UpdateAddress(){
        functionPage.waitForElement(manageAddressLink);
        manageAddressLink.click();
        functionPage.waitForElement(changeAddressLink);
        changeAddressLink.click();

        functionPage.waitForElement(cityField);
        cityField.sendKeys("a");
        functionPage.waitForElement(saveAddressButton);
        saveAddressButton.click();

    }


        public boolean verifyUpdateAddress(){
        functionPage.waitForElement(successMsg);
            return successMsg.isDisplayed();
        }
}
