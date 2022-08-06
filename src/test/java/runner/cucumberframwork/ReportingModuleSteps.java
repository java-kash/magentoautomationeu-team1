package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.reportingmodule.*;
import com.unitedcoder.magentoautomationtest.utility.FunctionPage;
import com.unitedcoder.magentoautomationtest.utility.Log4j;
import com.unitedcoder.magentoautomationtest.utility.ScreenshotUtility;
import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportingModuleSteps extends TestBase {
    ReportingModuleLogin loginPage;
    ReportingModuleDashBoard dashBoard;
    ReportingOrderedReportPage orderedReportPage;
    SeeShoppingCartPage seeShoppingCartPage;
    SeeTagsPage seeTagsPage;
    ScreenshotUtility screenshotUtility;
    String configFile = "config-qa.properties";
    String url = TestBase.readFromConfigProperties(configFile, "backend_url");
    String title;
    FunctionPage functionPage;
    ProductInCartsReport productInCartsReport;
    ProductsMostViewedReportPage productsMostViewedReportPage;
    ProductReviewsReportPage productReviewsReportPage;
    @Before("@MagentoReportingModuleTest")
    public void setUp() {
        browserSetUp(url);
        loginPage = new ReportingModuleLogin(driver);
        loginPage.login();
    }
    @After("@MagentoReportingModuleTest")
    public void tearDown(Scenario scenario){
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

    @Given("Reporting Manager at the dashboard page")
    public void reporting_manager_at_the_dashboard_page() {
        dashBoard = new ReportingModuleDashBoard(driver);
        orderedReportPage = new ReportingOrderedReportPage(driver);
        dashBoard.clickOnDashBoardLink();
        seeShoppingCartPage=new SeeShoppingCartPage(driver);
        seeTagsPage=new SeeTagsPage(driver);
        functionPage = new FunctionPage(driver);
        productInCartsReport=new ProductInCartsReport(driver);
        productsMostViewedReportPage=new ProductsMostViewedReportPage(driver);
        productReviewsReportPage=new ProductReviewsReportPage(driver);
    }

    @When("Reporting manager navigate to sales ordered report page")
    public void reporting_manager_navigate_to_sales_ordered_report_page() {
        dashBoard.openOrdersPage();
    }

    @When("Fills in {string} {string} and clicks submit button")
    public void fills_in_and_clicks_submit_button(String string, String string2) {
        orderedReportPage.fillFilterInfo(string, string2);
    }

    @Then("Report is visible")
    public void report_is_visible() {
        Assert.assertTrue(orderedReportPage.reportIsVisible());
    }


    @When("Reporting manager navigate to sales refund report page")
    public void reportingManagerNavigateToSalesRefundReportPage() {
        dashBoard = new ReportingModuleDashBoard(driver);
        dashBoard.openRefundsPage();
    }

    @When("see Shopping Cart - Abandoned carts Report")
    public void seeShoppingCartAbandonedCartsReport() {
        seeShoppingCartPage.viewAbandonedCartsReport();
    }

    @Then("verify see Shopping Cart - Abandoned carts Report")
    public void verifyReport() {
        seeShoppingCartPage.verify();
    }

    @When("see Tags - Popular Report")
    public void seeTagsPopularReport() {
        seeTagsPage.viewPopularReport();
    }

    @Then("verify see Tags - Popular Report")
    public void verifySeeTagsPopularReport() {
        seeTagsPage.verifyReport();
    }


    @When("Reporting gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = functionPage.getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("Reporting module page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @When("Reporting hovers to click the {string}")
    public void userHoversOverThe(String text) {
        functionPage.hoverToClick(text);
    }

    @Given("Reporting navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        String name = functionPage.getPageNameH3(pageName);
        System.out.println("Page name is: " + name);
    }


    @When("see Shopping cart-Product in cart")
    public void seeShoppingCartProductInCart() {
        productInCartsReport.productInCarts();

    }

    @Then("Vrify can see shopping cart-product in carts")
    public void vrifyCanSeeShoppingCartProductInCarts() {
        Assert.assertTrue(productInCartsReport.verifyproductInCarts());
    }





    @When("Reporting manager navigate to  most viewed page")
    public void reporting_manager_navigate_to_most_viewed_page() {
        productsMostViewedReportPage.mostViewedPage();

    }
    @When("Fills in {string} {string} and clicks show report button")
    public void fills_in_and_clicks_show_report_button(String string, String string2) {
        productsMostViewedReportPage.showReport(string,string2);

    }
    @Then("Most viewed report is visible")
    public void most_viewed_report_is_visible() {

            Assert.assertTrue(productsMostViewedReportPage. mostViewedReportIsVisible());

    }
    @When("see product reviews report")
    public void see_product_reviews_report() {
        productReviewsReportPage.seeProductReviewsReport();

    }
    @Then("verify see product reviews report")
    public void verify_see_product_reviews_report() {
        productReviewsReportPage.verifyProductReviewsReport();
    }

}
