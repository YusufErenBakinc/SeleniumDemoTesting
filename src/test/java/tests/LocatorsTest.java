package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocatorsPage;

public class LocatorsTest extends BaseTest {

    @Test
    public void testButtonVeListeLocatorDogrulama() {
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        locatorsPage.open();

        // Buton sayfada görünüyor mu?
        Assert.assertTrue(locatorsPage.isAddItemButtonDisplayed(),
                "HATA: 'Add Item' butonu sayfada bulunamadı!");

        // Listedeki elemanın metni doğru mu?
        Assert.assertEquals(locatorsPage.getTaskReviewText(), "Task 1: Review",
                "HATA: Görev listesi 1. eleman metni uyuşmadı!");
    }

    @Test
    public void testTabloVerisiLocatorDogrulama() {
        LocatorsPage locatorsPage = new LocatorsPage(driver);
        locatorsPage.open();

        // Tablodaki 'Monitor' ürününün stoğu '0' mı?
        String stock = locatorsPage.getMonitorStockValue();
        Assert.assertEquals(stock, "0", "HATA: Monitor ürününün stok değeri beklenenle uyuşmadı!");
    }
}