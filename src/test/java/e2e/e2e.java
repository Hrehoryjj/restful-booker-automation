package e2e;

import api.client.BaseApiClient;
import api.endpoints.BookingEndpoints;
import base.BaseTestUI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ui.pages.HomePage;

import java.time.Duration;

import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertTrue;

public class e2e extends BaseTestUI {
    @Test
    public void tc01_createBookingWithValidData() throws InterruptedException {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        HomePage homePage = new HomePage(driver);
        BaseApiClient apiClient = new BaseApiClient();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/03/2027", Keys.ESCAPE);
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/03/2027", Keys.ESCAPE);

        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Hryhorii", "Tester", "test123@gmail.com", "1234567891011");
        homePage.clickReserveNow();
        String actualMessage = homePage.getSuccessBookingMessage();
        assertTrue(actualMessage.contains("Booking Confirmed"), "Passed");
        driver.close();

        Thread.sleep(1000);

        Response response = apiClient.Get(BookingEndpoints.CREATE_BOOKING, "Hryhorii", "Tester");

        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body(notNullValue());
    }
}
