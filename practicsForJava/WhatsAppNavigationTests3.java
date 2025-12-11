package practicsForJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class contains navigation related test cases
 */
public class WhatsAppNavigationTests3 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");
        wait.until(ExpectedConditions.urlContains("web.whatsapp.com"));
    }

    @Test
    public void TC11_verifyRefresh() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.urlContains("web.whatsapp.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("web.whatsapp.com"), "Refresh should keep us on WhatsApp Web");
    }

    @Test
    public void TC12_verifyBackNavigation() {
        driver.get("https://web.whatsapp.com/");
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("web.whatsapp.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("web.whatsapp.com"), "Back navigation should return to WhatsApp Web");
    }

    @Test
    public void TC13_verifyForwardNavigation() {
        driver.get("https://web.whatsapp.com/");
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("web.whatsapp.com"));
        driver.navigate().forward();
        wait.until(ExpectedConditions.urlContains("google.com"));
        Assert.assertTrue(driver.getCurrentUrl().contains("google.com"), "Forward navigation should go to Google");
    }

    @Test
    public void TC14_verifyMaximizeWindow() {
        driver.manage().window().maximize();
        // You can add some check here, e.g. window size not zero
        Dimension size = driver.manage().window().getSize();
        Assert.assertTrue(size.getHeight() > 0 && size.getWidth() > 0, "Window should be maximized to a visible size");
    }

    @Test
    public void TC15_verifyCurrentURL() {
        driver.get("https://web.whatsapp.com/");
        wait.until(ExpectedConditions.urlContains("web.whatsapp.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://web.whatsapp.com/", "Current URL should be WhatsApp Web");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
