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
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Sales Invoices']")).isDisplayed();
        System.out.println("Sales invoice tab is present :"+salesOrder);
    }

    @Test(priority = 3)
    public void verifyPastInvoices(){
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Past Invoices']")).isDisplayed();
        System.out.println("Past invoice tab is present :"+salesOrder);
    }


    @Test(priority = 4)
    public void testBillingVaidation() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.navigateToBilling(phoneRandom(),randomString(),randomString());
        bp.addProduct(randomLength(),randomAmount());
    }

    @Test(priority = 5)
    public void verifyBillFrom(){
        boolean name = driver.findElement(By.id("boutiqueName")).isDisplayed();
        System.out.println("BillFrom is displayed :"+name);
    }

    @Test(priority = 6)
    public void verifyMobileNumber(){
        boolean mobNum = driver.findElement(By.id("boutiqueMobileNumber")).isDisplayed();
        System.out.println("Mobile Number is displayed :"+mobNum);
    }

    @Test(priority = 7)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("boutiqueAddress")).isDisplayed();
        System.out.println("Address field is present :"+address);
    }

    @Test(priority = 8)
    public void verifySubmit(){
        BillingPage bp2 = new BillingPage(driver);
        bp2.submitEstimation();
    }



}
