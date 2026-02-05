package TestBase;

import PageObjects.ProductPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductPageTest extends BaseClass {

    @Test(priority = 8)
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

        pp.backButton();
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
        boolean addProduct = driver.findElement(By.xpath("//span[text()='Add Product Type']")).isDisplayed();
        System.out.println("Verify add product field :"+addProduct);
    }

    @Test(priority = 6)
    public void verifyPrevious(){
        boolean previous = driver.findElement(By.xpath("//span[text()='Previous']")).isDisplayed();
        System.out.println("Verify previous button :"+previous);
    }

    @Test(priority = 7)
    public void verifyDone(){
        boolean done = driver.findElement(By.xpath("//span[text()='Done']")).isDisplayed();
        System.out.println("Verify done button :"+done);
    }



}
