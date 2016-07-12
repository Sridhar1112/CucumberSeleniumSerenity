package demo.ui.test1;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;




@RunWith(CucumberWithSerenity.class)
@CucumberOptions(	format = {"pretty", "html:reports/test-report"},
features="src/test/resources/features/")

public class RunSmokeTest {

}
