package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.frontend.publicmodule.MyDashboardPage;
import com.unitedcoder.magentoautomationtest.frontend.publicmodule.PublicLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class FrontendRunner extends TestBase {
    FunctionPage functionPage;
    PublicLogin publicLogin;
    MyDashboardPage myDashboardPage;
    String configFile = "config-qa.properties";

    @BeforeSuite
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "frontend_url"));
        publicLogin = new PublicLogin(driver);
        functionPage = new FunctionPage(driver);
    }

    @BeforeClass
    public void login() {
        publicLogin.login();
        Assert.assertTrue(true);
    }

    @Test
    public void userEditItemTest() {
        myDashboardPage = new MyDashboardPage(driver);
        myDashboardPage.updateItem();
        Assert.assertTrue(myDashboardPage.verifyUpdatedItem());
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
