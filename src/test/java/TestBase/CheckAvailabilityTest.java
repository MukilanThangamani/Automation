package TestBase;

import PageObjects.CheckAvailabilityPage;
import org.testng.annotations.Test;

public class CheckAvailabilityTest extends BaseClass{

    @Test(priority = 11)
    public void testAvailability() throws InterruptedException{
        CheckAvailabilityPage cp = new CheckAvailabilityPage(driver);
        cp.modAndDate(randomOne(),randomOne());
        cp.close();
    }

}