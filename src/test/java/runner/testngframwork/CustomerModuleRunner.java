package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import com.unitedcoder.magentoautomationtest.utility.TestNGResultListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestNGResultListener.class)
public class CustomerModuleRunner extends TestBase {
    FunctionPage functionPage;
    static CustomerManagerLogin customerManagerLogin;
    CustomerDashboardPage customerDashboardPage;
    NewCustomerPage newCustomerPage;
    EditCustomerPage editCustomerPage;
    AddNewAddressPage addNewAddressPage;
    String configFile = "config-qa.properties";

    @BeforeSuite()
    public void setUp(ITestContext context){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        context.setAttribute("driver",driver);
        customerManagerLogin=new CustomerManagerLogin(driver);
        customerDashboardPage=new CustomerDashboardPage(driver);
        newCustomerPage=new NewCustomerPage(driver);
        functionPage=new FunctionPage(driver);
        editCustomerPage=new EditCustomerPage(driver);
        addNewAddressPage=new AddNewAddressPage(driver);

    }
    @BeforeClass
    public void loginCustomerModule(){
        Assert.assertTrue(customerManagerLogin.verifyLoginPageOpened());
        customerManagerLogin.login();
    }
    @BeforeMethod
    public void backToDashboard(){
        customerDashboardPage.clickOnMagentoLogoBackDashboard();

    }
    @Test(description = "Customer Manager can add a new customer ")
    public void addCustomer(){
        customerDashboardPage.clickOnAddNewCustomerButton();
        newCustomerPage.addNewCustomerPage();
        Assert.assertTrue(newCustomerPage.verifyAddNewCustomer());
    }
    @Test(description = "Customer Manager can update an existing customer ")
    public void upDataCustomer(){
        customerDashboardPage.clickOnCustomerEditIcon();
        editCustomerPage.editCustomerInformation();
        Assert.assertTrue(true);

    }

    @Test(description = "Customer Manager can add a new address for a customer")
    public void addNewAddress(){
        addNewAddressPage.selectCustomer();
        addNewAddressPage.addNewAddress();
        Assert.assertTrue(addNewAddressPage.verifyAddAddress());
    }



    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}
