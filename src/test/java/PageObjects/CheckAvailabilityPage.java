package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckAvailabilityPage extends BasePage{

    public CheckAvailabilityPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()=' Check Availability']")
    WebElement checkmodbtn;

    @FindBy(id = "tasks_0_taskTypeId")
    WebElement taskType;

    @FindBy(xpath = "//div[text()='CkUpE']")
    WebElement selecttask;

    @FindBy(id = "tasks_0_estimatedTimeInHours")
    WebElement estTime;

    @FindBy(id = "deliveryDate")
    WebElement deliverydate;

    @FindBy(id = "tasks_0_priority")
    WebElement priority;

    @FindBy(xpath = "//span[text()='Check Availability']")
    WebElement getCheckbtn;


    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    public void modAndDate(String estimation,String prio) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        Thread.sleep(1000);
        System.out.println("Check Availability Button is displayed:"+checkmodbtn.isDisplayed());
        Thread.sleep(1000);
        checkmodbtn.click();
        Thread.sleep(1000);
        System.out.println("Delivery date widget is displayed:"+deliverydate.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Task type field is displayed :"+taskType.isDisplayed()); //-->sep
        Thread.sleep(1000);
        taskType.click();
        Thread.sleep(1000);
        System.out.println("Selecting task type is displayed:"+selecttask.isDisplayed());
        selecttask.click();
        Thread.sleep(1000);
        System.out.println("Estimation time field is visible :"+estTime.isDisplayed());
        estTime.click();
        Thread.sleep(1000);
        estTime.sendKeys(estimation);
        System.out.println("Priority field is visible :"+priority.isDisplayed());
        Thread.sleep(1000);
        priority.click();
        Thread.sleep(1000);
        priority.sendKeys(prio);
    }

    public void close() throws InterruptedException {
        System.out.println("Check button :"+getCheckbtn.isDisplayed());  //-->sep
        Thread.sleep(1000);
        getCheckbtn.submit();
        System.out.println(getCheckbtn.isSelected());
        System.out.println("Completed");
    }

    public void setDeliveryDate(String date) {
        WebElement el = driver.findElement(By.id("deliverydate"));
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
        el.sendKeys(date);
    }

    public void selectTaskType() {
        taskType.click();
        selecttask.click();
    }

    public void enterEstimation(String estimation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By locator = By.id("tasks_0_estimatedTimeInHours");

        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));


        try {
            el.click();

            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);

        } catch (StaleElementReferenceException e) {
            el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);
        }

        el.sendKeys(estimation);
        el.sendKeys(Keys.TAB);
    }

    public void enterPriority(String priority) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By locator = By.id("tasks_0_priority");

        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            el.click();

            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);

        } catch (StaleElementReferenceException e) {
            el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);
        }
        el.sendKeys(priority);

        el.sendKeys(Keys.TAB);
    }

    public void clickCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("tasks_0_isSplitable"));
        Thread.sleep(1000);
        checkbox.click();
    }

    public void employeeInvolved(String employeeInvolved){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By locator = By.id("tasks_0_employeesInvolved");

        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            el.click();

            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);

        } catch (StaleElementReferenceException e) {
            el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
            el.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            el.sendKeys(Keys.DELETE);
        }

        el.sendKeys(employeeInvolved);

        el.sendKeys(Keys.TAB);
    }

    public void clickCheckAvailability(){
       getCheckbtn.click();
    }

    public void clickModule() {
        checkmodbtn.click();
    }
}