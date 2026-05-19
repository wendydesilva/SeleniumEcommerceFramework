package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void productDisplayTest_TC01() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isProductListDisplayed());
    }

    @Test
    public void productSortAZTest_TC02() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);

        productPage.sortProducts("az");

        Assert.assertTrue(productPage.verifyProductsSortedAZ());
    }

    @Test
    public void productSortZATest_TC03() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);

        productPage.sortProducts("za");

        Assert.assertTrue(productPage.verifyProductsSortedZA());
    }

    @Test
    public void priceLowToHighTest_TC04() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);

        productPage.sortProducts("lohi");

        Assert.assertTrue(productPage.verifyPriceLowToHigh());
    }

    @Test
    public void priceHighToLowTest_TC05() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);

        productPage.sortProducts("hilo");

        Assert.assertTrue(productPage.verifyPriceHighToLow());
    }
}