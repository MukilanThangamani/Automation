package TestBase;

import PageObjects.ExpensePage;
import org.testng.annotations.Test;

public class ExpensePageTest extends BaseClass{

    @Test
    public void testExpense() throws InterruptedException{
        ExpensePage ep = new ExpensePage(driver);
        ep.addCategory(randomString());
        ep.addExpense(randomString(),"06/01/2026",randomAmount());
    }



}