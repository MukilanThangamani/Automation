package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class RolePage extends BasePage {

    public RolePage(WebDriver driver) {
        super(driver);
    }

    // Locators  //span[text()='Add Role']
    @FindBy(xpath = "//span[text()='Add Role']")
    WebElement addRole;

    @FindBy(id = "roles_roleName")
    WebElement rolename;

    @FindBy(id = "roles_tasks_0_taskName")
    WebElement task;

    @FindBy(id = "roles_tasks_0_chargesPerHour")
    WebElement charge;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement rolesubmit;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nxtEmp;

    @FindBy(id = "roles_tasks_0_isBufferRequired")
    WebElement checkbox;

    public void add(String roleName) throws InterruptedException {
        addRole.click();
        Thread.sleep(1000);
        rolesubmit.click();
        Thread.sleep(1000);
        rolename.sendKeys(roleName);
        Thread.sleep(1000);
    }

    public void addTask1(String tsk, String chrg) throws InterruptedException {
        task.sendKeys(tsk);
        Thread.sleep(1000);
        charge.sendKeys(chrg);
        Thread.sleep(1000);
    }

    public void submit() {
        rolesubmit.submit();
    }

    public void clickAddRole() {
        addRole.click();
    }

    public void enterRole(String s) throws InterruptedException {
        WebElement element = driver.findElement(By.id("roles_roleName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(s);
    }

    public void enterTask(String task) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//label[normalize-space(text())='Task Name']/following::input)[1]"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(task);
    }

    public void enterCharge(String charge) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//label[normalize-space(text())='Charges / Hour']/following::input)[1]"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(charge);
    }

    public void clickCheckBox() {
      checkbox.click();
    }

    public void bufferTime(String buffer) throws InterruptedException {
        WebElement element = driver.findElement(By.id("roles_tasks_0_bufferTime"));
        element.click();
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(buffer);
    }

    public void bufferRush(String rush) throws InterruptedException {
        WebElement element = driver.findElement(By.id("roles_tasks_0_bufferTimeForRush"));
        element.click();
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);
        Thread.sleep(500);
        element.sendKeys(rush);
    }

    public void moveToNextPage() throws InterruptedException {
        System.out.println("Role page tested ** ");
        Thread.sleep(1000);
        System.out.println("In next button in role page ");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nxtEmp);
    }

}