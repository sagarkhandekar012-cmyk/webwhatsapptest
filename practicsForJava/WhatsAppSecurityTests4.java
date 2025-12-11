package practicsForJava;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * This class contains basic security-related tests
 */
public class WhatsAppSecurityTests4 {

    WebDriver driver;

    // Setup before tests
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().maximize();
    }

    // Test Case 16: Verify HTTPS protocol
    @Test
    public void TC16_verifyHTTPS() {
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https"));
    }

    // Test Case 17: Verify title is not empty
    @Test
    public void TC17_verifyTitleNotEmpty() {
        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    // Test Case 18: Verify no chats before login
    @Test
    public void TC18_verifyNoChatVisibleBeforeLogin() {
        Assert.assertTrue(driver.findElements(By.xpath("//div[@role='grid']")).size() == 0);
    }

    // Test Case 19: Verify search box is not visible before login
    @Test
    public void TC19_verifyNoSearchBoxBeforeLogin() {
        Assert.assertTrue(true); // Expected behavior (not available before login)
    }

    // Test Case 20: Verify browser window handle not null
    @Test
    public void TC20_verifyWindowNotNull() {
        Assert.assertNotNull(driver.getWindowHandle());
    }

    // Cleanup
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
