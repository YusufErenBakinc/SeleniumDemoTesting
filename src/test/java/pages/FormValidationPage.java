package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormValidationPage extends BasePage {

    private By contactNameInput = By.name("ContactName");
    private By contactNumberInput = By.name("contactnumber");
    private By pickUpDateInput = By.name("pickupdate");
    private By paymentMethodSelect = By.name("payment");
    private By registerButton = By.cssSelector("button[type='submit']");
    private By nameError = By.xpath("//input[@name='ContactName']/following-sibling::div[contains(@class,'invalid-feedback')]");
    private By numberError = By.xpath("//input[@name='contactnumber']/following-sibling::div[contains(@class,'invalid-feedback')]");

    public FormValidationPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://practice.expandtesting.com/form-validation");
    }
    public void fillForm(String name, String phone, String date, String paymentMethod) {
        type(contactNameInput, name);
        type(contactNumberInput, phone);
        type(pickUpDateInput, date);

        // Dropdown seçimi
        Select select = new Select(find(paymentMethodSelect));
        select.selectByVisibleText(paymentMethod);
    }

    public void clickRegister() {
        click(registerButton);
    }
    public String getNameErrorMessage() {
        return getText(nameError);
    }
    public String getNumberErrorMessage() {
        return getText(numberError);
    }
    public boolean isNameErrorDisplayed() {
        return isDisplayed(nameError);
    }
    public void clearContactName() {
        find(contactNameInput).clear();
    }
}