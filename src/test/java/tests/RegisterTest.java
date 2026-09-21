package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testUyumsuzSifreKayitHatasi() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.register("testuser123", "SuperSecret1!", "FarkliSifre2!");

        String message = registerPage.getMessage();
        Assert.assertTrue(message.contains("Passwords do not match") || message.contains("Password does not match"),
                "Şifre uyuşmazlığı uyarı mesajı görüntülenemedi!");
    }

    @Test
    public void testBosFormGonderilemez() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();

        // Hiçbir şey yazmadan doğrudan register butonuna tıklar
        registerPage.register("", "", "");

        // Sayfa başka yere gitmemeli, hala /register sayfasında kalmalı
        Assert.assertEquals(registerPage.getCurrentUrl(), "https://practice.expandtesting.com/register",
                "Boş form gönderildiğinde sayfa yönlendirilmez!");
    }
}