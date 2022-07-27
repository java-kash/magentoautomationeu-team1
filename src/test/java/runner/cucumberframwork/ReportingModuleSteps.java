package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.backend.reportingmodule.ReportingModuleDashBoard;
import com.unitedcoder.magentoautomationtest.backend.reportingmodule.ReportingModuleLogin;
import com.unitedcoder.magentoautomationtest.backend.reportingmodule.ReportingOrderedReportPage;
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
    ScreenshotUtility screenshotUtility;
    String configFile = "config-qa.properties";
    String url = TestBase.readFromConfigProperties(configFile, "backend_url");

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
}
