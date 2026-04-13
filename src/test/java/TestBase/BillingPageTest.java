package TestBase;

import PageObjects.BillingPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillingPageTest extends BaseClass{

    @Test(priority = 1)
    public void verifySalesOrder() throws InterruptedException {
        BillingPage billing = new BillingPage(driver);
        billing.moduleClick();
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Sales Orders']")).isDisplayed();
        System.out.println("Sales order tab is present :"+salesOrder);
    }

    @Test(priority = 2)
    public void verifySalesInvoice(){
        boolean salesInvoice = driver.findElement(By.xpath("//div[text()='Sales Invoices']")).isDisplayed();
        System.out.println("Sales invoice tab is present :"+salesInvoice);
    }

    @Test(priority = 3)
    public void verifyPastInvoices(){
        boolean pastInvoice = driver.findElement(By.xpath("//div[text()='Past Invoices']")).isDisplayed();
        System.out.println("Past invoice tab is present :"+pastInvoice);
    }

    @Test(priority = 4)
    public void verifyRecivedStatus(){
        boolean received = driver.findElement(By.xpath("//div[normalize-space(text())='Received']")).isDisplayed();
        System.out.println("Received status is present :"+received);
    }

    @Test(priority = 5)
    public void verifyPendingStatus(){
        boolean pending = driver.findElement(By.xpath("//div[normalize-space(text())='Pending']")).isDisplayed();
        System.out.println("Pending status is present :"+pending);
    }

    @Test(priority = 6)
    public void verifyTotal(){
        boolean total = driver.findElement(By.xpath("//div[normalize-space(text())='Total']")).isDisplayed();
        System.out.println("Total amount is displayed :"+total);
    }


    @Test(priority = 7)
    public void testBillingVaidation() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.navigateToBilling(phoneRandom(),randomString(),randomString());
        bp.addProduct(randomLength(),randomAmount(),randomString());
    }

    @Test(priority = 8)
    public void verifyBillFrom(){
        boolean name = driver.findElement(By.id("boutiqueName")).isDisplayed();
        System.out.println("BillFrom is displayed :"+name);
    }

    @Test(priority = 9)
    public void verifyMobileNumber(){
        boolean mobNum = driver.findElement(By.id("boutiqueMobileNumber")).isDisplayed();
        System.out.println("Mobile Number is displayed :"+mobNum);
    }

    @Test(priority = 10)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("boutiqueAddress")).isDisplayed();
        System.out.println("Address field is present :"+address);
    }

    @Test(priority = 11)
    public void verifySubmit(){
        BillingPage bp2 = new BillingPage(driver);
        bp2.submitEstimation();
    }



}
