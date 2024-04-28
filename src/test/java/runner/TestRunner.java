package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature", // Location of feature files
        glue = {"stepdefinitions", "hooks"}, // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"}, // Plugins for generating reports
        tags = "@UAT"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class doesn't need any code inside, it's just used to set up Cucumber options
}
