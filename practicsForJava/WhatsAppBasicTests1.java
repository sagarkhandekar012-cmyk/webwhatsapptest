package practicsForJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * This class contains basic UI test cases for WhatsApp Web.
 */
public class WhatsAppBasicTests1 {

    WebDriver driver;
    WebDriverWait wait;

    /**
     * Setup method runs once before all test methods.
     * Initializes the ChromeDriver, maximizes window,
     * sets explicit wait, and opens WhatsApp Web.
     */
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();                // Launch Chrome browser
        driver.manage().window().maximize();        // Maximize browser window
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Explicit wait for up to 30 seconds
        driver.get("https://web.whatsapp.com/");    // Navigate to WhatsApp Web
    }

    /**
     * Test Case 1:
     * Verify that the current URL contains 'whatsapp'.
     */
    @Test
    public void TC01_verifyPageOpened() {
        Assert.assertTrue(driver.getCurrentUrl().contains("whatsapp"), "URL does not contain 'whatsapp'");
    }

    /**
     * Test Case 2:
     * Verify that the page title contains 'WhatsApp'.
     */
    @Test
    public void TC02_verifyTitle() {
        Assert.assertTrue(driver.getTitle().contains("WhatsApp"), "Page title does not contain 'WhatsApp'");
    }

    /**
     * Test Case 3:
     * Verify that the QR code (canvas element) is visible on the page.
     * Uses explicit wait to wait until the element is visible.
     */
    @Test
    public void TC03_verifyQRVisible() {
        WebElement qr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas")));
        Assert.assertTrue(qr.isDisplayed(), "QR code is not displayed");
    }

    /**
     * Test Case 5:
     * Verify that the <body> tag is present and visible on the page.
     */
    @Test
    public void TC05_verifyBodyVisible() {
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.isDisplayed(), "Body tag is not displayed");
    }

    /**
     * Cleanup method runs once after all test methods.
     * Closes the browser and quits the WebDriver instance.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close browser and end WebDriver session
        }
    }
}
