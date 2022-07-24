package runner.cucumberframwork.storemodulesteps;

import com.unitedcoder.magentoautomationtest.backend.storemodule.*;
import com.unitedcoder.magentoautomationtest.utility.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class StoreModuleSteps extends TestBase {


    //****************************   Habiba   *********************************
    StoreModuleLogin storeModuleLogin;

    final static String configFile = "config-qa.properties";
    final static String url = TestBase.readFromConfigProperties(configFile, "backend_url");

//******************************************************************************

    CreateNewOrderPage createNewOrderPage;
    EditOrderPage editOrderPage;
    CancelOrderPage cancelOrderPage;
    CreateStoreViewPage createStoreViewPage;
@Before("@MagentoStoreModuleFeature")
public void setUp(){
    browserSetUp(url);
    storeModuleLogin = new StoreModuleLogin(driver);
    storeModuleLogin.login();



}

@Given("create page object")
    public void storeManagerAlreadyLoggedIn() {

        storeModuleLogin = new StoreModuleLogin(driver);
        createNewOrderPage=new CreateNewOrderPage(driver);
        editOrderPage=new EditOrderPage(driver);
        cancelOrderPage=new CancelOrderPage(driver);
        createNewOrderPage=new CreateNewOrderPage(driver);

    }


//*************   Nijat   ***************************

//Create New Order Steps
    @When("a customer selected")
    public void aCustomerSelected() {
        createNewOrderPage.selectCustomer();
        createNewOrderPage.createOrder();
    }

    @Then("create a new order")
    public void createANewOrder() {
        createNewOrderPage.fillTheForm();
    }

    @And("verify create a new order")
    public void verifyCreateANewOrder() {
        Assert.assertTrue(createNewOrderPage.verify());
        System.out.println("create order");
    }

    @After("@MagentoStoreModuleFeature")
        public  void tearDown() {
        driver.quit();
    }

//Edit order steps
    @When("a customer select for edit")
    public void aCustomerSelectForEdit() {
        editOrderPage.findOrder();
    }

    @Then("edit a new order")
    public void editANewOrder() {
        editOrderPage.editOrder();
    }

    @And("verify  edit order")
    public void verifyEditOrder() {
        Assert.assertTrue(editOrderPage.verify());
        System.out.println("edit order");
    }


//cancel order steps
    @When("select a customer")
    public void selectACustomer() {
        cancelOrderPage.findOrder();
    }

    @Then("cancel order")
    public void cancelOrder() {
        cancelOrderPage.cancelOrder();
    }

    @And("verify  cancel order")
    public void verifyCancelOrder() {
        cancelOrderPage.verify();
        System.out.println("cancel order");
    }
    //create store steps
    // *************************Esma*****************************

    ManageStoresPage manageStoresPage;
    ManageCurrencyRatesPage manageCurrencyRatesPage;
    private String storeName;
    private String websiteCode;

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


    @When("the user edit the store")
    public void theUserEditTheStore() {
        manageStoresPage=new ManageStoresPage(driver);
        manageCurrencyRatesPage.clickManageStore();
        manageStoresPage.editStore();
    }
    @Then("store edit successfully")
    public void storeEditSuccessfully() {
        Assert.assertTrue(manageStoresPage.verifyEditStore());
    }
    //      createWebsite
    // *************************Zohra*****************************
    CreateWebsitePage createWebsitePage;

    @When("store manager should be able to create website")
    public void store_manager_should_be_able_to_create_website() {
        createWebsitePage=new CreateWebsitePage(driver);
        manageCurrencyRatesPage.clickManageStore();
        createWebsitePage.createWebsite();

    }
    @Then("a new website should be created")
    public void store_manager_should_be_able_to_see_the_website_has_been_saved_message() {
        Assert.assertTrue(createWebsitePage.verifyCreateWebsite());
    }
    // *************************Abdukerim*****************************
    @When("store manager is on manage store page")
    public void storeManagerIsOnManageStorePage() {

    }

    @Then("store manager create new store view")
    public void storeManagerCreateNewStoreView() {
    }

    @And("verify create new store view")
    public void verifyCreateNewStoreView() {
    }
}
