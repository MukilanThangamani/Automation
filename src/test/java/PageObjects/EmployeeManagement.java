package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class EmployeeManagement extends BasePage{

    public EmployeeManagement(WebDriver driver) {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//span[text()='Employee Management']")
    WebElement empMgmt;

    @FindBy(xpath = "//span[text()='Add Employee']")
    WebElement empbtn;

    @FindBy(id = "boutique_name")
    WebElement empName;

    @FindBy(id = "boutique_roleId")
    WebElement roleDropdown;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/div/div/div[3]/div")
    WebElement role;

    @FindBy(xpath = "//*[@id=boutique_dateOfBirth]")
    WebElement dob;

    @FindBy(xpath = "//*[@id=boutique_dateOfJoining]")
    WebElement doj;

    @FindBy(id = "boutique_phone")
    WebElement mobNum;

    @FindBy(id = "boutique_emergencyPhone")
    WebElement mobNum1;

    @FindBy(id = "boutique_password")
    WebElement pass;

    @FindBy(xpath = "//*[@id=\"boutique_gender\"]")
    WebElement genderDropdown;


    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subEmp;

    @FindBy(xpath = "//span[text()='Close']")
    WebElement close;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    @FindBy(css = "#__next > div > div:nth-child(2) > section > div > div > main > section > div > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(2) > svg")
    WebElement deleteIcon;

    @FindBy(xpath = "//span[text()='Delete']")
    WebElement deleteBtn;

    // Action
    public void empDetail() throws InterruptedException {

        System.out.println("Navigating to Employee Management section.");
        System.out.println("Employee Management button is displayed : " + empMgmt.isDisplayed());
        empMgmt.click();
        Thread.sleep(1000);

        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(empbtn));
        System.out.println("Add emp button is displayed : " + empbtn.isDisplayed());
        Thread.sleep(2000);
        empbtn.click();

        wait.until(ExpectedConditions.visibilityOf(empName));
        System.out.println("Add emp name field is displayed : " + empName.isDisplayed());
        Thread.sleep(2000);
        empName.sendKeys(randomString());

        System.out.println("Role dropdown is visible: " + roleDropdown.isDisplayed());
        Thread.sleep(2000);
        roleDropdown.click();
        Thread.sleep(1000); // Optional, better to wait with WebDriverWait

        List<WebElement> roleOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div")));

        Random random = new Random();
        int randomIndex = random.nextInt(roleOptions.size());
        WebElement selectRole = roleOptions.get(randomIndex);
        selectRole.click();

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
        genderDropdown.click(); // open dropdown
        Thread.sleep(1000); // or better: use WebDriverWait

        List<WebElement> genderOption = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div")));
        int randomIdx = random.nextInt(genderOption.size());
        WebElement selectGender = genderOption.get(randomIdx);
        selectGender.click();

        Thread.sleep(1000);
        System.out.println("Submit button is displayed: " + subEmp.isDisplayed());
        Thread.sleep(1000);
        subEmp.click();
        System.out.println("Close button is visible :"+close.isDisplayed());
        Thread.sleep(1000);
        System.out.println("Delete icon is visible :"+deleteIcon.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        deleteIcon.click();
        Thread.sleep(1000);
        System.out.println("CloseButton in delete is displayed:"+close.isDisplayed());
        System.out.println("Delete button is visible :"+deleteBtn.isDisplayed());
        deleteBtn.click();
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

}
