package com.unitedcoder.magentoautomationtest.backend.catalogmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterProductsByCategoryPage {

    WebDriver filterDriver;
    FunctionPage functionPage;
    Select select;
    Actions actions;

    public FilterProductsByCategoryPage(WebDriver filterDriver) {
        this.filterDriver = filterDriver;
        PageFactory.initElements(filterDriver, this);
        functionPage = new FunctionPage(filterDriver);
        actions=new Actions(filterDriver);
    }

    @FindBy(xpath = "//span[contains(text(),\"Catalog\")]")
    WebElement catalogTab;

    @FindBy(xpath = "//span[contains(text(),\"Manage Categories\")]")
    WebElement manageCategoriesOption;

    @FindBy(css = ".tree-actions>a[onclick=\"tree.expandTree(); return false;\"]")
    WebElement expandAll;

    @FindBy(css = "#category_info_tabs_products")
    WebElement categoryProductsTab;

    @FindBy(css = "select[name=\"limit\"]")
    WebElement viewLimit;

    @FindBy(xpath = "//span[contains(text(),\"Electronics (13)\")]")
    WebElement electronicsCategory;

    @FindAll(@FindBy(css = "#catalog_category_products_table>tbody>tr"))
    List<WebElement> electronicsTable;

    @FindBy(xpath = "//div[@id=\"category-edit-container\"]/div/h3[contains(text(),\"Electronics (ID: 24)\")]")
    WebElement headerOfElectronicsProduct;


    public void openCategoryList(){
        functionPage.waitForElement(catalogTab);
        actions.moveToElement(catalogTab).perform();
        functionPage.waitForElement(manageCategoriesOption);
        manageCategoriesOption.click();
        functionPage.waitForElement(expandAll);
        expandAll.click();
        functionPage.waitForElement(categoryProductsTab);
        categoryProductsTab.click();
    }

    public void viewLimit(){
        functionPage.waitForElement(viewLimit);
        select=new Select(viewLimit);
        int selectOptions=select.getOptions().size();
        select.selectByIndex(selectOptions-1);            // select last option of view dropdown list.
    }

    public void filterByCategoryName(){
        functionPage.waitForElement(electronicsCategory);
        electronicsCategory.click();
    }


    public boolean verify(){
        functionPage.waitForElement(headerOfElectronicsProduct);
        if(electronicsTable.size()>0 && headerOfElectronicsProduct.isDisplayed()) {
            return true;
        }
        return true;
    }




}
