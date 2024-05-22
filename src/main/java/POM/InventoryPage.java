package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    // String URL = "https://www.saucedemo.com/inventory.html";
    WebDriver driver;

    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void addToCart(String itemName)
    {
        String XpathLocator = String.format("//div[contains(text(),'%s')]/../../following-sibling::div/button",itemName);
        WebElement addToCardElement = driver.findElement(new By.ByXPath(XpathLocator));

        addToCardElement.click();

    }
}