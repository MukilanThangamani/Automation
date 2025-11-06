package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CheckAvailabilityPage extends BasePage{

    public CheckAvailabilityPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//span[text()=' Check Availability']")
    WebElement checkmodbtn;

    @FindBy(id = "tasks_0_roleId")
    WebElement taskType;

    @FindBy(xpath = "//div[text()='CfSdy']")
    WebElement selecttask;

    @FindBy(id = "tasks_0_estimatedTimeInMinutes")
    WebElement estTime;

    @FindBy(id = "deliveryDate")
    WebElement deliverydate;

    @FindBy(id = "tasks_0_priority")
    WebElement priority;

    @FindBy(xpath = "//span[text()='Check Availability']")
    WebElement getCheckbtn;

    public void modAndDate(String estimation,String prio) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Check Availability Button is displayed:"+checkmodbtn.isDisplayed());
        Thread.sleep(1000);
        checkmodbtn.click();
        Thread.sleep(1000);
        System.out.println("Delivery date widget is displayed:"+deliverydate.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Task type field is displayed :"+taskType.isDisplayed()); //-->sep
        Thread.sleep(1000);
        taskType.click();
        Thread.sleep(1000);
        System.out.println("Selecting task tupe is displayed:"+selecttask.isDisplayed());
        selecttask.click();
        Thread.sleep(1000);
        System.out.println("Estimation time field is visible :"+estTime.isDisplayed());
        estTime.click();
        Thread.sleep(1000);
        estTime.sendKeys(estimation);
        System.out.println("Priority field is visible :"+priority.isDisplayed());
        Thread.sleep(1000);
        priority.click();
        Thread.sleep(1000);
        priority.sendKeys(prio);

    }

    public void close() throws InterruptedException {
        System.out.println("Check button :"+getCheckbtn.isDisplayed());  //-->sep
        Thread.sleep(1000);
        getCheckbtn.submit();
        System.out.println(getCheckbtn.isSelected());
        System.out.println("Completed");
    }

}