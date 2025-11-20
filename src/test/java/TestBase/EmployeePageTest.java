package TestBase;

import PageObjects.EmployeePage;
import org.testng.annotations.Test;

public class EmployeePageTest extends BaseClass{

    @Test(priority = 7)
    public void testAddEmployee() throws InterruptedException {
        EmployeePage ep = new EmployeePage(driver);

          String[] names = {randomString(), randomString()};
          ep.empDetail();
          ep.nxtBtnEmp();
    }

}