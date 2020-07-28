package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features",
        glue ={"stepdefinitions"},
        plugin = {"json:target/cucumber-report/cucumber.json"},
        monochrome = true
)
public class CucumberTestsRunner {

}
