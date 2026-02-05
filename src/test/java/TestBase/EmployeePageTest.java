package TestBase;

import PageObjects.EmployeePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EmployeePageTest extends BaseClass{

    @Test(priority = 17)
    public void testAddEmployee() throws InterruptedException {
        EmployeePage ep = new EmployeePage(driver);
          ep.empDetail();
          ep.nxtBtnEmp();
    }

    @Test(priority = 1)
    public void verifySearch(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search...']")).isDisplayed();
        System.out.println("Verify search field :"+search);
    }

    @Test(priority = 2)
    public void verifyUserTypeFilter(){
        boolean userType = driver.findElement(By.xpath("//span[text()='Filter by User Type']")).isDisplayed();
        System.out.println("Verify user type filter is displayed :"+userType);
    }

    @Test(priority = 3)
    public void verifyRoleFilter(){
        boolean role = driver.findElement(By.xpath("//span[text()='Filter by Role']")).isDisplayed();
        System.out.println("Verify role is displayed :"+role);
    }

    @Test(priority = 4)
    public void addEmployee(){
        boolean addEmp = driver.findElement(By.xpath("//span[text()='Add Employee']")).isDisplayed();
        System.out.println("Verify add Employee is displayed :"+addEmp);
    }

    @Test(priority = 5)
    public void empDetails(){
        EmployeePage ep = new EmployeePage(driver);
        ep.clickAddEmp();
    }

    @Test(priority = 6)
    public void verifyNameField(){
        boolean name = driver.findElement(By.id("boutique_name")).isDisplayed();
        System.out.println("Verify name field :"+name);
    }

    @Test(priority = 7)
    public void verifyDOB(){
        boolean dob = driver.findElement(By.id("boutique_dateOfBirth")).isDisplayed();
        System.out.println("Verify date of birth field :"+dob);
    }

    @Test(priority = 8)
    public void verifyMobileNum(){
        boolean mobNum = driver.findElement(By.id("boutique_phone")).isDisplayed();
        System.out.println("Verify Mobile Number field :"+mobNum);
    }

    @Test(priority = 9)
    public void verifyEmergencyNum(){
        boolean emergency = driver.findElement(By.id("boutique_emergencyPhone")).isDisplayed();
        System.out.println("Verify emergency field :"+emergency);
    }

    @Test(priority = 10)
    public void verifyPasswordField(){
        boolean password = driver.findElement(By.id("boutique_password")).isDisplayed();
        System.out.println("Verify password field :"+password);
    }

    @Test(priority = 11)
    public void verifyGenderField(){
        boolean gender = driver.findElement(By.id("boutique_gender")).isDisplayed();
        System.out.println("Verify gender field :"+gender);
    }

    @Test(priority = 12)
    public void verifyWorkDetail(){
        boolean workDetail = driver.findElement(By.xpath("//strong[text()='Work Details']")).isDisplayed();
        System.out.println("Verify work detail title :"+workDetail);
    }

    @Test(priority = 13)
    public void userType(){
        boolean usertype = driver.findElement(By.id("boutique_userRoleId")).isDisplayed();
        System.out.println("Verify usertype field :"+usertype);
    }

    @Test(priority = 14)
    public void userRole(){
        boolean userRole = driver.findElement(By.id("boutique_roleId")).isDisplayed();
        System.out.println("Verify user role :"+userRole);
    }

    @Test(priority = 15)
    public void verifySubmit(){
        boolean submitBtn = driver.findElement(By.xpath("//span[text()='Submit']")).isDisplayed();
        System.out.println("Verify submit button :"+submitBtn);
    }

    @Test(priority = 16)
    public void verifyClose(){
        boolean closeBtn = driver.findElement(By.xpath("//span[text()='Close']")).isDisplayed();
        System.out.println("Verify close button is :"+closeBtn);
    }

}
