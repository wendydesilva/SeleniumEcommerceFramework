package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.List;

public class CartPage {

    WebDriver driver;


    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void goToCart() {
        driver.findElement(cartIcon).click();
    }


    public void addBackPackProduct() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("shopping_cart_badge")));
    }

    public void addTShirtProduct() {

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("shopping_cart_badge")));
    }



    public void removeProduct(String productName) {
        driver.findElement(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")
        ).click();
    }


    public int getCartBadgeCount() {

        List<WebElement> badge = driver.findElements(cartBadge);

        if (badge.size() == 0) {
            return 0;
        }

        return Integer.parseInt(badge.get(0).getText());
    }
}