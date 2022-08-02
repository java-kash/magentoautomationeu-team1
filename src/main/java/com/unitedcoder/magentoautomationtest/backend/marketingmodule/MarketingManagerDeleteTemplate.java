package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketingManagerDeleteTemplate extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";

    public MarketingManagerDeleteTemplate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Newsletter\")]")
    WebElement newsletterTab;
    @FindBy(xpath = "//span[contains(text(),'Newsletter Templates')]")
    WebElement newsletterTemplateOption;
    @FindBy(xpath = "//input[@name=\"code\"]")
    WebElement searchTemplateNameField;
    @FindBy(xpath = "//span[contains(text(),\"Search\")]")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"hor-scroll\"]//tbody//td[1]")
    WebElement myAddedTemplate;
    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> myTemplate;
    @FindBy(xpath = "//*[contains(text(),\"Delete Template\")]")
    WebElement deleteTemplateTab;

    public void deleteNewNewsLetterTemplate(String templateName) {
        functionPage.waitForElement(newsletterTab);
        newsletterTab.click();
        functionPage.waitForElement(newsletterTemplateOption);
        newsletterTemplateOption.click();
        functionPage.waitForElement(searchTemplateNameField);
        searchTemplateNameField.click();
        searchTemplateNameField.sendKeys(templateName);
        functionPage.waitForElement(searchButton);
        searchButton.click();
        functionPage.waitForElement(myAddedTemplate);
        myAddedTemplate.click();
        functionPage.waitForElement(deleteTemplateTab);
        deleteTemplateTab.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public boolean verifyNewsletterDeletedSuccessfully(String myTemplateName) {
        functionPage.waitForElement(newsletterTab);
        newsletterTab.click();
        functionPage.waitForElement(newsletterTemplateOption);
        newsletterTemplateOption.click();
        functionPage.waitForElement(searchTemplateNameField);
        searchTemplateNameField.sendKeys(myTemplateName);
        functionPage.waitForElement(searchButton);
        searchButton.click();
        if (myTemplate.size()==0) {
            return true;
        } else {
            return false;
        }
    }
}