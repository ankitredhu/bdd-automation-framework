package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@Smoke1",
        plugin = {"pretty",
        		"html:target/cucumber-reports.html",
        		"rerun:target/failedrerun.txt" 
        		},
        monochrome = true,
        dryRun = false
)
public class TestRunner{
}
