package TestBase;

import PageObjects.EmployeePage;
import PageObjects.LoginPage;
import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmployeePageTest extends BaseClass{

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
        WebElement clo = driver.findElement(By.xpath("//span[text()='Close']"));
        System.out.println("Verify close button is :"+clo.isDisplayed());
        clo.click();
    }

    @Test(priority = 17)
    public void verifyOutsourcingEmp(){
        boolean outsourcing = driver.findElement(By.xpath("//div[normalize-space(text())='Outsourcing Employees']")).isDisplayed();
        System.out.println("Verify outsourcing employee is visible:"+outsourcing);
    }

    @Test(priority = 18)
    public void clickOnOutsourcing() throws InterruptedException {
        EmployeePage ep1 = new EmployeePage(driver);
        ep1.clickOutsourcing();
    }

    @Test(priority = 19)
    public void verifySearchField(){
        boolean search = driver.findElement(By.xpath("(//input[@placeholder='Search...'])[2]")).isDisplayed();
        System.out.println("Verify search field :"+search);
    }

    @Test(priority = 20)
    public void verifyAddOutsourcingButton(){
        boolean addoutsourcing = driver.findElement(By.xpath("//span[normalize-space(text())='Add Outsourcing Employee']")).isDisplayed();
        System.out.println("Verify outsourcing employee is displayed:"+addoutsourcing);
    }

    @Test(priority = 21)
    public void verifyMobileHeading() throws InterruptedException {
        boolean mobileNum = driver.findElement(By.xpath("//th[normalize-space(text())='Mobile Number']")).isDisplayed();
        System.out.println("Verify mobile header :"+mobileNum);
    }

    @Test(priority = 22)
    public void clickOnAddButton() throws InterruptedException {
        EmployeePage ep1 = new EmployeePage(driver);
        ep1.clickOnAddOutsourcing();
    }

    @Test(priority = 23)
    public void verifyName(){
        boolean name = driver.findElement(By.xpath("(//label[normalize-space(text())='Name']/following::input)[1]")).isDisplayed();
        System.out.println("Verify name field is displayed :"+name);
    }

    @Test(priority = 24)
    public void verifyMobile(){
        boolean mobile = driver.findElement(By.id("mobileNumber")).isDisplayed();
        System.out.println("Verify Employee Mobile number field :"+mobile);
    }

    @Test(priority = 25)
    public void verifyRole(){
        boolean role = driver.findElement(By.id("employeeRoleId")).isDisplayed();
        System.out.println("Verify role field is visible:"+role);
    }

    @Test(priority = 26)
    public void verifyAddress(){
        boolean address = driver.findElement(By.id("address")).isDisplayed();
        System.out.println("Verify address field :"+address);
    }

    @Test(priority = 27)
    public void verifySubmitButton(){
        boolean submit = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")).isDisplayed();
        System.out.println("Verify submit button :"+submit);
    }

    @Test(priority = 28)
    public void verifyCloseButton(){
        boolean close = driver.findElement(By.xpath("//span[normalize-space(text())='Close']")).isDisplayed();
        System.out.println("Verify close button :"+close);
    }

    @Test(priority = 29)
    public void emptyNameValidationTest() throws Exception {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.setName("");
        ep2.setMobile("9875937594");
        ep2.selectRole();
        ep2.setAddress(randomString());
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Name is required']")));
        Assert.assertTrue(toast.getText().contains("Name is required"), "Error message not displayed");

    }

    @Test(priority = 30)
    public void invalidMobileNumberTest() throws Exception {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.setName("Mukilan");
        ep2.setMobile("123");
        ep2.selectRole();
        ep2.setAddress("Chennai");
        ep2.clickSubmit();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
        WebElement close = driver.findElement(By.xpath("//span[normalize-space(text())='Close']"));
        close.click();
    }

    @Test(priority = 31)
    public void emptyRoleValidationTest() throws Exception {
        EmployeePage ep2 = new EmployeePage(driver);
         WebElement addOutsource = driver.findElement(By.xpath("//span[normalize-space(text())='Add Outsourcing Employee']"));
         addOutsource.click();
        ep2.setName("Mukilan");
        Thread.sleep(1000);
        ep2.setMobile("9876543210");
        Thread.sleep(1000);
        ep2.setAddress("Chennai");
        Thread.sleep(1000);
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Role is required']")));
        Assert.assertTrue(toast.getText().contains("Role is required"), "Error message not displayed");
    }


    @Test(priority = 32)
    public void mobileNumberWithOneTest() throws Exception {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.setName("Mukilan");
        ep2.setMobile("9");
        ep2.selectRole();
        ep2.setAddress("Chennai");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }


    @Test(priority = 33)
    public void submitModalTest() {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }


    @Test(priority = 34)
    public void addEmployeeWithValidDataTest() throws Exception {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.setName(randomString());
        ep2.setMobile(phoneRandom());
        ep2.selectRole();
        ep2.setAddress("Chennai");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Outsourcing employee created successfully']")));
        Assert.assertTrue(toast.getText().contains("Outsourcing employee created successfully"), "Error message not displayed");
    }

    @Test(priority = 35)
    public void emptyNameField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickAddEmp();
        ep2.enterName("");
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@sd");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Name is required']")));
        Assert.assertTrue(toast.getText().contains("Name is required"), "Error message not displayed");
    }

    @Test(priority = 36)
    public void emptyMobileNumField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob("");
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@sd");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Mobile Number is required']")));
        Assert.assertTrue(toast.getText().contains("Mobile Number is required"), "Error message not displayed");
    }

    @Test(priority = 37)
    public void invalidMobileNumField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob("6");
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@sd");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Invalid phone number for selected country']")));
        Assert.assertTrue(toast.getText().contains("Invalid phone number for selected country"), "Error message not displayed");
    }

    @Test(priority = 38)
    public void incompleteMobileNumField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob("54");
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@sd");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Please enter a valid 10-digit phone number.']")));
        Assert.assertTrue(toast.getText().contains("Please enter a valid 10-digit phone number."), "Error message not displayed");
    }

    @Test(priority = 39)
    public void emptyEmergencyMobileNumField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum("");
        ep2.enterPassword("a@sd");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Emergency Contact Number is required']")));
        Assert.assertTrue(toast.getText().contains("Emergency Contact Number is required"), "Error message not displayed");
    }

    @Test(priority = 40)
    public void emptyPasswordField() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();
        ep2.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Password is required']")));
        Assert.assertTrue(toast.getText().contains("Password is required"), "Error message not displayed");
    }

    @Test(priority = 41)
    public void emptyGenderTest() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickAddEmp();
        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@d");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();
        ep2.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Gender is required']")));
        Assert.assertTrue(toast.getText().contains("Gender is required"), "Error message not displayed");
    }

    @Test(priority = 42)
    public void emptyUserTest() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickAddEmp();
        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@d");
        ep2.selectGender("Male");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();
        ep2.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Access Right is required']")));
        Assert.assertTrue(toast.getText().contains("Access Right is required"), "Error message not displayed");
    }

    @Test(priority = 43)
    public void emptyRoleTest() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickAddEmp();
        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@d");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.clickSubmit();
        ep2.closeModal();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Role is required']")));
        Assert.assertTrue(toast.getText().contains("Role is required"), "Error message not displayed");
    }

    @Test(priority = 44)
    public void emptyDataTest() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);
        ep2.clickAddEmp();
        ep2.enterName("");
        ep2.enterMob("");
        ep2.enterEmergencyNum("");
        ep2.enterPassword("");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Password is required']")));
        Assert.assertTrue(toast.getText().contains("Password is required"), "Error message not displayed");
    }

    @Test(priority = 45)
    public void validInputTest() throws InterruptedException {
        EmployeePage ep2 = new EmployeePage(driver);

        ep2.enterName(randomString());
        ep2.enterMob(phoneRandom());
        ep2.enterEmergencyNum(phoneRandom());
        ep2.enterPassword("a@d");
        ep2.selectGender("Male");
        ep2.selectUser("Employee");
        ep2.chooseRole("PRHjDunSBn");
        ep2.clickSubmit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Employee added successfully!']")));
        Assert.assertTrue(toast.getText().contains("Employee added successfully!"), "Error message not displayed");

        ep2.nxtBtnEmp();
    }


}