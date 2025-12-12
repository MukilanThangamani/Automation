package TestBase;

import PageObjects.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTest extends BaseClass{

    @Test(priority = 12)
    public void testAppointment() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.clientDetails(phoneRandom(),randomString(),"River street ,karapakkam,induslnd bank","Style consultation","11/12/2025 17:00","Style consulting in boutique");
        ap.updateAppointment("Update appointment");
    }   // 17/10/2025 05:00

}