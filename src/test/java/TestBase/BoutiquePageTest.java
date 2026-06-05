package TestBase;

import PageObjects.BoutiquePage;
import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public void navigateToShopDetail(){
        BoutiquePage bp = new BoutiquePage(driver);
        bp.clickOnShop();
    }






}