package TestBase;

import PageObjects.EmployeeManagement;
import PageObjects.EmployeePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmployeeManagementTest extends BaseClass{

    @Test(priority = 0)
    public void verifyModule() throws InterruptedException {
        EmployeeManagement emp = new EmployeeManagement(driver);
        emp.moduleClick();
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
        ep.clickEmp();
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
    public void verifyClose() throws InterruptedException {
        boolean closeBtn = driver.findElement(By.xpath("//span[text()='Close']")).isDisplayed();
        System.out.println("Verify close button is :"+closeBtn);
        EmployeeManagement emp1 = new EmployeeManagement(driver);
        emp1.closeBtn();
    }

    @Test(priority = 17)
    public void verifyPayment() throws InterruptedException {
        EmployeeManagement em1 = new EmployeeManagement(driver);
        em1.payment();
    }

    @Test(priority = 18)
    public void verifyType(){
        boolean type = driver.findElement(By.id("Advance_type")).isDisplayed();
        System.out.println("Verify type field is displayed :"+type);
    }

    @Test(priority = 19)
    public void verifyAmount(){
        boolean amt = driver.findElement(By.id("Advance_amount")).isDisplayed();
        System.out.println("Verify amt field is displayed :"+amt);
    }

    @Test(priority = 20)
    public void verifyDate(){
        boolean date = driver.findElement(By.id("Advance_date")).isDisplayed();
        System.out.println("Verify date field is displayed:"+date);
    }

    @Test(priority = 21)
    public void verifyRemarks(){
        boolean remarks = driver.findElement(By.id("Advance_remarks")).isDisplayed();
        System.out.println("Verify date field is displayed:"+remarks);
    }

    @Test(priority = 22)
    public void verifySubmitBtn(){
        boolean submitBtn = driver.findElement(By.xpath("//span[text()='Submit']")).isDisplayed();
        System.out.println("Verify submit button :"+submitBtn);
    }

    @Test(priority = 23)
    public void verifyCloseBtn(){
        boolean closeBtn = driver.findElement(By.xpath("//span[text()='Close']")).isDisplayed();
        System.out.println("Verify submit button :"+closeBtn);
    }
//
//    @Test(priority = 24)
//    public void close() throws InterruptedException {
//        EmployeeManagement em3 = new EmployeeManagement(driver);
//        em3.closeBtn();
//    }

    @Test(priority = 24)
    public void emptyType() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.enterAmount("1000");
        em3.enterRemarks(randomString());
        em3.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Type is required']")));
        Assert.assertTrue(toast.getText().contains("Type is required"), "Error message not displayed");
    }

    @Test(priority = 25)
    public void emptyAmount() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.enterAmount("");
        em3.enterRemarks(randomString());
        em3.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Amount is required']")));
        Assert.assertTrue(toast.getText().contains("Amount is required"), "Error message not displayed");
    }

    @Test(priority = 26)
    public void emptyDate() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.enterAmount("1000");
        em3.enterRemarks(randomString());
        em3.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Date is required']")));
        Assert.assertTrue(toast.getText().contains("Date is required"), "Error message not displayed");
    }

    @Test(priority = 27)
    public void emptyRemarks() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.enterAmount("1000");
        em3.enterDate();
        em3.enterRemarks("");
        em3.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Remarks is required']")));
        Assert.assertTrue(toast.getText().contains("Remarks is required"), "Error message not displayed");
    }

    @Test(priority = 28)
    public void validPayment() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.setType();
        em3.enterAmount("1000");
        em3.enterDate();
        em3.enterRemarks(randomString());
        em3.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Employee advance added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Employee advance added successfully!"), "Error message not displayed");
    }

    @Test(priority = 29)
    public void emptyNameValidation() throws InterruptedException {
        EmployeeManagement em3 = new EmployeeManagement(driver);
        em3.clickAddEmployee();
        em3.setName("");
        em3.setMobile(phoneRandom());
        em3.setEmergencyMobile(phoneRandom());
        em3.enterPassword("a@sd");
        em3.selectGender("Male");
        em3.selectUser("Employee");
        em3.chooseRole("PRHjDunSBn");
        em3.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Name is required']")));
        Assert.assertTrue(toast.getText().contains("Name is required"), "Error message not displayed");
    }

    @Test(priority = 30)
    public void emptyMobileNumberTest() throws Exception {
        EmployeeManagement em3 = new EmployeeManagement(driver);

        em3.setName(randomString());
        em3.setMobile("");
        em3.setEmergencyMobile(phoneRandom());
        em3.enterPassword("a@sd");
        em3.selectGender("Male");
        em3.selectUser("Employee");
        em3.chooseRole("PRHjDunSBn");
        em3.clickSubmit();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 31)
    public void singleMobileNumberTest() throws Exception {
        EmployeeManagement em3 = new EmployeeManagement(driver);

        em3.setName(randomString());
        em3.setMobile("6");
        em3.setEmergencyMobile(phoneRandom());
        em3.enterPassword("a@sd");
        em3.selectGender("Male");
        em3.selectUser("Employee");
        em3.chooseRole("PRHjDunSBn");
        em3.clickSubmit();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }

    @Test(priority = 32)
    public void invalidMobileNumberTest() throws Exception {
        EmployeeManagement em3 = new EmployeeManagement(driver);

        em3.setName(randomString());
        em3.setMobile("69");
        em3.setEmergencyMobile(phoneRandom());
        em3.enterPassword("a@sd");
        em3.selectGender("Male");
        em3.selectUser("Employee");
        em3.chooseRole("PRHjDunSBn");
        em3.clickSubmit();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
    }

    @Test(priority = 33)
    public void emptyEmergencyMobileNumber() throws Exception {
        EmployeeManagement em3 = new EmployeeManagement(driver);

        em3.setName(randomString());
        em3.setMobile(phoneRandom());
        em3.setEmergencyMobile("");
        em3.enterPassword("a@sd");
        em3.selectGender("Male");
        em3.selectUser("Employee");
        em3.chooseRole("PRHjDunSBn");
        em3.clickSubmit();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Emergency Contact Number is required']")));
        Assert.assertTrue(toast.getText().contains("Emergency Contact Number is required"), "Error message not displayed");
    }

    @Test(priority = 34)
    public void emptyPasswordField() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);

        em.setName(randomString());
        em.setMobile(phoneRandom());
        em.setEmergencyMobile(phoneRandom());
        em.enterPassword("");
        em.selectGender("Male");
        em.selectUser("Employee");
        em.chooseRole("PRHjDunSBn");
        em.clickSubmit();
        em.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Password is required']")));
        Assert.assertTrue(toast.getText().contains("Password is required"), "Error message not displayed");
    }

    @Test(priority = 35)
    public void emptyGenderTest() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);
        em.clickAddEmployee();
        em.setName(randomString());
        em.setMobile(phoneRandom());
        em.setEmergencyMobile(phoneRandom());
        em.enterPassword("");
        em.selectUser("Employee");
        em.chooseRole("PRHjDunSBn");
        em.clickSubmit();
        em.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Gender is required']")));
        Assert.assertTrue(toast.getText().contains("Gender is required"), "Error message not displayed");
    }

    @Test(priority = 36)
    public void emptyUserTest() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);
        em.clickAddEmployee();
        em.setName(randomString());
        em.setMobile(phoneRandom());
        em.setEmergencyMobile(phoneRandom());
        em.enterPassword("");
        em.selectGender("Male");
        em.chooseRole("PRHjDunSBn");
        em.clickSubmit();
        em.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Access Right is required']")));
        Assert.assertTrue(toast.getText().contains("Access Right is required"), "Error message not displayed");
    }

    @Test(priority = 37)
    public void emptyRoleTest() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);
        em.clickAddEmployee();
        em.setName(randomString());
        em.setMobile(phoneRandom());
        em.setEmergencyMobile(phoneRandom());
        em.enterPassword("");
        em.selectGender("Male");
        em.selectUser("Employee");
        em.clickSubmit();
        em.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Role is required']")));
        Assert.assertTrue(toast.getText().contains("Role is required"), "Error message not displayed");
    }

    @Test(priority = 38)
    public void emptyDataTest() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);
        em.clickAddEmployee();
        em.setName("");
        em.setMobile("");
        em.setEmergencyMobile("");
        em.enterPassword("");
        em.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Password is required']")));
        Assert.assertTrue(toast.getText().contains("Password is required"), "Error message not displayed");
    }

    @Test(priority = 39)
    public void validInputTest() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);

        em.setName(randomString());
        em.setMobile(phoneRandom());
        em.setEmergencyMobile(phoneRandom());
        em.enterPassword("a@d");
        em.selectGender("Male");
        em.selectUser("Employee");
        em.chooseRole("PRHjDunSBn");
        em.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Employee added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Employee added successfully!"), "Error message not displayed");
    }

}