package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TaskSettingPage extends BasePage{

    public TaskSettingPage(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(xpath = "//span[text()='Add Task']")
    public WebElement addTask;

    @FindBy(id = "taskForm_taskName")
    WebElement tskname;

    @FindBy(id = "taskForm_chargesPerHour")
    WebElement chrg;

    @FindBy(id="taskForm_roleId")
    WebElement role;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subTask;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement taskInNxt;

    @FindBy(xpath = "//span[text()='Close']" )
    WebElement close;

    //Action
    public void setAddTask(String taskname,String charge,String rle) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        System.out.println("Task btn is displayed or not :" + addTask.isDisplayed());
        Thread.sleep(1000);
        addTask.click();
        System.out.println("Task name field :" + tskname.isDisplayed());
        Thread.sleep(1000);
        tskname.sendKeys(taskname);
        System.out.println("Task charge field :" + chrg.isDisplayed());
        Thread.sleep(1000);
        chrg.sendKeys(charge);
        Thread.sleep(1000);
        role.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        List<WebElement> roleOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div")));

        Random random = new Random();
        int randomIndex = random.nextInt(roleOptions.size());
        WebElement selectRole = roleOptions.get(randomIndex);
        selectRole.click();

        Thread.sleep(1000);
        System.out.println("Task submit is visible :" + subTask.isDisplayed());
        Thread.sleep(1000);
        subTask.click();

    }

    public void printDuplicateTaskErrorMessage() {
        By errorMessage = By.xpath("//*[contains(text(), 'already exists') or contains(text(), 'duplicate')]");

        By closeButton = By.xpath("//button[text()='Close' or text()='CLOSE']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        try {

            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            String duplicateMessage = error.getText();
            System.out.println("⚠ Duplicate Task Error Message captured: " + duplicateMessage);

            boolean isDuplicate = duplicateMessage.toLowerCase().contains("exists")
                    || duplicateMessage.toLowerCase().contains("duplicate");

            softAssert.assertTrue(isDuplicate,
                    "Expected duplicate error message not shown! Found: " + duplicateMessage);

            try {
                // WebElement closeBtn = driver.findElement(closeButton);
                close.click();
                System.out.println(" Task modal closed.");
            } catch (NoSuchElementException nse) {
                System.out.println("ℹ Close button not found. Maybe it was a toast notification.");
            }

        } catch (TimeoutException te) {
            System.out.println("No duplicate task error message displayed within wait time.");
            softAssert.fail("Duplicate error message not displayed.");
        } catch (Exception e) {
            System.out.println(" Unexpected error while checking duplicate task message.");
            e.printStackTrace();
            softAssert.fail("Unexpected exception: " + e.getMessage());
        }

        softAssert.assertAll();
    }

    public void verifyTasksInTable(String[] taskNames, String[] charges) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < taskNames.length; i++) {
            String expectedTask = taskNames[i];
            String expectedCharge = charges[i];
            try {
                String xpath = "//td[normalize-space(text())='" + expectedTask + "']/following-sibling::td[1]";
                WebElement chargeCell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                String actualCharge = chargeCell.getText().trim().replace("₹", "").trim();

                if (expectedCharge.equals(actualCharge)) {
                    System.out.println("Task '" + expectedTask + "' with charge '" + expectedCharge + "' found in table.");
                } else {
                    System.out.println("Task '" + expectedTask + "' found but charge mismatch. Expected: '" + expectedCharge + "', Found: '" + actualCharge + "'");
                }
            } catch (Exception e) {
                System.out.println("Task '" + expectedTask + "' not found in table. Continuing to next task...");
            }
        }
    }

    public void addTask(String task, String chrge,String taskrole) throws InterruptedException {
        System.out.println("In duplicate for task setting..");
        addTask.click();
        tskname.sendKeys(task);
        chrg.sendKeys(chrge);
        role.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        List<WebElement> roleOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div")));

        Random random = new Random();
        int randomIndex = random.nextInt(roleOptions.size());
        WebElement selectRole = roleOptions.get(randomIndex);
        selectRole.click();

        Thread.sleep(1000);
        subTask.click();
    }

    public void nextInTask() throws InterruptedException {
        System.out.println("next button is displayed in task settings :"+taskInNxt.isDisplayed());
        Thread.sleep(2000);
        taskInNxt.click();
    }

}