package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInformation {
    WebDriver driver;
    FunctionPage functionPage;
    @FindBy(xpath = "//a[contains(text(),'Account Information')]")
    WebElement accountInformationLink;
    @FindBy(css = "#middlename")
    WebElement middleNameField;
    @FindBy(css = "#current_password")
    WebElement currentPasswordField;
    @FindBy(css = "//span[contains(text(),'Save')]")
    WebElement saveButton;
    @FindBy(xpath = "//span[contains(text(),'The account information has been saved.')]")
    WebElement successfullyEditMessage;


    public EditAccountInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    public void clickOnAccountInformationLink() {
        functionPage.waitForElement(accountInformationLink);
        accountInformationLink.click();
    }
    public void clickOnMiddleNameField() {
        functionPage.waitForElement(middleNameField);
        middleNameField.click();
    }
    public void editAccountInformation(){
        functionPage.waitForElement(middleNameField);
        middleNameField.sendKeys();
        currentPasswordField.sendKeys();
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
}
