package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.fabriplay.com");
       // driver.get("https://stage.fabriplay.com/");

    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String phoneRandom() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaAnumeric() {
        String num = RandomStringUtils.randomNumeric(2);
        String nam = RandomStringUtils.randomAlphabetic(3);
        return nam + "@" + num;
    }

    public String randomAmount() {
        return RandomStringUtils.randomNumeric(3);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(5);
    }

    public String randomLength() {
        return RandomStringUtils.randomNumeric(2);
    }
}