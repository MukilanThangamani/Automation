package TestBase;

import PageObjects.CheckAvailabilityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckAvailabilityTest extends BaseClass{

    @Test
    public void verifyModule(){
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.clickModule();
    }

    @Test(priority = 1)
    public void verifyDeliveryDate(){
        boolean deliveryDate = driver.findElement(By.xpath("//label[text()='Delivery Date']")).isDisplayed();
        System.out.println(deliveryDate);
    }

    @Test(priority = 2)
    public void verifyCheckButton(){
        boolean deliveryDate = driver.findElement(By.xpath("//span[text()='Check Availability']")).isDisplayed();
        System.out.println(deliveryDate);
    }

    @Test(priority = 3)
    public void verifyAddTask(){
        boolean deliveryDate = driver.findElement(By.xpath("//span[text()='Add Task']")).isDisplayed();
        System.out.println(deliveryDate);
    }

//    @Test(priority = 4)
//    public void testAvailability() throws InterruptedException{
//        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
//        cp.modAndDate(randomOne(),randomOne());
//        cp.close();
//    }

    @Test(priority = 4)
    public void emptyTask() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("1");
        cp.clickCheckbox();
        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Task Type is required']")));
        Assert.assertTrue(toast.getText().contains("Task Type is required"), "Error message not displayed");
    }

    @Test(priority = 5)
    public void emptyEstimation() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.selectTaskType();
        cp.enterEstimation("");
        cp.enterPriority("1");
        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Estimation Time is required']")));
        Assert.assertTrue(toast.getText().contains("Estimation Time is required"), "Error message not displayed");
    }

    @Test(priority = 6)
    public void invalidCharacterEstimation() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("h");
        cp.enterPriority("1");
        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Must be a valid number']")));
        Assert.assertTrue(toast.getText().contains("Must be a valid number"), "Error message not displayed");
    }

    @Test(priority = 7)
    public void negativeInputEstimation() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("-2");
        cp.enterPriority("1");
        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Must be a valid number']")));
        Assert.assertTrue(toast.getText().contains("Must be a valid number"), "Error message not displayed");
    }


    @Test(priority = 8)
    public void emptyPriority() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("");

        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Priority is required']")));
        Assert.assertTrue(toast.getText().contains("Priority is required"), "Error message not displayed");
    }


    @Test(priority = 9)
    public void invalidCharPriority() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("f");

        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Priority must be a number']")));
        Assert.assertTrue(toast.getText().contains("Priority must be a number"), "Error message not displayed");
    }

    @Test(priority = 10)
    public void negativePriority() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("-3");

        cp.employeeInvolved("2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Priority must be a number']")));
        Assert.assertTrue(toast.getText().contains("Priority must be a number"), "Error message not displayed");
    }


    @Test(priority = 11)
    public void emptyEmployeesInvolved() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("2");
        cp.employeeInvolved("");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Employees involved is required']")));
        Assert.assertTrue(toast.getText().contains("Employees involved is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void invalidCharInvolved() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("2");
        cp.employeeInvolved("d");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Must be a number greater than 0']")));
        Assert.assertTrue(toast.getText().contains("Must be a number greater than 0"), "Error message not displayed");
    }

    @Test(priority = 13)
    public void negativeInvolved() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("2");
        cp.employeeInvolved("-2");
        cp.clickCheckAvailability();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Must be a number greater than 0']")));
        Assert.assertTrue(toast.getText().contains("Must be a number greater than 0"), "Error message not displayed");
    }

    @Test(priority = 14)
    public void validTaskDetails() throws InterruptedException {
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.enterEstimation("2");
        cp.enterPriority("1");
        cp.employeeInvolved("2");
        cp.clickCheckAvailability();
    }

    @Test(priority = 15)
    public void verifycheckBtn(){
        WebElement addTask = driver.findElement(By.xpath("//span[text()='Check Availability']"));
        System.out.println("check button is visible :"+addTask.isDisplayed());
    }

    @Test(priority = 16)
    public void verifyTaskNameHeader(){
        WebElement taskname = driver.findElement(By.xpath("//th[normalize-space(text())='Task Name']"));
        System.out.println("Task name is visible :"+taskname.isDisplayed());
    }

    @Test(priority = 17)
    public void verifyEndTimeHeader(){
        WebElement endTime = driver.findElement(By.xpath("//th[normalize-space(text())='Estimated Endtime']"));
        System.out.println("End time is visible :"+endTime.isDisplayed());
    }

    @Test(priority = 18)
    public void verifyAvailabilityHeader(){
        WebElement availability = driver.findElement(By.xpath("//th[normalize-space(text())='Availability']"));
        System.out.println("availability is visible :"+availability.isDisplayed());
    }

}