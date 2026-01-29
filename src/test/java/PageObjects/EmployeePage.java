package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    @FindBy(id = "boutique_name")
    WebElement empName;

    @FindBy(id = "boutique_userRoleId")
    WebElement roleId;

    @FindBy(xpath = "//div[text()='EMPLOYEE']")
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


    // Action

    public void empDetail() throws InterruptedException {

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
        WebElement selectRole1 = driver.findElement(By.xpath("//div[text()='oSBUl']"));
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

//        List<WebElement> genderOption = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div")));
//        int randomIdx = random.nextInt(genderOption.size());
        WebElement selectGender = driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option') and @title='Male']"));
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
      //  WebElement deleteIcon = driver.findElement(By.cssSelector("#__next > div > div:nth-child(2) > section > div > div > main > section > div:nth-child(3) > div > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(2) > svg"));
        WebElement delete =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#__next > div > div > div > section > div > div > main > section > div:nth-child(3) > div > div.ant-table-wrapper.custom-antd-table.css-198drv2 > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(2) > svg")));
        delete.click();
        Thread.sleep(1000);
        System.out.println("CloseButton in delete is displayed:"+close.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Delete button is visible :"+deleteBtn.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        deleteBtn.click();
        Thread.sleep(1000);
    }

    // Java

    public void nxtBtnEmp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-modal-wrap")));
        System.out.println("Next button is displayed: " + nextButton.isDisplayed());
        nextButton.click();
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

}