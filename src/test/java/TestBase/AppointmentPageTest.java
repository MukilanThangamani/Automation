package TestBase;

import PageObjects.AppointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AppointmentPageTest extends BaseClass{


    @Test
    public void verifyPreviousButon(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Previous']")).isDisplayed();
        System.out.println(previous);
    }

    @Test
    public void verifyNextButon(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed();
        System.out.println(previous);
    }

    @Test
    public void verifySearchClient(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Search Client']")).isDisplayed();
        System.out.println(previous);
    }

    @Test
    public void verifyAppointmentGroupTestcases() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.clientDetails(phoneRandom(),randomString(),"River street ,karapakkam,induslnd bank","Style consultation","10/02/2026 15:00","Style consulting in boutique");
        ap.updateAppointment("Update appointment");
    }   // 17/10/2025 05:00

}