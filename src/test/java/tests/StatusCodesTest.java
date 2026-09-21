package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StatusCodesPage;

public class StatusCodesTest extends BaseTest {

    // AÇIKLAMA: 4 ayrı test yazmak yerine tek bir test havuzu (DataProvider) kuruyoruz.
    // TestNG bu dizideki her bir değeri sırayla aşağıdaki teste parametre olarak gönderir.
    @DataProvider(name = "statusCodesData")
    public Object[][] getStatusCodes() {
        return new Object[][]{
                {"200"},
                {"301"},
                {"404"},
                {"500"}
        };
    }

    @Test(dataProvider = "statusCodesData")
    public void testStatusCodes(String statusCode) {
        StatusCodesPage statusPage = new StatusCodesPage(driver);

        statusPage.open();
        statusPage.removeAds();
        statusPage.clickStatusCode(statusCode);

        // Tarayıcının URL adresi değişti mi?
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/status-codes/" + statusCode),
                "HATA: Beklenen URL yönlenmesi gerçekleşmedi! Mevcut URL: " + currentUrl);

        // Sayfa içindeki metinde o durum kodu yazıyor mu?
        String pageText = statusPage.getResultText();
        Assert.assertTrue(pageText.contains(statusCode),
                "HATA: Sayfa metninde '" + statusCode + "' kodu yer almıyor!");
    }
}