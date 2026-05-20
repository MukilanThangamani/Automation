package TestBase;

import PageObjects.SourcingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SourcingPageTest extends BaseClass{


//    @Test(priority = 1)
//    public void toTestSourcing() throws InterruptedException {
//        SourcingPage sp = new SourcingPage(driver);
//        sp.sourcingDetails("2","100","4",randomString());
//    }

    @Test(priority = 1)
    public void emptyProductType() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.clickModule();
        sp.clickAddSourcing();
        sp.enterQuantity("2");
        sp.enterAmount("");
        sp.saveBtn();
        sp.closeBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Product is required']")));
        Assert.assertTrue(toast.getText().contains("Product is required"), "Error message not displayed");
    }

    @Test(priority = 2)
    public void emptySelectType() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.clickAddSourcing();
        sp.selectproduct();
        sp.enterQuantity("2");
        sp.enterAmount("2");
        sp.saveBtn();
        sp.closeBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Sourcing type is required']")));
        Assert.assertTrue(toast.getText().contains("Sourcing type is required"), "Error message not displayed");
    }

    @Test(priority = 3)
    public void emptyQuantity() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.clickAddSourcing();
        sp.selectproduct();
        sp.selectSourceType();
        sp.enterQuantity("");
        sp.enterAmount("2");
        sp.saveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Quantity is required']")));
        Assert.assertTrue(toast.getText().contains("Quantity is required"), "Error message not displayed");
    }

    @Test(priority = 4)
    public void emptyAmount() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.enterQuantity("3");
        sp.enterAmount("");
        sp.saveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Total Amount is required']")));
        Assert.assertTrue(toast.getText().contains("Total Amount is required"), "Error message not displayed");
    }

    @Test(priority = 5)
    public void quantityInCharacter() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.enterQuantity("e");
        sp.enterAmount("3");
        sp.saveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Only numbers with decimals are allowed']")));
        Assert.assertTrue(toast.getText().contains("Only numbers with decimals are allowed"), "Error message not displayed");
    }

    @Test(priority = 6)
    public void amountInCharacter() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.enterQuantity("5");
        sp.enterAmount("f");
        sp.saveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Only numbers with decimals are allowed']")));
        Assert.assertTrue(toast.getText().contains("Only numbers with decimals are allowed"), "Error message not displayed");
    }

    @Test(priority = 7)
    public void validSourcing() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.enterQuantity("5");
        sp.enterAmount("4");
        sp.saveBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Sourcing added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Sourcing added successfully!"), "Error message not displayed");
    }

    @Test(priority = 8)
    public void productDropdown(){
        WebElement productstatus = driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[1]"));
        System.out.println("Product status dropdown is displayed :"+productstatus.isDisplayed());
    }

    @Test(priority = 9)
    public void Status(){
        WebElement sourcingStatus = driver.findElement(By.xpath("(//span[@title='To Start'])[1]"));
        System.out.println("Sourcing dropdown status :"+sourcingStatus.isDisplayed());
    }

    @Test(priority = 10)
    public void download(){
        WebElement downloadPdf = driver.findElement(By.xpath("//span[normalize-space(text())='Download Pdf']"));
        System.out.println("Download pdf is visible :"+downloadPdf.isDisplayed());
    }

    @Test(priority = 11)
    public void clientDetail(){
        WebElement client = driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[1]"));
        System.out.println("Client details :"+client.isDisplayed());
    }

    @Test(priority = 12)
    public void product(){
        WebElement products = driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[2]"));
        System.out.println("Product detail :"+products.isDisplayed());
    }

}