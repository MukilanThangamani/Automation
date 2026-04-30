package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    // ✅ static — shared across ALL test classes
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static boolean isLoggedIn = false;

    protected static final String BASE_URL = "https://www.fabriplay.com";
    protected static final String USERNAME  = "6369188818";
    protected static final String PASSWORD  = "Test@123";


    @BeforeSuite                          // ✅ runs ONCE before all test classes
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(BASE_URL);

        login();
    }

//    @AfterSuite                           // ✅ runs ONCE after all test classes
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Browser closed after full suite.");
//        }
//    }

    private void login() {
        if (isLoggedIn) {
            System.out.println("Already logged in — skipping.");
            return;
        }
        try {
            driver.findElement(By.name("email")).sendKeys(USERNAME);
            driver.findElement(By.name("password")).sendKeys(PASSWORD);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            wait.until(ExpectedConditions.urlContains("dashboard"));
            isLoggedIn = true;
            System.out.println("Login successful.");
        } catch (Exception e) {
            System.out.println("Login failed or already logged in: " + e.getMessage());
        }
    }

    /** Helper – tablet view emulation for responsive checks */
    protected void setTabletView() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("width", 768);
        metrics.put("height", 1024);
        metrics.put("pixelRatio", 2.0);
        metrics.put("touch", true);

        ((ChromiumDriver) driver)
                .executeCdpCommand("Emulation.setDeviceMetricsOverride", metrics);
    }
}