package TestBase;

import PageObjects.BoutiquePage;
import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void verifyWhatsappNum(){
        boolean whatsapp = driver.findElement(By.id("boutique_whatsappPhone")).isDisplayed();
        System.out.println("Verify whatsapp number field :"+whatsapp);
    }

    @Test(priority = 14)
    public void emptyBoutiqueName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        TestListener.test.get().pass("Shop Details :");
//        bm.enterShopName("The Atelier Edi");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        bm.enterLegalName("Looms");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        bm.enterNickName("Maison");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        bm.enterGst("HDJH373893HD");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        bm.address("G-8","1/321,chennai","Chennai","Tamilnadu","636 012","7483947383");
        bm.setName("");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Name is required']")));
        Assert.assertTrue(toast.getText().contains("Name is required"), "Error message not displayed");

    }

    @Test(priority = 15)
    public void emptyLegalName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Legal Name is required']")));
        Assert.assertTrue(toast.getText().contains("Legal Name is required"), "Error message not displayed");

    }

    @Test(priority = 16)
    public void emptyDisplayName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Nick Name is required']")));
        Assert.assertTrue(toast.getText().contains("Nick Name is required"), "Error message not displayed");
    }

    @Test(priority = 17)
    public void emptyGSTName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='GST Number is required']")));
        Assert.assertTrue(toast.getText().contains("GST Number is required"), "Error message not displayed");
    }

    @Test(priority = 18)
    public void emptyShopName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Shop Number required']")));
        Assert.assertTrue(toast.getText().contains("Shop Number required"), "Error message not displayed");
    }

    @Test(priority = 19)
    public void emptyAddressName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("");
        bm.setCity("Tamilnadu");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Area, Street, Sector, Village is required']")));
        Assert.assertTrue(toast.getText().contains("Area, Street, Sector, Village is required"), "Error message not displayed");

    }

    @Test(priority = 20)
    public void emptyCityName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("");
        bm.setPincode("636012");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='City is required']")));
        Assert.assertTrue(toast.getText().contains("City is required"), "Error message not displayed");
    }

    @Test(priority = 21)
    public void emptyPINCodeName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='PIN Code is required']")));
        Assert.assertTrue(toast.getText().contains("PIN Code is required"), "Error message not displayed");
    }

    @Test(priority = 22)
    public void invalidCharactersName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("sdf");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Only numbers are allowed']")));
        Assert.assertTrue(toast.getText().contains("Only numbers are allowed"), "Error message not displayed");
    }

    @Test(priority = 23)
    public void emptyMobileNumName() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("848383");
        bm.setMobileNum("");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 24)
    public void invalidMobile() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("848383");
        bm.setMobileNum("8373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");

    }

    @Test(priority = 25)
    public void emptyShopDetail() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("");
        bm.setLegalName("");
        bm.setDisplayName("");
        bm.setGst("");
        bm.setShopNumber("");
        bm.setAddress("");
        bm.setCity("");
        bm.setPincode("");
        bm.setMobileNum("");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='PIN Code is required']")));
        Assert.assertTrue(toast.getText().contains("PIN Code is required"), "Error message not displayed");
    }

    @Test(priority = 26)
    public void validShopDetail() throws InterruptedException {
        BoutiquePage bm = new BoutiquePage(driver);

        bm.setName("The Atelier Edits");
        bm.setLegalName("Looms");
        bm.setDisplayName("Blush Theo");
        bm.setGst("HDJH373893HD");
        bm.setShopNumber("G-8");
        bm.setAddress("1/321,chennai");
        bm.setCity("Tamilnadu");
        bm.setPincode("848383");
        bm.setMobileNum("83737 37373");
        bm.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Boutique updated successfully!']")));
        Assert.assertTrue(toast.getText().contains("Boutique updated successfully!"), "Error message not displayed");

        bm.nextInB();
    }

}