package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.github.javafaker.Faker;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CreateWebsitePage {
    WebDriver driver;
    FunctionPage functionPage;
    String  sentName= TestBase.readFromConfigProperties("config-qa.properties","websiteName");



    public CreateWebsitePage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }


    @FindBy(xpath = "(//button[@title='Create Website'])[1]")
    WebElement createWebsiteIcon;
    @FindBy(id = "website_name")
    WebElement name;
    @FindBy(id ="website_code" )
    WebElement websiteCode;
    @FindBy(xpath = "(//span[text()='Save Website'])[1]")
    WebElement saveWebsiteButton;
   @FindBy(xpath = "//span[text()='The website has been saved.']")
    WebElement successMassage;

   public void createWebsite(){

       functionPage.waitForElement(createWebsiteIcon);
       createWebsiteIcon.click();
       name.sendKeys(sentName);
       functionPage.waitForElement(websiteCode);
       Random random = new Random();
       char randomizedCharacter = (char) (random.nextInt(26) + 'a');
       Faker javaFaker=  new Faker();
       String zipCode = functionPage.generateZipCode().toString().replace("-","_");
       websiteCode.sendKeys(randomizedCharacter+zipCode);
       functionPage.waitForElement(saveWebsiteButton);
       saveWebsiteButton.click();

   }
   public boolean verifyCreateWebsite(){
       functionPage.waitForElement(successMassage);
       if (successMassage.isDisplayed())
           return true;
       else
           return false;
   }






}
