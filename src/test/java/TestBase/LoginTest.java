package TestBase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.LoginPage;

public class LoginTest extends BaseClass {

    @Test
    public void testLoginFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setPhonenumber("6369188818");
        loginPage.setPassword("Mukilan@2003");
        loginPage.clickLogin();
    }



}