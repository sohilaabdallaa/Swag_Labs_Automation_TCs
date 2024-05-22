package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver;
    String loginpageURL = "https://www.saucedemo.com/";

    WebElement userFieldElement;
    WebElement passwordFieldElement;
    WebElement loginButton;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void navigate(){
        driver.get(loginpageURL);
    }
    public void loginCrad(String username, String password)
    {

        userFieldElement = driver.findElement(By.id("user-name"));
        passwordFieldElement = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));

        userFieldElement.sendKeys(username);
        passwordFieldElement.sendKeys(password);

        loginButton.click();

    }



}
