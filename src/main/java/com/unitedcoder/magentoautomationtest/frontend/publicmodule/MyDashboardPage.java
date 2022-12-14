package com.unitedcoder.magentoautomationtest.frontend.publicmodule;

import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class MyDashboardPage {
    WebDriver driver;
    FunctionPage functionPage;
    String productsName;
    //(xpath = "//a[text()='My Wishlist']")
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
    @FindBy(xpath = "//*[@id='top']/body/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[9]/a")
    WebElement myWishListLink;
    @FindBy(xpath = "//a[contains(text(),'Newsletter Subscriptions')] ")
    WebElement newsletterSubscriptionsLink;
    @FindBy(xpath = "//a[contains(text(),'My Downloadable Products')]")
    WebElement myDownloadableProductsLink;
    @FindBy(xpath = "//h1[text()='My Dashboard']")
    WebElement myDashboardTittle;
    @FindBy(css = ".skip-link.skip-account")
    WebElement accountButton;
    @FindBy(css = "a[title=\"My Account\"]")
    WebElement myAccountLink;
    //Kadirdan
    @FindBy(css = ".skip-link.skip-cart")
    WebElement cartLink;
    @FindBy(xpath = "//*[@title='Update Cart']")
    WebElement updateCartButton;
    @FindBy(xpath = "//ul[@class='messages']//span")
    WebElement successMessage;
    @FindBy(css = ".product-name>span")
    WebElement productName;
    @FindBy(css="#qty")
    WebElement productCount;

    //ayimsa
    @FindBy(xpath = "//a[text()='My Product Reviews']")
    WebElement myProductReviewLink;
    //Zulfikar
    @FindBy(xpath = "//*[@id=\"subscription\"]")
    WebElement generalSubsIsChecked;


    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionPage = new FunctionPage(driver);

    }

    public String getProductsName() {
        return this.productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public boolean verifyLogin() {
        functionPage.waitForElement(myDashboardTittle);
        if (myDashboardTittle.isDisplayed()) {
            Log4j.info("MyDashBoard page Opened");
        }
        return true;
    }

    public void clickOnAccountDashboardLink() {
        functionPage.waitForElement(accountDashboardLink);
        accountDashboardLink.click();
    }

    public void clickOnAccountInformationLink() {
        functionPage.waitForElement(accountInformationLink);
        accountInformationLink.click();
    }

    public void clickOnAddressBookLink() {
        functionPage.waitForElement(addressBookLink);
        addressBookLink.click();
    }

    public void clickOnMyOrdersLink() {
        functionPage.waitForElement(myOrdersLink);
        myOrdersLink.click();
    }

    public void clickOnMyDownloadableProductsLink() {
        functionPage.waitForElement(myDownloadableProductsLink);
        myDownloadableProductsLink.click();
    }


    public void clickOnMyWishList() {
        functionPage.waitForElement(myWishListLink);
        myWishListLink.click();
    }

    public void clickOnNewsLetterSubscriptions() {
        functionPage.waitForElement(newsletterSubscriptionsLink);
        newsletterSubscriptionsLink.click();
    }

    public void clickOnMyAccountLink() {
        functionPage.waitForElement(accountButton);
        accountButton.click();
        functionPage.waitForElement(myAccountLink);
        myAccountLink.click();
    }

    //Kadirdan
    public void updateItem() {
        functionPage.waitForElement(cartLink);
        cartLink.click();
        Random random = new Random();
        List<WebElement> listInCard = driver.findElements(By.xpath("//*[@title='Edit item']"));
        int list = random.nextInt(listInCard.size());
        listInCard.get(list).click();
        functionPage.waitForElement(productName);
        setProductsName(productName.getText());
        int value = random.nextInt(9) + 1; // 1-10
        functionPage.waitForElement(productCount);
        productCount.clear();
        productCount.sendKeys(String.valueOf(value));
        functionPage.waitForElement(updateCartButton);
        updateCartButton.click();
    }

    public boolean verifyUpdatedItem() {
        functionPage.waitForElement(successMessage);
        if (successMessage.getText().toLowerCase().contains(getProductsName().toLowerCase() + " was updated in your shopping cart.")) {
            Log4j.info("Shopping cart updated successfully!");
            return true;
        } else
            Log4j.info("Shopping cart  updated failed!");
        return false;
    }

    public boolean productReviewLinkVisible() {
        functionPage.waitForElement(myProductReviewLink);
        if (myProductReviewLink.isDisplayed()) {
            Log4j.info("My Product Reviews link is visible");
            return true;
        } else
            Log4j.error("My Product Reviews link is not visible");
        return false;
    }

    public void clickOnMyProductReviewLink() {
        functionPage.waitForElement(myProductReviewLink);
        myProductReviewLink.click();
    }


}
