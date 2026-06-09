package TestBase;

import PageObjects.BoutiquePage;
import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BoutiquePageTest extends BaseClass{

    @Test(priority = 1)
    public void testAddNewBoutiqueFields() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        TestListener.test.get().pass("Selected one boutique :");
        bp.clickAddBoutique();
    }

    @Test(priority = 2)
    public void VerifyGeneralSettings(){
        WebElement generalSettings = driver.findElement(By.xpath("//h3[normalize-space(text())='General Settings']"));
        System.out.println("General setting is visible :"+generalSettings);
    }

    @Test(priority = 3)
    public void VerifyCustomSettings(){
        WebElement customsettings = driver.findElement(By.xpath("//h3[normalize-space(text())='Custom Settings']"));
        System.out.println("custom setting is visible :"+customsettings);
    }

    @Test(priority = 4)
    public void verifyPlandetail(){
        WebElement planDetail = driver.findElement(By.xpath("//h3[normalize-space(text())='Plan Details']"));
        System.out.println("plan detail is visible :"+planDetail);
    }

    @Test(priority = 5)
    public void exploreProfile(){
        BoutiquePage bp = new BoutiquePage(driver);
        bp.verifySubcription();
        driver.navigate().back();
    }

    @Test(priority = 6)
    public void navigateToCustomSettings(){
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnCustom();
    }

    @Test(priority = 7)
    public void verifyCrmSettings(){
        WebElement customsettings = driver.findElement(By.xpath("//span[contains(.,'CRM Fields')]"));
        System.out.println("CRM fields is visible :"+customsettings.isDisplayed());
    }

    @Test(priority = 8)
    public void verifyOrderSettings(){
        WebElement orderSettings = driver.findElement(By.xpath("//span[contains(.,'Orders Fields')]"));
        System.out.println("order fields is visible :"+orderSettings.isDisplayed());
    }

    @Test(priority = 9)
    public void verifySourcingSettings(){
        WebElement sourceSettings = driver.findElement(By.xpath("//span[contains(.,'Sourcing Fields')]"));
        System.out.println("source fields is visible :"+sourceSettings.isDisplayed());
    }

    @Test(priority = 10)
    public void verifyCrm(){
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnCrm();
    }

    @Test(priority = 11)
    public void verifyFieldLabel(){
        WebElement fieldlabel = driver.findElement(By.id("CustomField_fieldLabel"));
        System.out.println("Verify field label is present :"+fieldlabel.isDisplayed());
    }

    @Test(priority = 12)
    public void verifyStep(){
        WebElement step = driver.findElement(By.id("CustomField_stepKey"));
        System.out.println("Verify step label is present :"+step.isDisplayed());
    }

    @Test(priority = 13)
    public void verifyFieldType(){
        WebElement fieldType = driver.findElement(By.id("CustomField_fieldType"));
        System.out.println("Verify field type is present :"+fieldType.isDisplayed());
    }

    @Test(priority = 14)
    public void verifyDisplayOrder(){
        WebElement order = driver.findElement(By.id("CustomField_displayOrder"));
        System.out.println("Verify display order is present :"+order.isDisplayed());
    }

    @Test(priority = 15)
    public void verifyRequiredCheckBox(){
        WebElement required = driver.findElement(By.xpath("//span[normalize-space(text())='Required']"));
        System.out.println("Required checkbox is present :"+required.isDisplayed());
    }

    @Test(priority = 15)
    public void verifyCancelBtn(){
        WebElement cancelBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Cancel']"));
        System.out.println("cancel button is present :"+cancelBtn.isDisplayed());
    }

    @Test(priority = 16)
    public void verifyCreateBtn(){
        WebElement createBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Create']"));
        System.out.println("create button is present :"+createBtn.isDisplayed());
    }

    @Test(priority = 17)
    public void emptyFieldName() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        bp.enterFieldName("");
        bp.selectStep();
        bp.selectType();
        bp.clickCreate();
        bp.clickClose();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Field label is required']")));
        Assert.assertTrue(toast.getText().contains("Field label is required"), "Error message not displayed");
    }

    @Test(priority = 18)
    public void emptyStep() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnCrm();
        bp.enterFieldName(randomString());
       // bp.selectStep();
        bp.selectType();
        bp.clickCreate();
        bp.clickClose();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Step is required']")));
        Assert.assertTrue(toast.getText().contains("Step is required"), "Error message not displayed");
    }

    @Test(priority = 19)
    public void emptyFiltertype() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnCrm();
        bp.enterFieldName(randomString());
        bp.selectStep();
        bp.clickCreate();
        bp.clickClose();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Field type is required']")));
        Assert.assertTrue(toast.getText().contains("Field type is required"), "Error message not displayed");
    }

    @Test(priority = 20)
    public void validInputs() throws InterruptedException {
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnCrm();
        bp.enterFieldName(randomString());
        bp.selectStep();
        bp.selectType();
        bp.clickCreate();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Custom field created successfully!']")));
        Assert.assertTrue(toast.getText().contains("Custom field created successfully!"), "Error message not displayed");
    }

    @Test(priority = 21)
    public void navigateToShopDetail(){
        BoutiquePage bp = new BoutiquePage(driver);
        driver.navigate().back();
        driver.navigate().refresh();
        bp.clickOnShop();
    }

}