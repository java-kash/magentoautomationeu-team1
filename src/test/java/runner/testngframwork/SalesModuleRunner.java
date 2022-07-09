package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.*;
import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesManagerLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import com.unitedcoder.magentoautomationtest.utility.TestNGResultListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestNGResultListener.class)
public class SalesModuleRunner extends TestBase {
    FunctionPage functionPage;
    SalesManagerLogin salesManagerLogin;
    String configFile = "config-qa.properties";
    String username=TestBase.readFromConfigProperties(configFile, "sm-username");
    String password=TestBase.readFromConfigProperties(configFile, "sm-password");

    @BeforeSuite()
    public void setUp(ITestContext context) {
        browserSetUp(readFromConfigProperties(configFile, "backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        context.setAttribute("driver", driver);
        functionPage = new FunctionPage(driver);
        salesManagerLogin=new SalesManagerLogin(driver);

    }

  @BeforeClass()
    public void loginSalesModule() {
salesManagerLogin.login(username,password);
      Assert.assertTrue(salesManagerLogin.verifyLogin());
    }

  @Test
  public void test1(){
      System.out.println(10);
  }
    @AfterClass
    public void tearDown(){
        salesManagerLogin.logout();
        driver.close();
        driver.quit();
    }
}
