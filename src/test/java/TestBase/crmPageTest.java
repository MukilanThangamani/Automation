package TestBase;

import PageObjects.CrmPage;
import org.testng.annotations.Test;

public class crmPageTest extends BaseClass {

    @Test
    public void verifyCrmFields() throws InterruptedException {
        CrmPage crmPage = new CrmPage(driver);
        crmPage.clickCrm(randomString(),"8575656560","FB","1/432,chennai,AnnaNagar","Alteration process");
    }

    @Test
    public void verifyMeasurement() throws InterruptedException {
        CrmPage crmPage1 = new CrmPage(driver);
        crmPage1.measurement("7","8","9");
    }

    @Test
    public void verifySearch() throws InterruptedException {
        CrmPage crmPage2 = new CrmPage(driver);
        crmPage2.search("Hasini");
    }

}