package com.unitedcoder.magentoautomationtest.backend.catalogmodule;


import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class NewProductAttributePage extends TestBase {

    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    String currentTimeStamp = String.valueOf(System.currentTimeMillis());
    String attributeCode;

    public NewProductAttributePage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    @FindBy(css = "#attribute_code")
    WebElement attributeCodeField;

    @FindBy(xpath = "//*[@onchange='toggleApplyVisibility(this)']")
    WebElement applyToOptionField;

    @FindBy(xpath = "//*[@class='middle']//*[@title='Save Attribute']")
    WebElement saveAttributeButton;

    @FindBy(css = ".input-text.required-option.validation-failed")
    WebElement adminField;

    @FindBy(css = "#messages")
    WebElement successMessage;

    public static void selectValueFromDropDown(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public void enterOrSelectValidValues() {
        String codeName = readFromConfigProperties(configFile, "attributeCode") + currentTimeStamp;
        System.out.println("first time"+codeName);
        functionPage.waitForElement(attributeCodeField);
        attributeCodeField.sendKeys(codeName);
        setAttributeCode(codeName);
        functionPage.waitForElement(applyToOptionField);
        selectValueFromDropDown(applyToOptionField, "1");
        Random random = new Random();
        List<WebElement> options = driver.findElements(By.xpath("//*[@id='apply_to']//option"));
        int list = random.nextInt(options.size());
        options.get(list).click();
        functionPage.waitForElement(saveAttributeButton);
        saveAttributeButton.click();
        functionPage.waitForElement(adminField);
        adminField.sendKeys(readFromConfigProperties(configFile, "admin") + currentTimeStamp);
        functionPage.waitForElement(saveAttributeButton);
        saveAttributeButton.click();
    }

    public boolean verifyNewAttributeSuccessMessages() {
        System.out.println("seconde"+getAttributeCode());
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().contains("The product attribute has been saved.")) {
            return true;
        } else
            return false;
    }

    public boolean verifyNewAttributeInTheTableList() {
        return driver.getPageSource().contains(getAttributeCode());
    }
}
