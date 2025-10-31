package TestBase;

import org.testng.annotations.Test;
import PageObjects.LogoPage;
import TestBase.BaseClass;
import org.openqa.selenium.By;

public class HomePageTest extends BaseClass {

    @Test(priority = 1)
    //  @Test(dependsOnMethods = "testLoginFunctionality",alwaysRun = true)
    public void testHomePageAndClickLogin() throws InterruptedException {
      //  logger.info("In home page");
        boolean w = driver.findElement(By.linkText("Start Free Trial →")).isDisplayed();
        System.out.println("login button visible:" + w);

        LogoPage lo = new LogoPage(driver);
        lo.clickLogin();

     //   logger.info("TestCase 1 passed");
    }
}