package runner.cucumberframwork.marketingsteps;

import com.unitedcoder.magentoautomationtest.backend.marketingmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.TestBase;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;


public class MarketingSteps extends TestBase {
    MarketingLoginPage marketingLoginPage;
    CatalogPriceRulePage catalogPriceRulePage;
    DashboardPage dashboardPage;
    FunctionPage functionPage;
    UpdateExistingCatalogPriceRule updateExistingCatalogPriceRule;
    String configFile="config-qa.properties";
    PendingReviewsPage pendingReviewsPage;
    @Before("@MagentoMarketingModuleFeature")
    public void setUp(){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        marketingLoginPage=new MarketingLoginPage(driver);
        marketingLoginPage.login();

    }
    @After("@MagentoMarketingModuleFeature")
    public  void tearDown() {
        driver.quit();
    }

//    @Given("Marketing manager  is already in Magento admin login page")
//    public void marketingManagerIsAlreadyInMagentoAdminLoginPage() {
//        marketingLoginPage=new MarketingLoginPage(driver);
//
//    }
//
//    @When("Marketing manager  enter valid username and password")
//    public void marketingManagerEnterValidUsernameAndPassword() {
//        marketingLoginPage.login();
//    }
//
//    @Then("Marketing manager able to login successfully")
//    public void marketingManagerAbleToLoginSuccessfully() {
//        Assert.assertTrue(marketingLoginPage.verify());
//    }

    @Given("Marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        functionPage=new FunctionPage(driver);
        catalogPriceRulePage=new CatalogPriceRulePage(driver);
        dashboardPage=new DashboardPage(driver);
        updateExistingCatalogPriceRule=new UpdateExistingCatalogPriceRule(driver);
        pendingReviewsPage=new PendingReviewsPage(driver);
    }

    @When("Click on the Catalog Price Rules")
    public void clickOnTheCatalogPriceRules() {
        dashboardPage.clickOnCatalogPriceRulesOption();
    }

    @And("Marketing manager add new rule{string}")
    public void marketingManagerAddNewRule(String arg0) {
        catalogPriceRulePage.addNewCatalogPriceRule(arg0);
    }

    @Then("Marketing manager add new catalog price rule")
    public void marketingManagerAddNewCatalogPriceRule() {
        Assert.assertTrue(catalogPriceRulePage.verifyAddNewCatalogPriceRule());
    }
    @After("@marketingModule")
    public void close(){
        closeBrowser();
    }




    @When("Catalog Price Rule Page Open")
    public void catalogPriceRulePageOpen() {
        updateExistingCatalogPriceRule.openCatalogPriceRulePage();
    }

    @Then("update existing Catalog Price Rule")
    public void updateExistingCatalogPriceRule() {
        updateExistingCatalogPriceRule.update();
    }

    @And("verify existing Catalog Price Rule updated")
    public void verifyExistingCatalogPriceRuleUpdated() {
        updateExistingCatalogPriceRule.verify();
    }

    @When("Marketing manager should be able edit pending reviews")
    public void marketingManagerShouldBeAbleEditPendingReviews() {
        dashboardPage.clickAllReviewsOption();
        pendingReviewsPage.updatePendingReviews();

    }

    @Then("Marketing manager can update pending reviews")
    public void marketingManagerCanUpdatePendingReviews() {
       Assert.assertTrue(pendingReviewsPage.verifyUpdatePendingReviews());
    }
}
