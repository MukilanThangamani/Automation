package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoutiquePage extends BasePage {

    public BoutiquePage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(xpath = "//label[text()='Time Zone']")
    WebElement timeZone;

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

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'MuiButton-containedPrimary')]")
    WebElement sub;


    // Actions

    public void clickAddBoutique() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("(//button[contains(., 'View Details')])[32]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

        button.click();
    }

    public void setName(String name) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_name"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(name);
    }

    public void setLegalName(String legal) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_legalName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(legal);
    }

    public void setDisplayName(String nick) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_nickName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(nick);
    }

    public void setGst(String gst) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_gstNumber"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(gst);
    }

    public void setShopNumber(String shopNum) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_shopNumber"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(shopNum);
    }

    public void setAddress(String addr) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_address"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(addr);
    }

    public void setCity(String city) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_city"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(city);
    }

    public void setPincode(String pincode) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_pincode"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(pincode);
    }

    public void setMobileNum(String mobile) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_phone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(mobile);
    }


    public void nextInB(){

        WebDriverWait wa = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement nextButton = wa.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Next']")
        ));
        System.out.println("Next button is visible in boutique page :"+nextButton.isDisplayed());
        nextButton.click();
    }


    public void clickSubmit() {
        WebElement submit = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']"));
        submit.click();
    }



}