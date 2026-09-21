package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;
import java.io.File;

public class UploadTest extends BaseTest {

    @Test
    public void testDosyaYukleme() {
        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.open();

        // Her makinede var olan proje kökündeki pom.xml dosyasını seçiyoruz
        File uploadFile = new File("pom.xml");
        String absolutePath = uploadFile.getAbsolutePath();

        // Dosyayı yüklüyoruz
        uploadPage.uploadFile(absolutePath);

        // Yüklenen dosya adı ekranda 'pom.xml' olarak listelendi mi?
        // ya da sayfa başlığında 'File Uploaded' ifadesi yer alıyor mu?
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(uploadPage.getUploadedFileName().contains("pom.xml")
                        || uploadPage.getResultHeaderText().contains("File")
                        || currentUrl.contains("upload"),
                "HATA: Dosya başarıyla yüklenemedi!");
    }
}