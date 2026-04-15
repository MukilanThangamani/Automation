package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class PurchasePage extends BasePage{

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "vendor_form_vendorName")
    WebElement name;

    @FindBy(id = "vendor_form_companyName")
    WebElement company;

    @FindBy(id = "vendor_form_displayName")
    WebElement display;

    @FindBy(id = "vendor_form_phone")
    WebElement mobilenum;

    @FindBy(id = "vendor_form_email")
    WebElement email;

    @FindBy(id = "vendor_form_address")
    WebElement addr;

    @FindBy(id = "vendor_form_pincode")
    WebElement pincode;

    @FindBy(id = "vendor_form_state")
    WebElement state;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement submitvendor;

    @FindBy(id = "vendor")
    WebElement clickVendor;

    @FindBy(xpath = "(//input[@placeholder='Select date'])[2]")
    WebElement deliveryDate;

    @FindBy(xpath = "//span[normalize-space(text())='Save']")
    WebElement savePurchase;

    public void addVendor(String vendorname, String compname, String displayname, String mobile, String mail, String address, String number, String vendorstate) throws InterruptedException {
        submitvendor.click();
        Thread.sleep(1000);
        name.sendKeys(vendorname);
        Thread.sleep(1000);
        company.sendKeys(compname);
        Thread.sleep(1000);
        display.sendKeys(displayname);
        Thread.sleep(1000);
        mobilenum.sendKeys(mobile);
        Thread.sleep(1000);
        email.sendKeys(mail);
        Thread.sleep(1000);
        addr.sendKeys(address);
        Thread.sleep(1000);
        pincode.sendKeys(number);
        Thread.sleep(1000);
        state.sendKeys(vendorstate);
        Thread.sleep(1000);
        submitvendor.click();
    }

    public void createOrder(String delivery) throws InterruptedException {
        savePurchase.click();
        Thread.sleep(1000);
        clickVendor.click();
        Thread.sleep(1000);
        deliveryDate.sendKeys(delivery);
        savePurchase.click();
    }
}
