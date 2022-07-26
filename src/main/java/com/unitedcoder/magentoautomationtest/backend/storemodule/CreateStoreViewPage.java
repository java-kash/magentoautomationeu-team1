package com.unitedcoder.magentoautomationtest.backend.storemodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;
import java.util.Random;

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

    Random random = new Random();
    @FindBy(xpath = "//span[text()='System']")
    WebElement Systemtab;

    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement ManageStore;

    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement CreateStrbtn;

    @FindBy(css = "input[id=\"store_name\"]")
    WebElement Namefeild;
    @FindBy(css = "input[id=\"store_code\"]")
    WebElement codefeild;
    @FindBy(id = "store_is_active")
    WebElement statusdropdown;

    @FindBy(id= "store_group_id")
    WebElement selectstoreviewdrop;
    @FindBy(xpath = "(//span[text()=\"Save Store View\" ])[1]")
    WebElement SaveStrBtn;

    @FindBy(xpath = "(//span[text()=\"Save Store View\" ])[1]")
    WebElement SaveStrBtn2;

    @FindBy(xpath = "//span[text()=\"The store view has been saved\" ]")
    WebElement successmsg;

    @FindBy(xpath = "(//a[@title='Id: 33'])[2]")
    WebElement selectstoreview;
    @FindBy(xpath = "//span[text()='(Code: aqfwde)']")
    WebElement existingWebsite;

    //td[@class='a-left last'])[4]//a

    //a[@title='Id: 73']
    //td[@class='a-left last']

    public void manageStorePage(){
        functionPage.waitForElement(Systemtab);
        Systemtab.click();
        functionPage.waitForElement(ManageStore);
        ManageStore.click();
    }

    public void createStoreView(String StoreViewName){

        int value = random.nextInt(19)+1;
        functionPage.waitForElement(CreateStrbtn);
        CreateStrbtn.click();
        functionPage.waitForElement(selectstoreviewdrop);
        selectstoreviewdrop.click();
        Select select=new Select(selectstoreviewdrop);
        select.selectByIndex(value);
        functionPage.waitForElement(Namefeild);
        // Namefeild.click();
        Namefeild.sendKeys(StoreViewName);
        functionPage.waitForElement(codefeild);
        //codefeild.click();
        codefeild.sendKeys(functionPage.generateFirstName().toLowerCase(Locale.ROOT));
        functionPage.waitForElement(statusdropdown);
        statusdropdown.click();
        Select select1=new Select(statusdropdown);
        select1.selectByIndex(1);


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

    public void editStoreView(String StoreViewName2,String code2){
        int value = random.nextInt(19)+1;
        //actions.moveToElement(selectstoreview).click(selectstoreview).perform();
        functionPage.waitForElement(selectstoreview);
        selectstoreview.click();

        functionPage.waitForElement(selectstoreviewdrop);
        selectstoreviewdrop.click();
        Select select=new Select(selectstoreviewdrop);
        select.selectByIndex(value);
        functionPage.waitForElement(Namefeild);
        // Namefeild.click();
        Namefeild.sendKeys(StoreViewName2);
        functionPage.waitForElement(codefeild);
        //codefeild.click();
        codefeild.sendKeys(code2);
        functionPage.waitForElement(statusdropdown);
        statusdropdown.click();
        Select select1=new Select(statusdropdown);
        select1.selectByIndex(1);


        functionPage.waitForElement(SaveStrBtn);
        SaveStrBtn.click();

    }


}
