package sapient.demo.api.test.module;

import static net.serenitybdd.rest.SerenityRest.rest;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import net.thucydides.core.annotations.Step;

public class ProviderPostSteps {

    public ProviderPostSteps() {
        RestAssured.baseURI = "http://hrsaext1dev.nih.gov";
        RestAssured.port = 8380;
        RestAssured.basePath = "";
    }

    @Step
    public String postProviderNPI(String npiNum) throws IOException {
        String jsonBody = IOUtils.toString(
                this.getClass().getResourceAsStream("/providerBodyRequest.json"));
        final Response r = rest()
                .given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post("/sdms-provider-service/rest/providers/" + npiNum)
                .prettyPeek();
        String responseBody = r.toString();
        // String userId = get("/person").path("person.npi");
        JsonPath jsonPath = new JsonPath(responseBody);
        String npiID = r.path("npi"); // jsonPath.getInt("npi"));
        return npiID;
    }

    @Step
    public void postPCOAcknowledgement() throws IOException {
        String jsonBody = IOUtils.toString(
                this.getClass().getResourceAsStream("/sample.json"));
        ValidatableResponse r = rest()
                .given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post("http://hrsaext1dev.nih.gov:8380/sdms-designation-service/rest/pco-acknowledgement/acknowledge")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
