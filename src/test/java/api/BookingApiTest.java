package api;

import api.client.BaseApiClient;
import api.endpoints.BookingEndpoints;
import api.models.Booking;
import api.models.BookingDates;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BookingApiTest extends BaseApiTest {
    private final BaseApiClient apiClient = new BaseApiClient();

    @Test
    public void CreateBookingTest(){
        BookingDates dates = new BookingDates("2026-10-10", "2026-10-17");
        Booking payload = new Booking("Gregory", "Test", 250, true, dates, "Breakfast");
        Response response = apiClient.Post(BookingEndpoints.CREATE_BOOKING, payload);

        response.then().statusCode(201);
    }

}
