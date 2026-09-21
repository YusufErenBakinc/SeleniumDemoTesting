package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends BaseTest {

    @Test
    public void testInputsDisplay() {
        InputsPage inputsPage = new InputsPage(driver);
        inputsPage.open();

        inputsPage.fillForm("12345", "Yusuf", "GizliSifre123", "01/01/2026");
        inputsPage.clickDisplayInputs();

        Assert.assertEquals(inputsPage.getOutputNumber(), "12345", "Sayı çıktısı eşleşmedi!");
        Assert.assertEquals(inputsPage.getOutputText(), "Yusuf", "Metin çıktısı eşleşmedi!");
        Assert.assertEquals(inputsPage.getOutputPassword(), "GizliSifre123", "Şifre çıktısı eşleşmedi!");
    }

    @Test
    public void testClearInputs() {
        InputsPage inputsPage = new InputsPage(driver);
        inputsPage.open();
        inputsPage.fillForm("999", "TemizlenecekMetin", "pass", "01/01/2026");
        inputsPage.clickClearInputs();

        String currentValue = inputsPage.getNumberInputValue();

        Assert.assertFalse(currentValue.equals("999"), "Temizleme butonuna basılmasına rağmen kutu temizlenmedi!");
        Assert.assertEquals(currentValue, "", "Kutunun içi tamamen boş olmalıydı!");
    }
}