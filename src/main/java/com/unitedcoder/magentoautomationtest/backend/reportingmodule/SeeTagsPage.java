package com.unitedcoder.magentoautomationtest.backend.reportingmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SeeTagsPage {

//Reporting Manager should be able to see Tags - Popular Report

    WebDriver reportingDriver;
    FunctionPage functionPage;

    public SeeTagsPage(WebDriver reportingDriver) {
        this.reportingDriver = reportingDriver;
        PageFactory.initElements(reportingDriver,this);
        functionPage=new FunctionPage(reportingDriver);
    }


    @FindBy(xpath = "//ul[@id=\"nav\"]/li/a/span[contains(text(),\"Reports\")]")
    WebElement reportsTab;

    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul/li/a/span[contains(text(),\"Tags\")]")
    WebElement tagsOption;

    @FindBy(xpath = "//ul[@id=\"nav\"]/li/ul/li/ul/li/a/span[contains(text(),\"Popular\")]")
    WebElement popular;

    @FindAll(@FindBy(css = "table[id=\"grid_table\"]>tbody>tr"))
    List<WebElement> totalPopularTags;

    public void viewPopularReport(){
        functionPage.waitForElement(reportsTab);
        reportsTab.click();
        functionPage.waitForElement(tagsOption);
        tagsOption.click();
        functionPage.waitForElement(popular);
        popular.click();
    }

    public boolean verifyReport(){
        if (totalPopularTags.size() > 0 );
            return true;
    }



}
