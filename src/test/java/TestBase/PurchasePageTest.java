package TestBase;

import PageObjects.PurchasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PurchasePageTest extends BaseClass{

    @Test(priority = 1)
    public void verifyPurchaseModule(){
        WebElement purchases = driver.findElement(By.xpath("//span[normalize-space(text())='Purchases']"));
        System.out.println("Purchase module is displayed :"+purchases.isDisplayed());
        purchases.click();
    }

    @Test(priority = 4)
    public void verifyVendorModule(){
        WebElement vendor = driver.findElement(By.xpath("//span[normalize-space(text())='Vendor']"));
        System.out.println("vendor module is displayed :"+vendor.isDisplayed());
        vendor.click();
    }

    @Test(priority = 2)
    public void verifyPurchaseOrderModule(){
        WebElement purchase = driver.findElement(By.xpath("//span[normalize-space(text())='Purchase Order']"));
        System.out.println("purchase order module is displayed :"+purchase.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyBill(){
        WebElement bill = driver.findElement(By.xpath("//span[normalize-space(text())='Bills']"));
        System.out.println("Bill module is displayed :"+bill.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyVendorHeader(){
        boolean vendorHeader = driver.findElement(By.xpath("//h2[normalize-space(text())='Vendors']")).isDisplayed();
        System.out.println("Verify vendor header is visible :"+vendorHeader);
    }

    @Test(priority = 6)
    public void verifyName(){
        boolean name = driver.findElement(By.xpath("//th[normalize-space(text())='Name']")).isDisplayed();
        System.out.println("Verify name header is visible :"+name);
    }

    @Test(priority = 7)
    public void verifyCompanyName(){
        boolean companyname = driver.findElement(By.xpath("//th[normalize-space(text())='Company Name']")).isDisplayed();
        System.out.println("Verify company name header is visible :"+companyname);
    }

    @Test(priority = 8)
    public void verifyEmailHeader(){
        boolean email = driver.findElement(By.xpath("//th[normalize-space(text())='Email']")).isDisplayed();
        System.out.println("Verify email header is visible :"+email);
    }

    @Test(priority = 9)
    public void verifyMobile(){
        boolean mobile = driver.findElement(By.xpath("//th[normalize-space(text())='Mobile Number']")).isDisplayed();
        System.out.println("Verify mobile number header is visible :"+mobile);
    }

    @Test(priority = 9)
    public void verifyActionHeader(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Actions']")).isDisplayed();
        System.out.println("Verify action header is visible :"+action);
    }

    @Test(priority = 10)
    public void verifyAddVendor(){
        WebElement addvendor = driver.findElement(By.xpath("//span[normalize-space(text())='Add Vendor']"));
        System.out.println("Verify add vendor is visible :"+addvendor.isDisplayed());
        addvendor.click();
    }

    @Test(priority = 11)
    public void verifyAddVendorHeader(){
        WebElement vendor = driver.findElement(By.xpath("//div[normalize-space(text())='Add Vendor']"));
        System.out.println("Verify vendor is visible :"+vendor.isDisplayed());
    }

    @Test(priority = 12)
    public void verifyvendorName(){
        WebElement vendorname = driver.findElement(By.id("vendor_form_vendorName"));
        System.out.println("Verify vendor name is visible :"+vendorname.isDisplayed());
    }

    @Test(priority = 13)
    public void verifyvendorCompanyName(){
        WebElement vendorCompname = driver.findElement(By.id("vendor_form_companyName"));
        System.out.println("Verify vendor company name is visible :"+vendorCompname.isDisplayed());
    }

    @Test(priority = 14)
    public void verifydisplayName(){
        boolean displayName = driver.findElement(By.id("vendor_form_displayName")).isDisplayed();
        System.out.println("Verify display name is visible :"+displayName);
    }

    @Test(priority = 14)
    public void verifymobile(){
        boolean mobile = driver.findElement(By.id("vendor_form_phone")).isDisplayed();
        System.out.println("Verify mobile is visible :"+mobile);
    }

    @Test(priority = 14)
    public void verifyEmail(){
        boolean email = driver.findElement(By.id("vendor_form_email")).isDisplayed();
        System.out.println("Verify email is visible :"+email);
    }

    @Test(priority = 15)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("vendor_form_address")).isDisplayed();
        System.out.println("Verify address is visible :"+address);
    }

    @Test(priority = 16)
    public void verifyPinCode(){
        boolean pincode = driver.findElement(By.id("vendor_form_pincode")).isDisplayed();
        System.out.println("Verify pincode is visible :"+pincode);
    }

    @Test(priority = 17)
    public void verifyState(){
        boolean state = driver.findElement(By.id("vendor_form_state")).isDisplayed();
        System.out.println("Verify state is visible :"+state);
    }

    @Test(priority = 17)
    public void verifySubmit(){
        WebElement submitBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']"));
        System.out.println("Verify submit button is visible :"+submitBtn.isDisplayed());
        submitBtn.click();
    }//

    @Test(priority = 18)
    public void verifyCancel(){
        boolean cancelBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Cancel']")).isDisplayed();
        System.out.println("Verify cancel button is visible :"+cancelBtn);
    }

    @Test(priority = 35)
    public void validVendorCreation() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[normalize-space(text())='Vendor created successfully']")));

        Assert.assertTrue(successMsg.isDisplayed());
    }

    @Test(priority = 19)
    public void emptyVendorName() throws InterruptedException {
        PurchasePage vp = new PurchasePage(driver);
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter vendor name']"))
                .isDisplayed());
    }


    @Test(priority = 20)
    public void emptyCompanyName() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterCompanyName("");
        vp.enterVendorName("Vendor123");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter company name']"))
                .isDisplayed());
    }

    @Test(priority = 21)
    public void emptyDisplayName() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterDisplayName("");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter display name']"))
                .isDisplayed());
    }

    @Test(priority = 22)
    public void emptyMobileNumber() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Mobile Number is required']"))
                .isDisplayed());
    }

    @Test(priority = 23)
    public void invalidEmailValidation() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("abc");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter a valid email']"))
                .isDisplayed());
    }

    @Test(priority = 24)
    public void emptyAddressValidation() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter address']"))
                .isDisplayed());
    }

    @Test(priority = 25)
    public void emptyPincodeValidation() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter pincode']"))
                .isDisplayed());
    }

    @Test(priority = 26)
    public void emptyStateValidation() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Vendor Display");
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("");

        vp.clickSubmit();

        Assert.assertTrue(driver.findElement(
                        By.xpath("//div[normalize-space(text())='Please enter state']"))
                .isDisplayed());
    }

    @Test(priority = 27)
    public void mobileNumberLessThanTenDigits() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        vp.enterDisplayName("Display Vendor");
        vp.enterMobile("98765");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 28)
    public void mobileNumberMoreThanTenDigits() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("987654321012");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("600001");
        Thread.sleep(1000);
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 29)
    public void pincodeLessThanSixDigits() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        Thread.sleep(1000);
        vp.enterEmail("vendor@test.com");
        Thread.sleep(1000);
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("6000");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(text(),'Pincode')]")));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 30)
    public void invalidEmailWithoutAtSymbol() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        Thread.sleep(1000);
        vp.enterEmail("vendortest.com");
        Thread.sleep(1000);
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("600001");
        Thread.sleep(1000);
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebElement error = driver.findElement(
                By.xpath("//div[normalize-space()='Please enter a valid email']"));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 31)
    public void invalidEmailSpecialCharacters() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        Thread.sleep(1000);
        vp.enterEmail("abc@#$%.com");
        Thread.sleep(1000);
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebElement error = driver.findElement(
                By.xpath("//div[normalize-space()='Please enter a valid email']"));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 32)
    public void invalidEmailWithoutDomain() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        Thread.sleep(1000);
        vp.enterEmail("vendor@");
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("600001");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebElement error = driver.findElement(
                By.xpath("//div[normalize-space()='Please enter a valid email']"));

        Assert.assertTrue(error.isDisplayed());
    }

    @Test(priority = 33)
    public void pincodeWithAlphabets() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        vp.enterEmail("vendor@test.com");
        vp.enterAddress("Chennai");
        Thread.sleep(1000);
        vp.enterPincode("ABC123");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[normalize-space(text())='Only digits are allowed']")));

        Assert.assertTrue(error.isDisplayed(),
                "Pincode validation message not displayed");
    }

    @Test(priority = 34)
    public void pincodeWithAlphabetsOnly() throws InterruptedException {

        PurchasePage vp = new PurchasePage(driver);

        vp.enterVendorName("Vendor123");
        Thread.sleep(1000);
        vp.enterCompanyName("ABC Pvt Ltd");
        Thread.sleep(1000);
        vp.enterDisplayName("Display Vendor");
        Thread.sleep(1000);
        vp.enterMobile("9876543210");
        Thread.sleep(1000);
        vp.enterEmail("vendor@test.com");
        Thread.sleep(1000);
        vp.enterAddress("Chennai");
        vp.enterPincode("ABCDEF");
        vp.enterState("Tamil Nadu");

        vp.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[normalize-space(text())='Only digits are allowed']")));

        Assert.assertTrue(error.isDisplayed(),
                "Pincode validation message not displayed");
    }

