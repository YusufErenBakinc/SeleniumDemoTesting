package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage {

    // Ana sayfada bulunan kapsayıcı (Shadow Host)
    private By shadowHost = By.id("shadow-host");

    // Shadow DOM'un içindeki buton (CSS Selector olmalı, XPath Shadow DOM içinde çalışmaz)
    private By insideButton = By.cssSelector("#my-btn");

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/shadowdom");
    }

    // Shadow Root'a erişip içindeki butona tıklama
    public void clickShadowButton() {
        // Host elementi bul
        WebElement hostElement = find(shadowHost);

        // Host üzerinden shadow root'u al (SearchContext döner)
        SearchContext shadowRoot = hostElement.getShadowRoot();

        // Shadow root içerisindeki butona tıkla
        WebElement button = shadowRoot.findElement(insideButton);
        button.click();
    }

    // Butonun metnini alma
    public String getShadowButtonText() {
        WebElement hostElement = find(shadowHost);
        SearchContext shadowRoot = hostElement.getShadowRoot();
        return shadowRoot.findElement(insideButton).getText();
    }
}