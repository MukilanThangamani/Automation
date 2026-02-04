package TestBase;

import PageObjects.BillingPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BillingPageTest extends BaseClass{

    @Test
    public void verifySalesOrder(){
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Sales Orders']")).isDisplayed();
        System.out.println("Sales order tab is present :"+salesOrder);
    }

    @Test
    public void verifySalesInvoice(){
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Sales Invoices']")).isDisplayed();
        System.out.println("Sales invoice tab is present :"+salesOrder);
    }

    @Test
    public void verifyPastInvoices(){
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Past Invoices']")).isDisplayed();
        System.out.println("Past invoice tab is present :"+salesOrder);
    }

    @Test
    public void testBillingVaidation() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.navigateToBilling(phoneRandom(),randomString(),randomString());
        bp.addProduct(randomLength(),randomAmount());
    }


}
