package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.CustomerManagerLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {
    FunctionPage functionPage;
    static CustomerManagerLogin customerManagerLogin;
    String configFile = "config-qa.properties";

    @BeforeSuite
    public void setUp(){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        customerManagerLogin=new CustomerManagerLogin(driver);
        functionPage=new FunctionPage(driver);


    }
    @Test
    public void loginCustomerModule(){
        Assert.assertTrue(customerManagerLogin.verifyLoginPageOpened());
        customerManagerLogin.login();
    }
    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}
