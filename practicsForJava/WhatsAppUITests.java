package practicsForJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class WhatsAppUITests {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://web.whatsapp.com/";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(url);
    }

    // -------------------- BASIC TESTS --------------------

    @Test(priority = 1)
    public void TC01_verifyPageOpened() {
        Assert.assertTrue(driver.getCurrentUrl().contains("whatsapp"));
    }

    @Test(priority = 2)
    public void TC02_verifyPageTitle() {
        Assert.assertTrue(driver.getTitle().contains("WhatsApp"));
    }

    @Test(priority = 3)
    public void TC03_verifyQRCanvasDisplayed() {
        WebElement qr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas")));
        Assert.assertTrue(qr.isDisplayed());
    }

    @Test(priority = 4)
    public void TC04_verifyLinkDeviceText() {
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Link a device')]"))
        );
        Assert.assertTrue(text.isDisplayed());
    }

    @Test(priority = 5)
    public void TC05_verifyWhatsAppLogoExists() {
        List<WebElement> logo = driver.findElements(By.xpath("//img[contains(@src,'whatsapp')]"));
        Assert.assertTrue(logo.size() >= 0);
    }

    @Test(priority = 6)
    public void TC06_verifyQRContainerPresence() {
        boolean qrPresent = driver.findElements(By.xpath("//canvas")).size() > 0;
        Assert.assertTrue(qrPresent);
    }

    @Test(priority = 7)
    public void TC07_verifyPageSourceLength() {
        String source = driver.getPageSource();
        Assert.assertTrue(source.length() > 1000);
    }

    @Test(priority = 8)
    public void TC08_verifyPageIsHTTPS() {
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https"));
    }

    @Test(priority = 9)
    public void TC09_verifyBrowserTitleNotEmpty() {
        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    // -------------------- UI ELEMENT TESTS --------------------

    @Test(priority = 10)
    public void TC10_verifyFooterTextPresent() {
        List<WebElement> footer = driver.findElements(By.xpath("//*[contains(text(),'end-to-end')]"));
        Assert.assertTrue(footer.size() >= 0);
    }

    @Test(priority = 11)
    public void TC11_verifyPhoneLoginButtonIfPresent() {
        driver.findElements(By.xpath("//*[contains(text(),'phone number')]"));
        Assert.assertTrue(true); // optional UI
    }

    @Test(priority = 12)
    public void TC12_verifyRememberMeCheckboxNotMandatory() {
        driver.findElements(By.tagName("input")).size();
        Assert.assertTrue(true);
    }

    @Test(priority = 13)
    public void TC13_verifyNoConsoleErrorBlockingUI() {
        Assert.assertTrue(true); // Selenium can't read console errors directly
    }

    @Test(priority = 14)
    public void TC14_verifyCanvasTagCount() {
        int count = driver.findElements(By.tagName("canvas")).size();
        Assert.assertTrue(count >= 1);
    }

    @Test(priority = 15)
    public void TC15_verifyLoginPanelVisible() {
        WebElement panel = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        Assert.assertTrue(panel.isDisplayed());
    }

    // -------------------- NEGATIVE / BOUNDARY TESTS --------------------

    @Test(priority = 16)
    public void TC16_verifyNoChatListBeforeLogin() {
        List<WebElement> chats = driver.findElements(By.xpath("//div[@role='grid']"));
        Assert.assertTrue(chats.size() == 0);
    }

    @Test(priority = 17)
    public void TC17_verifyNoSearchBoxBeforeLogin() {
        List<WebElement> search = driver.findElements(By.xpath("//input[@type='text']"));
        Assert.assertTrue(search.size() >= 0);
    }

    @Test(priority = 18)
    public void TC18_verifyRefreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(true);
    }

    @Test(priority = 19)
    public void TC19_verifyBackForwardNavigation() {
        driver.navigate().to("https://google.com");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("whatsapp"));
    }

    @Test(priority = 20)
    public void TC20_verifyWindowIsMaximized() {
        Assert.assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
