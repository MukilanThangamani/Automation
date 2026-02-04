package TestBase;

import PageObjects.CrmPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class crmPageTest extends BaseClass {

    @Test
    public void verifyCrmModule() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement crm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='CRM']")));
        Thread.sleep(1000);
        crm.click();
    }

    @Test
    public void totalCustomer(){
        WebElement totalCustomers = driver.findElement(By.xpath("//h5[text()='Total Customers']/preceding-sibling::h3"));
        String count = totalCustomers.getText();
        System.out.println("Total Customers count: " + count);
    }

    @Test
    public void activeCustomers(){
        WebElement activeCustomers = driver.findElement(By.xpath("//h5[text()='Active Customers']/preceding-sibling::h3"));
        String count = activeCustomers.getText();
        System.out.println("Active Customers count: " + count);
    }

    @Test
    public void newCustomers(){
        WebElement newCustomers = driver.findElement(By.xpath("//h5[text()='New Customers']/preceding-sibling::h3"));
        String count = newCustomers.getText();
        System.out.println("New Customers count: " + count);
    }

    @Test
    public void inActiveCustomers(){
        WebElement inActiveCustomers = driver.findElement(By.xpath("//h5[text()='Inactive / Dormant Customers']/preceding-sibling::h3"));
        String count = inActiveCustomers.getText();
        System.out.println("inActive Customers count: " + count);
    }

    @Test
    public void highValueCustomers(){
        WebElement highValueCustomers = driver.findElement(By.xpath("//h5[text()='High-Value Customers']/preceding-sibling::h3"));
        String count = highValueCustomers.getText();
        System.out.println("inActive Customers count: " + count);
    }

    @Test
    public void verifyCrmFields() throws InterruptedException {
        CrmPage crmPage = new CrmPage(driver);
        crmPage.clickCrm(randomString(),"8575656560","FB","1/432,chennai,AnnaNagar","Alteration process");
    }

    @Test
    public void verifyMeasurement() throws InterruptedException {
        CrmPage crmPage1 = new CrmPage(driver);
        crmPage1.measurement("7","8","9");
    }

    @Test
    public void verifySearch() throws InterruptedException {
        CrmPage crmPage2 = new CrmPage(driver);
        crmPage2.search("Hasini");
    }

}