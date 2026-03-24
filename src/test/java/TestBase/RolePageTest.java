package TestBase;

import PageObjects.RolePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RolePageTest extends BaseClass {

    @Test
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);

//        rp.add(roleName);
//        rp.verifyRoleInTable(roleName);
//        System.out.println(" Role added and verified: " + roleName);
//
//        rp.nextBtn();
//
//        String editRole = randomString();
//        rp.editclick(editRole);
//        System.out.println(" Role edited to: " + editRole);
//
//
//        Thread.sleep(1000);
//        rp.toFindDuplicate("master");
//        System.out.println(" Checked for duplicate role: master");
//
//        rp.moveToNextPage();
//        System.out.println(" Moved to next page after role tests");
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
    public void nextPage() throws InterruptedException {
        RolePage rp3 = new RolePage(driver);
        rp3.moveToNextPage();
    }

}