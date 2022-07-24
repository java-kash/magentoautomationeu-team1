package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesModuleInvoicesPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    String text;

    public SalesModuleInvoicesPage(WebDriver driver) {
        this.driver = driver;
    PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
        actions=new Actions(driver);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @FindBy(xpath = "(//a[text()='View'])[1]")
    WebElement viewIcon;
    @FindBy(xpath = "(//*[text()='Sales'])[1]")
    WebElement salesTeb;
    @FindBy(xpath = "//*[text()='Invoices']")
    WebElement invoicesOption;
    @FindBy(xpath = "(//*[@class='form-list'])[1]")
    WebElement invoiceList;
    @FindBy(id = "history_comment")
    WebElement commentField;
    @FindBy(xpath = "//*[text()='Submit Comment']")
    WebElement submitCommentButton;
    @FindBy(css = ".box-left.entry-edit")
    WebElement invoiceHistoryTable;

    public void salesManagerViewInvoices(){
        functionPage.waitForElement(salesTeb);
        actions.moveToElement(salesTeb).perform();
        functionPage.waitForElement(invoicesOption);
        invoicesOption.click();

    }
    public boolean verifyViewInvoices(){
        functionPage.waitForElement(viewIcon);
        viewIcon.click();
        if (invoiceList.isDisplayed()){
            return true;
        }else
            return false;
    }

    public void invoiceAdComment(String commentText){
        functionPage.waitForElement(commentField);
        commentField.clear();
        commentField.sendKeys(commentText);
        setText(commentText);
        functionPage.waitForElement(submitCommentButton);
        submitCommentButton.click();

    }
    public boolean verifyInvoiceComment(){
        functionPage.sleep(3);
        WebElement text=driver.findElement(By.xpath("//li[contains(.,'"+getText()+"')]"));
        //li[contains(.,'Submit')]
        return text.getText().contains(getText());

    }

}
