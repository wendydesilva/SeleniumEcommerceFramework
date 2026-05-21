package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By cancelBtn = By.id("cancel");

    By errorMsg = By.cssSelector("h3[data-test='error']");

    // STEP 1: Enter user info
    public void enterUserInfo(String f, String l, String zip) {
        driver.findElement(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
    public void clickCheckout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(continueBtn))
                .click();
    }
    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public void clickCancel() {
        driver.findElement(cancelBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isOverviewPage() {
        return driver.getCurrentUrl().contains("checkout-step-two");
    }
}