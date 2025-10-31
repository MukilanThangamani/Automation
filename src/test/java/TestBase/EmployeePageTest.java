package TestBase;

import PageObjects.EmployeePage;
import PageObjects.RolePage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeePageTest extends BaseClass{

    @Test(priority = 7)
    public void testAddEmployee() throws InterruptedException {
        EmployeePage ep = new EmployeePage(driver);

        String[] names = {randomString(), randomString()};

        // String[] role = {"Master","Tailor"};
        String[] role1 = {"Master","Tailor"};
        //  String[] mobiles = {phoneRandom(), phoneRandom()};
        // String[] passwords = {randomAlphaAnumeric(), randomAlphaAnumeric()};
        //   String[] gender = {"Female","Male"};

// Add employees
            ep.empDetail();

// ✅ Verify employees are present in table
        //  ep.verifyEmployeesInTable(names, role1);

// Continue to next page
          ep.nxtBtnEmp();
    }

}