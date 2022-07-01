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
    String configFile = "config-qa.properties";

    @BeforeSuite
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "frontend_url"));
        publicLogin = new PublicLogin(driver);
        functionPage = new FunctionPage(driver);
        myDashboardPage = new MyDashboardPage(driver);
        myWishPage=new MyWishPage(driver);
        myProductReviewPage=new MyProductReviewPage(driver);
        myOrdersPage=new MyOrdersPage(driver);
        Log4j.startTestCase("MagentoAutomationTestStart");
    }

    @BeforeClass
    public void login() {
        publicLogin.login();
        Assert.assertTrue(myDashboardPage.verifyLogin());
    }
    @BeforeMethod
    public void clickToMyAccount(){
      myDashboardPage.clickOnMyAccountLink();
      Assert.assertTrue(myDashboardPage.verifyLogin());
    }

    @Test
    public void userEditItemTest() {
        myDashboardPage.updateItem();
        Assert.assertTrue(myDashboardPage.verifyUpdatedItem());
    }
    @Test
    public void myWishList(){
        myDashboardPage.clickOnMyWishList();
        myWishPage.myWishList();
        Assert.assertTrue(myWishPage.myWishList());

    }
    //ayimsa
    @Test(description = "A user should see \"My Product Reviews\" link ")
    public void productReviewLinkVisible(){
       Assert.assertTrue(myDashboardPage.productReviewLinkVisible());
    }
    @Test(description = "A user should see \"My Product Reviews\" contents. ")
    public void productReviewContentVisible(){
      myDashboardPage.clickOnMyProductReviewLink();
      Assert.assertTrue(myProductReviewPage.productReviewContentIsVisible());
    }
    //EsmaNur
    @Test
    public void checkOutOrders(){
        myDashboardPage.clickOnMyOrdersLink();
        myOrdersPage.checkOutOrders();
        Assert.assertTrue(myOrdersPage.checkOutOrders());
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
