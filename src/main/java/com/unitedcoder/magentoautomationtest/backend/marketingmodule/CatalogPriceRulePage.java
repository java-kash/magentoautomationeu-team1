package com.unitedcoder.magentoautomationtest.backend.marketingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CatalogPriceRulePage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    private String idNumber;
    private String ruleName;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    public CatalogPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
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

    @FindBy(css = "#promo_catalog_grid_filter_rule_id")
    WebElement idField;

    @FindBy(css = "#promo_catalog_grid_filter_name")
    WebElement rulesNameField;

    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@title='Reset Filter']")
    WebElement resetFilterButton;

    public void addNewCatalogPriceRule(String ruleName) {
        functionPage.waitForElement(addNewRuleButton);
        addNewRuleButton.click();
        functionPage.waitForElement(ruleNameField);
        ruleNameField.clear();
        ruleNameField.sendKeys(ruleName);
        Select status = new Select(statusSelect);
        functionPage.waitForElement(statusSelect);
        status.selectByVisibleText(MarketingDropDownSelect.Active.name());
        Select webSites = new Select(webSitesSelect);
        functionPage.waitForElement(webSitesSelect);
        webSites.selectByValue("1");
        Select customerGroup = new Select(customerGroupsSelect);
        functionPage.waitForElement(customerGroupsSelect);
        customerGroup.selectByVisibleText(MarketingDropDownSelect.Almas.name());
        functionPage.waitForElement(actionsLink);
        actionsLink.click();
        functionPage.waitForElement(discountAmountField);
        discountAmountField.sendKeys(readFromConfigProperties(configFile, "discount-amount"));
        functionPage.waitForElement(saveButton);
        saveButton.click();
    }

    public boolean verifyAddNewCatalogPriceRule() {
        functionPage.waitForElement(successMessages);
        if (successMessages.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void selectsOneIdNumberRandomly() {
        Random random = new Random();
        List<WebElement> listInSections = driver.findElements(By.xpath("//*[@class='data']/tbody/tr/td[1]"));
        while (true) {
            int list = random.nextInt(listInSections.size());
            String selectedId = listInSections.get(list).getText();
            if (Integer.parseInt(selectedId) >= 10) {
                setIdNumber(selectedId);
                System.out.println("This is a selected Rule Name: " + selectedId);
                break;
            }
        }
    }

    public void fillIdToField() {
        idField.sendKeys(getIdNumber());
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public String getFieldValue() {
        return idField.getAttribute("value");
    }

    public String listIdNumber() {
        WebElement numberOnList = driver.findElement(By.xpath("//*[@class='data']//tbody//td[1][contains(.,'" + getIdNumber() + "')]"));
        return numberOnList.getText();
    }

    public void clickOnResetButton() {
        resetFilterButton.click();
    }

    public void selectsOneRuleNameRandomly() {
        Random random = new Random();
        List<WebElement> listInSections = driver.findElements(By.xpath("//*[@class='data']/tbody/tr/td[2]"));
        int list = random.nextInt(listInSections.size());
        String selectedRuleName = listInSections.get(list).getText();


        setRuleName(selectedRuleName);
        System.out.println("This is a selected Rule Name: " + selectedRuleName);
    }

    public void fillNameToField() {
        rulesNameField.sendKeys(getRuleName());
    }

    public String getNameFieldValue() {
        return rulesNameField.getAttribute("value");
    }

    public String listRuleName() {
        WebElement nameOnList = driver.findElement(By.xpath("//*[@class='data']//tbody//td[2][contains(.,'" + getRuleName() + "')]"));
        return nameOnList.getText();
    }




}
