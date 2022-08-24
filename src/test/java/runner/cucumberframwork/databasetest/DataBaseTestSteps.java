package runner.cucumberframwork.databasetest;

import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;

public class DataBaseTestSteps {

    ConnectionManager connectionManager;
    Connection connection;
    String configFile = "config-qa.properties";
    VerifyAddCustomers verifyAddCustomers;
    VerifyAddedStoreView verifyAddedStoreView;
    VerifyAddedTexRuleAtDB verifyAddedTexRuleAtDB;
    VerifyAddNewOrder verifyAddNewOrder;


    @Before
    public void setup() {
        connectionManager = new ConnectionManager();
        connection = connectionManager.connectToDatabaseServer();
    }


    @Given("connect to data base server")
    public void connectToDataBaseServer() {
        verifyAddCustomers = new VerifyAddCustomers();
        verifyAddedStoreView = new VerifyAddedStoreView();
        verifyAddedTexRuleAtDB = new VerifyAddedTexRuleAtDB();
        verifyAddNewOrder= new VerifyAddNewOrder();
    }

    @When("is customer exist")
    public boolean isCustomerExist() {
        String customerEmail = TestBase.readFromConfigProperties(configFile, "public_userEmail");
        boolean CustomerExist = verifyAddCustomers.getCustomer(customerEmail, connection);
        return CustomerExist;
    }

    @Then("Verify Newly Added Customers in data base server")
    public void verifyNewlyAddedCustomersInDataBaseServer() {
        Assert.assertTrue(isCustomerExist());
    }

    @After
    public void closeDatabaseConnection() {
        connectionManager.closeDatabaseConnection(connection);
    }


    @When("I get store view information")
    public void iGetStoreViewInformation() {
        String storeViewName = TestBase.readFromConfigProperties(configFile, "store-view-name");
        verifyAddedStoreView.getStoreViewInfo(storeViewName, connection);
    }

    @Then("Store view is visible at database")
    public void storeViewIsVisibleAtDatabase() {
        Assert.assertTrue(verifyAddedStoreView.verifyStoreViewIsAdded());
    }

    @When("I get tax rule information")
    public void iGetTaxRuleInformation() {
        String taxRule = TestBase.readFromConfigProperties(configFile, "tax-rule");
        verifyAddedTexRuleAtDB.getTaxRuleInfo(taxRule, connection);
    }

    @Then("Tax rule is visible at database")
    public void taxRuleIsVisibleAtDatabase() {
        Assert.assertTrue(verifyAddedTexRuleAtDB.verifyTexRuleIsAdded());
    }

    @When("The newly added order is exist")
    public boolean theNewlyAddedOrderIsExist() {
        int entity_id= Integer.parseInt(TestBase.readFromConfigProperties(configFile,"entity_id"));
       boolean OrderExist=verifyAddNewOrder.getOrder(entity_id,connection);
        return OrderExist;
    }

    @Then("Verify Newly added order in database server")
    public void verifyNewlyAddedOrderInDatabaseServer() {
        Assert.assertTrue(theNewlyAddedOrderIsExist());
    }
}
