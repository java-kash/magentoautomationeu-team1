package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.frontend.publicmodule.MyDashboardPage;
import com.unitedcoder.magentoautomationtest.frontend.publicmodule.MyWishPage;
import com.unitedcoder.magentoautomationtest.frontend.publicmodule.PublicLogin;
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
    String configFile = "config-qa.properties";

    @BeforeSuite
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "frontend_url"));
        publicLogin = new PublicLogin(driver);
        functionPage = new FunctionPage(driver);
        myDashboardPage = new MyDashboardPage(driver);
        myWishPage=new MyWishPage(driver);
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
    public void myWishtList(){
        myDashboardPage.clickOnMyWishList();
        myWishPage.myWishtList();
        Assert.assertTrue(myWishPage.myWishtList());

    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
