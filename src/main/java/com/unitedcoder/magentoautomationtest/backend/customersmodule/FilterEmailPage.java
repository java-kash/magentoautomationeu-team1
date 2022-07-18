package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.List;

public class FilterEmailPage {
    WebDriver driver;
    FunctionPage functionPage;

    String  sentEmail=TestBase.readFromConfigProperties("config-qa.properties","filterEmail");
    public FilterEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }
    @FindBy(id="customerGrid_filter_email")
    WebElement filterEmailInputBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBys(
            @FindBy(xpath ="//*[@id=\"customerGrid_table\"]/tbody/tr/td[4]" )
    )
    List<WebElement> verification;


    public void filterEmail(){

        functionPage.waitForElement(filterEmailInputBox);
        filterEmailInputBox.click();
        filterEmailInputBox.sendKeys(sentEmail);

        functionPage.waitForElement(searchButton);
        searchButton.click();

    }
    public void verification()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(verification.size(),1);
        Assert.assertEquals(verification.get(0).getText(),sentEmail);
    }
}
