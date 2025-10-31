package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    //locators
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement Clksetting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'management.png')]")));
//

    @FindBy(xpath = "//img[contains(@src, 'management.png')]")
    WebElement Clksetting;
    //Action
    public void clkSetting() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Settings button is displayed :"+Clksetting.isDisplayed());
        Thread.sleep(1000);
        Clksetting.click();
        Thread.sleep(1200);
    }

}