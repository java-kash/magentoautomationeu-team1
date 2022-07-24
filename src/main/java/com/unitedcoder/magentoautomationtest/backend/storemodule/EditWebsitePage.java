package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.github.javafaker.Faker;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class EditWebsitePage {

    WebDriver driver;

    FunctionPage functionPage;

    public EditWebsitePage(WebDriver driver) {
        this.driver = driver;
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(xpath =  "(//td[@class='a-left'])[1]//a")
    WebElement existingWebsite;
    @FindBy(id = "website_code")
    WebElement websiteCode;
    @FindBy(xpath = "(//span[text()='Save Website'])[1]")
    WebElement saveWebsiteButton;
    @FindBy(xpath = "//span[text()='The website has been saved.']")
    WebElement successMassage;

     public void editWebsite(){
         functionPage.waitForElement(existingWebsite);
       existingWebsite.click();
       functionPage.waitForElement(websiteCode);
         Random random = new Random();
         char randomizedCharacter = (char) (random.nextInt(26) + 'a');
//         Faker javaFaker=  new Faker();
         String zipCode = functionPage.generateZipCode().toString().replace("-","_");
         websiteCode.sendKeys(randomizedCharacter+zipCode);
       functionPage.waitForElement(saveWebsiteButton);
       saveWebsiteButton.click();

     }
    public boolean verifyEditWebsite(){
        functionPage.waitForElement(successMassage);
        if (successMassage.isDisplayed())
            return true;
        else
            return false;
    }
}
