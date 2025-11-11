package TestBase;

import PageObjects.CrmPage;
import org.testng.annotations.Test;

public class crmPageTest extends BaseClass {

    @Test(priority = 13)
    public void testCrm() throws InterruptedException {
        CrmPage cp = new CrmPage(driver);
        cp.clickCrm(randomString(),"8575656560","FB","1/432,chennai,AnnaNagar","Alteration process");
        cp.measurement();
        cp.search("Hasini");
        cp.edit("Alteration");
    }

}