package api;

import api.client.BaseApiClient;
import api.endpoints.BookingEndpoints;
import api.models.Booking;
import api.models.BookingDates;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


import static groovy.json.JsonOutput.prettyPrint;
import static org.hamcrest.Matchers.notNullValue;

public class BookingApiTest extends BaseApiTest {
    private final BaseApiClient apiClient = new BaseApiClient();

    @Test
    public void tc01_createBookingWithValidData(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 250, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);
        //response.prettyPrint();
        createBookingId = response.then().extract().path("bookingid");

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("bookingid", notNullValue());
    }

    @Test
    public void tc02_createBookingWithoutOptionalFields(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 250, true, dates, " ");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("bookingid", notNullValue());
    }

    @Test
    public void tc03_createBookingWithBoundaryPrice(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 1, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("bookingid", notNullValue());
    }

    @Test
    public void tc04_createBookingWithInvalidCheckoutDate(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 250, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("error", notNullValue());
    }

    @Test
    public void tc05_createBookingWithZeroPrice(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 0, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("error", notNullValue());
    }

    @Test
    public void tc06_createBookingWithNumbersInName(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("12345", "Test", 250, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("error", notNullValue());
    }

    @Test
    public void tc07_createBookingWithLettersInPrice(){
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", "Gregory");
        payload.put("lastname", "Test");
        payload.put("totalprice", "twenty");
        payload.put("depositpaid", true);
        payload.put("bookingdates", new BookingDates("2026-10-10", "2026-10-17"));

        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then()
                .log().ifValidationFails()
                .statusCode(400)
                .body("error", notNullValue());
    }

    @Test
    public void tc08_getAllBookingIds(){
        Response response = apiClient.Get(BookingEndpoints.CREATE_BOOKING);

                response.then()
                        .log().ifValidationFails()
                        .statusCode(200)
                        .body(notNullValue());
    }

    @Test
    public void tc09_getBookingById(){
        Response response = apiClient.Get(BookingEndpoints.GET_BOOKING, createBookingId);

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void tc10_getBookingByNameFilter(){
        Response response = apiClient.Get(BookingEndpoints.CREATE_BOOKING, "Gregory", "Test");

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(notNullValue());
    }
    @Test
    public void tc11_getBookingByWrongId() {
        Response response = apiClient.Get(BookingEndpoints.GET_BOOKING, 0);

        response.then()
                .log().ifValidationFails()
                .statusCode(404)
                .body(notNullValue());
    }

    @Test
    public void tc12_getBookingByWrongName() {
        Response response = apiClient.Get(BookingEndpoints.CREATE_BOOKING, "Grogory", "Test");
        response.prettyPrint();
        response.then()
                .log().ifValidationFails()
                .statusCode(404)
                .body(notNullValue());
    }

    @Test
    public void tc13_updateFullBookingInformation() {
        String token = getAuthToken();
        BookingDates dates = new BookingDates("2026-11-11", "2026-11-17");
        Booking payload = new Booking("Sasha", "Brown", 150, false, dates, "none");
        Response response = apiClient.Put(BookingEndpoints.UPDATE_BOOKING, createBookingId, token, payload);
        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void tc14_updateBookingAdditionalInfoOnly() {
    }

    @Test
    public void tc15_updateBookingToEmptyValues() {
    }

    @Test
    public void tc16_updateBookingWithInvalidDates() {
    }

    @Test
    public void tc17_deleteBookingSuccess() {
    }

    @Test
    public void tc18_deleteBookingWithoutId() {
    }

    @Test
    public void tc19_loginWithValidCredentials() {
    }

    @Test
    public void tc20_loginWithInvalidPassword() {
    }


}
