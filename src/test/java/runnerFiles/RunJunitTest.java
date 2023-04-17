package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles",
plugin={"junit:target/cucumber-reports/Cucumber.xml"},
glue = "stepDefinitions")
public class RunJunitTest {

	
}
