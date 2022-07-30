package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateExistingCatalogPriceRule {

    //Marketing Manager can update existing Catalog Price Rule

    WebDriver marketingDriver;
    FunctionPage functionPage;
    Select select;

    public UpdateExistingCatalogPriceRule(WebDriver marketingDriver) {
        this.marketingDriver = marketingDriver;
        PageFactory.initElements(marketingDriver,this);
        functionPage=new FunctionPage(marketingDriver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Promotions\")]")
    WebElement promotionsTab;

    @FindBy(xpath = "//span[contains(text(),\"Catalog Price Rules\")]")
    WebElement catalogPriceRuleOption;

    @FindBy(css = "#promo_catalog_grid_filter_name")
    WebElement ruleNameField;

    @FindBy(xpath = "//td[contains(text(),\"team1\")]")
    WebElement team1;

    @FindBy(css = "#rule_description")
    WebElement descriptionField;

    @FindBy(css = "#rule_website_ids")
    WebElement websites;

    @FindBy(xpath = "//span[contains(text(),\"Save and Apply\")]")
    WebElement saveAndApplyButton;

    @FindBy(xpath = "//span[contains(text(),\"The rule has been saved.\")]")
    WebElement successMassage;


    public void openCatalogPriceRulePage(){
        functionPage.waitForElement(promotionsTab);
        promotionsTab.click();
        functionPage.waitForElement(catalogPriceRuleOption);
        catalogPriceRuleOption.click();
        functionPage.waitForElement(ruleNameField);
        ruleNameField.sendKeys("team1");
        ruleNameField.sendKeys(Keys.ENTER);
        functionPage.waitForElement(team1);
        team1.click();
    }

    public void update(){
        functionPage.waitForElement(descriptionField);
        descriptionField.clear();
        descriptionField.sendKeys("write something about team1;"+System.currentTimeMillis());
        functionPage.waitForElement(websites);
        select=new Select(websites);
        select.selectByValue("21");
        functionPage.waitForElement(saveAndApplyButton);
        saveAndApplyButton.click();
    }


    public boolean verify(){
        functionPage.waitForElement(successMassage);
        successMassage.isDisplayed();
        return true;
    }




}
