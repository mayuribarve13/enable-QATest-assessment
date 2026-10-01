package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void cartTest() {
        // login with username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // add first product
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("back-to-products")).click();

        // add second product
        driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
        driver.findElement(By.id("add-to-cart")).click();

        // open cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // check buttons
        int items = driver.findElements(By.className("cart_item")).size();
        int removeButtons = driver.findElements(By.xpath("//button[text()='Remove']")).size();

        Assert.assertEquals(items, 2);
        Assert.assertEquals(removeButtons, items);
        Assert.assertTrue(driver.findElement(By.id("continue-shopping")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("checkout")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}