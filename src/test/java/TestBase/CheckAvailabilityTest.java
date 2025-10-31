package TestBase;

import PageObjects.CheckAvailabilityPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckAvailabilityTest extends BaseClass{

    @Test(priority = 11)
    public void testAvailability() throws InterruptedException{
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.modAndDate("06/08/2025");

        cp.fillTask("0", "Cutting ", "1", "1");
        //   cp.clickAddTask();
        //   cp.fillTask("1", "Stitching", "2", "2");
        cp.close();
    }
}