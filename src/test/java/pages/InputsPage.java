package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputsPage extends BasePage {

    private By inputNumber = By.id("input-number");
    private By inputText = By.id("input-text");
    private By inputPassword = By.id("input-password");
    private By inputDate = By.id("input-date");
    private By btnDisplayInputs = By.id("btn-display-inputs");
    private By btnClearInputs = By.id("btn-clear-inputs");

    // Display Inputs butonuna basınca çıkan textler
    private By outputNumber = By.id("output-number");
    private By outputText = By.id("output-text");
    private By outputPassword = By.id("output-password");
    private By outputDate = By.id("output-date");

    public InputsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/inputs");
    }

    public void fillForm(String number, String text, String password, String date) {
        type(inputNumber, number);
        type(inputText, text);
        type(inputPassword, password);
        type(inputDate, date);
    }

    public void clickDisplayInputs() {
        click(btnDisplayInputs);
    }

    public void clickClearInputs() {
        click(btnClearInputs);
    }

    // Çıktıları okuma metotları
    public String getOutputNumber() {
        return getText(outputNumber);
    }

    public String getOutputText() {
        return getText(outputText);
    }

    public String getOutputPassword() {
        return getText(outputPassword);
    }

    public String getOutputDate() {
        return getText(outputDate);
    }

    // Number kutusunun anlık değerini okur
    public String getNumberInputValue() {
        return find(inputNumber).getAttribute("value");
    }
}