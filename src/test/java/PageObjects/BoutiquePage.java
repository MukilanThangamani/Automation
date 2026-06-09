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

    @FindBy(xpath = "//span[normalize-space(text())='Plan Name']")
    WebElement planname;

    @FindBy(xpath = "//span[normalize-space(text())='Status']")
    WebElement status;

    @FindBy(xpath = "//span[normalize-space(text())='Billing Cycle']")
    WebElement billingcycle;

    @FindBy(xpath = "(//span[@class='anticon anticon-plus'])[1]")
    WebElement addCrm;

    @FindBy(id = "CustomField_stepKey")
    WebElement dropdownStep;

    @FindBy(xpath = "//div[normalize-space(text())='Client Details']")
    WebElement chooseStep;

    @FindBy(id = "CustomField_fieldType")
    WebElement dropdownType;

    @FindBy(xpath = "//div[normalize-space(text())='Text']")
    WebElement chooseType;

    @FindBy(xpath = "//span[normalize-space(text())='Create']")
    WebElement createBtn;

    @FindBy(xpath = "//span[normalize-space(text())='Cancel']")
    WebElement cancelBtn;


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

    public void verifySubcription() {
        WebElement planDetail = driver.findElement(By.xpath("//h3[normalize-space(text())='Plan Details']"));
        planDetail.click();
        System.out.println("Plan name :"+planname.isDisplayed());
        System.out.println("status name :"+status.isDisplayed());
        System.out.println("Billing cycle  name :"+billingcycle.isDisplayed());
    }

    public void clickOnShop() {
        WebElement generalSettings = driver.findElement(By.xpath("//h3[normalize-space(text())='General Settings']"));
        generalSettings.click();
    }

    public void clickOnCustom() {
        WebElement customsettings = driver.findElement(By.xpath("//h3[normalize-space(text())='Custom Settings']"));
        customsettings.click();
    }


    public void clickOnCrm() {
      addCrm.click();
    }

    public void enterFieldName(String fieldname) throws InterruptedException {
        WebElement element = driver.findElement(By.id("CustomField_fieldLabel"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(fieldname);
    }

    public void selectStep() throws InterruptedException {
        dropdownStep.click();
        Thread.sleep(500);
        chooseStep.click();
    }

    public void selectType() throws InterruptedException {
      dropdownType.click();
      Thread.sleep(500);
      chooseType.click();
    }

    public void clickCreate() {
        createBtn.click();
    }

    public void clickClose() {
        cancelBtn.click();
    }
}