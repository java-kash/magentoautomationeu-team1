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
    String configFile = "config-qa.properties";
    FilterCustomersPage filterCustomersPage;


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
        filterCustomersPage=new FilterCustomersPage(driver);


    }
    @BeforeClass
    public void loginCustomerModule(){
        Assert.assertTrue(customerManagerLogin.verifyLoginPageOpened());
        customerManagerLogin.login();
    }

    /*@BeforeMethod
    public void backToDashboard() {
        customerDashboardPage.clickOnMagentoLogoBackDashboard();

    }*/

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

    @Test(description = " Customer manager should be able to filter by email")
    public void FilterCustomerByEmails(){
        customerDashboardPage.filteredByEmails();
    }

    @Test(description = "Customer manager should be able to filtered by Email")
    public void custFilteredByEmail(){
        customerDashboardPage.filteredByEmails();
        customerDashboardPage.verifyCustByEmail();
        Assert.assertTrue(customerDashboardPage.verifyCustByEmail());
    }
    @Test(description = "Customer Manager can filter customers by Grou")
    public void CustomerMangerGroup(){
       filterCustomersPage.ManagerFilter();
        filterCustomersPage.verifyGroups();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}
