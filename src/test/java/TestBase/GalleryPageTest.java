package TestBase;

import PageObjects.GalleryPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GalleryPageTest extends BaseClass{

    @Test(priority = 1)
    public void testGalleryPage() throws InterruptedException {
      GalleryPage gp = new GalleryPage(driver);
      gp.moduleClick();
    }

    @Test(priority = 2)
    public void verifyCommonImages(){
        boolean commonImage = driver.findElement(By.xpath("//div[text()='Common Images']")).isDisplayed();
        System.out.println("Verify common image is displayed :"+commonImage);
    }

    @Test(priority = 3)
    public void verifyClientImage(){
        boolean clientImage = driver.findElement(By.xpath("//div[text()='Client Images']")).isDisplayed();
        System.out.println("Verify client image is displayed :"+clientImage);
    }

    @Test(priority = 4)
    public void verifyProductImage(){
        boolean productImage = driver.findElement(By.xpath("//div[text()='Product Images']")).isDisplayed();
        System.out.println("Verify product image is displayed :"+productImage);
    }

    @Test(priority = 5)
    public void verifyReferenceImage(){
        boolean referenceImage = driver.findElement(By.xpath("//div[text()='Reference Images']")).isDisplayed();
        System.out.println("Verify reference image is displayed:"+referenceImage);
    }

    @Test(priority = 6)
    public void verifyAddFolder(){
        boolean addFolder = driver.findElement(By.xpath("//span[text()='Add Folder']")).isDisplayed();
        System.out.println("Verify add folder button is displayed :"+addFolder);
    }

    @Test(priority = 7)
    public void addFolder(){
        GalleryPage gp1 = new GalleryPage(driver);
        gp1.clickAddFolder();
    }

    @Test(priority = 8)
    public void verifyFoldername(){
        boolean folder = driver.findElement(By.id("editFolder_folderName")).isDisplayed();
        System.out.println("Verify folder field is displayed :"+folder);
    }

    @Test(priority = 9)
    public void verifyUpdate(){
        boolean updateBtn = driver.findElement(By.xpath("//span[text()='Update']")).isDisplayed();
        System.out.println("Verify update is displayed :"+updateBtn);
    }

    @Test(priority = 10)
    public void verifyClose(){
        boolean closeBtn = driver.findElement(By.xpath("//span[text()='Close']")).isDisplayed();
        System.out.println("Verify close is displayed:"+closeBtn);
    }

    @Test(priority = 11)
    public void createFolder() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.addName(randomString());

    }

}
