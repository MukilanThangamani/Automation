package TestBase;

import PageObjects.ExpensePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
    public void testExpense() throws InterruptedException{
        ExpensePage ep = new ExpensePage(driver);
        ep.addCategory(randomString());
        ep.addExpense(randomString(),"17/03/2026",randomAmount());
    }

}