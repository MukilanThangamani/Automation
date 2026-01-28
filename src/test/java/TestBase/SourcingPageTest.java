package TestBase;

import PageObjects.SourcingPage;
import org.testng.annotations.Test;

public class SourcingPageTest extends BaseClass{


    @Test
    public void toTestSourcing() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.sourcingDetails("2","100","4");
    }

}