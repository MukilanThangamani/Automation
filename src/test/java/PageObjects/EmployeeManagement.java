package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class EmployeeManagement extends BasePage{

    public EmployeeManagement(WebDriver driver) {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//span[text()='Employees']")
    WebElement empMgmt;

    @FindBy(id = "boutique_name")
    WebElement empName;

    @FindBy(id = "boutique_userRoleId")
    WebElement roleId;

    @FindBy(xpath = "//div[text()='Employee']")
    WebElement selectRole;

    @FindBy(id = "boutique_roleId")
    WebElement roleDropdown;

    @FindBy(id = "boutique_phone")
    WebElement mobNum;

    @FindBy(id = "boutique_emergencyPhone")
    WebElement mobNum1;

    @FindBy(id = "boutique_password")
    WebElement pass;

    @FindBy(xpath = "//*[@id=\"boutique_gender\"]")
    WebElement genderDropdown;

    @FindBy(xpath = "//span[text()='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subEmp;

    @FindBy(xpath = "//span[text()='Close']")
    WebElement close;


    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "(//span[@class='anticon anticon-dollar'])[1]")
    WebElement payment;


    // Action
    public void empDetail() throws InterruptedException {
        System.out.println("In Employee Management page");

        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement addEmp =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Employee']")));
        Thread.sleep(2000);
        System.out.println("Add emp button is displayed : " + addEmp.isDisplayed());
        Thread.sleep(2000);
        addEmp.click();

        //  wait.until(ExpectedConditions.visibilityOf(empName));
        System.out.println("Add emp name field is displayed : " + empName.isDisplayed());
        Thread.sleep(2000);
        empName.sendKeys(randomString());
        Thread.sleep(1000);
        roleId.click();
        Thread.sleep(2000);
        selectRole.click();
        Thread.sleep(1000);
        System.out.println("Role dropdown is visible: " + roleDropdown.isDisplayed());
        Thread.sleep(2000);
        roleDropdown.click();
        Thread.sleep(1000); // Optional, better to wait with WebDriverWait
        Random random = new Random();
        WebElement selectRole1 = driver.findElement(By.xpath("//div[normalize-space(text())='PRHjDunSBn']"));
        selectRole1.click();

        Thread.sleep(1000);
        mobNum.click();
        Thread.sleep(1000);
        mobNum.sendKeys(phoneRandom());
        Thread.sleep(1000);
        mobNum1.click();
        mobNum1.sendKeys(phoneRandom());
        Thread.sleep(1000);
        pass.click();
        pass.sendKeys(randomAlphaAnumeric());

        System.out.println("Gender dropdown is visible: " + genderDropdown.isDisplayed());
        Thread.sleep(2000);
        genderDropdown.click();
        WebElement selectGender =  driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option')]//div[normalize-space()='Male']"));
        selectGender.click();

        Thread.sleep(1000);
        System.out.println("Submit button is displayed: " + subEmp.isDisplayed());
        Thread.sleep(1000);
        subEmp.click();
        Thread.sleep(1000);

    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String phoneRandom() {
        return "98"+RandomStringUtils.randomNumeric(8);
    }

    public String randomAlphaAnumeric() {
        String num = RandomStringUtils.randomNumeric(2);
        String nam = RandomStringUtils.randomAlphabetic(3);
        return nam + "@" + num;
    }

    public void payment() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Payment icon is visible :"+payment.isDisplayed());
        Thread.sleep(2000);
        payment.click();
    }

    public void closeBtn() throws InterruptedException {
        Thread.sleep(1000);
        close.click();
    }

    public void moduleClick() throws InterruptedException {
        Thread.sleep(1000);
        empMgmt.click();
    }

    public void setName(String empname) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("(//label[normalize-space(text())='Name']/following::input)[1]"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(empname);
    }

    public void clickAddEmployee() {
        WebElement addEmployee = driver.findElement(By.xpath("//span[normalize-space(text())='Add Employee']"));
        addEmployee.click();
    }

    public void setMobile(String number) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_phone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(number);
    }

    public void chooseRole(String roleName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Click proper dropdown container
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='boutique_roleId']/ancestor::div[contains(@class,'ant-select')]")
        ));
        dropdown.click();

        // ✅ Select role dynamically
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option')]//div[normalize-space()='" + roleName + "']")
        ));
        option.click();
    }

    public void setAddress(String empaddress) throws InterruptedException {
        WebElement element = driver.findElement(By.id("address"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(empaddress);
    }

    public void clickSubmit() {
        driver.findElement(By.xpath("//span[normalize-space(text())='Submit']")).click();
    }

    public void setEmergencyMobile(String emergencyNumber) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_emergencyPhone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(emergencyNumber);
    }


    public void enterPassword(String password) throws InterruptedException {
        WebElement element = driver.findElement(By.id("boutique_password"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(password);
    }

    public void selectGender(String gender) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Click the actual dropdown container (not input)
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='boutique_gender']/ancestor::div[contains(@class,'ant-select')]")
        ));
        dropdown.click();

        // ✅ Select option by visible text
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option')]//div[text()='" + gender + "']")
        ));
        option.click();
    }

    public void selectUser(String role) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Click actual dropdown container
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@id='boutique_userRoleId']/ancestor::div[contains(@class,'ant-select')]")
        ));
        dropdown.click();

        // ✅ Select option by visible text
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option')]//div[text()='" + role + "']")
        ));
        option.click();
    }

    public void closeModal() {
        WebElement close =driver.findElement(By.xpath("//span[normalize-space(text())='Close']"));
        close.click();
    }

    public void enterAmount(String number) throws InterruptedException {
        WebElement element = driver.findElement(By.id("Advance_amount"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(number);
    }

    public void enterDate() throws InterruptedException {
        WebElement element = driver.findElement(By.id("Advance_date"));
        element.click();
        WebElement selectToday = driver.findElement(By.xpath("//a[normalize-space(text())='Today']"));
        selectToday.click();
    }

    public void enterRemarks(String remarks) throws InterruptedException {
        WebElement element = driver.findElement(By.id("Advance_remarks"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(remarks);
    }

    public void setType() {
        WebElement type = driver.findElement(By.id("Advance_type"));
        type.click();
        WebElement typeOption = driver.findElement(By.xpath("//div[normalize-space(text())='Advance']"));
        typeOption.click();
    }
}