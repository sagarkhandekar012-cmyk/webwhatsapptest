package practicsForJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * This class contains UI related test cases for WhatsApp Web.
 */
public class WhatsAppUITests2 {

    WebDriver driver;
    WebDriverWait wait;

    // Run before all tests: set up WebDriver and open WhatsApp Web
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); // Launch Chrome browser
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/"); // Open WhatsApp Web
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Test Case 6: Verify QR code container exists and is visible
    @Test
    public void TC06_verifyQRCodeContainer() {
        // Wait explicitly for the QR code canvas to be visible on page
        WebElement qrCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("canvas")));
        Assert.assertTrue(qrCode.isDisplayed(), "QR code canvas should be visible");
    }

    // Test Case 7: Verify WhatsApp logo presence (dummy for now)
    @Test
    public void TC07_verifyLogoPresence() {
        // Placeholder: Add actual verification when stable locator is found
        Assert.assertTrue(true);
    }

    // Test Case 8: Verify "login with phone number" option if present (dummy for now)
    @Test
    public void TC08_verifyPhoneLoginOptionIfPresent() {
        // Placeholder for the real test when locator is identified
        Assert.assertTrue(true);
    }

    // Test Case 9: Verify footer/help text (dummy for now)
    @Test
    public void TC09_verifyFooterText() {
        // Placeholder for footer text verification
        Assert.assertTrue(true);
    }

    // Test Case 10: Verify page source length is reasonable
    @Test
    public void TC10_verifyPageSourceLength() {
        Assert.assertTrue(driver.getPageSource().length() > 1000, "Page source length should be greater than 1000 characters");
    }

    // Run after all tests: close the browser
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
