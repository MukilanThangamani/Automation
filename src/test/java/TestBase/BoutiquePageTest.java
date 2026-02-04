package TestBase;

import PageObjects.BoutiquePage;
import org.testng.annotations.Test;

import java.time.Duration;

public class BoutiquePageTest extends BaseClass{

    @Test
    public void testAddNewBoutiqueFields() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        bp.clickAddBoutique();

    }
}