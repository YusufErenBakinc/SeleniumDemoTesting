package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        DragAndDropPage dndPage = new DragAndDropPage(driver);
        dndPage.open();

        // İşlem öncesi kontrol: Sol kutuda A olmalı
        Assert.assertEquals(dndPage.getColumnAText(), "A", "Başlangıçta sol kutuda A olmalı!");

        // A kutusunu B kutusunun üzerine sürükler
        dndPage.dragAtoB();

        // İşlem sonrası kontrol: Kutular yer değiştirdi mi?
        Assert.assertEquals(dndPage.getColumnAText(), "B", "Sürükleme sonrası sol kutuda B olmalı!");
        Assert.assertEquals(dndPage.getColumnBText(), "A", "Sürükleme sonrası sağ kutuda A olmalı!");
    }
}