package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {

    private By fileInput = By.cssSelector("input[type='file']");
    private By uploadBtn = By.cssSelector("button[type='submit']");
    private By uploadedFiles = By.id("uploaded-files");
    private By resultHeader = By.tagName("h1");

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/upload");
    }

    public void uploadFile(String filePath) {
        find(fileInput).sendKeys(filePath);
        click(uploadBtn);
    }

    public String getUploadedFileName() {
        return getText(uploadedFiles);
    }

    public String getResultHeaderText() {
        return getText(resultHeader);
    }
}