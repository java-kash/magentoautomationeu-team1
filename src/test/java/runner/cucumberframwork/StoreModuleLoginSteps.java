package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.salesmodule.SalesManagerLogin;
import com.unitedcoder.magentoautomationtest.backend.storemodule.ManageCurrencyRatesPage;
import com.unitedcoder.magentoautomationtest.backend.storemodule.ManageStoresPage;
import com.unitedcoder.magentoautomationtest.backend.storemodule.StoreModuleLogin;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreModuleLoginSteps extends TestBase {
    StoreModuleLogin storeModuleLogin;
    FunctionPage functionPage;


    @Given("admin user is already in Magento admin login page")
    public void adminUserIsAlreadyInMagentoAdminLoginPage() {
        browserSetUp("http://magentoqa2.unitedcoder.com/index.php/admin");
        storeModuleLogin = new StoreModuleLogin(driver);
    }

    @When("admin user enter valid username and password")
    public void adminUserEnterValidUsernameAndPassword() {
        storeModuleLogin.login();
    }

    @Then("admin user able to login successfully")
    public void adminUserAbleToLoginSuccessfully() {
        Assert.assertTrue(storeModuleLogin.verifyLogin());
    }

// *************************Esma*****************************

      ManageStoresPage manageStoresPage;
      ManageCurrencyRatesPage manageCurrencyRatesPage;
      private String storeName;

    @Given("store manager is on the dashboard page")
    public void storeManagerIsOnTheDashboardPage() {
        storeModuleLogin=new StoreModuleLogin(driver);
        manageCurrencyRatesPage=new ManageCurrencyRatesPage(driver);
        manageStoresPage=new ManageStoresPage(driver);


   }

    @When("the user fills out a new store form {string}")
    public void theUserFillsOutANewStoreForm(String arg0) {
        manageStoresPage=new ManageStoresPage(driver);
        manageCurrencyRatesPage.clickManageStore();
        storeName=arg0;
        manageStoresPage.CreateStore(storeName);
    }

    @Then("a new store should be created")
    public void aNewStoreShouldBeCreated() {
        Assert.assertTrue(manageStoresPage.verifyCreateStore());
    }


}

