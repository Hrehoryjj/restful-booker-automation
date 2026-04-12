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

    public Response Get(String endpoint, int id) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .get(endpoint + "{id}");
    }

    public Response Get(String endpoint, String firstname, String lastname){
        return given()
                .header("Content-Type", "application/json")
                .queryParam("firstname", firstname)
                .queryParam("lastname", lastname)
                .when()
                .get(endpoint);
    }
    public Response Put(String endpoint,int id,String token, Object body){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(body)
                .pathParam("id", id)
                .when()
                .put(endpoint + "{id}");
    }


}
