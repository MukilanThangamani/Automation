package TestBase;

import PageObjects.RolePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RolePageTest extends BaseClass {

    @Test
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);
    }

    @Test(priority = 1)
    public void verifyAddRole(){
        boolean addRole = driver.findElement(By.xpath("//span[text()='Add Role']")).isDisplayed();
        System.out.println("Verify addRole button is displayed :"+addRole);
    }

    @Test(priority = 2)
    public void add() throws InterruptedException {
        RolePage rp = new RolePage(driver);
        String role = randomString();
        rp.add(role);
    }

    @Test(priority = 3)
    public void verifyAddTask(){
        boolean addTask = driver.findElement(By.xpath("//span[text()='+ Add Task']")).isDisplayed();
        System.out.println("Verifying addTask button is displayed :"+addTask);
    }

    @Test(priority = 4)
    public void verifyTaskNamefield(){
        boolean taskName = driver.findElement(By.id("roles_tasks_0_taskName")).isDisplayed();
        System.out.println("Verifying taskName is displayed :"+taskName);
    }

    @Test(priority = 5)
    public void verifyChargeField(){
        boolean chargeField = driver.findElement(By.id("roles_tasks_0_chargesPerHour")).isDisplayed();
        System.out.println("Verifying charge field is displayed :"+chargeField);
    }

    @Test(priority = 6)
    public void verifySubmit(){
        boolean submitBtn = driver.findElement(By.xpath("//span[text()='Submit']")).isDisplayed();
        System.out.println("Verifying submit button is displayed :"+submitBtn);
    }

    @Test(priority = 7)
    public void verifyClose(){
        boolean closeBtn = driver.findElement(By.xpath("//span[text()='Close']")).isDisplayed();
        System.out.println("Verifying close button is displayed :"+closeBtn);
    }

    @Test(priority = 8)
    public void addTaskAndCharge() throws InterruptedException {
        RolePage rp1 = new RolePage(driver);
        String task = randomString();
        String chrg = randomLength();
        rp1.addTask1(task,chrg);
    }

    @Test(priority = 9)
    public void submit(){
        RolePage rp2 = new RolePage(driver);
        rp2.submit();
    }

    @Test(priority = 10)
    public void verifyNextBtn(){
        boolean next = driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed();
        System.out.println("Verifying next button is displayed :"+next);
    }

    @Test(priority = 11)
    public void emptyRoleTest() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);
        rp2.clickAddRole();
        rp2.enterRole("");
        rp2.enterTask(randomString());
        rp2.enterCharge(randomString());
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Role is required']")));
        Assert.assertTrue(toast.getText().contains("Role is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void emptyTaskName() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask("");
        rp2.enterCharge(randomString());
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Task Name is required']")));
        Assert.assertTrue(toast.getText().contains("Task Name is required"), "Error message not displayed");
    }

    @Test(priority = 13)
    public void emptyChargeTest() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Charges per hour is required']")));
        Assert.assertTrue(toast.getText().contains("Charges per hour is required"), "Error message not displayed");
    }

    @Test(priority = 14)
    public void invalidChargeTest() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("fgh");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Numbers only allowed']")));
        Assert.assertTrue(toast.getText().contains("Numbers only allowed"), "Error message not displayed");
    }

    @Test(priority = 15)
    public void validTest() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("120");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Role added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Role added successfully!"), "Error message not displayed");
    }

    @Test(priority = 16)
    public void emptyBufferTime() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);
        rp2.clickAddRole();
        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("120");
        rp2.clickCheckBox();
        rp2.bufferTime("");
        rp2.bufferRush("2");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter Buffer time for Idle']")));
        Assert.assertTrue(toast.getText().contains("Please enter Buffer time for Idle"), "Error message not displayed");
    }

    @Test(priority = 17)
    public void emptyRushTime() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("120");
        rp2.bufferTime("2");
        rp2.bufferRush("");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter Buffer time for Rush']")));
        Assert.assertTrue(toast.getText().contains("Please enter Buffer time for Rush"), "Error message not displayed");
    }

    @Test(priority = 18)
    public void validBufferTime() throws InterruptedException {
        RolePage rp2 = new RolePage(driver);

        rp2.enterRole(randomString());
        rp2.enterTask(randomString());
        rp2.enterCharge("120");
        rp2.bufferTime("2");
        rp2.bufferRush("2");
        rp2.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Role added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Role added successfully!"), "Error message not displayed");
    }

    @Test(priority = 19)
    public void nextPage() throws InterruptedException {
        RolePage rp3 = new RolePage(driver);
        rp3.moveToNextPage();
    }

}