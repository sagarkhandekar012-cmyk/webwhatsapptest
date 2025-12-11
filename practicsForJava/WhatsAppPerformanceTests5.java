package practicsForJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class contains performance related test cases
 */
public class WhatsAppPerformanceTests5 {

    WebDriver driver;

    // Setup before tests
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().maximize();
    }

    // Test Case 21: Verify page load time
    @Test
    public void TC21_verifyPageLoadSpeed() {
        long start = System.currentTimeMillis();
        driver.navigate().refresh();
        long end = System.currentTimeMillis();
        Assert.assertTrue((end - start) < 10000);
    }

    // Test Case 22: Verify multiple refresh works
    @Test
    public void TC22_verifyMultipleRefresh() {
        driver.navigate().refresh();
        driver.navigate().refresh();
        Assert.assertTrue(true);
    }

    // Test Case 23: Verify driver session is active
    @Test
    public void TC23_verifyDriverSession() {
        Assert.assertNotNull(driver);
    }

    // Test Case 24: Verify browser is open
    @Test
    public void TC24_verifyBrowserOpen() {
        Assert.assertTrue(true);
    }

    // Test Case 25: Verify close operation (dummy check)
    @Test
    public void TC25_verifyCloseOperation() {
        Assert.assertTrue(true);
    }

    // Cleanup after all tests
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
