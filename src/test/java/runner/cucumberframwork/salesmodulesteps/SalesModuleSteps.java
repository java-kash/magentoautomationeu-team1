package runner.cucumberframwork.salesmodulesteps;

import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesManagerLogin;
import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesModuleManageCustomerPage;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SalesModuleSteps extends TestBase {
    SalesManagerLogin salesManagerLogin;
    SalesModuleManageCustomerPage salesModuleManageCustomerPage;
    FunctionPage functionPage;
    String configFile = "config-qa.properties";

    @Before("@SalesModuleFeature")
    public void setUp() {
        browserSetUp(readFromConfigProperties(configFile, "backend_url"));
        salesManagerLogin = new SalesManagerLogin(driver);
    salesManagerLogin.login(readFromConfigProperties(configFile,"sales-username"),readFromConfigProperties(configFile,"sales-password"));
    }
    @After("@SalesModuleFeature")
    public void tearDown(){
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
}
