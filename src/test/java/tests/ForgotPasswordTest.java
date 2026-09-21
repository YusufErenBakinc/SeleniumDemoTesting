package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void testBasariliSifreSifirlamaTalebi() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();

        // Geçerli bir e-posta adresi girip butona basıyoruz
        forgotPasswordPage.retrievePassword("testuser@example.com");

        // E-postanın gönderildiğine dair onay mesajı çıktı mı?
        String message = forgotPasswordPage.getConfirmationMessage();
        Assert.assertTrue(message.contains("email has been sent") || message.contains("An e-mail has been sent to you which explains how to reset your password."),
                "HATA: Şifre sıfırlama e-posta gönderim mesajı görüntülenemedi!");
    }
}