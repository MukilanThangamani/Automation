package TestBase;
import PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderPageTest extends BaseClass{

    @Test(priority = 1)
    public void verifyDashboard() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        Thread.sleep(1000);
        op.dashboard();
    }

    @Test(priority = 2)
    public void verifyOrderAndOutsourcing() throws InterruptedException {
        WebElement orderOutsourcing = driver.findElement(By.xpath("//span[normalize-space(text())='Orders & Outsourcing']"));
        System.out.println("Module is visible :"+orderOutsourcing.isDisplayed());
        orderOutsourcing.click();
    }

    @Test(priority = 3)
    public void verifyOutsourcingModule(){
        WebElement outsourcing = driver.findElement(By.xpath("//span[normalize-space(text())='Outsourcing']"));
        System.out.println("Module is visible :"+outsourcing.isDisplayed());
    }


    @Test(priority = 4)
    public void verifyOrderModule(){
        WebElement order = driver.findElement(By.xpath("//span[normalize-space(text())='Orders']"));
        System.out.println("Module is visible :"+order.isDisplayed());
        order.click();
    }

    @Test(priority = 5)
    public void clickCurrentTab(){
        OrderPage op = new OrderPage(driver);
        System.out.println("Current tab is displayed ");
        op.clickCurrentTab();
    }

    @Test(priority = 6)
    public void verifyDelayedTab(){
        WebElement delayed = driver.findElement(By.xpath("//div[normalize-space(text())='Delayed']"));
        System.out.println("Delayed tab is visible :"+delayed.isDisplayed());
    }

    @Test(priority = 7)
    public void verifyAlterationTab(){
        WebElement alteration = driver.findElement(By.xpath("//div[normalize-space(text())='Alteration']"));
        System.out.println("alteration tab is visible :"+alteration.isDisplayed());
    }

    @Test(priority = 8)
    public void verifyRushTab(){
        WebElement rush = driver.findElement(By.xpath("//div[normalize-space(text())='Rush']"));
        System.out.println("rush tab is visible :"+rush.isDisplayed());
    }

    @Test(priority = 9)
    public void verifyOutForDeliveryTab(){
        WebElement outForDelivery = driver.findElement(By.xpath("//div[normalize-space(text())='Out for Delivery']"));
        System.out.println(" outForDelivery tab is visible :"+outForDelivery.isDisplayed());
    }

    @Test(priority = 10)
    public void verifydeliveredTab(){
        WebElement more = driver.findElement(By.xpath("//div[normalize-space(text())='More']"));
        more.click();
        WebElement Delivery = driver.findElement(By.xpath("//span[normalize-space(text())='Delivered']"));
        System.out.println(" Delivery tab is visible :"+Delivery.isDisplayed());
    }

    @Test(priority = 11)
    public void verifyCancelledTab(){
        WebElement cancelled = driver.findElement(By.xpath("//span[normalize-space(text())='Cancelled']"));
        System.out.println(" cancelled tab is visible :"+cancelled.isDisplayed());
    }

    @Test(priority = 12)
    public void verifyFilterBtn(){
        WebElement filter = driver.findElement(By.xpath("//span[normalize-space(text())='Filter']"));
        System.out.println("filter is visible :"+filter.isDisplayed());
        filter.click();
    }

    @Test(priority = 13)
    public void verifyAddFilter(){
        WebElement addFilter = driver.findElement(By.xpath("//span[normalize-space(text())='Add filter']"));
        System.out.println("Add filter btn is visible :"+addFilter.isDisplayed());
        addFilter.click();
    }

    @Test(priority = 14)
    public void verifyProductTypeOption(){
        WebElement prod = driver.findElement(By.xpath("//span[normalize-space(text())='Product Type']"));
        System.out.println("product type btn is visible :"+prod.isDisplayed());
    }

    @Test(priority = 15)
    public void verifyAssignedToOption(){
        WebElement assigned = driver.findElement(By.xpath("//span[normalize-space(text())='Assigned to']"));
        System.out.println("Assigned btn is visible :"+assigned.isDisplayed());
    }

    @Test(priority = 16)
    public void verifyOrderDateOption(){
        WebElement order = driver.findElement(By.xpath("//span[normalize-space(text())='Order Date']"));
        System.out.println("order btn is visible :"+order.isDisplayed());
    }

    @Test(priority = 17)
    public void verifyDeliveryDateOption(){
        WebElement delivery = driver.findElement(By.xpath("//span[normalize-space(text())='Delivery Date']"));
        System.out.println("delivery btn is visible :"+delivery.isDisplayed());
    }

    @Test(priority = 18)
    public void verifyUnassignedOption(){
        WebElement unassigned = driver.findElement(By.xpath("//span[normalize-space(text())='Task Unassigned']"));
        System.out.println("unassigned btn is visible :"+unassigned.isDisplayed());
    }///////
    ///
    ///
    @Test(priority = 19)
    public void emptyMobileNumber() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.clickCreateOrder();
        op.clientMob("");
        op.nextBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 20)
    public void invalidNumber() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.clientMob("2");
        Thread.sleep(1000);
        op.nextBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }

    @Test(priority = 21)
    public void incompleteNumber() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.clientMob("232");
        op.nextBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
    }

    @Test(priority = 22)
    public void emptyNameField() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.clientMob(phoneRandom());
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Name is required']")));
        Assert.assertTrue(toast.getText().contains("Name is required"), "Error message not displayed");
    }

    @Test(priority = 23)
    public void validClientDetail() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.clientMob(phoneRandom());
        op.clientname(randomString());
        op.nextBtn();

    }

    @Test(priority = 24)
    public void emptyProductType() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterProductName(randomString());
        //op.enterDeliveryDate("17/05/2026");
        op.nextBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Product Type Required']")));
        Assert.assertTrue(toast.getText().contains("Product Type Required"), "Error message not displayed");
    }

    @Test(priority = 25)
    public void emptyProductName() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.selectProductType();
        op.enterProductName("");
      //  op.enterDeliveryDate("17/05/2026");
        op.nextBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Product Name Required']")));
        Assert.assertTrue(toast.getText().contains("Product Name Required"), "Error message not displayed");
    }

    @Test(priority = 26)
    public void emptyDeliveryDate() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterProductName(randomString());
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Delivery Date Required']")));
        Assert.assertTrue(toast.getText().contains("Delivery Date Required"), "Error message not displayed");
    }

    @Test(priority = 27)
    public void validProductDetails() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterProductName(randomString());
        op.enterDeliveryDate("17/05/2026");
        op.nextBtn();
    }

    @Test(priority = 28)
    public void verifyAddProductBtn(){
        WebElement addProduct = driver.findElement(By.xpath("//span[normalize-space(text())='Add Product']"));
        System.out.println("Add product button is visible :"+addProduct.isDisplayed());
    }

    @Test(priority = 29)
    public void verifyPaymentDetail(){
        OrderPage op = new OrderPage(driver);
        op.nextBtn();
        WebElement paymentHeader = driver.findElement(By.xpath("//h3[normalize-space(text())='Payment details']"));
        System.out.println("payment detail is visible :"+paymentHeader.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyOrderAmt(){
        WebElement orderAmt = driver.findElement(By.id("orderAmount"));
        System.out.println("order amount field is visible :"+orderAmt.isDisplayed());
    }

    @Test(priority = 31)
    public void verifyAdvanceReceived(){
        WebElement advance = driver.findElement(By.id("advanceReceived"));
        System.out.println("advance field field is visible :"+advance.isDisplayed());
    }

    @Test(priority = 32)
    public void verifyCreateBtn(){
        WebElement createBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Create Order']"));
        System.out.println("create button field is visible :"+createBtn.isDisplayed());
        createBtn.click();
    }

//    @Test(priority = 19)
//    public void verifyGroupTestcases() throws InterruptedException{
//        OrderPage op = new OrderPage(driver);
//        op.orderModuleClient(phoneRandom(),randomString(),randomString());
//        System.out.println("*** All over ***");
//        op.ProductDetail(randomString(),"17/04/2026",randomNumber(),randomLength(),"Wait for your delivery");
//        op.paymentDetails(randomLength());
//        System.out.println("***Order successfully created***");
//    }

//    @Test(priority = 33)
//    public void verifyAddProduct() throws InterruptedException {
//        WebElement addProduct = driver.findElement(By.xpath("//span[normalize-space(text())='Add Product']"));
//        addProduct.click();
//    }

    @Test(priority = 33)
    public void verifyTaskEffort(){
        WebElement taskEffort = driver.findElement(By.xpath("//strong[text()=' Task Effort']"));
        System.out.println("Task Effort is displayed :"+taskEffort.isDisplayed());
        taskEffort.click();
    }

    @Test(priority = 34)
    public void verifytaskname(){
        WebElement taskname = driver.findElement(By.xpath("(//th[@class='ant-table-cell']//strong)[1]"));
        System.out.println("Task name is displayed :"+taskname.isDisplayed());
    }

    @Test(priority = 35)
    public void verifyEstimationname(){
        WebElement estimation = driver.findElement(By.xpath("(//th[@class='ant-table-cell']//strong)[2]"));
        System.out.println("Estimation time is displayed :"+estimation.isDisplayed());
    }

    @Test(priority = 36)
    public void verifyOutsourcingName(){
        WebElement outsourcing = driver.findElement(By.xpath("(//th[@class='ant-table-cell']//strong)[3]"));
        System.out.println("outsourcing is displayed :"+outsourcing.isDisplayed());
    }

    @Test(priority = 37)
    public void verifyProductSpecification(){
        WebElement prodSpecification = driver.findElement(By.xpath("//strong[text()=' Product Specification']"));
        System.out.println("Product specification is displayed :"+prodSpecification.isDisplayed());
    }

    @Test(priority = 38)
    public void verifySourcing(){
        WebElement sourcing = driver.findElement(By.xpath("//strong[text()=' Sourcing']"));
        System.out.println("Sourcing is displayed :"+sourcing.isDisplayed());
        sourcing.click();
    }//----

    @Test(priority = 39)
    public void verifySourcingType(){
        WebElement sourcingType = driver.findElement(By.id("sourcing_0_sourcingType"));
        System.out.println("Sourcing type is displayed :"+sourcingType.isDisplayed());
    }

    @Test(priority = 40)
    public void verifyQuantity(){
        WebElement quantity = driver.findElement(By.id("sourcing_0_quantity"));
        System.out.println("quantity is displayed :"+quantity.isDisplayed());
    }

    @Test(priority = 41)
    public void verifyTotalAmt(){
        WebElement totalAmt = driver.findElement(By.id("sourcing_0_total"));
        System.out.println("total amount is displayed :"+totalAmt.isDisplayed());
    }

    @Test(priority = 42)
    public void verifyProductionNecessay(){
        WebElement checkBox = driver.findElement(By.xpath("//span[normalize-space(text())='Is this necessary for production?']"));
        System.out.println("checkbox is displayed :"+checkBox.isDisplayed());
    }

    @Test(priority = 43)
    public void verifyremarks(){
        WebElement remarks = driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
        System.out.println("remarks is displayed :"+remarks.isDisplayed());
    }

    @Test(priority = 44)
    public void verifyAddSourceBtn(){
        WebElement addSourceBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Add Sourcing']"));
        System.out.println("addSource button is displayed :"+addSourceBtn.isDisplayed());
    }

    @Test(priority = 45)
    public void emptySourcetype() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterQuantity("2");
        op.enterTotalAmt("100");
        op.clickSave();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Required']")));
        Assert.assertTrue(toast.getText().contains("Required"), "Error message not displayed");
    }

    @Test(priority = 46)
    public void emptyQuantity() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterQuantity("");
        op.enterTotalAmt("100");
        op.clickSave();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Quantity required']")));
        Assert.assertTrue(toast.getText().contains("Quantity required"), "Error message not displayed");
    }

    @Test(priority = 47)
    public void emptyAmount() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.selectSourcingType();
        op.enterQuantity("2");
        op.enterTotalAmt("");
        op.clickSave();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Total required']")));
        Assert.assertTrue(toast.getText().contains("Total required"), "Error message not displayed");
    }

    @Test(priority = 48)
    public void validSourcingDetails() throws InterruptedException {
        OrderPage op = new OrderPage(driver);
        op.enterQuantity("2");
        op.enterTotalAmt("200");
    }

    @Test(priority = 49)
     public void verifyAddProduct() throws InterruptedException {
        WebElement addProduct = driver.findElement(By.xpath("//span[normalize-space(text())='Add Product']"));
        addProduct.click();
    }

    @Test(priority = 50)
    public void verifyProductTypeField(){
        WebElement productType = driver.findElement(By.id("products_0_productTypeId"));
        System.out.println("Product type is displayed:"+productType);
    }

    @Test(priority = 51)
    public void verifyProductNameField(){
        WebElement productName = driver.findElement(By.id("products_0_productName"));
        System.out.println("Product name is displayed:"+productName);
    }

    @Test(priority = 52)
    public void verifyDeliveryField(){
        WebElement deliveryDate = driver.findElement(By.id("products_0_deliveryDate"));
        System.out.println("Delivery date is displayed:"+deliveryDate);
    }

    @Test(priority = 53)
    public void verifyRushOrder(){
        WebElement rush = driver.findElement(By.xpath("//span[text()='Mark as Rush Order']"));
        System.out.println("Verify rush order checkbox :"+ rush);
    }

    @Test(priority = 54)
    public void verifyReferenceAvailable(){
        WebElement reference = driver.findElement(By.xpath("//span[text()='Reference Garment Available']"));
        System.out.println("Verify reference available checkbox :"+ reference);
    }

    @Test(priority = 55)
    public void predefinedNotes(){
        WebElement predefined = driver.findElement(By.xpath("//div[text()='Predefined Notes']"));
        System.out.println("Verify predefined :"+predefined);
    }

    @Test(priority = 56)
    public void verifyNotes(){
        WebElement notes = driver.findElement(By.xpath("//textarea[@placeholder='Type your custom instructions here...']"));
        System.out.println("Verify notes field :"+notes);
    }

    @Test(priority = 57)
    public void verifySubmitBtn(){
        WebElement subBtn = driver.findElement(By.xpath("//span[text()=' Submit']"));
        System.out.println("Verify submit button is visible :"+subBtn.isDisplayed());
    }

    @Test(priority = 58)
    public void closeModel() throws InterruptedException {
        OrderPage obj = new OrderPage(driver);
        obj.closeTab();
    }

    @Test(priority = 59)
    public void verifySaveAllButton(){
        WebElement saveAll = driver.findElement(By.xpath("//span[normalize-space(text())='Save All']"));
        System.out.println("Verify save all button is visible :"+saveAll.isDisplayed());
        saveAll.click();
    }

    @Test(priority = 60)
    public void verifyOutsourcing(){
        WebElement outsourcing = driver.findElement(By.xpath("//span[normalize-space(text())='Outsourcing']"));
        System.out.println("Outsourcing module is visible:"+outsourcing.isDisplayed());
        outsourcing.click();
    }

    @Test(priority = 61)
    public void verifyTitle(){
        boolean outSourcing = driver.findElement(By.xpath("//h2[normalize-space(text())='Outsourcing']")).isDisplayed();
        System.out.println("Verify outsourcing title is displayed :"+outSourcing);
        Assert.assertTrue(outSourcing,"OutSourcing title is not displayed");
    }

    @Test(priority = 62)
    public void verifyGivenStatus(){
        boolean givenStatus = driver.findElement(By.xpath("//span[@title='Given']")).isDisplayed();
        System.out.println("Verify status dropdown is displayed :"+givenStatus);
    }

    @Test(priority = 63)
    public void verifySearchField(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search...']")).isDisplayed();
        System.out.println("Verify search field is displayed:"+search);
    }

    @Test(priority = 64)
    public void verifyOrderNo(){
        boolean orderNo = driver.findElement(By.xpath("//th[normalize-space(text())='Order Number']")).isDisplayed();
        System.out.println("Verify order number is visible :"+orderNo);
    }

    @Test(priority = 65)
    public void verifyProduct(){
        boolean prod = driver.findElement(By.xpath("//th[normalize-space(text())='Product']")).isDisplayed();
        System.out.println("Verify product detail is displayed :"+prod);
    }

    @Test(priority = 66)
    public void verifyGivenDate(){
        boolean givenDate = driver.findElement(By.xpath("//th[normalize-space(text())='Given Date']")).isDisplayed();
        System.out.println("Verify given date is displayed :"+givenDate);
    }

    @Test(priority = 67)
    public void verifyExpecDate(){
        boolean expectDate = driver.findElement(By.xpath("//th[normalize-space(text())='Expected Date']")).isDisplayed();
        System.out.println("Verify expected date is displayed :"+expectDate);
    }

    @Test(priority = 68)
    public void verifyNote(){
        boolean notes = driver.findElement(By.xpath("//th[normalize-space(text())='Notes']")).isDisplayed();
        System.out.println("Verify notes is displayed :"+notes);
    }

    @Test(priority = 69)
    public void verifystatus(){
        boolean status = driver.findElement(By.xpath("//th[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Verify status is displayed:"+status);
    }

    @Test(priority = 70)
    public void verifyAction(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Actions']")).isDisplayed();
        System.out.println("Verify action is displayed:"+action);
    }

}