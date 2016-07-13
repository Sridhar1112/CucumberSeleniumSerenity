package sapient.demo.api.test.module;

import static net.serenitybdd.rest.SerenityRest.rest;

import java.io.IOException;

import net.thucydides.core.annotations.Step;

import org.apache.commons.io.IOUtils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class AppPostSteps {

    public AppPostSteps() {
        RestAssured.baseURI = "";
        RestAssured.port = 8380;
        RestAssured.basePath = "";
    }

    @Step
    public void CreateNewUserAppointment() throws IOException {
        String jsonBody = IOUtils.toString(
                this.getClass().getResourceAsStream("/createNewAppointment.json"));
        final Response r = rest()
                .given()
                .contentType("application/json; charset=UTF-8")
                .body(jsonBody)
                .when()
                .post("")
                .prettyPeek();
        String responseBody = r.toString();
        // String userId = get("/person").path("person.npi");
        JsonPath jsonPath = new JsonPath(responseBody);
        // String npiID = r.path("npi"); // jsonPath.getInt("npi"));
        // return npiID;
    }

}
