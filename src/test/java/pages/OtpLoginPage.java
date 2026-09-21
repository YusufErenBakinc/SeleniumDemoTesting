package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtpLoginPage extends BasePage {

    private By emailInput = By.id("email");
    private By btnSendCode = By.id("btn-send-otp");
    private By otpInput = By.id("otp");
    private By btnVerifyCode = By.id("btn-send-verify");
    private By flashMessage = By.id("flash");

    public OtpLoginPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://practice.expandtesting.com/otp-login");
    }

    public void sendOtpCode(String email) {
        type(emailInput, email);
        click(btnSendCode);
    }

    public void verifyOtpCode(String otp) {
        type(otpInput, otp);
        click(btnVerifyCode);
    }

    public String getMessage() {
        return getText(flashMessage);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}