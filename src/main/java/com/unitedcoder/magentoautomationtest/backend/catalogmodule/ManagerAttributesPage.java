package com.unitedcoder.magentoautomationtest.backend.catalogmodule;


import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerAttributesPage {

    WebDriver driver;
    FunctionPage functionPage;

    public ManagerAttributesPage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='wrapper']//*[@title='Add New Attribute']")
    WebElement addNewAttributeButton;

    public void clickOnAddNewAttributeButton() {
        functionPage.waitForElement(addNewAttributeButton);
        addNewAttributeButton.click();
    }
}
