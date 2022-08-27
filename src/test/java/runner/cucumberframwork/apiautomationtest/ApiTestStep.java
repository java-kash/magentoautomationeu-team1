package runner.cucumberframwork.apiautomationtest;

import com.unitedcoder.magentoautomationtest.apitest.PayloadUtility;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;


public class ApiTestStep extends TestBase {

    Response response;
    String configFile="config-qa.properties";
    String baseURL=readFromConfigProperties(configFile,"api.baseurl");
    String username=readFromConfigProperties(configFile,"api.username");
    String password=readFromConfigProperties(configFile,"api.password");
    int port= Integer.parseInt(readFromConfigProperties(configFile,"api.port"));

    @Given("User Should be able Get Request information")
    public void userShouldBeAbleGetRequestInformation() {
    }
    @When("User Should be able to send request get{string} information")
    public void userShouldBeAbleToSendRequestGetInformation(String arg0) {
        response=RestAssured.given().auth().basic(username,password).when()
                .get(baseURL+":"+port+"/"+arg0);
        System.out.println(response.getBody().prettyPrint());
    }
    @Then("User Should be get information about the Customer")
    public void userShouldBeGetInformationAboutTheCustomer() {

        int responseCode=response.getStatusCode();
        Assert.assertEquals(responseCode,200);
    }

    @Given("User should be able to send request for update specific {string} information.")
    public void userShouldBeAbleToSendRequestForUpdateSpecificCustomer_GroupInformation(String groupId) {
        response= RestAssured.given().headers("Content-Type","application/json").and().body(PayloadUtility.getCustomerGroupPayload(110,"Ay_Team1",7))
                .auth().basic(username,password)
                .when().put(baseURL+":"+port+"/"+groupId);
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("User should get response {int} .")
    public void userShouldGetResponse(int arg1) {
       Assert.assertEquals(response.getStatusCode(),arg1);
    }




    @Then("User Should be get information about the categories.")
    public void userShouldBeGetInformationAboutTheCategories() {

        int responseCode=response.getStatusCode();
        Assert.assertEquals(responseCode,200);
    }


}
