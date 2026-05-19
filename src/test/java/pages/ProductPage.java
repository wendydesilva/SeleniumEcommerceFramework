package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage {

    WebDriver driver;

    By productList = By.className("inventory_item");
    By sortDropdown = By.className("product_sort_container");
    By productNames = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductListDisplayed() {

        return driver.findElements(productList).size() > 0;
    }

    public void sortProducts(String value) {

        Select select = new Select(driver.findElement(sortDropdown));

        select.selectByValue(value);
    }

    public boolean verifyProductsSortedAZ() {

        List<WebElement> elements =
                driver.findElements(productNames);

        List<String> actualList = new ArrayList<>();

        for (WebElement element : elements) {
            actualList.add(element.getText());
        }

        List<String> expectedList =
                new ArrayList<>(actualList);

        Collections.sort(expectedList);

        return actualList.equals(expectedList);
    }

    public boolean verifyProductsSortedZA() {

        List<WebElement> elements =
                driver.findElements(productNames);

        List<String> actualList = new ArrayList<>();

        for (WebElement element : elements) {
            actualList.add(element.getText());
        }

        List<String> expectedList =
                new ArrayList<>(actualList);

        expectedList.sort(Collections.reverseOrder());

        return actualList.equals(expectedList);
    }

    public boolean verifyPriceLowToHigh() {

        List<WebElement> elements =
                driver.findElements(productPrices);

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement element : elements) {

            actualPrices.add(
                    Double.parseDouble(
                            element.getText().replace("$", "")
                    )
            );
        }

        List<Double> expectedPrices =
                new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices);

        return actualPrices.equals(expectedPrices);
    }

    public boolean verifyPriceHighToLow() {

        List<WebElement> elements =
                driver.findElements(productPrices);

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement element : elements) {

            actualPrices.add(
                    Double.parseDouble(
                            element.getText().replace("$", "")
                    )
            );
        }

        List<Double> expectedPrices =
                new ArrayList<>(actualPrices);

        expectedPrices.sort(Collections.reverseOrder());

        return actualPrices.equals(expectedPrices);
    }
}