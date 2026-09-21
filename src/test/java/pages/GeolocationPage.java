package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeolocationPage extends BasePage {

    private By whereAmIBtn = By.id("geoBtn");
    private By latValue = By.id("lat-value");
    private By longValue = By.id("lon-value");

    public GeolocationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://practice.expandtesting.com/geolocation");
    }

    public void clickWhereAmI() {
        click(whereAmIBtn);
    }

    public String getLatitude() {
        return getText(latValue);
    }

    public String getLongitude() {
        return getText(longValue);
    }
}