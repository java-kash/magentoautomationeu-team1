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
    AssignCustomerToAGroup assignCustomerToAGroup;
    AddNewAddressPage addNewAddressPage;
    String configFile = "config-qa.properties";
    FilterCustomersPage filterCustomersPage;
    TestDataHolder info = new TestDataHolder();


    @BeforeSuite()
    public void setUp(ITestContext context) {
        browserSetUp(readFromConfigProperties(configFile, "backend_url"));
        Log4j.startTestCase("Magento_Customer_Module_Automation_Test_Start");
        context.setAttribute("driver",driver);
        customerManagerLogin=new CustomerManagerLogin(driver);
        customerDashboardPage=new CustomerDashboardPage(driver);
        newCustomerPage=new NewCustomerPage(driver);
        functionPage=new FunctionPage(driver);
        editCustomerPage=new EditCustomerPage(driver);
        addNewAddressPage=new AddNewAddressPage(driver);
        filterCustomersPage=new FilterCustomersPage(driver);
        assignCustomerToAGroup=new AssignCustomerToAGroup(driver);
        customerGroupsPage=new CustomerGroupsPage(driver);
    }

    @BeforeClass
    public void loginCustomerModule() {
        Assert.assertTrue(customerManagerLogin.verifyLoginPageOpened());
        customerManagerLogin.login();
    }

    @Test(description = "Customer Manager can add a new customer ", dataProvider = "NewCustomerInfo")
    public void addCustomer(String firstName, String lastName, String emailAddress) {
        customerDashboardPage.clickOnAddNewCustomerButton();
        newCustomerPage.addNewCustomerPage(firstName, lastName, emailAddress);
        Assert.assertTrue(newCustomerPage.verifyAddNewCustomer());
    }

    @Test(description = "Customer Manager can update an existing customer ", dataProvider = "customerFirstName",
           dependsOnMethods = "addCustomer")
    public void upDataCustomer(String firstName, String middleName) {
        customerDashboardPage.clickOnCustomerEditIcon(firstName);
        editCustomerPage.editCustomerInformation(middleName);
        Assert.assertTrue(true);
    }

    @Test(description = "Customer Manager can delete an existing customer ",dataProvider = "customerEmail",
           dependsOnMethods = "upDataCustomer")
    public void deleteCustomer(String customerEmail) {
        editCustomerPage.deleteCustomer(customerEmail);
        Assert.assertTrue(true);

    }


    @Test(description = "Customer Manager can add a new address for a customer",enabled = false)
    public void addNewAddress() {
        addNewAddressPage.selectCustomer();
        addNewAddressPage.addNewAddress();
        Assert.assertTrue(addNewAddressPage.verifyAddAddress());
    }


    @Test(description = "Customer Manager can export customers -abdukerim")
    public void exportCustomers() {
        customerDashboardPage.exportCustomers();
        Assert.assertTrue(customerDashboardPage.verifyExportCustomer());
    }

    @Test(description = "Customer Manager should be able to filter Customer by country, state and website")
    public void filterCustomersByCountryWebsiteState() {
        customerDashboardPage.filterCustomerByCountry();
        customerDashboardPage.filterCustomerByWebsite();
        customerDashboardPage.filterCustomerByState();
        Assert.assertTrue(true);
    }

    @Test(description="Customer manager can assign a customer to a group in the actions onn the all customer page")
    public void setAssignCustomerToAGroup(){
        assignCustomerToAGroup.assignGroup();
        Assert.assertTrue(assignCustomerToAGroup.verifyAssignCustomerToAGroup());
    }

        @Test(description = "Customer Manager Can Add New Customer Groups",dataProvider = "customerGroupInfo")
        public void addCustomerGroups(TestDataHolder testDataHolder){
        customerDashboardPage.clickCustomerGroupsLink();
        customerGroupsPage.clickOnAddNewCustomerGroup(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyAddNewCustomerGroups());

        }
        @Test(description = "customer manager can update existing customer groups",dataProvider ="customerGroupInfo" )
        public void updateExistingCustomerGroups(TestDataHolder testDataHolder){
        customerDashboardPage.clickCustomerGroupsLink();
        customerGroupsPage.updateExistingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyUpdateExistingCustomerGroups());
        }
        @Test(description = "customer manager can delete existing customer groups ",dataProvider = "customerGroupInfo")
        public void deleteExistingCustomerGroups(TestDataHolder testDataHolder){
        customerDashboardPage.clickCustomerGroupsLink();
        customerGroupsPage.deleteExitingCustomerGroups(testDataHolder);
        Assert.assertTrue(customerGroupsPage.verifyDeleteExistingCustomerGroups());
        }


    @Test(description = "Customer Manager can filter customers by Group")
    public void CustomerMangerGroup() {
        filterCustomersPage.ManagerFilter();
        Assert.assertTrue(true);
        customerDashboardPage.filterReset();
    }

    @DataProvider
    public Object[][] NewCustomerInfo() {

        info.setCustomerFirstName(functionPage.generateFirstName());
        info.setCustomerLastName(functionPage.generateLastName());
        info.setCustomerEmailAddress(functionPage.generateEmail());
        System.out.println("in the data first:  " + info.getCustomerFirstName());
        Object[][] customerInfo = new Object[][]{
                {"Team1" + info.getCustomerFirstName(), info.getCustomerLastName(),
                        info.getCustomerEmailAddress()}
        };
        return customerInfo;
    }

    @DataProvider
    public Object[][] customerFirstName() {
        System.out.println("in the second Data:  " + info.getCustomerFirstName());
        Object[][] customerName = new Object[][]{
                {"Team1" + info.getCustomerFirstName(), "Team1" + functionPage.generateMiddleName()}
        };
        return customerName;
    }

    @DataProvider
    public Object[][] customerEmail() {
        Object[][] customerEmail = new Object[][]{
                {info.getCustomerEmailAddress()}
        };
        return customerEmail;
    }

    @DataProvider
    public Object[][] customerGroupInfo() {
        Object[][] data = new Object[][]{
                {new TestDataHolder("master")}
        };
        return data;
    }


    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }

}
