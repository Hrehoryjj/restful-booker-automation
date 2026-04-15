package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("name");
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("email");
    private By emailFieldCF = By.id("email");
    private By phoneField = By.name("phone");
    private By phoneFieldCF = By.id("phone");
    private By subjectField = By.id("subject");
    private By messageField = By.id("description");
    private By submitButton = By.xpath("//button[text()='Submit']");
    private By reserveNowButton = By.xpath("//button[text()='Reserve Now']");
    private By successContactFormMessage = By.xpath("//h3[contains(text(),'Thanks for getting in touch')]");
    private By successBookingMessage = By.xpath("//h2[text()='Booking Confirmed']");
    private By errorCFmessage = By.cssSelector(".alert.alert-danger");
    private By errorBookingmessage = By.cssSelector(".alert.alert-danger");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillBookingForm(String firstName, String lastName,String email, String phone){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);

    }
    public void clickReserveNow() {
        wait.until(ExpectedConditions.elementToBeClickable(reserveNowButton)).click();
    }
    public String getSuccessBookingMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successBookingMessage)).getText();
    }

    public void fillContactForm(String name, String email, String phone, String subject, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailFieldCF).sendKeys(email);
        driver.findElement(phoneFieldCF).sendKeys(phone);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getSuccessMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successContactFormMessage)).getText();
    }

    public String getErrorMessageCF(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorCFmessage)).getText();
    }

    public String getErrorBookingMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorBookingmessage)).getText();
    }
}