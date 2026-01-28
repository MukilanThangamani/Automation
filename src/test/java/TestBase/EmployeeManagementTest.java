package TestBase;

import PageObjects.EmployeeManagement;
import org.testng.annotations.Test;

public class EmployeeManagementTest extends BaseClass{


    @Test
    public void manageEmployee() throws InterruptedException {
        EmployeeManagement em = new EmployeeManagement(driver);
        em.empDetail();
    }

}
