package TestBase;

import PageObjects.EmployeeManagement;
import org.testng.annotations.Test;

public class EmployeeManagementTest extends BaseClass{

    @Test(priority = 16)
    public void manageEmployee() throws InterruptedException {
        // Placeholder for future employee management tests
        EmployeeManagement em = new EmployeeManagement(driver);
        em.empDetail();
    }

}
