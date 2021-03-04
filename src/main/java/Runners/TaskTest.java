package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/requirement.feature"},

        glue = {"StepDefinitions"},

        dryRun = false
)

public class TaskTest extends AbstractTestNGCucumberTests {

}
