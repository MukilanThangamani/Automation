package TestBase;

import PageObjects.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import javax.swing.*;

public class ProductPageTest extends BaseClass {

    @Test(priority = 16)
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

    @Test(priority = 11)
    public void verifyDefaultTime(){
        boolean defaultTime = driver.findElement(By.xpath("//h5[normalize-space(text())='Set Default Time for Each Task']")).isDisplayed();
        System.out.println("Verify to set default time title id visible :"+defaultTime);
        Assert.assertTrue(defaultTime,"Default time title is missing");
    }

    @Test(priority = 12)
    public void verifyTaskFlow(){
        boolean taskFlow = driver.findElement(By.xpath("//h5[normalize-space(text())='Drag and drop to re-order the task execution flow']")).isDisplayed();
        System.out.println("Verify task execution flow :"+taskFlow);
        Assert.assertTrue(taskFlow,"task execution flow is missing");
    }

    @Test(priority = 13)
    public void verifyAddTask(){
        boolean addTask = driver.findElement(By.xpath("//span[normalize-space(text())='Add Task']")).isDisplayed();
        System.out.println("Verify addTask button is visible :"+addTask);
        Assert.assertTrue(addTask,"add task button is not displayed");
    }

    @Test(priority = 14)
    public void verifySubmit(){
        boolean submitBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")).isDisplayed();
        System.out.println("Verify submit button is displayed :"+submitBtn);
        Assert.assertTrue(submitBtn,"submit button is not displayed");
    }

    @Test(priority = 15)
    public void verifyCloseBtn(){
        WebElement closeBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Close']"));
        System.out.println("Verify close button is displayed :"+closeBtn.isDisplayed());
        closeBtn.click();
    }

    @Test(priority = 17)
    public void verifyPrevious(){
        WebElement previous = driver.findElement(By.xpath("//span[normalize-space(text())='Previous']"));
        System.out.println("Verify previous button :"+previous.isDisplayed());
    }

    @Test(priority = 18)
    public void verifyDone(){
        boolean done = driver.findElement(By.xpath("//span[normalize-space(text())='Done']")).isDisplayed();
        System.out.println("Verify done button :"+done);
    }

}
