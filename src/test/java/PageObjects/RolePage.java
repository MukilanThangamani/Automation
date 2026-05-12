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

    public void moveToNextPage() throws InterruptedException {
        System.out.println("Role page tested ** ");
        Thread.sleep(1000);
        System.out.println("In next button in role page ");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nxtEmp);
    }

}