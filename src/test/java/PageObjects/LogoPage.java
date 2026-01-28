package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LogoPage extends BasePage{

    public LogoPage(WebDriver driver){
        super(driver);
    }

    //locator
    @FindBy(xpath = "//span[text()='Explore for Free']")
    WebElement ClkLogin;

    //Action

    public void clickLogin() throws InterruptedException {
        System.out.println("Login button is visible :"+ClkLogin.isDisplayed());
        Thread.sleep(1000);
        ClkLogin.click();
    }

    public boolean logobtn(){
        try {
            return driver.findElement(By.xpath("//span[text()='Explore for Free']")).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
}