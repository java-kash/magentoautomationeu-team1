package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInformation {
    WebDriver driver;
    FunctionPage functionPage;

    @FindBy(css = "#middlename")
    WebElement middleNameField;
    @FindBy(css = "#current_password")
    WebElement currentPasswordField;
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement saveButton;
    @FindBy(xpath = "//span[contains(text(),'The account information has been saved.')]")
    WebElement successfullyEditMessage;


    static  String  configFile="config-qa.properties";

    public EditAccountInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }


    public void clickOnMiddleNameField() {
        functionPage.waitForElement(middleNameField);
        middleNameField.click();
    }
    public void editAccountInformation(){
        functionPage.waitForElement(middleNameField);
        middleNameField.sendKeys(functionPage.generateMiddleName());
        currentPasswordField.sendKeys(password);
    }

    public void clickOnSaveButton() {
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }

    public boolean verifySuccessfullyEdit() {
        functionPage.waitForElement(successfullyEditMessage);
        if (successfullyEditMessage.isDisplayed()) {
            Log4j.info("Account Information edited successfully!");
            return true;
        } else
            Log4j.info("Account Information is not edited");
        return false;
    }



    public String password=TestBase.readFromConfigProperties(configFile,"public_password");



}
