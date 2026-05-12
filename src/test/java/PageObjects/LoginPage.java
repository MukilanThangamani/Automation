package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//button[text()='Reject']")
    WebElement reject;

    @FindBy(xpath = "//div[contains(@class,'ant-modal')]//div[text()='Timezone Missing!']/ancestor::div[contains(@class,'ant-modal')]//button[@aria-label='Close']")
    WebElement cross;

    @FindBy(xpath = "//input[@id='basic_username']")
    WebElement enterphonenumber;

    @FindBy(xpath = "//input[@id='basic_password']")
    WebElement enterpassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clkLogin;

    public LoginPage(WebDriver driver){
        super(driver);
    }

   /* public void setPhonenumber(String phnum) throws InterruptedException {
        System.out.println("Phone number field is present :"+enterphonenumber.isDisplayed());
        enterphonenumber.clear();
        Thread.sleep(1000);
        enterphonenumber.sendKeys(phnum);
    }*/

    public void setPhonenumber(String phnum) throws InterruptedException {
        System.out.println("Password field is present : "
                + enterphonenumber.isDisplayed());
        enterphonenumber.click();
        Thread.sleep(1000);
        enterphonenumber.sendKeys(Keys.COMMAND+"a");
        Thread.sleep(1000);
        enterphonenumber.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        enterphonenumber.sendKeys(phnum);
    }

    public void setPassword(String password) throws InterruptedException {
        System.out.println("Password field is present : "
                + enterpassword.isDisplayed());
        enterpassword.click();
        Thread.sleep(1000);
        enterpassword.sendKeys(Keys.COMMAND + "a");
        Thread.sleep(1000);
        enterpassword.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        enterpassword.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("login button is visible :"+clkLogin.isDisplayed());
        Thread.sleep(1000);
        clkLogin.click();
        Thread.sleep(1000);
    }


}