package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GeolocationPage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GeolocationTest extends BaseTest {

    @Test
    public void testMockGeolocation() {
        ChromeDriver chromeDriver = (ChromeDriver) driver;

        // İzin verme parametrelerini düzeltiyoruz (permissions listesi bekler)
        Map<String, Object> permissionParams = new HashMap<>();
        permissionParams.put("permissions", Collections.singletonList("geolocation"));
        permissionParams.put("origin", "https://practice.expandtesting.com");
        chromeDriver.executeCdpCommand("Browser.grantPermissions", permissionParams);

        // Koordinatları emüle ediyoruz
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 41.0082);
        coordinates.put("longitude", 28.9784);
        coordinates.put("accuracy", 100);
        chromeDriver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        GeolocationPage geoPage = new GeolocationPage(driver);
        geoPage.open();
        geoPage.removeAds();
        geoPage.clickWhereAmI();

        Assert.assertTrue(geoPage.getLatitude().contains("41.0082"), "HATA: Latitude eşleşmedi!");
        Assert.assertTrue(geoPage.getLongitude().contains("28.9784"), "HATA: Longitude eşleşmedi!");
    }
}