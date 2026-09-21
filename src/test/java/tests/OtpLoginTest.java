package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OtpLoginPage;

public class OtpLoginTest extends BaseTest {

    @Test
    public void testBasariliOtpLogin() {
        OtpLoginPage otpLoginPage = new OtpLoginPage(driver);
        otpLoginPage.open();
        otpLoginPage.sendOtpCode("practice@expandtesting.com");

        otpLoginPage.verifyOtpCode("214365");

        Assert.assertTrue(otpLoginPage.getCurrentUrl().contains("/secure"),
                "HATA: Başarılı OTP girişinden sonra güvenli alana yönlendirilemedi!");
        Assert.assertTrue(otpLoginPage.getMessage().contains("secure area"),
                "HATA: Başarılı giriş mesajı görüntülenemedi!");
    }

    @Test
    public void testHataliOtpGiris() {
        OtpLoginPage otpLoginPage = new OtpLoginPage(driver);
        otpLoginPage.open();

        otpLoginPage.sendOtpCode("practice@expandtesting.com");
        otpLoginPage.verifyOtpCode("999999");

        Assert.assertFalse(otpLoginPage.getCurrentUrl().contains("/secure"),
                "HATA: Yanlış OTP koduna rağmen güvenli alana giriş yapıldı!");
    }
}