package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class AddNewNewsletterTemplate extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";

    public AddNewNewsletterTemplate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Newsletter Templates')]")
    WebElement newsletterTemplateOption;
    @FindBy(xpath = "//*[contains(text(),'Add New Template')]")
    WebElement addNewTemplateButton;
    @FindBy(id = "code")
    WebElement templateNameField;
    @FindBy(css = "#subject")
    WebElement templateSubjectField;
    @FindBy(id = "sender_name")
    WebElement senderNameField;
    @FindBy(xpath = "//span[contains(text(),\"Save Template\")]")
    WebElement saveTemplateButton;
    @FindBy(xpath = "//input[@name=\"code\"]")
    WebElement searchTemplateNameField;
    @FindBy(xpath = "//span[contains(text(),\"Search\")]")
    WebElement searchButton;
    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> myTemplate;
    @FindBy(xpath = "//span[contains(text(),\"Newsletter\")]")
    WebElement newsletterTab;


    public void addNewNewsLetterTemplate(String templateName,String templateSubject,String senderName){
        functionPage.waitForElement(newsletterTab);
        newsletterTab.click();
        functionPage.waitForElement(newsletterTemplateOption);
        newsletterTemplateOption.click();
        functionPage.waitForElement(addNewTemplateButton);
        addNewTemplateButton.click();
        functionPage.waitForElement(templateNameField);
        templateNameField.sendKeys(templateName);
        functionPage.waitForElement(templateSubjectField);
        templateSubjectField.sendKeys(templateSubject);
        functionPage.waitForElement(senderNameField);
        senderNameField.clear();
        senderNameField.sendKeys(senderName);
        functionPage.waitForElement(saveTemplateButton);
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        saveTemplateButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean verifyNewsletterAddedSuccessfully(String myTemplateName){
        functionPage.waitForElement(newsletterTab);
        newsletterTab.click();
        functionPage.waitForElement(newsletterTemplateOption);
        newsletterTemplateOption.click();
        functionPage.waitForElement(searchTemplateNameField);
        searchTemplateNameField.sendKeys(myTemplateName);
        functionPage.waitForElement(searchButton);
        searchButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(myTemplate.contains(myTemplateName)){
            return true;}
            else
        { return false;
        }

//        if(myTemplate.size()>0){
//            return true;}
//         else
//        {return false;};
  }
}
