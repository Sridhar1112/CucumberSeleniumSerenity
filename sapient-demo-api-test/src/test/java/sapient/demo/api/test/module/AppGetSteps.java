package sapient.demo.api.test.module;

import static com.jayway.restassured.RestAssured.get;
import static net.serenitybdd.rest.SerenityRest.rest;
import net.thucydides.core.annotations.Step;

import org.json.JSONObject;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class AppGetSteps {

    public final String uid = "1003000126";

    public AppGetSteps() {
        RestAssured.baseURI = "";
        // RestAssured.port = ;
        RestAssured.basePath = "";
    }

    @Step
    public int getProviderByNPI(String npiNum) {
        final Response getProviderResponse = get("/rest/providers/" + npiNum);
        String json = getProviderResponse.asString();
        System.out.println(" status = " + getProviderResponse.getStatusCode());
        return getProviderResponse.getStatusCode();
    }

    @Step
    public void getNPIData() {
        final String StatusCode = get("/rest/providers/1003000126")
                .prettyPrint();
        System.out.println("status = " + StatusCode);
    }

    @Step
    public void checkStatusCode() {
        rest()
                .given()
                .get("/rest/providers/1003000126")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step
    public String checkProviderDisciplineList() {
        final String r = rest()
                .given()
                .get("/rest/providerDiscipline")
                .prettyPrint();
        return r;
    }

    @Step
    public String checkProviderControllerServiceStatus() {
        final String r = rest()
                .given()
                .when()
                .get("rest/status")
                .prettyPrint();
        JSONObject obj = new JSONObject(r);
        return obj.getString("status");
    }

    @Step
    @Test
    public void checkProviderSpecialty() {
        rest()
                .given()
                .get("/rest/providerSpecialty")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
