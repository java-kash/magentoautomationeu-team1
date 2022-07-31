package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.marketingmodule.*;
import com.unitedcoder.magentoautomationtest.backend.storemodule.ManageStoresPage;
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
    AddNewNewsletterTemplate addNewNewsletterTemplate;
    UpdateExistingCatalogPriceRule updateExistingCatalogPriceRule;
    String configFile="config-qa.properties";
    PendingReviewsPage pendingReviewsPage;
    AddNewCartPriceRulePage addNewShoppingCartPriceRulePage;
    UpdateExistingReviews updateExistingReviews;
    ScreenshotUtility screenshotUtility=new ScreenshotUtility();
    UpdateAnExistingNewsletterTemplatePage updateAnExistingNewsletterTemplatePage;
    String title;
    ViewAllReviews viewAllReviews;
    MarketingManagerDeleteTemplate marketingManagerDeleteTemplate;

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
        addNewNewsletterTemplate=new AddNewNewsletterTemplate(driver);
        updateAnExistingNewsletterTemplatePage=new UpdateAnExistingNewsletterTemplatePage(driver);
        updateExistingReviews = new UpdateExistingReviews(driver);
        viewAllReviews=new ViewAllReviews(driver);
        marketingManagerDeleteTemplate=new MarketingManagerDeleteTemplate(driver);

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

    @When("Marketing manager add new newsletter template{string} and {string} and{string}")
    public void marketingManagerAddNewNewsletterTemplateAndAnd(String arg0, String arg1, String arg2) {
        addNewNewsletterTemplate.addNewNewsLetterTemplate(arg0,arg1,arg2);
    }


    @Then("Marketing manager can see her new added template {string}")
    public void marketingManagerCanSeeHerNewAddedTemplate(String arg0) {
        addNewNewsletterTemplate.verifyNewsletterAddedSuccessfully(arg0);
    }




    @When("Marketing manager should be able update existing")
    public void marketingManagerShouldBeAbleUpdateExisting() {
        addNewShoppingCartPriceRulePage.upDateShoppingCartPriceRule();
    }

    @Then("Marketing manager should be updated")
    public void marketingManagerShouldBeUpdated() {
        Assert.assertTrue(addNewShoppingCartPriceRulePage.verifyUpDateShoppingCartPriceRule());
    }

    @When("Marketing manager Update {string} and {string}")
    public void marketingManagerUpdateAnd(String arg0, String arg1) {
        updateAnExistingNewsletterTemplatePage.updateNewsletterTemplate(arg0,arg1);
    }

    @Then("Marketing manager able to see his updated new template content {string}")
    public void marketingManagerAbleToSeeHisUpdatedNewTemplateContent(String arg0) {
        updateAnExistingNewsletterTemplatePage.updateNewsletterTemplateSuccessfully(arg0);
    }

    @When("User hovers to click the {string}")
    public void userHoversOverThe(String text) {
        functionPage.hoverToClick(text);
    }
    @Then("User navigates to {string}")
    public void userNavigatesToPageAndShouldSeePageName(String expectedPageName) {
        System.out.println("Expected page name: " + expectedPageName);
        System.out.println("Actual page name: " + functionPage.getPageName(expectedPageName));
        Assert.assertEquals(expectedPageName, functionPage.getPageName(expectedPageName));
    }



    @Then("user should see page name All Reviews")
    public void userShouldSeePageNameAllReviews() {
        Assert.assertTrue(viewAllReviews.verifyRiewsPage());

    }

    @When("user selects one id number randomly in ID column on the list table")
    public void userSelectsOneIdNumberRandomlyInIDColumnOnTheListTable() {
        catalogPriceRulePage.selectsOneIdNumberRandomly();
    }

    @And("user fills the number in ID field with made the random id number")
    public void userFillsTheNumberInIDFieldWithMadeTheRandomIdNumber() {
        catalogPriceRulePage.fillIdToField();
    }

    @And("user Clicks on Search button")
    public void userClicksOnSearchButton() {
        catalogPriceRulePage.clickOnSearchButton();
    }

    @Then("user should be able to see rules ID match with selected ID")
    public void userShouldBeAbleToSeeRulesIDMatchWithSelectedID() {
        Assert.assertEquals(catalogPriceRulePage.listIdNumber(), catalogPriceRulePage.getFieldValue());

        System.out.println("Id field value is: " + catalogPriceRulePage.getFieldValue());
        System.out.println("Table's ID is: " + catalogPriceRulePage.listIdNumber());
    }

    @When("user clicks on Reset Filter button")
    public void userClicksOnResetFilterButton() {
        catalogPriceRulePage.clickOnResetButton();
    }

    @When("user selects one rule name randomly in Rule Name column on the list table")
    public void userSelectsOneRuleNameRandomlyInRuleNameColumnOnTheListTable() {
        catalogPriceRulePage.selectsOneRuleNameRandomly();
    }

    @And("user fills the Rule Name field with made the random rule name")
    public void userFillsTheRuleNameFieldWithMadeTheRandomRuleName() {
        catalogPriceRulePage.fillNameToField();
    }

    @Then("user should be able to see rules Rule Name match with selected Rule Name")
    public void userShouldBeAbleToSeeRulesRuleNameMatchWithSelectedRuleName() {
        Assert.assertEquals(catalogPriceRulePage.listRuleName(), catalogPriceRulePage.getNameFieldValue());

        System.out.println("Rule name field value is: " + catalogPriceRulePage.getNameFieldValue());
        System.out.println("Table's rule name is: " + catalogPriceRulePage.listRuleName());
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = functionPage.getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @When("Marketing manager can update review")
    public void marketingManagerCanUpdateReview() {
        dashboardPage.clickAllReviewsOption2();
        updateExistingReviews.updateReview();

    }

    @Then("Marketing manager can see the success massage")
    public void marketingManagerCanSeeTheSuccessMassage() {
        Assert.assertTrue(updateExistingReviews.verifyUpdateReview());
    }



    @When("Marketing manager delete an existing template {string}")
    public void marketingManagerDeleteAnExistingTemplate(String arg0) {
        marketingManagerDeleteTemplate.deleteNewNewsLetterTemplate(arg0);
    }

    @Then("Marketing manager can't able to see template {string}")
    public void marketingManagerCanTAbleToSeeTemplate(String arg0) {
        marketingManagerDeleteTemplate.verifyNewsletterDeletedSuccessfully(arg0);
    }
}
