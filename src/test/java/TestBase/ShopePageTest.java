package TestBase;

import PageObjects.BoutiquePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.time.Duration;

public class ShopePageTest extends BaseClass {


    @Test(priority = 1)
    public void verifyNameField(){
        boolean name = driver.findElement(By.id("boutique_name")).isDisplayed();
        System.out.println("Verify name field :"+name);
    }

    @Test(priority = 2)
    public void verifyLegalName(){
        boolean legalName = driver.findElement(By.id("boutique_legalName")).isDisplayed();
        System.out.println("Verify legalName :"+legalName);
    }

    @Test(priority = 3)
    public void displayName(){
        boolean displayName = driver.findElement(By.id("boutique_nickName")).isDisplayed();
        System.out.println("Verify nick name :"+displayName);
    }

    @Test(priority = 4)
    public void gstNumber(){
        boolean gstNumber = driver.findElement(By.id("boutique_gstNumber")).isDisplayed();
        System.out.println("Verify GST number :"+gstNumber);
    }

    @Test(priority = 5)
    public void timeZone(){
        boolean timeZone = driver.findElement(By.xpath("//span[text()='Asia/Calcutta']")).isDisplayed();
        System.out.println("Verify timeZone field :"+timeZone);
    }

    @Test(priority = 6)
    public void boutiqueHours(){
        boolean workingHours = driver.findElement(By.id("boutique_businessHours")).isDisplayed();
        System.out.println("Verify working hours :"+workingHours);
    }

    @Test(priority = 7)
    public void shopNumber(){
        boolean shopNum = driver.findElement(By.id("boutique_shopNumber")).isDisplayed();
        System.out.println("Verify shopNumber field :"+shopNum);
    }

    @Test(priority = 8)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("boutique_address")).isDisplayed();
        System.out.println("Verify Address field :"+address);
    }

    @Test(priority = 9)
    public void verifyCity(){
        boolean city = driver.findElement(By.id("boutique_city")).isDisplayed();
        System.out.println("Verify city field :"+city);
    }

    @Test(priority = 10)
    public void verifyState(){
        boolean state = driver.findElement(By.xpath("//span[text()='Tamil Nadu']")).isDisplayed();
        System.out.println("Verify state field :"+state);
    }

    @Test(priority = 11)
    public void verifyPinCode(){
        boolean pincode = driver.findElement(By.id("boutique_pincode")).isDisplayed();
        System.out.println("Verify pincode field :"+pincode);
    }

    @Test(priority = 12)
    public void verifyMobileNum(){
        boolean mobile = driver.findElement(By.id("boutique_phone")).isDisplayed();
        System.out.println("Verify mobile number field :"+mobile);
    }

    @Test(priority = 13)
    public void verifyAllShopFields() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterShopName("The Atelier Edi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterLegalName("Looms");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterNickName("Maison");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.enterGst("HDJH373893HD");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       bm.address("G-8","1/321,chennai","Chennai","Tamilnadu","636 012","7483947383");
        bm.nextInB();
    }
}