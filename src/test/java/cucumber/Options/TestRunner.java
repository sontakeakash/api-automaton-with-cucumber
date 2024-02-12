package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature/placeValidation.feature",plugin="json:target/jsonReports/cucumber-report.json" ,glue= {"stepDefinitions"}/*, tags= "@DeletePlace"*/)
//uncomment tags to run only @Deleteplace tags testcases
public class TestRunner {

}
