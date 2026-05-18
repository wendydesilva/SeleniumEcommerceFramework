package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest_TC01() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @Test
    public void emptyUsernameTest_TC02() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Username is required"));
    }

    @Test
    public void emptyPasswordTest_TC03() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Password is required"));
    }

    @Test
    public void incorrectUserNameTest_TC04() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void incorrectPasswordTest_TC05() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "123");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void lockedUserTest_TC06() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Epic sadface: Sorry, this user has been locked out"));
    }



}