package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.salesmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.ScreenshotUtility;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class SalesModuleSteps extends TestBase {
    SalesManagerLogin salesManagerLogin;
    SalesModuleManageCustomerPage salesModuleManageCustomerPage;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    SalesModuleInvoicesPage salesModuleInvoicesPage;
    ScreenshotUtility screenshotUtility=new ScreenshotUtility();
    ManageOrdersPage manageOrdersPage;
    SalesModuleShipmentPage salesModuleShipmentPage;
    EditOrdersWithInStorePickup editOrdersWithInStorePickup;
    OrdersPage ordersPage;
    CreditMemosPage creditMemosPage;
    String title;

    @Before("@SalesModuleFeature")
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "backend_url"));
        salesManagerLogin = new SalesManagerLogin(driver);
        manageOrdersPage= new ManageOrdersPage(driver);
    salesManagerLogin.login(readFromConfigProperties(configFile,"sales-username"),readFromConfigProperties(configFile,"sales-password"));
    }
    @After("@SalesModuleFeature")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            Log4j.error(scenario.getName()+"      Failed");
            screenshotUtility.takeScreenshot("image",scenario.getName(),driver);
            byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",scenario.getName());
        }
        if(!scenario.isFailed()) {
            Log4j.info(scenario.getName() + "       Passed");
        }
        driver.quit();
    }

    @Given("Sales manager at the Manage Customers page")
    public void salesManagerAtTheManageCustomersPage() {
        functionPage=new FunctionPage(driver);
        salesModuleManageCustomerPage = new SalesModuleManageCustomerPage(driver);
        salesModuleManageCustomerPage.clickOnManageCustomersLink();
    }

    @When("Sales manager click on customer")
    public void salesManagerClickOnCustomer() {
        salesModuleManageCustomerPage.navigateToCustomerInformationPage();


    }

    @Then("Sales manager at the Customer Information page and click on Shopping Cart to view shopping cart")
    public void salesManagerAtTheCustomerInformationPageAndClickOnShoppingCartToViewShoppingCart() {
        Assert.assertTrue(salesModuleManageCustomerPage.shoppingCartIsVisible());
    }

    @Given("sales manager is on the sales dashboard page")
    public void salesManagerIsOnTheSalesDashboardPage() {
        functionPage=new FunctionPage(driver);
        salesModuleInvoicesPage=new SalesModuleInvoicesPage(driver);
        editOrdersWithInStorePickup=new EditOrdersWithInStorePickup(driver);
        ordersPage = new OrdersPage(driver);
        creditMemosPage = new CreditMemosPage(driver);
    }

    @When("sales manager can view invoices on the invoices page")
    public void salesManagerCanViewInvoicesOnTheInvoicesPage() {
        salesModuleInvoicesPage=new SalesModuleInvoicesPage(driver);
        salesModuleInvoicesPage.salesManagerViewInvoices();

    }

    @Then("sales manager should be able to view invoices")
    public void salesManagerShouldBeAbleToViewInvoices() {
        salesModuleInvoicesPage.verifyViewInvoices();

    }



    @And("sales manager comments to invoices{string}")
    public void salesManagerCommentsToInvoices(String arg0) {
        salesModuleInvoicesPage.invoiceAdComment(arg0+System.currentTimeMillis());

    }

    @Then("sales manager should be able to comments to invoices")
    public void salesManagerShouldBeAbleToCommentsToInvoices() {
        Assert.assertTrue(salesModuleInvoicesPage.verifyInvoiceComment());
    }


    //Sales Manager should be able to create a new order-abdukerim
    @When("sales manager can create new order")
    public void salesManagerCanCreateNewOrder(){
        manageOrdersPage.createOrder();
    }

    @Then("sales manager should see success massage")
    public void salesManagerShouldSeeSuccessMassage() {
        Assert.assertTrue(manageOrdersPage.verifyCreateOrder());
    }

    //Sales Manager should be able to cancel  order abdukerim
    @When("sales manager can cancel order")
    public void salesManagerCanCancelOrder() {
        manageOrdersPage.deleteOrder();
    }

    @Then("sales manager should see cancel success massage")
    public void salesManagerShouldSeeCancelSuccessMassage() {
        Assert.assertTrue(manageOrdersPage.verifyCancelOrder());
    }

    @When("sales manager edit orders with in store pickup")
    public void salesManagerEditOrdersWithInStorePickup() {
        editOrdersWithInStorePickup.edit();
    }

    @Then("verify edit orders success")
    public void verifyEditOrdersSuccess() {
        editOrdersWithInStorePickup.editVerify();
    }



    @When("user selects Pending or Processing sections in Status drop down")
    public void userSelectsPendingOrProcessingSectionsInStatusDropDown() {
        ordersPage.selectPendingOrProcessingRandomly();
    }

    @And("Sales clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        functionPage.clickOnButton(buttonName);
    }

    @And("user clicks on any order in the list table")
    public void userClicksOnAnyOrderInTheListTable() {
        functionPage.sleep(2);
        ordersPage.clickOnAnyOrder();
    }

    @Given("Sales navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        String name = functionPage.getPageNameH3(pageName);
        System.out.println("Page name is: " + name);
    }

    @And("user gets the Credit Memos number on the table")
    public void userGetsTheCreditMemosNumberInTable() {
        creditMemosPage.getNumber();
    }

    @When("user enters order number in the Order field")
    public void userFillsTheCreditMemosNumberInCreditMemosFieldColumn() {
        functionPage.sleep(2);
        creditMemosPage.fillNumberField();
    }

    @Then("user should be able to see new Credit Memos in the table list")
    public void userShouldBeAbleToSeeNewCreditMemosInTheTableList() {
        Assert.assertTrue(creditMemosPage.verifyCanSeeCreditMemos());
    }

    @When("Sales gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = functionPage.getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("Sales module page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @When("Sales hovers to click the {string}")
    public void userHoversOverThe(String text) {
        functionPage.hoverToClick(text);
    }


    @Then("Sales should be able to see success message {string}")
    public void salesShouldBeAbleToSeeSuccessMessage(String successMessage) {
        Assert.assertTrue(functionPage.getSuccessMessage(successMessage));
    }

    @When("sales manager can update tracking and history information shipments{string}")
    public void salesManagerCanUpdateTrackingAndHistoryInformationShipmentsAnd(String arg0) {
        salesModuleShipmentPage=new SalesModuleShipmentPage(driver);
        salesModuleShipmentPage.updateInformation(arg0+System.currentTimeMillis());
    }
    @Then("sales manager should be able to comments to shipments")
    public void salesManagerShouldBeAbleToCommentsToShipments() {
        salesModuleShipmentPage.verifyShipmentPage();
    }

}
