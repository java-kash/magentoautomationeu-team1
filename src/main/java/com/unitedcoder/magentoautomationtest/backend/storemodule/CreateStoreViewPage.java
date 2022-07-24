package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateStoreViewPage {

    WebDriver storeDriver;
    FunctionPage functionPage;
    Actions actions;
    Select select;

    public CreateStoreViewPage(WebDriver storeDriver) {
        this.storeDriver = storeDriver;
        PageFactory.initElements(storeDriver,this);
        functionPage=new FunctionPage(storeDriver);
        actions=new Actions(storeDriver);
    }

    @FindBy(xpath = "//span[text()='System']")
    WebElement Systemtab;

    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement ManageStore;

    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement CreateStrbtn;

    @FindBy(xpath = "input[id=\"store_name\"]")
    WebElement Namefeild;
    @FindBy(xpath = "input[id=\"store_code\"]")
    WebElement codefeild;

    @FindBy(xpath = "(//span[text()=\"Save Store View\" ])[1]")
    WebElement SaveStrBtn;

    @FindBy(xpath = "//span[text()=\"The store view has been saved\" ]")
    WebElement successmsg;

    public void manageStorePage(){
        functionPage.waitForElement(Systemtab);
        Systemtab.click();
        functionPage.waitForElement(ManageStore);
        ManageStore.click();
    }

    public void createStoreView(){
        functionPage.waitForElement(CreateStrbtn);
        CreateStrbtn.click();
        functionPage.waitForElement(Namefeild);
        Namefeild.click();
        Namefeild.sendKeys(functionPage.generateFirstName());
        functionPage.waitForElement(codefeild);
        codefeild.click();
        codefeild.sendKeys(functionPage.generateZipCode());

        functionPage.waitForElement(SaveStrBtn);
        SaveStrBtn.click();


    }
    public boolean verifyCreateStoreView(){
        functionPage.waitForElement(successmsg);
        if (successmsg.isDisplayed()){
            return true;
        }
        return false;
    }
}
