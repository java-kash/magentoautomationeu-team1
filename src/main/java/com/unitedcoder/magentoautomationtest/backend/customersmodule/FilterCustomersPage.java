package com.unitedcoder.magentoautomationtest.backend.customersmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterCustomersPage {
    WebDriver driver;
    FunctionPage functionPage;

    public FilterCustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);
    }

    @FindBy(xpath = "//*[@id='customerGrid_filter_group'][1]")
    WebElement Groups;
    @FindBy(xpath = "//*[text()='Search']")
    WebElement SearchButton;
    @FindAll(
            @FindBy(xpath = " //*[@id='customerGrid_table']/tbody/tr"))
    List<WebElement> Groupnaams;
    String name = CustomerDropDownSelect.Private.toString();

    public void ManagerFilter() {
        functionPage.waitForElement(Groups);
        Groups.click();

        Select select = new Select(Groups);
        select.selectByVisibleText(CustomerDropDownSelect.Almas.name());
        functionPage.sleep(3);
        functionPage.waitForElement(SearchButton);
        SearchButton.click();

    }

    public boolean verifyGroups() {
         functionPage.sleep(1);
        System.out.println("name                                               is"+name );
        int count1 = Groupnaams.size();
        int count = 0;
        for (WebElement list : Groupnaams) {
            list.getText();
            System.out.println(list.getText());

            if (name == list.getText()) {
                System.out.println(name);
                count++;
            }
        }
        if (count == count1) {
            return true;
        } else
            return false;
        }


    }

