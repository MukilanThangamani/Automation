package TestBase;

import PageObjects.BoutiquePage;
import org.testng.annotations.Test;
import java.time.Duration;

public class ShopePageTest extends BaseClass {

    @Test(priority = 5)
    public void shopDetails() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterShopName("The Atelier Edi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterLegalName("Looms");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterNickName("Maison");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterGst("HDJH373893HD");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.address("G-8","1/321,chennai","Chennai","Tamilnadu","636 012","7483947383");
        bm.nextInB();
    }
}