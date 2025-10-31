package TestBase;

import PageObjects.ExpensePage;
import org.testng.annotations.Test;

public class ExpensePageTest extends BaseClass{

    @Test(priority = 14)
    public void testExpense() throws InterruptedException{
        ExpensePage ep = new ExpensePage(driver);
        ep.expenseDetail(randomString(),"11/08/2025",randomAmount());
        // ep.toUpdate();
    }

}