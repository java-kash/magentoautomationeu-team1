package com.unitedcoder.magentoautomationtest.backend.salesmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesModuleShipmentPage {
    WebDriver driver;
    FunctionPage functionPage;
    Actions actions;
    String text;



    public SalesModuleShipmentPage(WebDriver driver){
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
    @FindBy(xpath = "//*[@id='nav']/li/a/span[text()='Sales']")
    WebElement salesLink;
    @FindBy(xpath = "//*[text()='Shipments']")
    WebElement shipmentsTeb;
    @FindBy(xpath = " (//a[text()='View'])[1]")
    WebElement viewOption;
    @FindBy(xpath ="//*[@class='select']/option[6]")
    WebElement dhlOption;
    @FindBy(id ="tracking_number")
    WebElement inputOption;
    @FindBy(xpath = "//*[text()='Add']")
    WebElement addButton;
    @FindBy(xpath ="//*[@id='history_comment']")
    WebElement textLabel;
    @FindBy(xpath ="//*[@id='submit_comment_button']/span/span/span")
    WebElement submitCommentButton;
    @FindBy(xpath = "//*[@id='comments_block']/ul/li")
    WebElement shipmentComment;

    public void updateInformation(String CommetText){
        functionPage.waitForElement(salesLink);
        actions.moveToElement(salesLink).perform();
        functionPage.waitForElement(shipmentsTeb);
        shipmentsTeb.click();
        functionPage.waitForElement(viewOption);
        viewOption.click();
        functionPage.sleep(2);
        functionPage.waitForElement(dhlOption);
        dhlOption.click();
        functionPage.waitForElement(inputOption);
        inputOption.clear();
        inputOption.sendKeys("2");
        functionPage.sleep(2);
        functionPage.waitForElement(addButton);
        addButton.click();
        functionPage.sleep(2);
        functionPage.waitForElement(textLabel);
        textLabel.clear();
        textLabel.sendKeys(CommetText);
        setText(CommetText);
        functionPage.waitForElement(submitCommentButton);
        submitCommentButton.click();
    }
    public boolean verifyShipmentPage(){
        functionPage.sleep(3);
        WebElement text=driver.findElement(By.xpath("//li[contains(.,'"+getText()+"')]"));
        //li[contains(.,'Submit')]
        return text.getText().contains(getText());
    }

}
