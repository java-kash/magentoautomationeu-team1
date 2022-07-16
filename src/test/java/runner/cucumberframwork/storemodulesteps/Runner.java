package runner.cucumberframwork.storemodulesteps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target//cucumber-output/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        features = {"src/test/resources"},
        tags="@MagentoStoreModuleFeature"
)

public class Runner{


}
