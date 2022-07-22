package runner.cucumberframwork.salesmodulesteps;

import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesManagerLogin;
import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesModuleManageCustomerPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SalesModuleLoginSteps extends TestBase {
   SalesManagerLogin salesManagerLogin;
   SalesModuleManageCustomerPage salesModuleManageCustomerPage;

    @Given("Sales Manager is already in Magento admin login page")
    public void salesManagerIsAlreadyInMagentoAdminLoginPage() {
        browserSetUp("http://magentoqa2.unitedcoder.com/index.php/admin");
        salesManagerLogin=new SalesManagerLogin(driver);
        salesModuleManageCustomerPage=new SalesModuleManageCustomerPage(driver);
    }
    @When("admin user enter valid {string} and {string} for sales module")
    public void adminUserEnterValidAndForSalesModule(String arg0, String arg1) {
        salesManagerLogin.login(arg0,arg1);
    }
    @Then("admin user able to successfully login to the sales module dashboard page.")
    public void adminUserAbleToSuccessfullyLoginToTheSalesModuleDashboardPage() {
        Assert.assertTrue(salesManagerLogin.verifyLogin());
    }


    @Given("Sales manager at the Manage Customers page")
    public void salesManagerAtTheManageCustomersPage() {

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
