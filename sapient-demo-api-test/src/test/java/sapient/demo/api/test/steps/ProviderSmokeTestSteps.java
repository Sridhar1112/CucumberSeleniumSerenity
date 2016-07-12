package sapient.demo.api.test.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import sapient.demo.api.test.module.ProviderGetSteps;
import sapient.demo.api.test.module.ProviderPostSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProviderSmokeTestSteps {

    ProviderGetSteps providerGetSteps = new ProviderGetSteps();
    ProviderPostSteps providerPostSteps = new ProviderPostSteps();

    @Given("^get provider npi \"([^\"]*)\"$")
    public void getProviderByNPI(String arg1) throws Throwable {
        providerGetSteps.getProviderByNPI(arg1);
    }

    @Then("^check status$")
    public void checkStatusCode() throws Throwable {
        providerGetSteps.checkStatusCode();
    }

    @And("^post provider npi \"([^\"]*)\"$")
    public void postProviderNPI(String arg1) throws Throwable {
        String npiID = providerPostSteps.postProviderNPI(arg1);
        assertThat(Integer.parseInt(npiID), equalTo(Integer.parseInt(arg1)));
    }

    @Given("^check provider discipline list$")
    public void checkProviderDisciplineList() throws Throwable {
        String[] al = { "MH", "DH", "PC" };
        String disciplineList = providerGetSteps.checkProviderDisciplineList();
        for (int i = 0; i < al.length; i++) {
            System.out.println(disciplineList.contains(al[i]));
            assert (disciplineList.contains(al[i]));
        }
    }

    @Given("^check provider controller status$")
    public void checkProivderControllerServiceStatus() throws Throwable {
        String controllerStatus = providerGetSteps.checkProviderControllerServiceStatus();
        assertThat(Integer.parseInt(controllerStatus), equalTo(200));
    }

    @Given("^check post pco acknowledgement service$")
    public void postPCOAcknowledgement() throws Throwable {
        providerPostSteps.postPCOAcknowledgement();
    }

    @Given("^check provider specialty service$")
    public void checkProviderSpecialty() throws Throwable {
        providerGetSteps.checkProviderSpecialty();
    }

}
