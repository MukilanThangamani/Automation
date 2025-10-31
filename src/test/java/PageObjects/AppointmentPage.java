package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentPage extends BasePage {

    public AppointmentPage(WebDriver driver){
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//span[text()='Appointments']")
    WebElement appmodule;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/section/div/header/div/div[3]/button")
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

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subApp;

    @FindBy(xpath = "//div[text()='Style consultation']")
    WebElement purposeClk;

    @FindBy(xpath = "//span[text()='Close']")
    WebElement closebtn;

    //Actions
    public void clientDetails(String num,String cname,String add,String pur,String time,String not) throws InterruptedException {
        System.out.println("Appointment module button is displayed :"+appmodule.isDisplayed());
        appmodule.click();
        Thread.sleep(1000);
          scheduleApp.click();
          Thread.sleep(1000);
        System.out.println("Phone number field is visible :"+phoneNUmber.isDisplayed());
        phoneNUmber.sendKeys(num);
        Thread.sleep(1000);
        System.out.println("Client name field is visible :"+clientName.isDisplayed());
        clientName.sendKeys(cname);
        Thread.sleep(1000);
        System.out.println("Address field is visible :"+address.isDisplayed());
        address.sendKeys(add);
        Thread.sleep(1000);
        System.out.println("Reference field is visible :"+ref.isDisplayed());
        ref.click();
        Thread.sleep(1000);
        System.out.println("Reference option field is visible :"+referenceOption.isDisplayed());
        referenceOption.click();
        Thread.sleep(1000);
        System.out.println("Purpose field is visible :"+purpose.isDisplayed());
        purpose.sendKeys(pur);
        Thread.sleep(1000);
        System.out.println("Select then appointment slot is visible :"+appointmentTime.isDisplayed());
        Thread.sleep(1000);
        appointmentTime.sendKeys(time);
        Thread.sleep(1000);
        okbtn.click();
        Thread.sleep(1000);
        System.out.println("Notes field is visible :"+notes.isDisplayed());
        notes.sendKeys(not);
        Thread.sleep(1000);
        System.out.println("Submit button in appointment modal is visible :"+subApp.isDisplayed());
        subApp.submit();
        System.out.println("close button in appointment modal is visible :"+closebtn.isDisplayed());
        //  closebtn.click();
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

}