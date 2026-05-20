package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentPage extends BasePage {

    public AppointmentPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[text()='Appointments']")
    WebElement appmodule;

    @FindBy(css = "#__next > div > div > div > section > div > header > div:nth-child(2) > div:nth-child(2) > svg")
    WebElement scheduleApp;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phoneNUmber;

    @FindBy(id = "clientName")
    WebElement clientName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "reference")
    WebElement ref;

    @FindBy(xpath = "//div[text()='Whatsapp']")
    WebElement referenceOption;

    @FindBy(id = "purpose")
    WebElement purpose;

    @FindBy(id = "appointmentTime")
    WebElement appointmentTime;

    @FindBy(xpath = "//span[text()='OK']")
    WebElement okbtn;

    @FindBy(id = "notes")
    WebElement notes;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement subApp;

    @FindBy(xpath = "//div[text()='Style consultation']")
    WebElement purposeClk;

    @FindBy(xpath = "//span[text()='Close']")
    WebElement closebtn;

    //Actions
    public void clientDetails(String num,String cname,String add,String pur,String time,String not) throws InterruptedException {
        String pageTitle = driver.getTitle();
        System.out.println("The page title is :" + pageTitle);

        System.out.println("Appointment module button is displayed :" + appmodule.isDisplayed());
        appmodule.click();
        Thread.sleep(1000);
        scheduleApp.click();
        Thread.sleep(1000);
        subApp.submit();

        boolean isMobileErr = !driver.findElements(By.xpath("//div[text()='Mobile Number is required']")).isEmpty();
        boolean isClientErr = !driver.findElements(By.xpath("//div[text()='Client Name is required']")).isEmpty();
        boolean isClientAddErr = !driver.findElements(By.xpath("//div[text()='Client Address is required']")).isEmpty();
        boolean isReferenceErr = !driver.findElements(By.xpath("//div[text()='Reference is required']")).isEmpty();
        boolean isPurposeErr = !driver.findElements(By.xpath("//div[text()='Purpose is required']")).isEmpty();
        boolean isDeliveryDate = !driver.findElements(By.xpath("//div[text()='Appointment Date is required']")).isEmpty();

        if (isMobileErr || isClientErr || isClientAddErr || isReferenceErr || isPurposeErr || isDeliveryDate) {
            System.out.println("Phone number field is visible :" + phoneNUmber.isDisplayed());
            phoneNUmber.sendKeys(num);
            Thread.sleep(1000);
            System.out.println("Client name field is visible :" + clientName.isDisplayed());
            clientName.sendKeys(cname);
            Thread.sleep(1000);
            System.out.println("Address field is visible :" + address.isDisplayed());
            address.sendKeys(add);
            Thread.sleep(1000);
            System.out.println("Reference field is visible :" + ref.isDisplayed());
            ref.click();
            Thread.sleep(1000);
            System.out.println("Reference option field is visible :" + referenceOption.isDisplayed());
            referenceOption.click();
            Thread.sleep(1000);
            System.out.println("Purpose field is visible :" + purpose.isDisplayed());
            purpose.sendKeys(pur);
            Thread.sleep(1000);
            System.out.println("Select then appointment slot is visible :" + appointmentTime.isDisplayed());
            Thread.sleep(1000);
            appointmentTime.sendKeys(time);
            Thread.sleep(1000);
            okbtn.click();
            Thread.sleep(1000);
            System.out.println("Notes field is visible :" + notes.isDisplayed());
            notes.sendKeys(not);
            Thread.sleep(1000);
            System.out.println("Submit button in appointment modal is visible :" + subApp.isDisplayed());
            subApp.submit();
            Thread.sleep(1000);
        }
        else{

        }
    }

    public void updateAppointment(String update) throws InterruptedException {
        System.out.println("Update appointment functionality to be implemented");
        Thread.sleep(1000);
        System.out.println("Purpose field is visible : "+purposeClk.isDisplayed());
        Thread.sleep(1000);
        purposeClk.click();
        Thread.sleep(1000);
        purpose.clear();
        Thread.sleep(1000);
        purpose.sendKeys(update);
        Thread.sleep(1000);
        subApp.click();
    }

    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    public void enterMobileNumber(String mob) throws InterruptedException {
        WebElement element = driver.findElement(By.id("phone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        element.sendKeys(mob);
    }

    public void enterClientName(String client) throws InterruptedException {
        WebElement element = driver.findElement(By.id("clientName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        element.sendKeys(client);
    }

    public void enterAddress(String address) throws InterruptedException {
        WebElement element = driver.findElement(By.id("address"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(address);
    }


    public void selectReference() throws InterruptedException {
        ref.click();
        Thread.sleep(500);
        referenceOption.click();
    }

    public void enterPurpose(String purpose) throws InterruptedException {
        WebElement element = driver.findElement(By.id("purpose"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(purpose);
    }


    public void enterDeliveryDate(String deliveryDate) throws InterruptedException {
        WebElement element = driver.findElement(By.id("appointmentTime"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(deliveryDate);
        Thread.sleep(500);
        okbtn.click();
    }

    public void clickSubmit() {
        subApp.submit();
    }

    public void clickModule() throws InterruptedException {
        scheduleApp.click();
    }
}