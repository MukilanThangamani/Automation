package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class PurchasePage extends BasePage{

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "vendor_form_vendorName")
    WebElement vendorname;

    @FindBy(id = "vendor_form_companyName")
    WebElement companyname;

    @FindBy(id = "vendor_form_displayName")
    WebElement display;

    @FindBy(id = "vendor_form_phone")
    WebElement mobileNumber;

    @FindBy(id = "vendor_form_email")
    WebElement email;

    @FindBy(id = "vendor_form_address")
    WebElement address;

    @FindBy(id = "vendor_form_pincode")
    WebElement pincode;

    @FindBy(id = "vendor_form_state")
    WebElement state;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement submitvendor;

    @FindBy(id = "vendor")
    WebElement clickVendor;

    @FindBy(xpath = "//div[normalize-space(text())='gZuCr - gDOUI']")
    WebElement selectVendor;

    @FindBy(xpath = "(//input[@placeholder='Select date'])[2]")
    WebElement deliveryDate;

    @FindBy(xpath = "//span[normalize-space(text())='Save']")
    WebElement savePurchase;

    @FindBy(xpath = "(//span[@class='ant-select-selection-search'])[1]")
    WebElement purchaseStatus;


    public void enterVendorName(String name) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_vendorName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(name);
    }

    public void enterCompanyName(String company) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_companyName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(company);

    }

    public void enterDisplayName(String displayname) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_displayName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(displayname);
    }

    public void enterMobile(String mobilenum) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_phone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(mobilenum);
    }

    public void enterEmail(String mail) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_email"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(mail);
    }

    public void enterAddress(String addr) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_address"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(addr);
    }

    public void enterPincode(String pin) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_pincode"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(pin);
    }

    public void enterState(String st) throws InterruptedException {
        WebElement element = driver.findElement(By.id("vendor_form_state"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(st);
    }

    public void clickSubmit() {
        submitvendor.click();
    }

//    public void addVendor(String vendorname, String compname, String displayname, String mobile, String mail, String address, String number, String vendorstate) throws InterruptedException {
//        submitvendor.click();
//        Thread.sleep(1000);
//        name.sendKeys(vendorname);
//        Thread.sleep(1000);
//        company.sendKeys(compname);
//        Thread.sleep(1000);
//        display.sendKeys(displayname);
//        Thread.sleep(1000);
//        mobilenum.sendKeys(mobile);
//        Thread.sleep(1000);
//        email.sendKeys(mail);
//        Thread.sleep(1000);
//        addr.sendKeys(address);
//        Thread.sleep(1000);
//        pincode.sendKeys(number);
//        Thread.sleep(1000);
//        state.sendKeys(vendorstate);
//        Thread.sleep(1000);
//        submitvendor.click();
//    }

    public void createOrder(String delivery) throws InterruptedException {
        savePurchase.click();
        Thread.sleep(1000);
        clickVendor.click();
        Thread.sleep(1000);
        selectVendor.click();
        Thread.sleep(1000);
        deliveryDate.sendKeys(delivery);
        savePurchase.click();
    }

    public void purchaseStatus() throws InterruptedException {
        purchaseStatus.click();
        Thread.sleep(1000);
        System.out.println("Verify status header  is visible :"+purchaseStatus.isDisplayed());
    }
}