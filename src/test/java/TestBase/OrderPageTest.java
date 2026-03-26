package TestBase;
import PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass{

    @Test(priority = 1)
    public void verifyGroupTestcases() throws InterruptedException{
        OrderPage op = new OrderPage(driver);
        Thread.sleep(1000);
        op.dashboard();
        op.orderModuleClient(phoneRandom(),randomString(),randomString());
        System.out.println("*** All over ***");
        op.ProductDetail(randomString(),"28/03/2026",randomNumber(),randomLength(),"Wait for your delivery");
        op.paymentDetails(randomLength());
        System.out.println("***Order successfully created***");
    }

    @Test(priority = 5)
    public void verifyAddProduct() throws InterruptedException {
        WebElement addProduct = driver.findElement(By.xpath("//span[text()='Add Product']"));
        System.out.println("Add product is displayed :"+addProduct.isDisplayed());
        OrderPage orp = new OrderPage(driver);
        orp.clickProduct();
    }

    @Test(priority = 2)
    public void verifyTaskEffort(){
        WebElement taskEffort = driver.findElement(By.xpath("//strong[text()=' Task Effort']"));
        System.out.println("Task Effort is displayed :"+taskEffort.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyProductSpecification(){
        WebElement prodSpecification = driver.findElement(By.xpath("//strong[text()=' Product Specification']"));
        System.out.println("Product specification is displayed :"+prodSpecification.isDisplayed());
    }

    @Test(priority = 4)
    public void verifySourcing(){
        WebElement sourcing = driver.findElement(By.xpath("//strong[text()=' Sourcing']"));
        System.out.println("Sourcing is displayed :"+sourcing.isDisplayed());
    }

    @Test(priority = 6)
    public void verifyProductTypeField(){
        WebElement productType = driver.findElement(By.id("products_0_productTypeId"));
        System.out.println("Product type is displayed:"+productType);
    }

    @Test(priority = 7)
    public void verifyProductNameField(){
        WebElement productName = driver.findElement(By.id("products_0_productName"));
        System.out.println("Product name is displayed:"+productName);
    }

    @Test(priority = 8)
    public void verifyDeliveryField(){
        WebElement deliveryDate = driver.findElement(By.id("products_0_deliveryDate"));
        System.out.println("Delivery date is displayed:"+deliveryDate);
    }

    @Test(priority = 9)
    public void verifyRushOrder(){
        WebElement rush = driver.findElement(By.xpath("//span[text()='Mark as Rush Order']"));
        System.out.println("Verify rush order checkbox :"+ rush);
    }

    @Test(priority = 10)
    public void verifyReferenceAvailable(){
        WebElement reference = driver.findElement(By.xpath("//span[text()='Reference Garment Available']"));
        System.out.println("Verify reference available checkbox :"+ reference);
    }

    @Test(priority = 11)
    public void predefinedNotes(){
        WebElement predefined = driver.findElement(By.xpath("//div[text()='Predefined Notes']"));
        System.out.println("Verify predefined :"+predefined);
    }

    @Test(priority = 12)
    public void verifyNotes(){
        WebElement notes = driver.findElement(By.xpath("//textarea[@placeholder='Type your custom instructions here...']"));
        System.out.println("Verify notes field :"+notes);
    }

    @Test(priority = 13)
    public void verifySubmitBtn(){
        WebElement subBtn = driver.findElement(By.xpath("//span[text()=' Submit']"));
        System.out.println("Verify submit button is visible :"+subBtn.isDisplayed());
    }

    @Test(priority = 14)
    public void closeModel() throws InterruptedException {
        OrderPage op1 = new OrderPage(driver);
        op1.closeModel();
    }

    @Test(priority = 15)
    public void verifySaveAllButton(){
        WebElement saveAll = driver.findElement(By.xpath("//span[normalize-space(text())='Save All']"));
        System.out.println("Verify save all button is visible :"+saveAll.isDisplayed());
        saveAll.click();
    }

    @Test(priority = 16)
    public void verifyOutsourcing(){
        WebElement outsourcing = driver.findElement(By.xpath("//span[normalize-space(text())='Outsourcing']"));
        System.out.println("Outsourcing module is visible:"+outsourcing.isDisplayed());
        outsourcing.click();
    }

    @Test(priority = 17)
    public void verifyTitle(){
        boolean outSourcing = driver.findElement(By.xpath("//h2[normalize-space(text())='Outsourcing']")).isDisplayed();
        System.out.println("Verify outsourcing title is displayed :"+outSourcing);
        Assert.assertTrue(outSourcing,"OutSourcing title is not displayed");
    }

    @Test(priority = 18)
    public void verifyGivenStatus(){
        boolean givenStatus = driver.findElement(By.xpath("//span[@title='Given']")).isDisplayed();
        System.out.println("Verify status dropdown is displayed :"+givenStatus);
    }

    @Test(priority = 19)
    public void verifySearchField(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search...']")).isDisplayed();
        System.out.println("Verify search field is displayed:"+search);
    }

    @Test(priority = 20)
    public void verifyOrderNo(){
        boolean orderNo = driver.findElement(By.xpath("//th[normalize-space(text())='Order Number']")).isDisplayed();
        System.out.println("Verify order number is visible :"+orderNo);
    }

    @Test(priority = 21)
    public void verifyProduct(){
        boolean prod = driver.findElement(By.xpath("//th[normalize-space(text())='Product']")).isDisplayed();
        System.out.println("Verifuy product detail is displayed :"+prod);
    }

    @Test(priority = 22)
    public void verifyGivenDate(){
        boolean givenDate = driver.findElement(By.xpath("//th[normalize-space(text())='Given Date']")).isDisplayed();
        System.out.println("Verify given date is displayed :"+givenDate);
    }

    @Test(priority = 23)
    public void verifyExpecDate(){
        boolean expectDate = driver.findElement(By.xpath("//th[normalize-space(text())='Expected Date']")).isDisplayed();
        System.out.println("Verify expected date is displayed :"+expectDate);
    }

    @Test(priority = 24)
    public void verifyNote(){
        boolean notes = driver.findElement(By.xpath("//th[normalize-space(text())='Notes']")).isDisplayed();
        System.out.println("Verify notes is displayed :"+notes);
    }

    @Test(priority = 25)
    public void verifystatus(){
        boolean status = driver.findElement(By.xpath("//th[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Verify status is displayed:"+status);
    }

    @Test(priority = 26)
    public void verifyAction(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Actions']")).isDisplayed();
        System.out.println("Verify action is displayed:"+action);
    }

}