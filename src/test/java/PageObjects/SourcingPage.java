package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SourcingPage extends BasePage{

    public SourcingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Sourcing']")
    WebElement sourcingmodbtn;

    @FindBy(xpath = "//span[text()='Add Sourcing']")
    WebElement addBtn;

    @FindBy(id = "sourcing_productId")
    WebElement prodclick;

    @FindBy(id = "sourcing_quantity")
    WebElement quant;

    @FindBy(id = "sourcing_total")
    WebElement totalamt;

    @FindBy(xpath = "//span[text()='Save Sourcing']")
    WebElement savebtn;

    @FindBy(id = "sourcing_remarks")
    WebElement remarks;

    @FindBy(id = "sourcing_sourcingType")
    WebElement sourceType;

    @FindBy(xpath = "//div[text()='Fabrics']")
    WebElement sourceOption;

    @FindBy(xpath = "//span[normalize-space(text())='Close']")
    WebElement closeBtn;

    public void clickModule() {
        sourcingmodbtn.click();
    }

    public void sourcingDetails(String quantity,String amt,String updatequant,String remark) throws InterruptedException{
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        System.out.println("Sourcing button is visible :"+sourcingmodbtn.isDisplayed());
        Thread.sleep(2000);
        sourcingmodbtn.click();
        Thread.sleep(3000);
        System.out.println("Add sourcing button is visible :"+addBtn.isDisplayed());
        addBtn.click();
        Thread.sleep(1000);
        System.out.println("Product type is visible :"+prodclick.isDisplayed());
        prodclick.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement source = driver.findElement(By.xpath("//div[@title='2077 - lBzJP']//div[1]"));

        System.out.println("Sourcing type is visible :"+source.isDisplayed());
        source.click();

        WebElement sourcingType = driver.findElement(By.id("sourcing_sourcingType"));
        sourcingType.click();

        Thread.sleep(1500);

        WebElement prodType = driver.findElement(By.xpath("//div[text()='Fabrics']"));
        prodType.click();

        Thread.sleep(1000);
        System.out.println("Quantity field is visible :"+quant.isDisplayed());
        quant.sendKeys(quantity);
        System.out.println("Total amount is visible :"+totalamt.isDisplayed());
        Thread.sleep(1000);

        // totalamt.sendKeys(amt);
        System.out.println("Save sourcing button  is visible :"+savebtn.isDisplayed());
        System.out.println("Save sourcing button  is enabled :"+savebtn.isEnabled());
        savebtn.click();
        Thread.sleep(1000);
        boolean isTotalAmount = !driver.findElements(By.xpath("//div[text()='Total Amount is required']")).isEmpty();
        if(isTotalAmount){
            totalamt.sendKeys(amt);
            remarks.sendKeys(remark);
        }
        savebtn.click();

    }

    public void selectSourceType() throws InterruptedException {
        sourceType.click();
        Thread.sleep(500);
        sourceOption.click();
    }

    public void enterQuantity(String quan) throws InterruptedException {
        WebElement element = driver.findElement(By.id("sourcing_quantity"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(quan);
    }

    public void enterAmount(String amount) throws InterruptedException {
        WebElement element = driver.findElement(By.id("sourcing_total"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(amount);
    }

    public void saveBtn() {
        savebtn.click();
    }

    public void closeBtn() {
        closeBtn.click();
    }

    public void selectproduct() {
        prodclick.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement source = driver.findElement(By.xpath("//div[normalize-space(text())='68 - NFScX']"));

        System.out.println("Sourcing type is visible :"+source.isDisplayed());
        source.click();
    }

    public void clickAddSourcing() {
        addBtn.click();
    }
}