package TestBase;
import PageObjects.OrderPage;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass{

    @Test
    public void verifyGroupTestcases() throws InterruptedException{
        OrderPage op = new OrderPage(driver);
        Thread.sleep(1000);
        op.dashboard();
        op.orderModuleClient(phoneRandom(),randomString(),randomString());
        System.out.println("*** All over ***");
        op.ProductDetail(randomString(),"29/01/2026",randomNumber(),randomLength(),"Wait for your delivery");
        op.paymentDetails(randomLength());
        System.out.println("***Order successfully created***");
    }

}