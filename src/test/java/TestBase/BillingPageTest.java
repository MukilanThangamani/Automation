package TestBase;

import PageObjects.BillingPage;
import org.testng.annotations.Test;

public class BillingPageTest extends BaseClass{


    @Test
    public void testBilling() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.navigateToBilling(phoneRandom(),randomString(),randomString());
        bp.addProduct(randomLength(),randomAmount());
    }

}
