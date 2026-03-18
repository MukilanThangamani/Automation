package TestBase;

import PageObjects.EmployeePage;
import Utils.TestListener;
import org.testng.annotations.Test;

public class EmployeePageTest extends BaseClass{

    @Test
    public void testAddEmployee() throws InterruptedException {
        EmployeePage ep = new EmployeePage(driver);
        TestListener.test.get().pass("Enter employee details :");
          String[] names = {randomString(), randomString()};
          ep.empDetail();
          ep.nxtBtnEmp();
    }

}
