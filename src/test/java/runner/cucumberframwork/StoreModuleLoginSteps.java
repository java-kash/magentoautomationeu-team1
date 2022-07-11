package runner.cucumberframwork;

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
}
