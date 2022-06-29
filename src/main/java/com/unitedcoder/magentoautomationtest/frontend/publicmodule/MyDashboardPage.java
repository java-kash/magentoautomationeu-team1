package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    FunctionPage functionPage;

    @FindBy(xpath = "//strong[contains(text(),'Account Dashboard')]")
    WebElement accountDashboardLink;
    @FindBy(css = ".skip-content>.links>ul>.first>a")
    WebElement myAccountButton;
    @FindBy(xpath = "//a[contains(text(),'Account Information')]")
    WebElement accountInformationLink;
    @FindBy(xpath = "//a[contains(text(),'Address Book')]")
    WebElement addressBookLink;
    @FindBy(xpath = "//a[contains(text(),'My Orders')]")
    WebElement myOrdersLink;
    @FindBy(xpath = "//a[text()='My Wishlist']")
    WebElement myWishListLink;
    @FindBy(xpath ="//a[contains(text(),'Newsletter Subscriptions')] ")
    WebElement  newsletterSubscriptionsLink;
    @FindBy(xpath = "//a[contains(text(),'My Downloadable Products')]")
    WebElement myDownloadableProductsLink;
    @FindBy(xpath = "//h1[text()='My Dashboard']")
    WebElement myDashboardTittle;
    //Kadirdan
    @FindBy(css = ".skip-link.skip-cart")
    WebElement cartLink;
    @FindBy(xpath = "//*[@title='Slim fit Dobby Oxford Shirt']" +
            "/following::div/descendant::table/following::a[@title='Edit item']")
    WebElement editItemLink;
    @FindBy(xpath = "//*[@title='Update Cart']")
    WebElement updateCartButton;
    @FindBy(xpath = "//*[contains(text(),'Slim fit Dobby Oxford Shirt was updated in your shopping cart.')]")
    WebElement successMessage;

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionPage = new FunctionPage(driver);

    }
    public boolean verifyLogin(){
        functionPage.waitForElement(myDashboardTittle);
        if(myDashboardTittle.isDisplayed()){
            System.out.println("My Dashboard Page Openend");
        }
        return true;
    }
    public void clickOnAccountDashboardLink(){
        functionPage.waitForElement(accountDashboardLink);
        accountDashboardLink.click();
    }
    public void clickOnAccountInformationLink(){
        functionPage.waitForElement(accountInformationLink);
        accountInformationLink.click();
    }
    public void clickOnAddressBookLink(){
        functionPage.waitForElement(addressBookLink);
        addressBookLink.click();
    }
    public void clickOnMyOrdersLink(){
        functionPage.waitForElement(myOrdersLink);
        myOrdersLink.click();
    }
    public void clickOnMyWishList(){
        functionPage.waitForElement(myWishListLink);
        myWishListLink.click();
    }
    public void clickOnNewsLetterSubscriptions(){
        functionPage.waitForElement(newsletterSubscriptionsLink);
        newsletterSubscriptionsLink.click();
    }

    //Kadirdan
    public void updateItem(){
        functionPage.waitForElement(cartLink);
        cartLink.click();
        functionPage.waitForElement(editItemLink);
        editItemLink.click();
        functionPage.waitForElement(updateCartButton);
        updateCartButton.click();
    }
    public boolean verifyUpdatedItem(){
        functionPage.waitForElement(successMessage);
        return successMessage.isDisplayed();
    }
}
