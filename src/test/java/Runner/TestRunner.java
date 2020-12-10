package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/relatorio.html"},
        glue = {"StepsDefinitions"},
        tags = {"@teste"},
        features = {"src/test/features"})

public class TestRunner {
}
