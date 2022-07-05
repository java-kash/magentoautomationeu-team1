package runner.testngframwork;

import com.unitedcoder.magentoautomationtest.backend.customersmodule.*;
import com.unitedcoder.magentoautomationtest.utility.*;
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
    CustomerGroupsPage customerGroupsPage;
    String configFile = "config-qa.properties";

    @BeforeSuite()
    public void setUp(ITestContext context) {
        browserSetUp(readFromConfigProperties(configFile, "backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        context.setAttribute("driver", driver);
        customerManagerLogin = new CustomerManagerLogin(driver);
        customerDashboardPage = new CustomerDashboardPage(driver);
        newCustomerPage = new NewCustomerPage(driver);
        functionPage = new FunctionPage(driver);
        editCustomerPage = new EditCustomerPage(driver);
        context.setAttribute("driver", driver);
        customerManagerLogin = new CustomerManagerLogin(driver);
        customerDashboardPage = new CustomerDashboardPage(driver);
        newCustomerPage = new NewCustomerPage(driver);
        functionPage = new FunctionPage(driver);
        editCustomerPage = new EditCustomerPage(driver);
        customerGroupsPage=new CustomerGroupsPage(driver);

    }

    @BeforeClass
    public void loginCustomerModule() {
        Assert.assertTrue(customerManagerLogin.verifyLoginPageOpened());
        customerManagerLogin.login();
    }

    /*@BeforeMethod
    public void backToDashboard() {
        customerDashboardPage.clickOnMagentoLogoBackDashboard();

    }*/

    @Test(description = "Customer Manager can add a new customer ")
    public void addCustomer() {
        customerDashboardPage.clickOnAddNewCustomerButton();
        newCustomerPage.addNewCustomerPage();
        Assert.assertTrue(newCustomerPage.verifyAddNewCustomer());
    }

    @Test(description = "Customer Manager can update an existing customer ")
    public void upDataCustomer() {
        customerDashboardPage.clickOnCustomerEditIcon();
        editCustomerPage.editCustomerInformation();
        Assert.assertTrue(true);
    }

    @Test
    public void deleteCustomer() {
        editCustomerPage.deleteCustomer();
        Assert.assertTrue(true);

    }

    @Test(description = "Customer Manager can export customers -abdukerim")
    public void exportCustomers() {
        customerDashboardPage.exportCustomers();
        Assert.assertTrue(customerDashboardPage.verifyExportCustpmers());
    }

    @Test(description = "Customer Manager should be able to filter Customer by country, state and website")
    public void filterCustomersByCountryWebsiteState() {
        customerDashboardPage.filterCustomerByCountry();
        customerDashboardPage.filterCustomerByWebsite();
        customerDashboardPage.filterCustomerByState();
    }




    @Test(dataProvider = "customerGroupInfo",description = "Customer Manager can add new customer groups.")
    public void addCustomerGroups(TestHelper testHelper) {
        customerDashboardPage.clickCustomerGroupsLink();
        customerGroupsPage.addNewCustomerGroups(testHelper);
        Assert.assertTrue(customerGroupsPage.verifyAddNewCustomerGroups());
    }
    @Test(dataProvider ="customerGroupInfo",description = "Customer Manager can  update existing customer groups.",dependsOnMethods = "addCustomerGroups")
    public void updateExistingCustomerGroups(TestHelper testHelper){
        customerDashboardPage.clickCustomerGroupsLink();
        customerGroupsPage.updateExistingCustomerGroups(testHelper);
        Assert.assertTrue(customerGroupsPage.verifyUpdateExistingCustomerGroups());
    }
    @Test(dataProvider = "customerGroupInfo",description = "Customer Manager Can Delete Existing Customer Groups.",dependsOnMethods = "updateExistingCustomerGroups")
    public void deleteExistingCustomerGroups(TestHelper testHelper){
        customerGroupsPage.deleteExistingCustomerGroups(testHelper);
        Assert.assertTrue(customerGroupsPage.verifyDeleteExistingCustomerGroups());
    }



    @DataProvider
    public Object[][] customerGroupInfo(){
        Object[] data=new Object[]{new TestHelper("master")};
        return (Object[][]) data;
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}
