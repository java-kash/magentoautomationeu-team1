package runner.cucumberframwork.storemodulesteps;

import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target//cucumber-output/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        features = {"src/test/resources/salesmodulelogin.feature"}
  //       glue = {"runner/cucumberframwork/marketingsteps","runner/cucumberframwork/marketingsteps/"},
    //     tags = "@MagentoMarketingModuleFeature"


)

public class Runner {

}