//    @Test(priority = 19)
//    public void validateVendor() throws InterruptedException {
//        PurchasePage pp = new PurchasePage(driver);
//        pp.addVendor(randomString(),randomString(),randomString(),phoneRandom(),"abc@gmail.com",randomString(),"849849",randomString());
//    }

    @Test(priority = 36)
    public void verifyBills(){
        WebElement bills = driver.findElement(By.xpath("//span[normalize-space(text())='Bills']"));
        System.out.println("Verify purchase order module is visible :"+bills.isDisplayed());
        bills.click();
    }

    @Test(priority = 37)
    public void verifyBillHeader(){
        boolean bill = driver.findElement(By.xpath("//h2[normalize-space(text())='Bills']")).isDisplayed();
        System.out.println("Verify bill header  is visible :"+bill);
    }

    @Test(priority = 38)
    public void verifyStatus(){
        WebElement status = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
        System.out.println("Verify status header  is visible :"+status.isDisplayed());
        status.click();
    }

    @Test(priority = 39)
    public void verifyOpen(){
        boolean open = driver.findElement(By.xpath("//div[normalize-space(text())='Open']")).isDisplayed();
        System.out.println("Verify open status is visible :"+open);
    }

    @Test(priority = 40)
    public void verifyPartially(){
        boolean partial = driver.findElement(By.xpath("//div[normalize-space(text())='Partially Paid']")).isDisplayed();
        System.out.println("Verify partially status is visible :"+partial);
    }

    @Test(priority = 41)
    public void verifyPaid(){
        boolean paid = driver.findElement(By.xpath("//div[@title='Paid']//div[1]")).isDisplayed();
        System.out.println("Verify paid status is visible :"+paid);
    }

    @Test(priority = 42)
    public void verifyClosed(){
        boolean closed = driver.findElement(By.xpath("//div[normalize-space(text())='Open']")).isDisplayed();
        System.out.println("Verify closed status is visible :"+closed);
    }

    @Test(priority = 43)
    public void verifyVendor(){
        boolean vendor = driver.findElement(By.xpath("(//input[@type='search'])[2]")).isDisplayed();
        System.out.println("Verify vendor header  is visible :"+vendor);
    }

    @Test(priority = 44)
    public void verifyPaidAmt(){
        boolean paidamt = driver.findElement(By.xpath("(//div[@class='ant-card-body']//div)[1]")).isDisplayed();
        System.out.println("verify paid amount is visible :"+paidamt);
    }

    @Test(priority = 45)
    public void verifyUnPaidAmt(){
        boolean unpaidamt = driver.findElement(By.xpath("//div[normalize-space(text())='Unpaid']")).isDisplayed();
        System.out.println("verify unpaid amount is visible :"+unpaidamt);
    }

    @Test(priority = 46)
    public void verifyTotalPaidAmt(){
        boolean totpaidamt = driver.findElement(By.xpath("//div[normalize-space(text())='Total']")).isDisplayed();
        System.out.println("verify total amount is visible :"+totpaidamt);
    }

    @Test(priority = 47)
    public void verifyPurchaseOrderHeader(){
        boolean purchaseHeader = driver.findElement(By.xpath("//th[normalize-space(text())='Purchase Order Number']")).isDisplayed();
        System.out.println("verify purchase header is visible :"+purchaseHeader);
    }

    @Test(priority = 48)
    public void verifyDateHeader(){
        boolean date = driver.findElement(By.xpath("//th[normalize-space(text())='Date']")).isDisplayed();
        System.out.println("verify date header is visible :"+date);
    }

    @Test(priority = 49)
    public void verifyVendorDetailHeader(){
        boolean vendorDetail = driver.findElement(By.xpath("//th[normalize-space(text())='Vendor Details']")).isDisplayed();
        System.out.println("verify vendor detail header is visible :"+vendorDetail);
    }

    @Test(priority = 50)
    public void verifyTotalAmtHeader(){
        boolean totalAmt = driver.findElement(By.xpath("//th[normalize-space(text())='Total Amount']")).isDisplayed();
        System.out.println("verify total amount header is visible :"+totalAmt);
    }

    @Test(priority = 51)
    public void verifyPendinAmtHeader(){
        boolean pendingAmt = driver.findElement(By.xpath("//th[normalize-space(text())='Pending Amount']")).isDisplayed();
        System.out.println("verify pending amount header is visible :"+pendingAmt);
    }

    @Test(priority = 52)
    public void verifyDeliveryDateHeader(){
        boolean delivery = driver.findElement(By.xpath("//th[normalize-space(text())='Delivery Date']")).isDisplayed();
        System.out.println("verify  delivery date header is visible :"+delivery);
    }

    @Test(priority = 53)
    public void verifyPaymentHeader(){
        boolean payment = driver.findElement(By.xpath("//th[normalize-space(text())='Payment Terms']")).isDisplayed();
        System.out.println("verify  payment header is visible :"+payment);
    }

    @Test(priority = 54)
    public void verifyModeOfPayment(){
        boolean paymentMode = driver.findElement(By.xpath("//th[normalize-space(text())='Mode of Payment']")).isDisplayed();
        System.out.println("verify  paymentMode header is visible :"+paymentMode);
    }

    @Test(priority = 55)
    public void verifyPaymentStatusHeader(){
        boolean paymentStatus = driver.findElement(By.xpath("//th[normalize-space(text())='Payment Status']")).isDisplayed();
        System.out.println("verify  payment status header is visible :"+paymentStatus);
    }

    @Test(priority = 56)
    public void verifyAction(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Actions']")).isDisplayed();
        System.out.println("verify action header is visible :"+action);
    }

    @Test(priority = 57)
    public void verifySearchField(){
        WebElement searchBill = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
        System.out.println("Verify search field :"+searchBill);
        searchBill.click();
    }

    @Test(priority = 58)
    public void verifyPurchaseOrder(){
        WebElement purchaseOrder = driver.findElement(By.xpath("//span[normalize-space(text())='Purchase Order']"));
        System.out.println("Verify purchase order module is visible :"+purchaseOrder.isDisplayed());
        purchaseOrder.click();
    }

    @Test(priority = 59)
    public void verifyPurchaseStatus(){
        PurchasePage pp2 = new PurchasePage(driver);
        pp2.purchaseStaus();
    }

    @Test(priority = 60)
    public void verifyOpenStatus(){
        boolean open = driver.findElement(By.xpath("//div[normalize-space(text())='Created']")).isDisplayed();
        System.out.println("Verify open status is visible :"+open);
    }


    @Test(priority = 61)
    public void verifyPartiallyReceivedStatus(){
        boolean partiallyreceived = driver.findElement(By.xpath("//div[normalize-space(text())='Partially Received']")).isDisplayed();
        System.out.println("Verify partially received status is visible :"+partiallyreceived);
    }

    @Test(priority = 62)
    public void verifyInTransitStatus(){
        boolean transit = driver.findElement(By.xpath("//div[normalize-space(text())='In Transit']")).isDisplayed();
        System.out.println("Verify  transit status is visible :"+transit);
    }

    @Test(priority = 63)
    public void verifyClosedStatus(){
        boolean closed = driver.findElement(By.xpath("//div[normalize-space(text())='Closed']")).isDisplayed();
        System.out.println("Verify  closed status is visible :"+closed);
    }

    @Test(priority = 64)
    public void verifySearch(){
        boolean search = driver.findElement(By.xpath("(//input[@type='search'])[3]")).isDisplayed();
        System.out.println("Verify search is visible :"+search);
    }

    @Test(priority = 65)
    public void verifyCreatePurchaseOrder(){
        WebElement create = driver.findElement(By.xpath("//span[normalize-space(text())='Create Purchase Order']"));
        System.out.println("Verify create purchase order is visible :"+create.isDisplayed());
        create.click();
    }

    @Test(priority = 66)
    public void verifyCreatePurchOrderHeader(){
        boolean createOrder = driver.findElement(By.xpath("//h2[normalize-space(text())='Create Purchase Order']")).isDisplayed();
        System.out.println("Verify create purchase order is visible :"+createOrder);
    }

    @Test(priority = 67)
    public void verifyVendorField(){
        boolean vendor = driver.findElement(By.id("vendor")).isDisplayed();
        System.out.println("Verify vendor is visible :"+vendor);
    }

    @Test(priority = 68)
    public void verifyPaymentTerms(){
        boolean paymentTerms = driver.findElement(By.xpath("//span[normalize-space(text())='Net 90']")).isDisplayed();
        System.out.println("Verify payment terms is visible :"+paymentTerms);
    }

    @Test(priority = 69)
    public void verifyPurchaseDate(){
        boolean purchaseDate = driver.findElement(By.xpath("(//input[@placeholder='Select date'])[1]")).isDisplayed();
        System.out.println("Verify purchase date is visible :"+purchaseDate);
    }

    @Test(priority = 70)
    public void verifyDeliveryDate(){
        boolean deliveryDate = driver.findElement(By.xpath("(//input[@placeholder='Select date'])[2]")).isDisplayed();
        System.out.println("Verify delivery date is visible :"+deliveryDate);
    }

    @Test(priority = 71)
    public void verifyItemTableHeader(){
        boolean itemTable = driver.findElement(By.xpath("//strong[normalize-space(text())='Item Table']")).isDisplayed();
        System.out.println("Verify item table is visible :"+itemTable);
    }

    @Test(priority = 72)
    public void verifyItemField(){
        boolean item = driver.findElement(By.xpath("(//span[@class='ant-select-selection-item'])[2]")).isDisplayed();
        System.out.println("Verify item is visible :"+item);
    }

    @Test(priority = 73)
    public void verifyQtyField(){
        boolean qty = driver.findElement(By.xpath("//th[normalize-space(text())='Qty']")).isDisplayed();
        System.out.println("Verify quantity is visible :"+qty);
    }

    @Test(priority = 74)
    public void verifyRateField(){
        boolean rate = driver.findElement(By.xpath("//th[normalize-space(text())='Rate per Unit']")).isDisplayed();
        System.out.println("Verify rate is visible :"+rate);
    }

    @Test(priority = 75)
    public void verifyAmtField(){
        boolean amt = driver.findElement(By.xpath("//th[normalize-space(text())='Amount']")).isDisplayed();
        System.out.println("Verify amount is visible :"+amt);
    }

    @Test(priority = 76)
    public void verifyStatusDropdown(){
        boolean status = driver.findElement(By.xpath("//th[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Verify status is visible :"+status);
    }

    @Test(priority = 77)
    public void verifyActionTab(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Action']")).isDisplayed();
        System.out.println("Verify action is visible :"+action);
    }

    @Test(priority = 78)
    public void verifyAddItem(){
        boolean addItem = driver.findElement(By.xpath("//span[normalize-space(text())='+ Add Item']")).isDisplayed();
        System.out.println("Verify addItem is visible :"+addItem);
    }

    @Test(priority = 79)
    public void verifySaveBtn(){
        WebElement saveBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Save']"));
        System.out.println("Verify saveBtn is visible :"+saveBtn.isDisplayed());
        saveBtn.click();
    }

    @Test(priority = 80)
    public void verifyBackBtn(){
        boolean backBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Back']")).isDisplayed();
        System.out.println("Verify back button  is visible :"+backBtn);
    }

    @Test(priority = 81)
    public void validateCreatePurchase() throws InterruptedException {
        PurchasePage pp1 = new PurchasePage(driver);
        pp1.createOrder("15/04/2026");
    }

}