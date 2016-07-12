package sapient.demo.api.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(format = { "pretty", "html:reports/test-report" }, features = "src/test/resources/features/")
public class RunSmokeTest {

}
