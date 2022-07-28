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


    @Before
    public void setup(){
      connectionManager=new ConnectionManager();
     connection=connectionManager.connectToDatabaseServer();
    }


    @Given("connect to data base server")
    public void connectToDataBaseServer() {
        verifyAddCustomers=new VerifyAddCustomers();

    }

    @When("is customer exist")
    public boolean isCustomerExist() {
        String customerEmail= TestBase.readFromConfigProperties(configFile,"public_userEmail");
        boolean CustomerExist= verifyAddCustomers.getCustomer(customerEmail,connection);
        return CustomerExist;
    }

    @Then("Verify Newly Added Customers in data base server")
    public void verifyNewlyAddedCustomersInDataBaseServer() {
        Assert.assertTrue(isCustomerExist());
    }

    @After
    public void closeDatabaseConnection(){
        connectionManager.closeDatabaseConnection(connection);
}









}
