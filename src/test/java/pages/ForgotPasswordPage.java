package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private By emailInput = By.id("email");
    private By retrievePasswordBtn = By.cssSelector("button[type='submit']");
    private By confirmationMessage = By.id("confirmation-alert"); // Sayfadaki bildirim kutusu

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/forgot-password");
    }
    public void enterEmail(String email) {
        type(emailInput, email);
    }
    public void clickRetrievePassword() {
        click(retrievePasswordBtn);
    }
    public void retrievePassword(String email) {
        enterEmail(email);
        clickRetrievePassword();
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}