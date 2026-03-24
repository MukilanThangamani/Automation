package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver){
        super(driver);
    }

<<<<<<< HEAD
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/section/div/header/div[2]/div[5]")
=======
    @FindBy(css = "#__next > div > div > div > section > div > header > div:nth-child(2) > div:nth-child(5) > svg")
>>>>>>> master
    WebElement Clksetting;


    //Action

    public void clkSetting() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Settings button is displayed :"+Clksetting.isDisplayed());
        Thread.sleep(1000);
        Clksetting.click();
        Thread.sleep(1200);
    }

}