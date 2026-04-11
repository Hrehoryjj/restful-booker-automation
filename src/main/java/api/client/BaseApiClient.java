package api.client;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class BaseApiClient {

    public Response Post(String endpoint, Object body) {
        return given()
        .header("Content-Type", "application/json")
                .body(body)
        .when()
                .post(endpoint);

    }

    public Response Get(String endpoint){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint);
    }
}
