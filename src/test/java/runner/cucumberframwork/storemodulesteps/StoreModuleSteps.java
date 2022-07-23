package runner.cucumberframwork.storemodulesteps;

import com.unitedcoder.magentoautomationtest.backend.storemodule.*;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
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


    @Given("admin user is already in Magento admin login page")
    public void adminUserIsAlreadyInMagentoAdminLoginPage() {
       browserSetUp(url);
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


//******************************************************************************

    CreateNewOrderPage createNewOrderPage;
    EditOrderPage editOrderPage;
    CancelOrderPage cancelOrderPage;
    CreateStoreViewPage createStoreViewPage;



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

    @After
        public  void tearDown() {
        driver.close();
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
//*************  kerim  ***************************





}
