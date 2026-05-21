package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    // ---------------- TC01 ----------------
    @Test
    public void validCheckoutFlow() {

        // Add item to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart(Open Cart)
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click checkout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("checkout"))
        );

        checkoutBtn.click();

        // Enter checkout detailsdetails
        driver.findElement(By.id("first-name")).sendKeys("Wendy");
        driver.findElement(By.id("last-name")).sendKeys("De Silva");
        driver.findElement(By.id("postal-code")).sendKeys("V3A6R4");

        // Continue
        driver.findElement(By.id("continue")).click();

        // Validation
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("checkout-step-two"));
    }

    // ---------------- TC02 ----------------
    @Test
    public void emptyFirstName() {

        // Add item
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Leave first name empty
        driver.findElement(By.id("last-name")).sendKeys("De Silva");
        driver.findElement(By.id("postal-code")).sendKeys("V3A6R4");

        // Continue
        driver.findElement(By.id("continue")).click();

        // Validation
        WebElement error =
                driver.findElement(By.cssSelector("h3[data-test='error']"));

        Assert.assertEquals(
                error.getText(),
                "Error: First Name is required"
        );
    }

    // ---------------- TC03 ----------------
    @Test
    public void emptyLastName() {

        // Add item
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Leave last name empty
        driver.findElement(By.id("first-name")).sendKeys("Wendy");
        driver.findElement(By.id("postal-code")).sendKeys("V3A6R4");

        // Continue
        driver.findElement(By.id("continue")).click();

        // Validation
        WebElement error =
                driver.findElement(By.cssSelector("h3[data-test='error']"));

        Assert.assertEquals(
                error.getText(),
                "Error: Last Name is required"
        );
    }

    // ---------------- TC04 ----------------
    @Test
    public void emptyPostalCode() {

        // Add item
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Leave postal code empty
        driver.findElement(By.id("first-name")).sendKeys("Wendy");
        driver.findElement(By.id("last-name")).sendKeys("De Silva");

        // Continue
        driver.findElement(By.id("continue")).click();

        // Validation
        WebElement error =
                driver.findElement(By.cssSelector("h3[data-test='error']"));

        Assert.assertEquals(
                error.getText(),
                "Error: Postal Code is required"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}