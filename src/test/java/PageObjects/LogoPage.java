package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoPage extends BasePage{

    public LogoPage(WebDriver driver){
        super(driver);
    }

    //locator
    @FindBy(xpath = "//a[text()='Start Free Trial →']")
    WebElement ClkLogin;

    //Action
    public void clickLogin() throws InterruptedException {
        System.out.println("Login button is visible :"+ClkLogin.isDisplayed());
        Thread.sleep(1000);
        ClkLogin.click();
    }

    public boolean logobtn(){
        try {
            return driver.findElement(By.linkText("//a[text()='Start Free Trial →']")).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}