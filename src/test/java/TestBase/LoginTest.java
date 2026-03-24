package TestBase;

import Utils.TestListener;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import PageObjects.LoginPage;

public class LoginTest extends BaseClass {


    @Test(priority = 1)
    public void verifyMobileField(){
        boolean mobileNumber = driver.findElement(By.xpath("(//label[normalize-space(text())='Enter Mobile Number or Email']/following::input)[1]")).isDisplayed();
        TestListener.test.get().pass("Verify mobile number field is visible:"+mobileNumber);
    }

    @Test(priority = 2)
    public void verifyPasswordField(){
        boolean password = driver.findElement(By.xpath("//input[@type='password']")).isDisplayed();
        TestListener.test.get().pass("Verify password field is displayed:"+password);
    }

    @Test(priority = 3)
    public void verifyLoginButton(){
        boolean login = driver.findElement(By.xpath("//span[normalize-space(text())='Login']")).isDisplayed();
        TestListener.test.get().pass("Verify login button is displayed :"+login);
    }

    @Test(priority = 4)
    public void verifyLoginWithOTP(){
        boolean otpLogin = driver.findElement(By.xpath("//span[normalize-space(text())='Login with OTP']")).isDisplayed();
        TestListener.test.get().pass("Verify otp login link"+otpLogin);
    }

    @Test(priority = 5)
    public void verifyForgotPassword(){
        boolean forgotPassword = driver.findElement(By.xpath("//p[normalize-space(text())='Forgot password?']")).isDisplayed();
        TestListener.test.get().pass("Verify Forgot password link "+forgotPassword);
    }

    @Test(priority = 6)
    public void verifyRegitration(){
        boolean register = driver.findElement(By.xpath("//p[@class='LoginForm_forgotPassword__9dztr']/following-sibling::p[1]")).isDisplayed();
        TestListener.test.get().pass("Verify registration link "+register);
    }

    @Test(priority = 7)
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