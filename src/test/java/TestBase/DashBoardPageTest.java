package TestBase;

import PageObjects.DashboardPage;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseClass{

    @Test
    public void testDashboardAccess() throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        dp.clkSetting();

    }

}