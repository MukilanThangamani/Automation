package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BillingPage extends BasePage{

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[text()='Billing']")
    WebElement billingModule;

    @FindBy(xpath = "//div[text()='Estimations']")
    WebElement estimation;

    @FindBy(xpath = "//span[text()='Create Estimation']")
    WebElement createEstimation;

    @FindBy(id = "phone")
    WebElement phoneNUmber;

    @FindBy(id = "clientName")
    WebElement clientName;

    @FindBy(id = "clientAddress")
    WebElement clientAddress;

    @FindBy(id = "products_0_productTypeId")
    WebElement producttype;

    @FindBy(id = "products_0_productQuantity")
    WebElement productQuantity;

    @FindBy(id = "products_0_pricePerUnit")
    WebElement pricePerUnit;

    @FindBy(xpath = "(//textarea[contains(@class,'ant-input css-1w0sqha')])[3]")
    WebElement notes;

    @FindBy(id = "products_0_productAmount")
    WebElement productAmount;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submit;

    //Actions
    public void navigateToBilling(String number,String name,String address) throws InterruptedException {
        String pageTitle = driver.getTitle();
        System.out.println("The page title is ;"+pageTitle);

        System.out.println("Billing module button is displayed :"+billingModule.isDisplayed());
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // billingModule.click();
        System.out.println("Estimation button is displayed:"+estimation.isDisplayed());
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        estimation.click();
        System.out.println("Create Estimation button is displayed:"+createEstimation.isDisplayed());
        Thread.sleep(1000);
        createEstimation.click();
        System.out.println("Phone number field is displayed:"+phoneNUmber.isDisplayed());
        Thread.sleep(1000);
        phoneNUmber.sendKeys(number);
        System.out.println("Client name field is displayed :"+clientName.isDisplayed());
        Thread.sleep(1000);
        clientName.sendKeys(name);
        System.out.println("Client address field is displayed :"+clientAddress.isDisplayed());
        Thread.sleep(1000);
        clientAddress.click();
        Thread.sleep(1000);
        clientAddress.sendKeys(address);
    }

    public void addProduct(String quantity,String price,String note) throws InterruptedException {
        System.out.println("Add product functionality to be implemented");
        producttype.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement selectProduct = driver.findElement(By.xpath("//div[text()='Skirt']"));
        selectProduct.click();

        System.out.println("Product quantity field is displayed:"+productQuantity.isDisplayed());
        Thread.sleep(1000);
       // productQuantity.click();
       // productQuantity.sendKeys(quantity);
        System.out.println("Price per unit field is displayed :"+pricePerUnit.isDisplayed());
        Thread.sleep(1000);
        pricePerUnit.click();
        Thread.sleep(1000);
        pricePerUnit.sendKeys(price);
        Thread.sleep(1000);
        notes.sendKeys(note);

        System.out.println("Product amount field is displayed:"+productAmount.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Product amount is not enabled for editing:"+productAmount.isEnabled());

        System.out.println("Submit button is displayed:"+submit.isDisplayed());
        Thread.sleep(1000);
        submit.click();

        boolean isQuantityErr = !driver.findElements(By.xpath("//div[text()='Quantity is required']")).isEmpty();
        if(isQuantityErr){
            productQuantity.sendKeys(quantity);
        }else {}

      //  submit.click();
    }

    public void submitEstimation() {
        submit.click();
    }

    public void moduleClick() throws InterruptedException {
        Thread.sleep(2000);
        billingModule.click();
    }
}
