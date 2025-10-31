package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoutiquePage extends BasePage {

    public BoutiquePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    //--> //div[text()='Add boutique details']
    //-->"//div[normalize-space(text())='Ellie']/ancestor::div[contains(@class,'MuiPaper-root')]//button[normalize-space()='View Details']"
    // @FindBy(xpath = "//div[text()='Add boutique details']")
    //  WebElement ClkPlus;

    @FindBy(xpath = "(//button[contains(., 'View Details')])[32]")
    WebElement ClkPlus;

    @FindBy(id = "boutique_name")
    WebElement shopname;

    @FindBy(id = "boutique_legalName")
    WebElement legalname;

    @FindBy(id = "boutique_nickName")
    WebElement nickname;

    @FindBy(id = "boutique_gstNumber")
    WebElement gstNUmber;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/section/div/div/main/section/div[3]/form/div[1]/div/div[5]/div/div[1]/div[2]/div[1]/div/div/div")
    WebElement leaveDays;

    @FindBy(xpath = "//div[@aria-controls=':r1b:']")
    WebElement drop;

    @FindBy(xpath = "//li[@data-value='Sunday']")
    WebElement sun;

    @FindBy(xpath = "//li[@data-value='Saturday']")
    WebElement sat;

    @FindBy(id = "boutique_businessHoursStart")
    WebElement starttime;

    @FindBy(id = "boutique_businessHoursEnd")
    WebElement entime;

    @FindBy(id = "boutique_intervalStart")
    WebElement intervalStrttime;

    @FindBy(id = "boutique_intervalEnd")
    WebElement intervalEndttime;

    @FindBy(id = "boutique_shopNumber")
    WebElement shopNum;

    @FindBy(id = "boutique_address")
    WebElement addr;

    @FindBy(id = "boutique_landmark")
    WebElement land;

    @FindBy(id = "boutique_city")
    WebElement city;

    @FindBy(id = "boutique_stateCode")
    WebElement state;

    @FindBy(id = "boutique_pincode")
    WebElement pin;

    @FindBy(xpath = "//input[@class='PhoneInputInput']")
    WebElement mobile;

    @FindBy(xpath = "//option[@value='22']")
    WebElement st;

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'MuiButton-containedPrimary')]")
    WebElement sub; //

    @FindBy(xpath = "//div[normalize-space(text())='Blush The']/ancestor::div[contains(@class,'MuiPaper-root')]//button[normalize-space()='View Details'")
    WebElement viewDet;

    // @FindBy(xpath = "//button[text()='Next']")
    // WebElement nxt;   //div[normalize-space(text())='Neonpixel']/ancestor::div[contains(@class,'MuiPaper-root')]//button[normalize-space()='View Details'

    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));


    @FindBy(xpath = "//button[text()='Add Roles']")
    WebElement addRole;

    @FindBy(xpath = "//input[@name='roleName']")
    WebElement rolname;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement rolsubnit;

    // Actions
    public void clickAddBoutique()  {
        System.out.println("Boutique is visible :"+ClkPlus.isDisplayed());
        ClkPlus.click();
    }

    public void enterShopName(String shop) throws InterruptedException {
        System.out.println("** In Shop detail Page  ** ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("shop is displayed :"+shopname.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(1200);
        // shopname.clear();
        Thread.sleep(1000);
     //   shopname.sendKeys(shop);   //->Rem
    }

    public void enterLegalName(String legal) throws InterruptedException {
        System.out.println("Legal name is displayed :"+legalname.isDisplayed());
        //  legalname.clear();
        Thread.sleep(1000);
   //     legalname.sendKeys(legal);  //->Rem
        Thread.sleep(1000);
    }

    public void enterNickName(String nick) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        System.out.println("Nickname field is displayed :"+nickname.isDisplayed());
        //  nickname.clear();
        //   nickname.sendKeys(nick);
    }

    public void enterGst(String gstnum) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("GstNumber field is displayed :"+gstNUmber.isDisplayed());
       // System.out.println("Leave days field is displayed :"+leaveDays.isDisplayed());
        //   gstNUmber.clear();
        //->Rem   gstNUmber.sendKeys(gstnum);
    }

    public void address(String shopnum, String address, String landmark, String cities, String pincode, String mobileNum) throws InterruptedException {
        System.out.println("Start time is displayed : "+starttime.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("End time is displayed :"+entime.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Interval start time is displayed :"+intervalStrttime.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Interval end time is displayed :"+intervalEndttime.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("ShopNUmber field is visible :"+shopNum.isDisplayed());
        //    shopNum.clear();
        //    shopNum.sendKeys(shopnum);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("ShopAddress field is visible :"+addr.isDisplayed());
        //   addr.clear();
        Thread.sleep(1000);
        //  addr.sendKeys(address);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("ShopLandmark field is visible :"+land.isDisplayed());
        //    land.clear();
        Thread.sleep(1000);
        //  land.sendKeys(landmark);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("ShopCity field is visible :"+city.isDisplayed());
        //    city.clear();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("State field is displayed :"+state.isDisplayed());
        //      city.sendKeys(cities);
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("ShopPin field is visible :"+pin.isDisplayed());
        //    pin.clear();
        Thread.sleep(1000);
        //      pin.sendKeys(pincode);
        Thread.sleep(1000);
        System.out.println("ShopMobileNumber field is visible :"+mobile.isDisplayed());
        //   mobile.clear();
        Thread.sleep(1000);
        //     mobile.sendKeys(mobileNum);
        Thread.sleep(500);
    }

    public WebElement getStartTimeField() {
        return driver.findElement(By.xpath("//label[contains(text(),'Shop Working Hours')]/following-sibling::div//input[@type='time'][1]"));
    }

    public WebElement getEndTimeField() {
        return driver.findElement(By.xpath("//label[contains(text(),'Shop Working Hours')]/following-sibling::div//input[@type='time'][2]"));
    }

    public void setTime(WebElement timeField, String timeValue) {
        timeField.clear();  // Clear existing time
        timeField.sendKeys(timeValue);  // Set new time
    }

 /*   public void fillShopTimings(String startTime, String endTime) {
        WebElement start = getStartTimeField();
        WebElement end = getEndTimeField();

        setTime(start, startTime);
        setTime(end, endTime);
    }*/

    public void nxt() {
        try {
            // Wait for and click the Submit button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Submit button visible: " + sub.isDisplayed());
            //   sub.click();

            // Log current URL after clicking submit
            System.out.println("Current URL after submit: " + driver.getCurrentUrl());

            // Navigate back and refresh
            //  driver.navigate().back();
            //  driver.navigate().refresh();

            System.out.println("Current URL after refresh: " + driver.getCurrentUrl());

            // Wait until 'View Details' button is visible for product "Blush Theo"
            WebElement viewDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[normalize-space(text())='Maison']/ancestor::div[contains(@class,'MuiPaper-root')]//button[normalize-space()='View Details']")
            ));

            System.out.println("View Detail button is displayed: " + viewDetail.isDisplayed());
            //   viewDetail.click();

            // Log the URL after clicking 'View Details'
            //    System.out.println("Current URL after clicking 'View Details': " + driver.getCurrentUrl());

            // Wait for and click the 'Next' button
            WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[normalize-space()='Next']")
            ));
            nextButton.click();

        }
        catch (Exception e) {
            System.out.println("Exception occurred in nxt(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void nextInB(){

        WebDriverWait wa = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement nextButton = wa.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Next']")
        ));
        System.out.println("Next button is visible in boutique page :"+nextButton.isDisplayed());
        nextButton.click();
    }

}