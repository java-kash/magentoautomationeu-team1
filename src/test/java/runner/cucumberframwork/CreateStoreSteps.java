package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.storemodule.ManageStoresPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateStoreSteps extends TestBase {
    ManageStoresPage manageStoresPage;
    private String storeName;
    @Given("store manager is on the dashboard page")
    public void storeManagerIsOnTheDashboardPage() {
    }

    @When("the user fills out a new store form {string}")
    public void theUserFillsOutANewStoreForm(String arg0) {
        storeName=arg0;
        manageStoresPage=new ManageStoresPage(driver);
        manageStoresPage.CreateStore(storeName);
    }

    @Then("a new store should be created")
    public void aNewStoreShouldBeCreated() {
        Assert.assertTrue(manageStoresPage.verifyCreateStore());
    }


}
