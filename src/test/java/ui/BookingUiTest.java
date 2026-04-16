package ui;

import base.BaseTestUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BookingUiTest extends BaseTestUI {
    //Booking tests
    @Test
    public void tc01_createBookingWithValidData() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/10/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/10/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Gregory", "Test", "test123@gmail.com", "1234567891011");
        homePage.clickReserveNow();

        String actualMessage = homePage.getSuccessBookingMessage();
        assertTrue(actualMessage.contains("Booking Confirmed"), "Passed");
    }


    @Test
    public void tc02_createBookingWithMinimalPhoneLength() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/11/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/11/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Gregory", "Test", "test123@gmail.com", "12345678910");
        homePage.clickReserveNow();

        String actualMessage = homePage.getSuccessBookingMessage();
        assertTrue(actualMessage.contains("Booking Confirmed"), "Passed");
    }

    @Test
    public void tc03_createBookingWithMaximalPhoneLength() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/10/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/10/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Gregory", "Test", "test123@gmail.com", "123456789101112131415");
        homePage.clickReserveNow();

        String actualMessage = homePage.getSuccessBookingMessage();
        assertTrue(actualMessage.contains("Booking Confirmed"), "Passed");
    }

    @Test
    public void tc04_createBookingWithNumbersInName() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/12/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/12/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("1111", "Test", "test123@gmail.com", "1234567891011");
        homePage.clickReserveNow();

        String actualError = homePage.getErrorBookingMessage();
        assertTrue(actualError.contains("must be") || actualError.contains("be between"),
                "Error: " + actualError);
    }

    @Test
    public void tc05_createBookingWithInvalidEmailFormat() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/09/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/09/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Gregory", "Test", "test123gmail.com", "1234567891011");
        homePage.clickReserveNow();

        String actualError = homePage.getErrorBookingMessage();
        assertTrue(actualError.contains("must be") || actualError.contains("be between"),
                "Error: " + actualError);
    }

    @Test
    public void tc06_createBookingWithInvalidDatesRange() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/10/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "05/10/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        homePage.fillBookingForm("Gregory", "Test", "test123@gmail.com", "1234567891011");
        homePage.clickReserveNow();

        String actualError = homePage.getErrorBookingMessage();
        assertTrue(actualError.contains("Impossible") || actualError.contains("Incorrect"),
                "Error: " + actualError);
    }

    @Test
    public void tc07_createBookingWithEmptyFields() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement checkin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[1]")));
        checkin.click();
        checkin.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "10/09/2027", Keys.ESCAPE);

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]")));
        checkout.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, "15/09/2027", Keys.ESCAPE);


        driver.findElement(By.xpath("//button[text()='Check Availability']")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now'][1]"))).click();
        Thread.sleep(100);
        homePage.clickReserveNow();
        Thread.sleep(100);
        homePage.clickReserveNow();

        String actualError = homePage.getErrorBookingMessage();
        assertTrue(actualError.contains("must be") || actualError.contains("be between"),
                "Error: " + actualError);
    }

    // Contact form tests

    @Test
    public void tc08_sendContactFormWithValidData() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement descriptionField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description")));

        new org.openqa.selenium.interactions.Actions(driver)
                .scrollToElement(descriptionField)
                .perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");

        homePage.fillContactForm(
                "Gregory Test",
                "test123@gmail.com",
                "12345678910",
                "Reservation",
                "Test message with more than 20 symbols"
        );


        homePage.clickSubmit();

        String actualMessage = homePage.getSuccessMessageText();

        assertTrue(actualMessage.contains("Thanks for getting in touch"), "Passed");
    }

    @Test
    public void tc09_verifyContactFormMaxLength() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement descriptionField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description")));

        new org.openqa.selenium.interactions.Actions(driver)
                .scrollToElement(descriptionField)
                .perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");

        homePage.fillContactForm(
                "Gregory Test",
                "test123@gmail.com",
                "12345678910",
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",
                "Test message with more than 20 symbols"
        );


        homePage.clickSubmit();

        String actualMessage = homePage.getSuccessMessageText();

        assertTrue(actualMessage.contains("Thanks for getting in touch"), "Passed");
    }

    @Test
    public void tc10_verifyContactFormMinLength() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement descriptionField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description")));

        new org.openqa.selenium.interactions.Actions(driver)
                .scrollToElement(descriptionField)
                .perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");

        homePage.fillContactForm(
                "Gregory Test",
                "test123@gmail.com",
                "12345678910",
                "12345",
                "Test message with more than 20 symbols"
        );


        homePage.clickSubmit();

        String actualMessage = homePage.getSuccessMessageText();

        assertTrue(actualMessage.contains("Thanks for getting in touch"), "Passed");    }

    @Test
    public void tc11_submitContactFormWithEmptyFields() {
        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit']")));

        new org.openqa.selenium.interactions.Actions(driver)
                .scrollToElement(submitButton)
                .perform();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");


        homePage.clickSubmit();


        String actualError = homePage.getErrorMessageCF();
        assertTrue(actualError.contains("not be") || actualError.contains("be between"),
                "Error: " + actualError);
    }


}
