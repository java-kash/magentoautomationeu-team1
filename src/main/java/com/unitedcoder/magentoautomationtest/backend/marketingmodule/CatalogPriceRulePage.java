package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPriceRulePage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile="config-qa.properties";

    public CatalogPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }

    @FindBy(xpath = "//*[text()='Add New Rule'][1]")
    WebElement addNewRuleButton;
    @FindBy(id = "rule_name")
    WebElement ruleNameField;
    @FindBy(id = "rule_is_active")
    WebElement statusSelect;
    @FindBy(id = "rule_website_ids")
    WebElement webSitesSelect;
    @FindBy(id = "rule_customer_group_ids")
    WebElement customerGroupsSelect;
    @FindBy(xpath = "//*[text()='Actions']")
    WebElement actionsLink;
    @FindBy(id = "rule_discount_amount")
    WebElement discountAmountField;
    @FindBy(xpath = "//*[text()='Save'][1]")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()='The rule has been saved.']")
    WebElement successMessages;

    public void addNewCatalogPriceRule(String ruleName){
       functionPage.waitForElement(addNewRuleButton);
       addNewRuleButton.click();
       functionPage.waitForElement(ruleNameField);
       ruleNameField.clear();
       ruleNameField.sendKeys(ruleName);
        Select status=new Select(statusSelect);
        functionPage.waitForElement(statusSelect);
        status.selectByVisibleText(MarketingDropDownSelect.Active.name());
        Select webSites=new Select(webSitesSelect);
        functionPage.waitForElement(webSitesSelect);
        webSites.selectByValue("1");
        Select customerGroup=new Select(customerGroupsSelect);
        functionPage.waitForElement(customerGroupsSelect);
        customerGroup.selectByVisibleText(MarketingDropDownSelect.master.name());
        functionPage.waitForElement(actionsLink);
        actionsLink.click();
        functionPage.waitForElement(discountAmountField);
        discountAmountField.sendKeys(readFromConfigProperties(configFile,"discount-amount"));
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }
    public boolean verifyAddNewCatalogPriceRule(){
        functionPage.waitForElement(successMessages);
        if(successMessages.isDisplayed()){
            return true;
        }
        return false;
    }



}
