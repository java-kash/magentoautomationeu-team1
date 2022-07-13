package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

public class CustomerDashboardPage extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    String webSite;
    String countryName;
    Actions actions;

    public CustomerDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
    }

    @FindBy(css = "#messages+.content-header>table>tbody>tr>td+td>button")
    WebElement aadNewCustomerButton;
    @FindBy(xpath = "//span[text()='Customers']")
    WebElement CustomersLink;

    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[1]/ul/li[2]/a/span")
    WebElement customerGroupsLink;

    @FindBy(xpath = "//span[text()='Online Customers']")
    WebElement onlineCustomersLink;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement ReportsLink;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesLink;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsLink;

    @FindBy(xpath = "//img[@alt='Magento Logo']")
    WebElement customerMagentoDashboard;
    @FindBy(id = "anchor-content")
    WebElement manageCustomersTable;
    @FindAll(
            @FindBy(xpath = "//a[text()='Edit']")
    )
    List<WebElement> cutomerEditIcon;
    @FindBy(xpath = "//*[text()='Customer Information'][1]")
    WebElement editPageTitle;

    //kerim
    @FindBy(xpath = "//a[text()='Select All']")
    WebElement SelectAll;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportBtn;

    //Kadirdan
    @FindBy(id = "customerGrid_filter_billing_country_id")
    WebElement countryFilter;
    @FindBy(xpath = "//input[@name='billing_region']")
    WebElement stateInputBox;
    @FindBy(id = "customerGrid_filter_website_id")
    WebElement websiteFilter;
    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//select[@name='billing_country_id']/option[@selected='selected']")
    WebElement countryValue;
    @FindBy(xpath = "//th//input[@id='customerGrid_filter_billing_region']")
    WebElement stateValue;
    @FindBy(xpath = "//select[@id='customerGrid_filter_website_id']//option[@selected='selected']")
    WebElement webSiteValue;
    @FindAll(@FindBy(xpath = "//table[@id='customerGrid_table']/tbody/tr[@title]"))
    List<WebElement> filteredTableListRow;
    @FindBy(xpath = "//*[@title='Reset Filter']")
    WebElement resetFilterButton;


    public void exportCustomers() {
        functionPage.waitForElement(SelectAll);
        SelectAll.click();
        functionPage.waitForElement(exportBtn);
        exportBtn.click();

    }

    public boolean verifyExportCustpmers() {
        if (exportBtn.isEnabled()) {
            return true;
        } else
            return false;
    }

    public void clickOnAddNewCustomerButton() {
        functionPage.waitForElement(aadNewCustomerButton);
        aadNewCustomerButton.click();
    }

    public boolean clickOnMagentoLogoBackDashboard() {
        functionPage.waitForElement(customerMagentoDashboard);
        customerMagentoDashboard.click();
        functionPage.waitForElement(manageCustomersTable);
        if (manageCustomersTable.isDisplayed()) {
            return true;
        } else
            return false;
    }
    public void clickCustomerGroupsLink(){
        functionPage.waitForElement(CustomersLink);
        actions.moveToElement(CustomersLink).perform();
        functionPage.waitForElement(customerGroupsLink);
        customerGroupsLink.click();


        }

    // i need verify Add
    public boolean clickOnCustomerEditIcon() {
        WebElement firstListCustomer = cutomerEditIcon.get(1);
        functionPage.waitForElement(firstListCustomer);
        firstListCustomer.click();
        if (editPageTitle.isDisplayed()) {
            return true;
        } else
            return false;
    }

    //Kadirdan
    public static void selectValueFromDropDown(WebElement webElement, String visibleText) {
        Select select = new Select(webElement);
        select.selectByVisibleText(visibleText);
    }

    public void filterCustomerByCountry() {
        countryName = readFromConfigProperties(configFile, "countryName");
        functionPage.waitForElement(countryFilter);
        selectValueFromDropDown(countryFilter, "" + countryName + "");
        functionPage.waitForElement(searchButton);
        searchButton.click();
        //verify
        functionPage.waitForElement(countryValue);
        String verifiedCountry = countryValue.getText();
        System.out.println(verifiedCountry);
        List<WebElement> allCountryValue = driver.findElements(By.xpath("//table[@id=\"customerGrid_table\"]/tbody/tr" +
                "/td[contains(text(),'" + verifiedCountry + "')]"));
        Assert.assertEquals(allCountryValue.size(), filteredTableListRow.size());
    }

    public void filterCustomerByState() {
        functionPage.waitForElement(stateInputBox);
        stateInputBox.sendKeys(readFromConfigProperties(configFile, "stateValue"));
        functionPage.waitForElement(searchButton);
        searchButton.click();
        //can't verify, system issue
    }

    public void filterCustomerByWebsite() {
        webSite = readFromConfigProperties(configFile, "webSite");
        functionPage.waitForElement(websiteFilter);
        selectValueFromDropDown(websiteFilter, "" + webSite + "");
        functionPage.waitForElement(searchButton);
        searchButton.click();
        //verify
        functionPage.waitForElement(webSiteValue);
        String verifiedWebSite = webSiteValue.getText();
        System.out.println(verifiedWebSite);
        List<WebElement> allWebSiteValue = driver.findElements(By.xpath("//table[@id=\"customerGrid_table\"]/tbody/tr" +
                "/td[contains(text(),'" + verifiedWebSite + "')]"));
        Assert.assertEquals(allWebSiteValue.size(), filteredTableListRow.size());
    }


}
