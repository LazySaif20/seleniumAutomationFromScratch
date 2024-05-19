package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature", // Location of feature files
        glue = {"stepdefinitions", "hooks", "utilities"}, // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"}, // Plugins for generating reports
        tags = "@UAT"
)
public class TestRunner extends AbstractTestNGCucumberTests {
//Ansari
}
