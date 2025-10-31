package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckAvailabilityPage extends BasePage{

    public CheckAvailabilityPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//span[text()=' Check Availability']")
    WebElement checkmodbtn;

    @FindBy(name = "deliveryDate")
    WebElement deliveryDate;

    @FindBy(name = "tasks.0.roleId")
    WebElement dropdown0;

    @FindBy(xpath = "//option[text()='Cutting ']")
    WebElement task0;

    @FindBy(name = "tasks.0.estimatedTimeInMinutes")
    WebElement estimation0;

    @FindBy(name = "tasks.0.priority")
    WebElement priority0;

    @FindBy(xpath = "//button[text()='Add Task']")
    WebElement addTask;

    @FindBy(name = "tasks.1.roleId")
    WebElement dropdown1;

    @FindBy(xpath = "//option[text()='Stitching']")
    WebElement task1;

    @FindBy(name = "tasks.1.estimatedTimeInMinutes")
    WebElement estimation1;

    @FindBy(name = "tasks.1.priority")
    WebElement priority1;

    @FindBy(xpath = "//option[text()='Embroiding']")
    WebElement task2;

    @FindBy(name = "tasks.2.estimatedTimeInMinutes")
    WebElement estimation2;

    @FindBy(name = "tasks.2.priority")
    WebElement priority2;

    @FindBy(xpath = "//button[text()='Check Availability']")
    WebElement checkbtn;


    public void modAndDate(String date) throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Module for CAT :"+checkmodbtn.isDisplayed()); //-->sep
        checkmodbtn.click();
        System.out.println("Delivery date is visible :"+deliveryDate.isDisplayed());
        deliveryDate.sendKeys(date);
    }

  /*  public void toCheck(String dropdown,String task,String es,String pri) throws InterruptedException {

        int c=1;
        WebElement dropdowns = driver.findElement(By.name("tasks."+dropdown+".roleId"));
        System.out.println("dropdowns in task:"+dropdowns.isDisplayed());
        dropdowns.click();                                                                        //"//td[text()='" + role + "']"
        Thread.sleep(1000);

        WebElement tsk = driver.findElement(By.xpath("//option[text()='"+task+"']"));
        System.out.println("task name :"+tsk.getText());
        Thread.sleep(1000);
        tsk.click();
        Thread.sleep(1000);

        WebElement est = driver.findElement(By.name("tasks."+es+".estimatedTimeInMinutes"));
        est.sendKeys(es+1);
        Thread.sleep(1000);

        WebElement prio = driver.findElement(By.name("tasks."+pri+".priority"));
        prio.sendKeys(pri+1);
        Thread.sleep(1000);

        if(c<=1) {
            addTask.click();
            c++;
        }

    }*/

    public void fillTask(String index, String taskName, String est, String pri) {
        // Role dropdown
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement roleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("tasks." + index + ".roleId")));
        roleDropdown.click();

        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//option[text()='" + taskName + "']")));
        roleOption.click();

        // Estimated time
        WebElement estInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("tasks." + index + ".estimatedTimeInMinutes")));
        estInput.sendKeys(est);

        // Priority
        WebElement priInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("tasks." + index + ".priority")));
        priInput.sendKeys(pri);
    }

    public void clickAddTask() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addTask)).click();
    }


   /* public void toCheck1(String es,String prio) throws InterruptedException {
        System.out.println("2nd task:"+dropdown1.getText());
        dropdown1.click();
        Thread.sleep(1000);
        task1.click();
        Thread.sleep(1000);
        estimation1.sendKeys(es);
        Thread.sleep(1000);
        priority1.sendKeys(prio);
    }*/

    public void close() throws InterruptedException {
        System.out.println("Check button :"+checkbtn.isDisplayed());  //-->sep
        Thread.sleep(1000);
        checkbtn.submit();
        System.out.println(checkbtn.isSelected());
        System.out.println("Completed");
    }

}