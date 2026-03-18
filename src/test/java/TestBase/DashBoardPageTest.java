package TestBase;

import PageObjects.DashboardPage;
import Utils.TestListener;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseClass{

    @Test
    public void testDashboardAccess() throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        TestListener.test.get().pass("Click on setting button :");
        dp.clkSetting();

    }

}