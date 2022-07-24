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

    String  sentRuleName= TestBase.readFromConfigProperties("config-qa.properties","ruleName");

    public AddNewCartPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
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
    Actions actions= new Actions(driver);
    actions.moveToElement(saveButton).build().perform();
    saveButton.click();

   }
   public boolean verifyAddNewShoppingCartPriceRule(){
       functionPage.waitForElement(successMessages);
       return successMessages.isDisplayed();
   }

}
