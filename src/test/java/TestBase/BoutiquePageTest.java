package TestBase;

import PageObjects.BoutiquePage;
import org.testng.annotations.Test;

import java.time.Duration;

public class BoutiquePageTest extends BaseClass{
    @Test(priority = 4)
    public void testAddNewBoutique() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        bp.clickAddBoutique();
        //  bp.nextInB();
        //  bp.nxt();
        //   bp.addRole("res","rew",":fde");
    //    logger.info("In creating of new boutique");
    //    logger.info("TestCase 4 passed");
    }
}