package TestBase;

import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseClass {

    LoginPage loginPage;

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

//    @Test(priority = 7)
//    public void invalidEmailValidPasswordTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        By emailField = By.xpath("//input[@placeholder='Enter email or mobile number']");
//        driver.findElement(emailField).clear();
//
//        loginPage.setPhonenumber("6369188817");
//        loginPage.setPassword("Test@123");
//
//        loginPage.clickLogin();
//
//        // Add explicit wait before getting the message
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='User not found']")));
//        Assert.assertTrue(toast.getText().contains("User not found"), "Error message not displayed");
//    }
//
//    @Test(priority = 8)
//    public void validEmailInvalidPasswordTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setPhonenumber("6369188818");
//        loginPage.setPassword("WrongPassword");
//
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Invalid password.']")));
//        Assert.assertTrue(toast.getText().contains("Invalid password."), "Error message not displayed");
//    }
//
//    @Test(priority = 9)
//    public void invalidEmailInvalidPasswordTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setPhonenumber("wrong@gmail.com");
//        loginPage.setPassword("Wrong123");
//
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='User not found']")));
//        Assert.assertTrue(toast.getText().contains("User not found"), "Error message not displayed");
//    }
//
//    @Test(priority = 10)
//    public void emptyEmailFieldTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setPhonenumber("");
//        loginPage.setPassword("Test@123");
//
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a mobile number or email!']")));
//        Assert.assertTrue(toast.getText().contains("Please enter a mobile number or email!"), "Error message not displayed");
//    }
//
//    @Test(priority = 11)
//    public void emptyPasswordFieldTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setPhonenumber("6369188818");
//        loginPage.setPassword("");
//
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please input your password!']")));
//        Assert.assertTrue(toast.getText().contains("Please input your password!"), "Error message not displayed");
//    }
//
//    @Test(priority = 12)
//    public void emptyFieldsTest() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.setPhonenumber("");
//        loginPage.setPassword("");
//
//        loginPage.clickLogin();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please input your password!']")));
//        Assert.assertTrue(toast.getText().contains("Please input your password!"), "Error message not displayed");
//    }

    @Test(priority = 13)
    public void testLoginFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        TestListener.test.get().pass("Enter Phone number:");
        loginPage.setPhonenumber("6369188818");
        TestListener.test.get().pass("Enter password:");
        loginPage.setPassword("Test@123");
        TestListener.test.get().pass("Click login button");
        loginPage.clickLogin();
    }

}