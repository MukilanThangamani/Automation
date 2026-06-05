package TestBase;

import PageObjects.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

public class ProductPageTest extends BaseClass {

    @Test(priority = 20)
    public void testProductTypes() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        SoftAssert softAssert = new SoftAssert();

        String[] prod = {"Pant","Blouse","Skirt"};
        String[] gen = {"Female", "Female","Female"};

        pp.customMeasurement(randomString());

        for (int i = 0; i < prod.length; i++) {
            System.out.println("Adding product: " + prod[i]);

            pp.addProduct(prod[i], gen[i]);

            pp.printDuplicateProductErrorMessage(softAssert);

            pp.verifyProductInList(prod[i], 1);
        }

        //  pp.backButton();
        softAssert.assertAll();

    }

    @Test(priority = 1)
    public void verifyTitle(){
        String title = driver.getTitle();
        boolean prodType = driver.findElement(By.xpath("//div[text()='Product Type']")).isDisplayed();
        System.out.println(title +"Verifying title name is visible :"+prodType);
    }

    @Test(priority = 2)
    public void verifyMeasurement(){
        boolean commonMeasurement = driver.findElement(By.xpath("//input[@placeholder='Add Custom measurement']")).isDisplayed();
        System.out.println("Common measurement is displayed :"+commonMeasurement);
    }

    @Test(priority = 3)
    public void verifySaveBtn(){
        boolean save = driver.findElement(By.xpath("//span[text()='Save']")).isDisplayed();
        System.out.println("Verify safe button is displayed :"+save);
    }

    @Test(priority = 4)
    public void verifySearch(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search...']")).isDisplayed();
        System.out.println("Verify search field :"+search);
    }

    @Test(priority = 5)
    public void verifyAddProduct(){
        WebElement addProduct = driver.findElement(By.xpath("//span[text()='Add Product Type']"));
        System.out.println("Verify add product field :"+addProduct.isDisplayed());
        addProduct.click();
    }

    @Test(priority = 6)
    public void verifyGenderField(){
        boolean gender = driver.findElement(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[2]")).isDisplayed();
        System.out.println("Verify gender field is present :"+gender);
    }

    @Test(priority = 7)
    public void verifyProductType(){
        boolean type = driver.findElement(By.xpath("//span[@title='Others']")).isDisplayed();
        System.out.println("Verify product type is present:"+type);
    }

    @Test(priority = 8)
    public void verifyNewType(){
        boolean newProduct = driver.findElement(By.xpath("//input[@placeholder='Enter new product type']")).isDisplayed();
        System.out.println("Verify new product field is visible:"+newProduct);
    }

    @Test(priority = 9)
    public void verifyaddMeasure(){
        boolean addMeasurement = driver.findElement(By.xpath("//span[normalize-space(text())='+ Add Measurement']")).isDisplayed();
        System.out.println("Verify add Measurement button :"+addMeasurement);
    }

    @Test(priority = 10)
    public void verifyNotes(){
        boolean notes = driver.findElement(By.xpath("(//label[normalize-space(text())='New Product Type']/following::input)[2]")).isDisplayed();
        System.out.println("Verify predefined notes :"+notes);
        // Assert.assertTrue(notes,"Predefined notes field is NOT displayed");
    }

//
//    @Test(priority = 14)
//    public void verifySubmit(){
//        boolean submitBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")).isDisplayed();
//        System.out.println("Verify submit button is displayed :"+submitBtn);
//        Assert.assertTrue(submitBtn,"submit button is not displayed");
//    }
//
//    @Test(priority = 15)
//    public void verifyCloseBtn(){
//        WebElement closeBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Close']"));
//        System.out.println("Verify close button is displayed :"+closeBtn.isDisplayed());
//        closeBtn.click();
//    }
//
//    @Test(priority = 16)
//    public void emptyProductTypeTest() {
//        ProductPage pp = new ProductPage(driver);
//        pp.clickAddProduct();
//        pp.selectGender();
//        pp.selectProductType();
//        pp.enterNewProductType("");
//        pp.clickSubmit();
//        pp.clickClose();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='New Product Type is required']")));
//        Assert.assertTrue(toast.getText().contains("New Product Type is required"), "Error message not displayed");
//    }
//
//    @Test(priority = 17)
//    public void genderNotSelectedTest() throws InterruptedException {
//        ProductPage pp = new ProductPage(driver);
//        pp.clickAddProduct();
//        Thread.sleep(1000);
//        pp.clickSubmit();
//        Thread.sleep(1000);
//        pp.clickClose();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Gender is required']")));
//        Assert.assertTrue(toast.getText().contains("Gender is required"), "Error message not displayed");
//    }
//
//    @Test(priority = 18)
//    public void verifyPredefinedNotes(){
//        WebElement notes = driver.findElement(By.xpath("(//label[normalize-space(text())='New Product Type']/following::input)[2]"));
//        System.out.println("Predefined field is present :"+notes);
//    }

//    @Test(priority = 21)
//    public void verifyPrevious(){
//        WebElement previous = driver.findElement(By.xpath("//span[normalize-space(text())='Previous']"));
//        System.out.println("Verify previous button :"+previous.isDisplayed());
//    }
//
//    @Test(priority = 22)
//    public void verifyDone(){
//        boolean done = driver.findElement(By.xpath("//span[normalize-space(text())='Done']")).isDisplayed();
//        System.out.println("Verify done button :"+done);
//    }

    @Test(priority = 11)
    public void emptyGender() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        Thread.sleep(1000);
        pp.enterNewProductType(randomString());
        pp.clickSubmit();
        pp.clickClose();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Gender is required']")));
        Assert.assertTrue(toast.getText().contains("Gender is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void emptyProduct() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        pp.addProductbtn();
        Thread.sleep(1000);
        pp.selectGender();
        Thread.sleep(1000);
        pp.clickSubmit();
        pp.clickClose();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='New Product Type is required']")));
        Assert.assertTrue(toast.getText().contains("New Product Type is required"), "Error message not displayed");
    }

    @Test(priority = 13)
    public void validBasicDetail() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        pp.addProductbtn();
        Thread.sleep(1000);
        pp.selectGender();
        pp.enterNewProductType(randomString());
        Thread.sleep(1000);
        pp.nextToNotes();
    }

    @Test(priority = 14)
    public void verifyNoteName(){
        WebElement note = driver.findElement(By.id("noteName"));
        System.out.println("verify note field is displayed :"+note);
    }

    @Test(priority = 15)
    public void verifyCharge(){
        WebElement charge = driver.findElement(By.id("charge"));
        System.out.println("verify charge field is displayed :"+charge);
    }

    @Test(priority = 16)
    public void verifyAddNote(){
        WebElement addNote = driver.findElement(By.xpath("//span[normalize-space(text())='Add Note']"));
        System.out.println("Verify add note is displayed :"+addNote);
    }

    @Test(priority = 17)
    public void predefinedNote(){
        ProductPage pp = new ProductPage(driver);
        pp.enterNote(randomString());
        pp.nextToNotes();
    }

    @Test(priority = 18)
    public void verifydefaultTime(){
        WebElement defaulttime = driver.findElement(By.xpath("//h5[normalize-space(text())='Set Default Time for Each Task']"));
        System.out.println("Verify default time is displayed :"+defaulttime);
    }

    @Test(priority = 19)
    public void addTaskBtn(){
        WebElement addTask = driver.findElement(By.xpath("//span[normalize-space(text())='Add Task']"));
        System.out.println("Verify add task is displayed :"+addTask);
    }

    @Test(priority = 20)
    public void Task(){
        ProductPage pp = new ProductPage(driver);
        pp.clickSubmit();
    }

}