package TestBase;

import PageObjects.BillingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BillingPageTest extends BaseClass{

    @Test(priority = 1)
    public void verifySalesOrder() throws InterruptedException {
        BillingPage billing = new BillingPage(driver);
        billing.moduleClick();
        boolean salesOrder = driver.findElement(By.xpath("//div[text()='Sales Orders']")).isDisplayed();
        System.out.println("Sales order tab is present :"+salesOrder);
    }

    @Test(priority = 2)
    public void verifyPastInvoices(){
        boolean pastInvoice = driver.findElement(By.xpath("//div[text()='Past Invoices']")).isDisplayed();
        System.out.println("Past invoice tab is present :"+pastInvoice);
    }

    @Test(priority = 3)
    public void verifyReceivedStatus(){
        boolean received = driver.findElement(By.xpath("//div[normalize-space(text())='Received']")).isDisplayed();
        System.out.println("Received status is present :"+received);
    }

    @Test(priority = 4)
    public void verifyPendingStatus(){
        boolean pending = driver.findElement(By.xpath("//div[normalize-space(text())='Pending']")).isDisplayed();
        System.out.println("Pending status is present :"+pending);
    }

    @Test(priority = 5)
    public void verifyTotal(){
        boolean total = driver.findElement(By.xpath("//div[normalize-space(text())='Total']")).isDisplayed();
        System.out.println("Total amount is displayed :"+total);
    }

    @Test(priority = 6)
    public void emptyMobile() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.clickEstimation();
        bp.enterMobile("");
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 7)
    public void singleMobileNum() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile("8");
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }

    @Test(priority = 8)
    public void invalidMobileNum() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile("89");
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
    }

    @Test(priority = 9)
    public void emptyClient() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.enterAddress(randomString());
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Client Name is required']")));
        Assert.assertTrue(toast.getText().contains("Client Name is required"), "Error message not displayed");
    }

    @Test(priority = 10)
    public void emptyAddress() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.enterAddress("");
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Address is required']")));
        Assert.assertTrue(toast.getText().contains("Address is required"), "Error message not displayed");
    }

    @Test(priority = 11)
    public void emptyQuantity() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.enterName(randomString());
        bp.enterAddress(randomString());
        bp.enterQuantity("");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Quantity is required']")));
        Assert.assertTrue(toast.getText().contains("Quantity is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void emptyPrice() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.enterQuantity("2");
        bp.enterPrice("");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Price is required']")));
        Assert.assertTrue(toast.getText().contains("Price is required"), "Error message not displayed");
    }

    @Test(priority = 13)
    public void emptyProduct() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.enterQuantity("2");
        bp.enterPrice("100");
        bp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Product is required']")));
        Assert.assertTrue(toast.getText().contains("Product is required"), "Error message not displayed");
    }

    @Test(priority = 14)
    public void validEstimation() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.enterMobile(phoneRandom());
        bp.selectProduct();
        bp.enterQuantity("2");
        bp.enterPrice("100");
    }

    @Test(priority = 15)
    public void verifyBillFrom(){
        boolean name = driver.findElement(By.id("boutiqueName")).isDisplayed();
        System.out.println("BillFrom is displayed :"+name);
    }

    @Test(priority = 16)
    public void verifyMobileNumber(){
        boolean mobNum = driver.findElement(By.id("boutiqueMobileNumber")).isDisplayed();
        System.out.println("Mobile Number is displayed :"+mobNum);
    }

    @Test(priority = 17)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("boutiqueAddress")).isDisplayed();
        System.out.println("Address field is present :"+address);
    }

    @Test(priority = 18)
    public void verifySubmit(){
        BillingPage bp2 = new BillingPage(driver);
        bp2.submitEstimation();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Estimation created successfully!']")));
        Assert.assertTrue(toast.getText().contains("Estimation created successfully!"), "Error message not displayed");
    }

    @Test(priority = 19)
    public void verifyBillSetting(){
        WebElement billSetting = driver.findElement(By.xpath("//span[@class='anticon anticon-setting']"));
        billSetting.click();
    }

    @Test(priority = 20)
    public void verifyBilling(){
        WebElement billing = driver.findElement(By.xpath("//h3[normalize-space(text())='Billing Settings']"));
        System.out.println("Billing header is displayed :"+billing.isDisplayed());
    }

    @Test(priority = 21)
    public void verifyDiscountButton(){
        WebElement disc = driver.findElement(By.xpath("//span[normalize-space(text())='Save Discount & GST']"));
        System.out.println("Discount button is displayed :"+disc.isDisplayed());
    }

    @Test(priority = 22)
    public void verifyChargeName(){
        WebElement charge = driver.findElement(By.id("extra-fitting-charges_chargeName"));
        System.out.println("Charge field is present :"+charge);
    }

    @Test(priority = 23)
    public void verifyAmount(){
        WebElement amt = driver.findElement(By.id("extra-fitting-charges_amount"));
        System.out.println("amount field is present :"+amt);
    }

    @Test(priority = 24)
    public void emptyFields(){
        BillingPage bp = new BillingPage(driver);
        bp.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter an amount']")));
        Assert.assertTrue(toast.getText().contains("Please enter an amount"), "Error message not displayed");
    }

    @Test(priority = 25)
    public void emptyCharge() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.setCharge("");
        bp.setAmount("100");
        bp.clickAdd();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a charge name']")));
        Assert.assertTrue(toast.getText().contains("Please enter a charge name"), "Error message not displayed");
    }

    @Test(priority = 26)
    public void validdatas() throws InterruptedException {
        BillingPage bp = new BillingPage(driver);
        bp.setCharge(randomString());
        bp.setAmount("100");
        bp.clickAdd();

    }








}