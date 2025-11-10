package TestBase;

import PageObjects.DashboardPage;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseClass{


    @Test(priority = 3)
    public void testDashboardAccess() throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        dp.clkSetting();
     //   logger.info("On dashboard page");
     //   logger.info("TestCase 3 passed");
    }

}