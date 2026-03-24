package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    // Locators

    @FindBy(xpath = "//div[normalize-space(text())='Employees']")
    WebElement employees;

    @FindBy(xpath = "//span[text()='Add Employee']")
    WebElement addEmployee;

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

    @FindBy(xpath = "//div[normalize-space(text())='Outsourcing Employees']")
    WebElement outsourcing;

    @FindBy(xpath = "//span[normalize-space(text())='Add Outsourcing Employee']")
    WebElement addOutsourcing;

    @FindBy(xpath = "(//label[normalize-space(text())='Name']/following::input)[1]")
    WebElement name;

    @FindBy(id = "mobileNumber")
    WebElement empmob;

    @FindBy(id = "address")
    WebElement empaddress;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement submitOutsourcing;

    @FindBy(xpath = "//input[@aria-controls='employeeRoleId_list']")
    WebElement empRoleList;

    // Action

    public void empDetail() throws InterruptedException {

        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        employees.click();
        Thread.sleep(1000);
        addEmployee.click();
        Thread.sleep(1000);
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
        Random random = new Random();WebElement selectRole1 = driver.findElement(By.xpath("//div[text()='DpIDb']"));
        selectRole1.click();

        Thread.sleep(1000);
        mobNum.click();
        Thread.sleep(1000);
        mobNum.sendKeys(phoneRandom());
        Thread.sleep(1000);
      //  mobNum1.click();
      //  mobNum1.sendKeys(phoneRandom());
        Thread.sleep(1000);
        pass.click();
        pass.sendKeys(randomAlphaAnumeric());

        System.out.println("Gender dropdown is visible: " + genderDropdown.isDisplayed());
        Thread.sleep(2000);
        genderDropdown.click(); // open dropdown
        Thread.sleep(1000); // or better: use WebDriverWait

        WebElement selectGender = driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option')]//div[normalize-space()='Male']"));
        selectGender.click();

        Thread.sleep(1000);
        System.out.println("Submit button is displayed: " + subEmp.isDisplayed());
        Thread.sleep(1000);

        subEmp.click();

        boolean isEmergencyErr = !driver.findElements(By.xpath("//div[text()='Emergency Contact Number is required']")).isEmpty();
        if(isEmergencyErr){
            mobNum1.click();
            mobNum1.sendKeys(phoneRandom());
        }
        else {}
        subEmp.click();

        Thread.sleep(1000);
    }

    public void nxtBtnEmp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-modal-wrap")));
        System.out.println("Next button is displayed: " + nextButton.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
    }

    public void clickOutsourcing() throws InterruptedException {
        System.out.println("Outsourcing Employee is displayed :"+outsourcing.isDisplayed());
        Thread.sleep(1000);
        outsourcing.click();
    }

    public void clickOnAddOutsourcing() throws InterruptedException {
        Thread.sleep(1000);
        addOutsourcing.click();
    }

    public void enterData(String empname, String Mobile ,String add) throws InterruptedException {
        name.sendKeys(empname);
        Thread.sleep(1000);
        empmob.sendKeys(Mobile);
        Thread.sleep(1000);
        empRoleList.click();
        Thread.sleep(1000);
        WebElement role = driver.findElement(By.xpath("//div[normalize-space(text())='DpIDb']"));
        role.click();
        Thread.sleep(1000);
        empaddress.sendKeys(add);
        Thread.sleep(1000);
        submitOutsourcing.click();
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

    public void clickAddEmp() {
        addEmployee.click();
    }

}