package TestBase;

import PageObjects.SourcingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SourcingPageTest extends BaseClass{


    @Test(priority = 1)
    public void toTestSourcing() throws InterruptedException {
        SourcingPage sp = new SourcingPage(driver);
        sp.sourcingDetails("2","100","4",randomString());
    }

    @Test(priority = 2)
    public void productDropdown(){
        WebElement productstatus = driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[1]"));
        System.out.println("Product status dropdown is displayed :"+productstatus.isDisplayed());
    }

    @Test(priority = 3)
    public void Status(){
        WebElement sourcingStatus = driver.findElement(By.xpath("(//span[@title='To Start'])[1]"));
        System.out.println("Sourcing dropdown status :"+sourcingStatus.isDisplayed());
    }

    @Test(priority = 4)
    public void download(){
        WebElement downloadPdf = driver.findElement(By.xpath("//span[normalize-space(text())='Download Pdf']"));
        System.out.println("Download pdf is visible :"+downloadPdf.isDisplayed());
    }

    @Test(priority = 5)
    public void clientDetail(){
        WebElement client = driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[1]"));
        System.out.println("Client details :"+client.isDisplayed());
    }

    @Test(priority = 6)
    public void product(){
        WebElement products = driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[2]"));
        System.out.println("Product detail :"+products.isDisplayed());
    }

}