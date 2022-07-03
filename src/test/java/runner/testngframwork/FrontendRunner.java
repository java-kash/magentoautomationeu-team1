package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.frontend.publicmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class FrontendRunner extends TestBase {
    FunctionPage functionPage;
    PublicLogin publicLogin;
    MyDashboardPage myDashboardPage;
    MyWishPage myWishPage;
    MyProductReviewPage myProductReviewPage;
    MyOrdersPage myOrdersPage;
    MyNewsletterSubsPage myNewsletterSubsPage;
    EditAccountInformation editAccountInformation;
    String configFile = "config-qa.properties";
    AccountInformationPage accountInformationPage;

    @BeforeSuite
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "frontend_url"));
        publicLogin = new PublicLogin(driver);
        functionPage = new FunctionPage(driver);
        myDashboardPage = new MyDashboardPage(driver);
        myWishPage = new MyWishPage(driver);
        myProductReviewPage = new MyProductReviewPage(driver);
        myOrdersPage = new MyOrdersPage(driver);
        myNewsletterSubsPage = new MyNewsletterSubsPage(driver);
        editAccountInformation = new EditAccountInformation(driver);
        Log4j.startTestCase("MagentoPublicModuleAutomationTestStart");
        accountInformationPage=new AccountInformationPage(driver);
    }

    @BeforeClass
    public void login() {
        publicLogin.login();
        Assert.assertTrue(myDashboardPage.verifyLogin());
    }

    @BeforeMethod
    public void clickToMyAccount() {
        myDashboardPage.clickOnMyAccountLink();
        Assert.assertTrue(myDashboardPage.verifyLogin());
    }

    @Test(description = "A user should be able to update shopping cart ")
    public void userEditItemTest() {
        myDashboardPage.updateItem();
        Assert.assertTrue(myDashboardPage.verifyUpdatedItem());
    }

    @Test(description = "A user should be able to view My wish list ")
    public void myWishList() {
        myDashboardPage.clickOnMyWishList();
        myWishPage.myWishList();
        Assert.assertTrue(myWishPage.myWishList());

    }


    @Test(description = "A user should see My Product Reviews contents. ")
    public void productReviewContentVisible() {
        myDashboardPage.productReviewLinkVisible();
        myDashboardPage.clickOnMyProductReviewLink();
        Assert.assertTrue(myProductReviewPage.productReviewContentIsVisible());
    }


    @Test(description = "A user should be able to check out the order ")
    public void checkOutOrders() {
        myDashboardPage.clickOnMyOrdersLink();
        Assert.assertTrue(myOrdersPage.checkOutOrders());
    }

    @Test(description = "A user should see newsletter subscription link and content")
    public void generalSubsIsChecked() {
        myNewsletterSubsPage.clickOnNewsLetterSubs();
        myNewsletterSubsPage.generalSubsIsChecked();
        Assert.assertTrue(myNewsletterSubsPage.generalSubsIsChecked());
    }
    @Test(description = "A user should be able to view account information")
    public void accountInformation(){
        myDashboardPage.clickOnAccountInformationLink();
        Assert.assertTrue(accountInformationPage.verifypage());
    }


    @Test(description = "user should be able to edit and view account information")
    public void editAccountInformation() {
        myDashboardPage.clickOnAccountInformationLink();
        editAccountInformation.clickOnMiddleNameField();
        editAccountInformation.editAccountInformation();
        editAccountInformation.clickOnSaveButton();
        Assert.assertTrue(editAccountInformation.verifySuccessfullyEdit());

    }


    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
