package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.frontend.publicmodule.MyDashboardPage;
import com.unitedcoder.magentoautomationtest.frontend.publicmodule.PublicLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrontendRunner extends TestBase {
    FunctionPage functionPage;
    PublicLogin publicLogin;
    MyDashboardPage myDashboardPage;
    String configFile = "config-qa.properties";
    String url = readFromConfigProperties(configFile, "frontend_url");

    @BeforeClass
    public void setUp() {
        browserSetUp(url);
        publicLogin = new PublicLogin(driver);
        functionPage = new FunctionPage(driver);
    }

    @Test
    public void login() {
        publicLogin.login();
        Assert.assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }


}
