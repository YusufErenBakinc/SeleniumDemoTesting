package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormValidationPage;

public class FormValidationTest extends BaseTest {

    @Test
    public void testBosFormGonderildigindeHataMesajiDogrulama() {
        FormValidationPage formPage = new FormValidationPage(driver);
        formPage.open();
        formPage.clearContactName();

        // Hiçbir şey doldurmadan Register butonuna basıyoruz
        formPage.clickRegister();

        // İsim alanı için çıkan hata mesajını doğruluyoruz
        Assert.assertTrue(formPage.isNameErrorDisplayed(),
                "HATA: İsim alanı boş bırakıldığında hata uyarısı çıkmadı!");
        Assert.assertEquals(formPage.getNameErrorMessage(), "Please enter your Contact name.",
                "HATA: Hata metni beklenenle uyuşmadı!");
    }

    @Test
    public void testBasariliFormDoldurma() {
        FormValidationPage formPage = new FormValidationPage(driver);
        formPage.open();

        // Geçerli verilerle formu dolduruyoruz
        formPage.fillForm("Yusuf Eren B", "012-3456789", "2026-9-21", "card");
        formPage.clickRegister();

        // Başarılı gönderim sonrası sayfa hata vermemeli veya yönlenmeli
        Assert.assertFalse(formPage.isNameErrorDisplayed(),
                "HATA: Form doğru doldurulmasına rağmen isim hatası görüntüleniyor!");
    }
}