import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AddToCard {

    static String URl = "https://www.saucedemo.com/inventory.html";
    static  String itemName = "Sauce Labs Bike Light";
    static  String xpathExpression;
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver instance
        driver = new ChromeDriver();
    }

    @Test
    public static void CartValidation() {

        // Log In First.
        logIn(URl,"standard_user","secret_sauce");

        // add item to cart
        addToCard(itemName);

        // Navigate to cart page
        driver.navigate().to("https://www.saucedemo.com/cart.html");

        //Locate Item in cart
        WebElement itemNameElement = driver.findElement(By.xpath(String.format("//div[@class=\"cart_item\"]//div[@class='inventory_item_name'][text()='%s']",itemName)));
        String actualItemName = itemNameElement.getText();

        // validate that the added item found
        Assert.assertEquals(actualItemName,itemName);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    public static void addToCard(String itemName)
    {
        // Locate the Add to card Button by item Name using XPath
        xpathExpression = String.format("//div[contains(text(), '%s')]//../..//following-sibling::div/button", itemName);

        // Locate the Add to card Button by item Name using XPath
        WebElement addToCardButton = driver.findElement(By.xpath(xpathExpression));
        addToCardButton.click();
    }

    public static void logIn(String URL,String UserName, String Password)
    {
        driver.get(URL);

        // Find and fill in the username and password fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(UserName);
        passwordField.sendKeys(Password);

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
}
