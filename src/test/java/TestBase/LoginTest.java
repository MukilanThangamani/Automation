package TestBase;

import Utils.TestListener;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void testLoginFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        TestListener.test.get().pass("Enter Phone number:");
        loginPage.setPhonenumber("6369188818");
        TestListener.test.get().pass("Enter password:");
        loginPage.setPassword("Mukilan@2003");
        TestListener.test.get().pass("Click login button");
        loginPage.clickLogin();
    }



}