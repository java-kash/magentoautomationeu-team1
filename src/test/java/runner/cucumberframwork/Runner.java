package runner.cucumberframwork;

import com.unitedcoder.magentoautomationtest.utility.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target//cucumber-output/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        features = {"src/test/resources"},
        tags="@SalesModuleLoginFeature"
)

public class Runner extends TestBase {
    @BeforeClass
    public static void setup() {

    }

    @AfterClass
    public static void tearDown() {

    }
}
