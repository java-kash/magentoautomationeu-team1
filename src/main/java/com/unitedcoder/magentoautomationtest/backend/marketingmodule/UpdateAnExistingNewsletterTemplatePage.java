package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAnExistingNewsletterTemplatePage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";
    String newContent=null;

    public UpdateAnExistingNewsletterTemplatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(xpath = "//span[contains(text(),\"Newsletter\")]")
    WebElement newsletterTab;
    @FindBy(xpath = "//span[contains(text(),'Newsletter Templates')]")
    WebElement newsletterTemplateOption;
    @FindBy(xpath = "//input[@name=\"code\"]")
    WebElement searchTemplateNameField;
    @FindBy(xpath = "//span[contains(text(),\"Search\")]")
    WebElement searchButton;
    @FindBy(id = "code")
    WebElement templateNameField;
    @FindBy(css = "#text")
    WebElement templateContentField;
    @FindBy(xpath = "//span[contains(text(),\"Save Template\")]")
    WebElement saveTemplateButton;
    @FindBy(xpath ="//div[@class=\"hor-scroll\"]//tbody//td[1]")
    WebElement myAddedTemplate;

    public void updateNewsletterTemplate(String templateName, String newContent){
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
        functionPage.waitForElement(templateContentField);
        templateContentField.clear();
        templateContentField.sendKeys(newContent);
        functionPage.waitForElement(saveTemplateButton);
        saveTemplateButton.click();
    }
        public boolean updateNewsletterTemplateSuccessfully(String templateName){
        functionPage.waitForElement(newsletterTab);
        newsletterTab.click();
        functionPage.waitForElement(newsletterTemplateOption);
        newsletterTemplateOption.click();
        functionPage.waitForElement(searchTemplateNameField);
        searchTemplateNameField.sendKeys(templateName);
        functionPage.waitForElement(searchButton);
        searchButton.click();
        functionPage.waitForElement(myAddedTemplate);
        myAddedTemplate.click();
        functionPage.waitForElement(templateContentField);
        String myContent=templateContentField.getText();
       if(myContent.equalsIgnoreCase(newContent)){
           return true;
       }else
           return false;
    }
}
