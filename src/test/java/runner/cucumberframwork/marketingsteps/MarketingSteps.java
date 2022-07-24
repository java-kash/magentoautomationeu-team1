package runner.cucumberframwork.marketingsteps;

import com.unitedcoder.magentoautomationtest.backend.marketingmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.ScreenshotUtility;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class MarketingSteps extends TestBase {
    MarketingLoginPage marketingLoginPage;
    CatalogPriceRulePage catalogPriceRulePage;
    DashboardPage dashboardPage;
    FunctionPage functionPage;
    UpdateExistingCatalogPriceRule updateExistingCatalogPriceRule;
    String configFile="config-qa.properties";
    PendingReviewsPage pendingReviewsPage;
    AddNewCartPriceRulePage addNewShoppingCartPriceRulePage;
    ScreenshotUtility screenshotUtility=new ScreenshotUtility();

    @Before("@MagentoMarketingModuleFeature")
    public void setUp(){
        browserSetUp(readFromConfigProperties(configFile,"backend_url"));
        marketingLoginPage=new MarketingLoginPage(driver);
        marketingLoginPage.login();

    }
    @After("@MagentoMarketingModuleFeature")
    public  void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            Log4j.error(scenario.getName()+"      Failed");
            screenshotUtility.takeScreenshot("image",scenario.getName(),driver);
            byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",scenario.getName());
        }
        if(!scenario.isFailed()) {
            Log4j.info(scenario.getName() + "       Passed");
        }
        driver.quit();
    }

    @Given("Marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        functionPage=new FunctionPage(driver);
        catalogPriceRulePage=new CatalogPriceRulePage(driver);
        dashboardPage=new DashboardPage(driver);
        updateExistingCatalogPriceRule=new UpdateExistingCatalogPriceRule(driver);
        pendingReviewsPage=new PendingReviewsPage(driver);
        addNewShoppingCartPriceRulePage=new AddNewCartPriceRulePage(driver);
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



    @When("Marketing manager should be able add new shopping cart price rule")
    public void marketing_manager_should_be_able_add_new_shopping_cart_price_rule() {

        addNewShoppingCartPriceRulePage.addNewShoppingCartPriceRule();

    }
    @Then("a new shopping cart price rule should be added")
    public void a_new_shopping_cart_price_rule_should_be_added() {
        Assert.assertTrue(addNewShoppingCartPriceRulePage.verifyAddNewShoppingCartPriceRule());
    }

    @When("Marketing manager should be able update existing")
    public void marketingManagerShouldBeAbleUpdateExisting() {
        addNewShoppingCartPriceRulePage.upDateShoppingCartPriceRule();
    }

    @Then("Marketing manager should be updated")
    public void marketingManagerShouldBeUpdated() {
        Assert.assertTrue(addNewShoppingCartPriceRulePage.verifyUpDateShoppingCartPriceRule());
    }
}
