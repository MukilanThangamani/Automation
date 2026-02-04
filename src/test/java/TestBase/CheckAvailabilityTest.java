package TestBase;

import PageObjects.CheckAvailabilityPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckAvailabilityTest extends BaseClass{

    @Test
    public void verifyDeliveryDate(){
        boolean deliveryDate = driver.findElement(By.xpath("//label[text()='Delivery Date']")).isDisplayed();
        System.out.println(deliveryDate);
    }//span[text()='Check Availability']

    @Test
    public void verifyCheckButton(){
        boolean deliveryDate = driver.findElement(By.xpath("//span[text()='Check Availability']")).isDisplayed();
        System.out.println(deliveryDate);
    }

    @Test
    public void verifyAddTask(){
        boolean deliveryDate = driver.findElement(By.xpath("//span[text()='Add Task']")).isDisplayed();
        System.out.println(deliveryDate);
    }

    @Test
    public void testAvailability() throws InterruptedException{
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.modAndDate(randomOne(),randomOne());
        cp.close();
    }



}