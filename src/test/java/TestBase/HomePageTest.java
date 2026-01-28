package TestBase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObjects.LogoPage;
import TestBase.BaseClass;
import org.openqa.selenium.By;

public class HomePageTest extends BaseClass {

    @Test
    public void testHomePageAndClickLogin() throws InterruptedException {

        boolean w = driver.findElement(By.xpath("//span[text()='Explore for Free']")).isDisplayed();
        System.out.println("login button visible:" + w);

        LogoPage lo = new LogoPage(driver);
        lo.clickLogin();

    }
}