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


public class SalesModuleSteps extends TestBase {
    SalesManagerLogin salesManagerLogin;
    SalesModuleManageCustomerPage salesModuleManageCustomerPage;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";
    SalesModuleInvoicesPage salesModuleInvoicesPage;
    ScreenshotUtility screenshotUtility=new ScreenshotUtility();
    ManageOrdersPage manageOrdersPage;
    EditOrdersWithInStorePickup editOrdersWithInStorePickup;

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

    @When("sales manager can create new order")
    public void salesManagerCanCreateNewOrder(){
        manageOrdersPage.createOrder();
    }

    @Then("sales manager should see success massage")
    public void salesManagerShouldSeeSuccessMassage() {
        Assert.assertTrue(manageOrdersPage.verifyCreateOrder());
    }

    @When("sales manager edit orders with in store pickup")
    public void salesManagerEditOrdersWithInStorePickup() {
        editOrdersWithInStorePickup.edit();
    }

    @Then("verify edit orders success")
    public void verifyEditOrdersSuccess() {
        editOrdersWithInStorePickup.editVerify();
    }






}
