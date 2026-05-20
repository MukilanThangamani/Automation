package TestBase;

import PageObjects.AppointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentPageTest extends BaseClass{

    @Test
    public void module(){
        WebElement mod = driver.findElement(By.xpath("//span[normalize-space(text())='Appointments']"));
        mod.click();
    }

    @Test(priority = 1)
    public void verifyPreviousButon(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Previous']")).isDisplayed();
        System.out.println(previous);
    }

    @Test(priority = 2)
    public void verifyNextButon(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed();
        System.out.println(previous);
    }

    @Test(priority = 3)
    public void verifySearchClient(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Search Client']")).isDisplayed();
        System.out.println(previous);
    }

    @Test(priority = 4)
    public void emptyMobileNumber() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.clickModule();
        ap.enterMobileNumber("");
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 6)
    public void invalidMobileNumber() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber("88");
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
    }

    @Test(priority = 7)
    public void singledMobileNumber() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber("8");
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }


    @Test(priority = 8)
    public void emptyClientName() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber(phoneRandom());
        Thread.sleep(1000);
        ap.enterClientName("");
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Client Name is required']")));
        Assert.assertTrue(toast.getText().contains("Client Name is required"), "Error message not displayed");
    }

    @Test(priority = 9)
    public void emptyAddress() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber(phoneRandom());
        Thread.sleep(1000);
        ap.enterClientName(randomString());
        ap.enterAddress("");
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Client Address is required']")));
        Assert.assertTrue(toast.getText().contains("Client Address is required"), "Error message not displayed");
    }

    @Test(priority = 10)
    public void emptyReference() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber(phoneRandom());
        Thread.sleep(1000);
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Reference is required']")));
        Assert.assertTrue(toast.getText().contains("Reference is required"), "Error message not displayed");
    }

    @Test(priority = 11)
    public void emptyPurpose() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber(phoneRandom());
        Thread.sleep(1000);
        ap.enterAddress(randomString());
        ap.selectReference();
        ap.enterPurpose("");
        ap.enterDeliveryDate("20/05/2026 12:30");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Purpose is required']")));
        Assert.assertTrue(toast.getText().contains("Purpose is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void validAppointment() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.enterMobileNumber(phoneRandom());
        Thread.sleep(1000);
        ap.enterAddress(randomString());
        ap.enterPurpose("Style consultation");
        ap.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Appointment created successfully!']")));
        Assert.assertTrue(toast.getText().contains("Appointment created successfully!"), "Error message not displayed");
    }

}