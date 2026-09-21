package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShadowDomPage;

public class ShadowDomTest extends BaseTest {

    @Test
    public void testShadowDomButonTiklama() {
        ShadowDomPage shadowDomPage = new ShadowDomPage(driver);
        shadowDomPage.open();
        shadowDomPage.removeAds();

        // Butonun metnini oku ve boş olmadığını doğrula
        String buttonText = shadowDomPage.getShadowButtonText();
        System.out.println("Shadow DOM Buton Metni: " + buttonText);
        Assert.assertFalse(buttonText.isEmpty(), "HATA: Buton metni okunamadı!");

        shadowDomPage.clickShadowButton();
    }
}