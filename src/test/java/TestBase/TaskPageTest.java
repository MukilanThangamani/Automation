package TestBase;

import PageObjects.TaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TaskPageTest extends BaseClass {

    @Test(priority = 1)
    public void testTaskSettings() throws InterruptedException {
         TaskPage tp = new TaskPage(driver);
         tp.moduleClick();
    }

    @Test(priority = 2)
    public void verifyTaskHeading(){
        boolean task = driver.findElement(By.xpath("//h2[normalize-space(text())='Tasks']")).isDisplayed();
        System.out.println("Task heading is displayed :"+task);
    }

    @Test(priority = 3)
    public void verifyTodaysTask(){
        boolean todays = driver.findElement(By.xpath("(//div[@aria-selected='true'])[1]")).isDisplayed();
        System.out.println("Todays task is visible :"+todays);
    }

    @Test(priority = 4)
    public void verifyTaskHeader(){
        boolean taskHeader = driver.findElement(By.xpath("//th[normalize-space(text())='Task']")).isDisplayed();
        System.out.println("Task heading is visible :"+taskHeader);
    }

    @Test(priority = 5)
    public void verifyStatus(){
        boolean status = driver.findElement(By.xpath("//th[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Status header is visible :"+status);
    }

    @Test(priority = 6)
    public void verifyAssigned(){
        boolean assigned = driver.findElement(By.xpath("//th[normalize-space(text())='Assigned to']")).isDisplayed();
        System.out.println("Assigned header is visible :"+assigned);
    }

    @Test(priority = 7)
    public void verifyPreviousStatus(){
        boolean previous = driver.findElement(By.xpath("//th[normalize-space(text())='Previous task Status']")).isDisplayed();
        System.out.println("Previous header is visible :"+previous);
    }

    @Test(priority = 8)
    public void verifyEstimation(){
        boolean estimation = driver.findElement(By.xpath("//th[normalize-space(text())='Estimated Time']")).isDisplayed();
        System.out.println("Estimation header is visible :"+estimation);
    }

    @Test(priority = 9)
    public void verifyWorkLoad(){
        boolean workload = driver.findElement(By.xpath("//div[normalize-space(text())='Employee Workload']")).isDisplayed();
        System.out.println("Workload header is visible :"+workload);
    }

    @Test(priority = 10)
    public void verifyCompletedTask(){
        WebElement completed = driver.findElement(By.xpath("//div[@title='Completed Task']"));
        System.out.println("Completed task is visible :"+completed.isDisplayed());
        completed.click();
    }

    @Test(priority = 11)
    public void verifyEmployee(){
        boolean employee = driver.findElement(By.xpath("(//input[@unselectable='on'])[1]")).isDisplayed();
        System.out.println("Verify employee dropdown is visible :"+employee);
    }

    @Test(priority = 12)
    public void verifyTask(){
      boolean task = driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[2]")).isDisplayed();
        System.out.println("Verify task dropdown is visible :"+task);
    }

    @Test(priority = 13)
    public void verifyDate(){
        boolean dateFilter = driver.findElement(By.xpath("//div[contains(@class,'ant-picker ant-picker-range')]")).isDisplayed();
        System.out.println("Verify date filter is visible :"+dateFilter);
    }

}