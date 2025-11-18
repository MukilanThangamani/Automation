package TestBase;

import PageObjects.ExpensePage;
import org.testng.annotations.Test;

public class ExpensePageTest extends BaseClass{

    @Test(priority = 15)
    public void testExpense() throws InterruptedException{
        ExpensePage ep = new ExpensePage(driver);
        ep.addCategory(randomString());
        ep.addExpense(randomString(),"18/11/2025",randomAmount());
        // ep.toUpdate();
    }

}