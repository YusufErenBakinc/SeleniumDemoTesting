package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadPage extends BasePage {

    private By targetFileLink = By.xpath("//a[normalize-space()='1789969394024_DNDAgentFile.txt']");

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/download");
    }

    public String downloadFirstAvailableFile() {
        WebElement element = find(targetFileLink);

        // Reklam veya sayfa kayması tıklamayı engellemesin diye elementi ortaya hizala
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        String fileName = element.getText().trim();

        // Selenium click engeline takılmamak için doğrudan JS ile tıklatıyoruz
        js.executeScript("arguments[0].click();", element);

        System.out.println("Tıklanan dosya: " + fileName);
        return fileName;
    }
}