package TestBase;

import PageObjects.CrmPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class crmPageTest extends BaseClass {

    @Test(priority = 1)
    public void verifyCrmModule() throws InterruptedException {
        CrmPage cm = new CrmPage(driver);
        cm.moduleClick();
    }

    @Test(priority = 2)
    public void totalCustomer(){
        WebElement totalCustomers = driver.findElement(By.xpath("//h5[text()='Total Customers']/preceding-sibling::h3"));
        String count = totalCustomers.getText();
        System.out.println("Total Customers count: " + count);
    }

    @Test(priority = 3)
    public void activeCustomers(){
        WebElement activeCustomers = driver.findElement(By.xpath("//h5[text()='Active Customers']/preceding-sibling::h3"));
        String count = activeCustomers.getText();
        System.out.println("Active Customers count: " + count);
    }

    @Test(priority = 4)
    public void newCustomers(){
        WebElement newCustomers = driver.findElement(By.xpath("//h5[text()='New Customers']/preceding-sibling::h3"));
        String count = newCustomers.getText();
        System.out.println("New Customers count: " + count);
    }

    @Test(priority = 5)
    public void inActiveCustomers(){
        WebElement inActiveCustomers = driver.findElement(By.xpath("//h5[text()='Inactive / Dormant Customers']/preceding-sibling::h3"));
        String count = inActiveCustomers.getText();
        System.out.println("inActive Customers count: " + count);
    }

    @Test(priority = 6)
    public void highValueCustomers(){
        WebElement highValueCustomers = driver.findElement(By.xpath("//h5[text()='High-Value Customers']/preceding-sibling::h3"));
        String count = highValueCustomers.getText();
        System.out.println("inActive Customers count: " + count);
    }

    @Test(priority = 7)
    public void verifyCrmFields() throws InterruptedException {
        CrmPage crmPage = new CrmPage(driver);
        crmPage.clickCrm(randomString(),"8575656560","FB","1/432,chennai,AnnaNagar","Alteration process");
    }

    @Test(priority = 8)
    public void verifyMeasurement() throws InterruptedException {
        CrmPage crmPage1 = new CrmPage(driver);
        crmPage1.measurement("7","8","9");
    }

    @Test(priority = 9)
    public void verifyOcassion() throws InterruptedException {
        CrmPage crmPage3 = new CrmPage(driver);
        crmPage3.occasion();
    }

    @Test(priority = 10)
    public void verifySelect() throws InterruptedException{
        CrmPage obj = new CrmPage(driver);
        obj.verifySelect();
    }

    @Test(priority = 11)
    public void verifyDate() throws InterruptedException{
        CrmPage obj1 = new CrmPage(driver);
        obj1.verifyDate();
    }

    @Test(priority = 12)
    public void verifyDeleteIcon(){
        CrmPage obj1 = new CrmPage(driver);
        obj1.verifyDelete();
    }

    @Test(priority = 13)
    public void verifyAddOccasion(){
        CrmPage obj2 = new CrmPage(driver);
        obj2.verifyAddOccasion();
    }

    @Test(priority = 14)
    public void verifySaveOccasion(){
        CrmPage obj3 = new CrmPage(driver);
        obj3.verifySaveOccasion();
    }

    @Test(priority = 15)
    public void verifyClose(){
        CrmPage obj4 = new CrmPage(driver);
        obj4.verifyCloseBtn();
    }

    @Test(priority = 16)
    public void validateData() throws InterruptedException {
        CrmPage data = new CrmPage(driver);
        data.validate("2026-03-13");
    }

    @Test(priority = 17)
    public void verifySearch() throws InterruptedException {
        CrmPage crmPage2 = new CrmPage(driver);
        crmPage2.search("Hasini");
    }

    @Test(priority = 18)
    public void verifySearchField(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search...']")).isDisplayed();
        System.out.println("Verify search field :"+search);
    }

    @Test(priority = 19)
    public void verifyUpload(){
        boolean uploadBtn = driver.findElement(By.xpath("(//button[@type='button']//span)[3]")).isDisplayed();
        System.out.println("Verify upload button:"+uploadBtn);
    }

    @Test(priority = 20)
    public void verifyAddClient(){
        boolean addClient = driver.findElement(By.xpath("//span[normalize-space(text())='Add Client']")).isDisplayed();
        System.out.println("Verify add client button :"+addClient);
    }

    @Test(priority = 21)
    public void verifyDownloadExcel(){
        boolean downloadExcel = driver.findElement(By.xpath("//span[normalize-space(text())='Download Excel']")).isDisplayed();
        System.out.println("Verify downloadExcel button is visible:"+downloadExcel);
    }


}