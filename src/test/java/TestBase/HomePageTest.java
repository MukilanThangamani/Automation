package TestBase;

import Utils.TestListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObjects.LogoPage;
import org.openqa.selenium.By;


public class HomePageTest extends BaseClass {

    @Test
    public void testHomePageAndClickLogin() throws InterruptedException {

        boolean w = driver.findElement(By.xpath("//span[text()='Login']")).isDisplayed();
        System.out.println("login button visible:" + w);
        TestListener.test.get().pass("Login button visible:");

        LogoPage lo = new LogoPage(driver);
        lo.clickLogin();

    }

}