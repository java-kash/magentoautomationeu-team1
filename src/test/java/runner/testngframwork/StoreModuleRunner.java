package runner.testngframwork;


import com.unitedcoder.magentoautomationtest.backend.storemodule.StoreModuleLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class StoreModuleRunner extends TestBase {
    FunctionPage functionPage;
    static StoreModuleLogin storeModuleLogin;
    String configFile = "config-qa.properties";
  @BeforeSuite
    public void setUp(){
      browserSetUp(readFromConfigProperties(configFile,"backend_url"));
      Log4j.startTestCase("Magento_StoreModule_Automation_Test_Start_Now");
      storeModuleLogin=new StoreModuleLogin(driver);

  }
  @BeforeClass
    public void loginStoreManagerModule(){
      Assert.assertTrue(storeModuleLogin.verifyLoginPageOpened());
      storeModuleLogin.login();
      Assert.assertTrue(storeModuleLogin.verifyLogin());
  }

@AfterSuite
    public void tearDown(){
      closeBrowser();
}
}
