package base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class BaseApiTest {

    protected static int createBookingId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    protected String getAuthToken(){
        Map<String, String> authData = new HashMap<>();
        authData.put("username", "admin");
        authData.put("password", "password123");

        return given()
                .contentType("application/json")
                .body(authData)
                .when()
                .post("/auth")
                .jsonPath()
                .getString("token");
    }
}