package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadPage;

import java.io.File;
import java.nio.file.Paths;

public class DownloadTest extends BaseTest {

    @Test
    public void testDosyaIndirme() throws InterruptedException {
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage.open();
        downloadPage.removeAds();

        // Hedef dosyayı indir ve adını al
        String downloadedFileName = downloadPage.downloadFirstAvailableFile();

        // Kullanıcının Downloads klasörünü belirle
        String userHome = System.getProperty("user.home");
        File downloadFolder = Paths.get(userHome, "Downloads").toFile();

        File downloadedFile = null;
        boolean isDownloaded = false;

        // Dosya diske düşene kadar en fazla 15 saniye bekle
        for (int i = 0; i < 15; i++) {
            File[] files = downloadFolder.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().contains("1789969394024_DNDAgentFile") && !f.getName().endsWith(".crdownload")) {
                        downloadedFile = f;
                        isDownloaded = true;
                        break;
                    }
                }
            }
            if (isDownloaded) {
                break;
            }
            Thread.sleep(1000);
        }

        //Doğrulamalar
        Assert.assertTrue(isDownloaded, "HATA: Dosya Downloads klasörüne inmedi!");
        Assert.assertNotNull(downloadedFile, "HATA: İndirilen dosya bulunamadı!");
        Assert.assertTrue(downloadedFile.length() > 0, "HATA: İndirilen dosya 0 byte!");

        //Test bittikten sonra indirilen dosyayı sil
        if (downloadedFile != null && downloadedFile.exists()) {
            downloadedFile.delete();
        }
    }
}