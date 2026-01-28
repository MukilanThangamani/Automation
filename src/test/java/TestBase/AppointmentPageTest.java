package TestBase;

import PageObjects.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTest extends BaseClass{

    @Test
    public void verifyAppointmentGroupTestcases() throws InterruptedException {
        AppointmentPage ap = new AppointmentPage(driver);
        ap.clientDetails(phoneRandom(),randomString(),"River street ,karapakkam,induslnd bank","Style consultation","28/01/2026 11:30","Style consulting in boutique");
        ap.updateAppointment("Update appointment");
    }   // 17/10/2025 05:00

}