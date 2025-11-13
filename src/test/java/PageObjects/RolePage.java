package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RolePage extends BasePage {

    public RolePage(WebDriver driver) {
        super(driver);
    }

    // Locators  //span[text()='Add Role']
    @FindBy(xpath = "//span[text()='Add Role']")
    WebElement addRole;

    // @FindBy(xpath = "//label[text()='Name']/following::input[1]")

    @FindBy(id = "roles_roleName")
    WebElement rolename;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement rolesubnit;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nxtEmp;

    @FindBy(xpath = "//span[text()='Previous']")
    WebElement previousToRole;

    @FindBy(xpath = "//button[contains(@class,'MuiIconButton-root')])[5]")
    WebElement firstIcon;

    @FindBy(xpath = "//input[@name='roleName']")
    WebElement r1;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement s1;

    @FindBy(css="#__next > div > div:nth-child(2) > section > div > div > main > section > div:nth-child(3) > div > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > div > svg > path")
    WebElement firstEdit;

    @FindBy(id = "roles_roleName")
    WebElement Data1;

    @FindBy(xpath = "//span[text()='Submit']")
     WebElement submit;


    //  Method to add a role (without verifying immediately)
    public void add(String roleName) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(addRole)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(rolename)).clear();
        Thread.sleep(1000);
        rolename.sendKeys(roleName);

        wait.until(ExpectedConditions.elementToBeClickable(rolesubnit)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
        System.out.println("Role '" + roleName + "' added.");
    }



    //  Final verification after all roles added
    // Method to verify if a specific role exists in the table
    public void verifyRoleInTable(String expectedRole) {
        try {
            // Find the cell with the role name
            WebElement roleCell = driver.findElement(By.xpath("//table//tbody//td[text()='" + expectedRole + "']"));

            if (roleCell.isDisplayed()) {
                System.out.println("Role '" + expectedRole + "' is present in the table.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Role '" + expectedRole + "' is NOT present in the table.");
        } catch (Exception e) {
            System.out.println("⚠ Error while verifying role in table: " + e.getMessage());
        }
    }



    public void nextBtn() throws InterruptedException {
        // System.out.println("Checked entered data are equal in the list ");
        System.out.println("Next button on role page is displayed or not: " + nxtEmp.isDisplayed());
        Thread.sleep(1000);
        System.out.println("**************************************************************************");
        nxtEmp.click();
        System.out.println("Previous to role page :"+previousToRole.isDisplayed());
        previousToRole.click();
    }

    public void editclick(String data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(firstEdit)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOf(Data1));
        input.clear();
        input.sendKeys(data);

        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
        System.out.println(" Role edited to: " + data);
    }

    public void toFindDuplicate(String role) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(addRole)).click();

            wait.until(ExpectedConditions.visibilityOf(rolename)).clear();
            rolename.sendKeys(role);

            wait.until(ExpectedConditions.elementToBeClickable(rolesubnit)).click();
            handleDuplicateRolePopupAndMoveNext(role);
        } catch (Exception e) {
            System.out.println("⚠ Unexpected error while adding role '" + role + "': " + e.getMessage());
        }
    }

    public void handleDuplicateRolePopupAndMoveNext(String role) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'ant-modal-content')]")));
            System.out.println(" Duplicate role detected for '" + role + "': " + popup.getText());

            WebElement closeBtn = popup.findElement(
                    By.xpath(".//button[@aria-label='Close' or contains(@class,'ant-modal-close')]"));
            closeBtn.click();
            System.out.println(" Closed duplicate popup successfully.");
        } catch (TimeoutException e) {
            System.out.println(" No duplicate popup found for '" + role + "'.");
        }
        moveToNextPage(); // always move forward
    }


    public void moveToNextPage(){
        System.out.println("Role page tested ** ");
        System.out.println("In next button in role page ");
        nxtEmp.click();
    }

    public void just() {
        nxtEmp.click();
    }
}