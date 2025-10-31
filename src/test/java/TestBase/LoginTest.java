package TestBase;

import org.testng.annotations.Test;
import PageObjects.LoginPage;
import TestBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(priority = 2)
    // @Test(dependsOnMethods = "testHomePageAndClickLogin", alwaysRun = true)
    public void testLoginFunctionality() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setPhonenumber("6369188818");
        lp.setPassword("Mukilan@2003");
        lp.clickLogin();
        //  logger.info("Login successful");
        //  logger.info("TestCase 2 passed");
    }
}