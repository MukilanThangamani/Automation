package TestBase;

import PageObjects.DashboardPage;
import Utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseClass{

    @Test(priority = 1)
    public void verifyOrderIcon(){
        boolean orderIcon = driver.findElement(By.xpath("(//div[@class='headerAction'])[1]")).isDisplayed();
        System.out.println("Verify order icon id displayed :"+orderIcon);
    }

    @Test(priority = 2)
    public void verifyAppointmentIcon(){
        boolean appointment = driver.findElement(By.xpath("(//div[@class='headerAction'])[2]")).isDisplayed();
        System.out.println("Verify appointment icon is displayed :"+appointment);
    }

    @Test(priority = 3)
    public void verifyCreateEstimation(){
        boolean estimation = driver.findElement(By.xpath("(//div[@class='headerAction'])[3]")).isDisplayed();
        System.out.println("Verify estimation is displayed: "+estimation);
    }

    @Test(priority = 4)
    public void verifyNotification(){
        WebElement notify = driver.findElement(By.xpath("(//div[@class='headerAction']/following-sibling::div)[3]"));
        TestListener.test.get().pass("Verify notification icon is displayed :"+notify.isDisplayed());
        notify.click();
    }

    @Test(priority = 5)
    public void verifyFilterType(){
        WebElement filter = driver.findElement(By.xpath("(//input[@class='ant-select-selection-search-input'])[3]"));
        TestListener.test.get().pass("Verify filter fropdown is visible :"+filter.isDisplayed());
        filter.click();
    }

    @Test(priority = 6)
    public void verifyShortage(){
        boolean shortage = driver.findElement(By.xpath("//div[normalize-space(text())='Shortage Reminder']")).isDisplayed();
        TestListener.test.get().pass("Verify shortage reminder is visible :"+shortage);
    }

    @Test(priority = 7)
    public void verifyIdle(){
        boolean idle = driver.findElement(By.xpath("//div[normalize-space(text())='Idle Reminder']")).isDisplayed();
        TestListener.test.get().pass("Verify idle remainder :"+idle);
    }

    @Test(priority = 8)
    public void verifyClientOccasion(){
        boolean clientOccasion = driver.findElement(By.xpath("//div[normalize-space(text())='Client Occasion Reminder']")).isDisplayed();
        TestListener.test.get().pass("Verify client occasion :"+clientOccasion);
    }

    @Test(priority = 9)
    public void closeTab(){
        WebElement close = driver.findElement(By.xpath("//span[@aria-label='close']"));
        TestListener.test.get().pass("Verify close model :"+close.isDisplayed());
        close.click();
    }

    @Test(priority = 10)
    public void verifyProfile(){
        WebElement profile = driver.findElement(By.cssSelector("#__next > div > div > div > section > div > header > div:nth-child(2) > div:nth-child(6)"));
        System.out.println("Verify profile icon is displayed:"+profile.isDisplayed());
        profile.click();
    }

    @Test(priority = 11)
    public void verifyViewOnLogout(){
        boolean logout = driver.findElement(By.xpath("//div[normalize-space(text())='Logout']")).isDisplayed();
        System.out.println("Verify logout is displayed :"+logout);
    }

    @Test(priority = 12)
    public void verifyClickOnProfile(){
        WebElement viewProfile = driver.findElement(By.xpath("//div[normalize-space(text())='Profile']"));
        System.out.println("Verify to view profile :"+viewProfile);
        viewProfile.click();
    }

    @Test(priority = 13)
    public void verifySubscriptionTitle(){
        boolean subscription = driver.findElement(By.xpath("//h5[normalize-space(text())='Subscription Details']")).isDisplayed();
        TestListener.test.get().pass("Verify subscription detail is visible :"+subscription);
    }

    @Test(priority = 14)
    public void verifyPlaneTitle(){
        boolean planeName = driver.findElement(By.xpath("//span[normalize-space(text())='Plan Name']")).isDisplayed();
        TestListener.test.get().pass("Verify plan name title :"+planeName);
    }

    @Test(priority = 15)
    public void verifyStatus(){
        boolean status = driver.findElement(By.xpath("//span[normalize-space(text())='Status']")).isDisplayed();
        TestListener.test.get().pass("Verify status is visible :"+status);
    }

    @Test(priority = 16)
    public void verifyBillingCycle(){
        boolean billingCycle = driver.findElement(By.xpath("//th[contains(.,'Billing Cycle')]")).isDisplayed();
        TestListener.test.get().pass("Verify billing cycle is visible :"+billingCycle);
    }

    @Test(priority = 17)
    public void verifyAmount(){
        boolean amount = driver.findElement(By.xpath("//span[normalize-space(text())='Amount']")).isDisplayed();
        TestListener.test.get().pass("Verify amount is visible :"+amount);
    }

    @Test(priority = 18)
    public void verifyStartDate(){
        boolean startDate = driver.findElement(By.xpath("//span[normalize-space(text())='Start Date']")).isDisplayed();
        TestListener.test.get().pass("Verify startDate is visible :"+startDate);
    }

    @Test(priority = 19)
    public void verifyEndDate(){
        boolean endDate = driver.findElement(By.xpath("//span[normalize-space(text())='End Date']")).isDisplayed();
        TestListener.test.get().pass("Verify endDate is visible :"+endDate);
    }

    @Test(priority = 20)
    public void verifyAutoRenew(){
        boolean autoRenew = driver.findElement(By.xpath("//span[normalize-space(text())='Auto Renew']")).isDisplayed();
        TestListener.test.get().pass("Verify Auto renew field is visible :"+autoRenew);
    }

    @Test(priority = 21)
    public void verifyModules(){
        boolean includedModules = driver.findElement(By.xpath("//h5[normalize-space(text())='Included Modules']")).isDisplayed();
        TestListener.test.get().pass("Verify included modules :"+includedModules);
    }

    @Test(priority = 22)
    public void testDashboardAccess() throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        TestListener.test.get().pass("Click on setting button :");
        dp.clkSetting();
    }

}