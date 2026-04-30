package TestBase;

import PageObjects.ReportPage;
import org.testng.annotations.Test;

public class ReportPageTest extends BaseClass{

    @Test(priority = 1)
    public void reportModule(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyModule();
    }

    @Test(priority = 2)
    public void verifyMonth(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyMonth();
    }

    @Test(priority = 3)
    public void checkProductReport(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyReport();
    }

    @Test(priority = 4)
    public void checkClientReport(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyClientReport();
    }

    @Test(priority = 5)
    public void checkYearlySummary(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyYearlySummary();
    }

    @Test(priority = 6)
    public void checkYearlyReport(){
        ReportPage rp = new ReportPage(driver);
        rp.verifyYearlyReport();
    }

}