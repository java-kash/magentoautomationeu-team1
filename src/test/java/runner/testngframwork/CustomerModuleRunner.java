package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.CustomerManagerLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CustomerModuleRunner extends TestBase {
    WebDriver driver;
    FunctionPage functionPage;
    CustomerManagerLogin customerManagerLogin;
    String configFile = "config-qa.properties";
    String url=readFromConfigProperties(configFile,"backend_url");

    @BeforeSuite
    public void setUp(){
        browserSetUp(url);
        functionPage=new FunctionPage(driver);
        customerManagerLogin=new CustomerManagerLogin(driver);
    }
    @Test
    public void loginCustomerModule(){
        Assert.assertTrue(true);
        customerManagerLogin.login();

    }

}
