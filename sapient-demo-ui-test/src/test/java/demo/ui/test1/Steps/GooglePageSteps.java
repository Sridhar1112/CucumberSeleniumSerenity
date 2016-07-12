package demo.ui.test1.Steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import demo.ui.test1.Module.GoogleModule;

public class GooglePageSteps {
    protected String Anumber = null;
    protected String status = null;
    protected String cid = null;

    @Steps
    GoogleModule gSteps;

    @Given("^go to google page$")
    public void go_to_google_page() throws Throwable {
        gSteps.gotoGooglePage();
    }

    @Given("^enter search key \"([^\"]*)\"$")
    public void enter_search_key(String arg1) throws Throwable {
        gSteps.enterSearchKey(arg1);
    }

}
