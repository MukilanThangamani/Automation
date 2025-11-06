package TestBase;
import PageObjects.OrderPage;
import org.testng.annotations.Test;
public class OrderPageTest extends BaseClass{

    @Test(priority = 10)
    public void testOrderPage() throws InterruptedException{
        OrderPage op = new OrderPage(driver);
        Thread.sleep(1000);
        op.orderModuleClient(phoneRandom(),randomString(),randomString());
        System.out.println("*** All over ***");
        op.ProductDetail(randomString(),"07/11/2025",randomNumber(),randomLength(),randomLength(),randomLength(),"Wait for your delivery");
        op.paymentDetails(randomAmount());
        System.out.println("***Order successfully created***");
    }

}