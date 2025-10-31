package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[text()='Reject']")
    WebElement reject;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //locators

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement enterphonenumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_username']")));

    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement enterpassword = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_password']")));


    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement clkLogin = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

    //Action
    public void setPhonenumber(String phnum) throws InterruptedException {
        System.out.println("Phone number field is present :"+enterphonenumber.isDisplayed());
        Thread.sleep(1000);
        enterphonenumber.sendKeys(phnum);
    }

    public  void setPassword(String password) throws InterruptedException {
        System.out.println("Password field is present :"+enterpassword.isDisplayed());
        Thread.sleep(1000);
        enterpassword.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        reject.click();
        System.out.println("login button is visible :"+clkLogin.isDisplayed());
        Thread.sleep(1000);
        clkLogin.click();
    }


}