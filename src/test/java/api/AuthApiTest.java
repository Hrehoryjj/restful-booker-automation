package api;

import api.client.BaseApiClient;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;

public class AuthApiTest extends BaseApiTest {
    private final BaseApiClient apiClient = new BaseApiClient();

    @Test
    public void tc19_loginWithValidCredentials() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "admin");
        credentials.put("password", "password123");

        Response response = apiClient.Post("/auth", credentials);

        response.then()
                .statusCode(200)
                .body("token", notNullValue());
    }


    @Test
    public void tc20_loginWithInvalidPassword() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", "admin");
        credentials.put("password", "wrongpass");

        Response response = apiClient.Post("/auth", credentials);

        response.then()
                .statusCode(403);
    }
    @Test
    public void tc21_loginWithEmptyUsername() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", " ");
        credentials.put("password", "password123");

        Response response = apiClient.Post("/auth", credentials);

        response.then()
                .statusCode(403);
    }
}
