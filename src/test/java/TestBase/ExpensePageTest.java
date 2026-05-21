package TestBase;

import PageObjects.ExpensePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExpensePageTest extends BaseClass{

    @Test(priority = 1)
    public void verifyExpenseModule(){
        ExpensePage ep = new ExpensePage(driver);
        ep.moduleClick();
    }

    @Test(priority = 2)
    public void verifyAddCategory(){
        boolean addcategory = driver.findElement(By.xpath("//span[text()='Add Category']")).isDisplayed();
        System.out.println("Verify add expense button is displayed :"+addcategory);
    }

    @Test(priority = 3)
    public void verifyDropdownCategory(){
        boolean dropCategory = driver.findElement(By.xpath("//span[text()='Category']")).isDisplayed();
        System.out.println("Verify category dropdown is displayed :"+dropCategory);
    }

    @Test(priority = 4)
    public void verifyMonthYear(){
        boolean monthYear = driver.findElement(By.xpath("//input[@placeholder='Month & Year']")).isDisplayed();
        System.out.println("Verify monthYear field is displayed :"+monthYear);
    }

    @Test(priority = 5)
    public void  verifyAddExpense(){
        boolean addExpense = driver.findElement(By.xpath("//span[text()='Add Expense']")).isDisplayed();
        System.out.println("Verify addExpense field is displayed :"+addExpense);
    }

    @Test(priority = 6)
    public void emptyCategory() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);
        ep.clickAddCategory();
        ep.enterCategory("");
        ep.clickCreate();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Category Name is required']")));
        Assert.assertTrue(toast.getText().contains("Category Name is required"), "Error message not displayed");
    }

    @Test(priority = 7)
    public void validCategory() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);
        ep.enterCategory(randomString());
        ep.clickCreate();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Expense category created successfully']")));
        Assert.assertTrue(toast.getText().contains("Expense category created successfully"), "Error message not displayed");
    }

    @Test(priority = 8)
    public void emptyExpenseCategory() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);
        ep.clickAddExpense();
        ep.enterExpenseAmount("100");
        ep.clickCreate();
        ep.clickClose();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Expense category is required']")));
        Assert.assertTrue(toast.getText().contains("Expense category is required"), "Error message not displayed");
    }

    @Test(priority = 9)
    public void emptyPayment() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.clickAddExpense();
        ep.selectExpenseCategory();

        ep.enterExpenseAmount("100");
        ep.clickCreate();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Payment method is required']")));
        Assert.assertTrue(toast.getText().contains("Payment method is required"), "Error message not displayed");
    }

    @Test(priority = 10)
    public void emptyDate() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.selectPayment();
        ep.enterExpenseDate("");
        ep.enterExpenseAmount("100");
        ep.clickCreate();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Expense date is required']")));
        Assert.assertTrue(toast.getText().contains("Expense date is required"), "Error message not displayed");
    }

    @Test(priority = 11)
    public void emptyAmount() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.enterExpenseAmount("");
        ep.clickCreate();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Expense amount is required']")));
        Assert.assertTrue(toast.getText().contains("Expense amount is required"), "Error message not displayed");
    }

    @Test(priority = 12)
    public void invalidAmount() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.enterExpenseAmount("h");
        ep.clickCreate();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Only numbers with decimals are allowed']")));
        Assert.assertTrue(toast.getText().contains("Only numbers with decimals are allowed"), "Error message not displayed");
    }


    @Test(priority = 13)
    public void emptyStatus() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.enterExpenseAmount("100");
        ep.clickCreate();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Status is required']")));
        Assert.assertTrue(toast.getText().contains("Status is required"), "Error message not displayed");
    }

    @Test(priority = 14)
    public void validExpense() throws InterruptedException {
        ExpensePage ep = new ExpensePage(driver);

        ep.enterExpenseDate("20/05/2026");
        ep.enterExpenseAmount("100");
        ep.selectStatus();
        ep.clickCreate();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Expense created successfully']")));
        Assert.assertTrue(toast.getText().contains("Expense created successfully"), "Error message not displayed");
    }

}