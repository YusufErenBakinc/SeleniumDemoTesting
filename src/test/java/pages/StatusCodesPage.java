package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatusCodesPage extends BasePage {

    // Sonuç sayfasında dönen metnin (açıklamanın) bulunduğu kapsayıcı alan
    private By contentArea = By.cssSelector("#content, .example, main");

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/status-codes");
    }

    // İlgili durum koduna (200, 301, 404, 500) tıklar ve yönlenmeyi bekler
    public void clickStatusCode(String code) {
        // Parametre gelen koda göre (örn: '200') ilgili linki buluyoruz
        By codeLink = By.xpath("//a[normalize-space()='" + code + "']");
        WebElement element = find(codeLink);

        // JavascriptExecutor ile tarayıcıya doğrudan "buna tıkla" komutu veriyoruz:
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        // Bu satır sayesinde URL içinde "/status-codes/+code" ifadesi görünene kadar test bekler:
        wait.until(ExpectedConditions.urlContains("/status-codes/" + code));
    }

    public String getResultText() {
        return getText(contentArea);
    }
}