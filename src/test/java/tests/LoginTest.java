package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testBasariliLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("practice", "SuperSecretPassword!");

        String actualMessage = loginPage.getMessage();
        Assert.assertTrue(actualMessage.contains("You logged into a secure area!"));
    }

    @Test
    public void testHataliSifreLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("practice", "YanlisSifre123");

        String actualMessage = loginPage.getMessage();
        Assert.assertTrue(actualMessage.contains("Your password is invalid!"));
    }
}