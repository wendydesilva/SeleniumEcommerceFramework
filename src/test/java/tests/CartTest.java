package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test

    public void addSingleItem_TC01() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        CartPage cart = new CartPage(driver);

        cart.addBackPackProduct();

        Assert.assertEquals(cart.getCartBadgeCount(), 1,
                "Item not added to cart");
    }

    @Test
    public void addMultipleItems_TC02() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        CartPage cart = new CartPage(driver);

        cart.addBackPackProduct();
        cart.addTShirtProduct();

        Assert.assertEquals(cart.getCartBadgeCount(), 2,
                "Multiple items not added correctly");
    }

    @Test
    public void removeItem_TC03() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        CartPage cart = new CartPage(driver);

        cart.addBackPackProduct();

        cart.removeProduct("Sauce Labs Backpack");

        Assert.assertEquals(cart.getCartBadgeCount(), 0,
                "Item was not removed");
    }

    @Test
    public void cartBadgeCount_TC04() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        CartPage cart = new CartPage(driver);

        cart.addBackPackProduct();
        cart.addTShirtProduct();

        Assert.assertEquals(cart.getCartBadgeCount(), 2,
                "Cart badge count is incorrect");
    }
}