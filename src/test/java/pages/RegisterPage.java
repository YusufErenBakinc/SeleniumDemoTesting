package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmPassword");
    private By registerButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/register");
    }

    public void register(String username, String password, String confirmPassword) {
        type(usernameInput, username);
        type(passwordInput, password);
        type(confirmPasswordInput, confirmPassword);
        click(registerButton);
    }

    public String getMessage() {
        return getText(flashMessage);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}