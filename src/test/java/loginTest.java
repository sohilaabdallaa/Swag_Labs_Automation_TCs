import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class loginTest {

    WebDriver driver;
    @Test
    public void validateUserCredentials()
    {
        driver = new ChromeDriver();
        String userName = "standard_user";
        String password = "secret_sauce";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.loginCrad(userName, password);

    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    }
}
