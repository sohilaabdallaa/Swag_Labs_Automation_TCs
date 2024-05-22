import POM.InventoryPage;
import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidateAddToCartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginCrad("standard_user","secret_sauce");
    }
    @Test
    public void validateSucessfullAddToCart()
    {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart("Sauce Labs Fleece Jacket");
    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
