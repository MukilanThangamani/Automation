package TestBase;

import PageObjects.GalleryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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
    public void emptyFolder() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.addName("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter folder name']")));
        Assert.assertTrue(toast.getText().contains("Please enter folder name"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void createFolder() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.addName(randomString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Common folder created successfully']")));
        Assert.assertTrue(toast.getText().contains("Common folder created successfully"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void emptyClient() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.clientFolder();
    }

    @Test(priority = 13)
    public void verifyFolder(){
        WebElement folder = driver.findElement(By.id("editFolder_folderName"));
        System.out.println("Verify folder is displayed :"+folder);
    }

    @Test(priority = 14)
    public void verifySelectClient(){
        WebElement selectClient = driver.findElement(By.id("editFolder_clientId"));
        System.out.println("Verify select client is displayed :"+selectClient);
        selectClient.click();
    }

    @Test(priority = 15)
    public void emptyFolderName(){
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.selectClientName();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter folder name']")));
        Assert.assertTrue(toast.getText().contains("Please enter folder name"), "Error message not displayed");
        gp2.closeBtn();
    }

    @Test(priority = 16)
    public void  emptyClientImages() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.clientImageFolder();
        gp2.addName(randomString());
        gp2.closeBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please select a client']")));
        Assert.assertTrue(toast.getText().contains("Please select a client"), "Error message not displayed");
    }

    @Test(priority = 17)
    public void valid() throws InterruptedException {
        GalleryPage gp2 = new GalleryPage(driver);
        gp2.clientImageFolder();
        gp2.selectClientName();
        gp2.addName(randomString());
    }


}