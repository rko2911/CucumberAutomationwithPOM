package Runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src\\test\\java\\Feature\\com\\Login.feature",
		 glue={"stepDefinitions"}
 )
public class TestRunner {
}