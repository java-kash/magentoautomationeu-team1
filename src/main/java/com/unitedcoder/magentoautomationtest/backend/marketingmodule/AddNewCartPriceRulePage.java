package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCartPriceRulePage {

    WebDriver driver;

    FunctionPage functionPage;
    Actions actions;
    String configFile="config-qa.properties";
    String  sentRuleName= TestBase.readFromConfigProperties(configFile,"ruleName");

    public AddNewCartPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions= new Actions(driver);
    }

    @FindBy(xpath = "//span[text()='Promotions']")
    WebElement promotionsLink;
    @FindBy(xpath = "//span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceRules;
   @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    WebElement addNewRule;
   @FindBy(id = "rule_name")
    WebElement ruleName;
   @FindBy(id = "rule_is_active")
      WebElement status;
   @FindBy(id ="rule_website_ids" )
    WebElement websites;
   @FindBy(id="rule_customer_group_ids")
    WebElement customerGroups;
   @FindBy(id = "rule_coupon_type")
    WebElement coupon;
   @FindBy(xpath = "(//span[text()='Save'])[1]")
    WebElement saveButton;
   @FindBy(xpath = "//span[text()='The rule has been saved.']")
    WebElement successMessages;
    @FindBy(xpath = "//td[contains(text(),'50% Sales')]")
    WebElement existingRule;
    @FindBy(id = "rule_description")
    WebElement descriptionField;

   public void addNewShoppingCartPriceRule(){
       functionPage.waitForElement(promotionsLink);
       promotionsLink.click();
    functionPage.waitForElement(shoppingCartPriceRules);
    shoppingCartPriceRules.click();
    functionPage.waitForElement(addNewRule);
    addNewRule.click();
    functionPage.waitForElement(ruleName);
    ruleName.sendKeys(sentRuleName);
    Select dropDownStatus = new Select(status);
    dropDownStatus.selectByVisibleText("Active");
    Select dropDownWebsites=new Select(websites);
    dropDownWebsites.selectByValue("28");
    Select dropDownGroups=new Select(customerGroups);
    dropDownGroups.selectByValue("0");
    Select dropDownCoupon=new Select(coupon);
    dropDownCoupon.selectByValue("1");
    functionPage.waitForElement(saveButton);

    actions.moveToElement(saveButton).build().perform();
    saveButton.click();

   }
   public boolean verifyAddNewShoppingCartPriceRule(){
       functionPage.waitForElement(successMessages);
       return successMessages.isDisplayed();
   }

   public void upDateShoppingCartPriceRule(){
       functionPage.waitForElement(promotionsLink);
       promotionsLink.click();
       functionPage.waitForElement(shoppingCartPriceRules);
       shoppingCartPriceRules.click();
       functionPage.waitForElement(existingRule);
       existingRule.click();
       functionPage.waitForElement(descriptionField);
       descriptionField.clear();
       descriptionField.sendKeys(TestBase.readFromConfigProperties(configFile,"description"));
       functionPage.waitForElement(saveButton);
       actions.moveToElement(saveButton).build().perform();
       saveButton.click();
   }
   public boolean verifyUpDateShoppingCartPriceRule(){
       functionPage.waitForElement(successMessages);
       if(successMessages.isDisplayed()){
           return true;
       }
        return false;
   }

}
