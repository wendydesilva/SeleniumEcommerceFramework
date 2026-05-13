package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("\n" +
                        "Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void emptyUsernameTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Username is required"));
    }

    @Test
    public void emptyPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Password is required"));
    }

}