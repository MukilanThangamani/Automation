package TestBase;

import PageObjects.ExpensePage;
import org.testng.annotations.Test;

public class ExpensePageTest extends BaseClass{

    @Test(priority = 15)
    public void testExpense() throws InterruptedException{
        ExpensePage ep = new ExpensePage(driver);
        ep.addCategory(randomString());
        ep.addExpense(randomString(),"11/12/2025",randomAmount());
        // ep.toUpdate();
    }

}