package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    By cartBadge = By.className("shopping_cart_badge");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("checkout"))
        );

        checkoutBtn.click();
    }

    public void addBackPackProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
    }

    public void addTShirtProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
    }

    public void removeProduct(String productName) {
        driver.findElement(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")
        ).click();
    }

    public int getCartBadgeCount() {
        List<WebElement> badge = driver.findElements(cartBadge);
        if (badge.isEmpty()) return 0;
        return Integer.parseInt(badge.get(0).getText());
    }
}