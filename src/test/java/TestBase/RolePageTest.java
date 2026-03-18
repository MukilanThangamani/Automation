package TestBase;

import PageObjects.RolePage;
import Utils.TestListener;
import org.testng.annotations.Test;

public class RolePageTest extends BaseClass {

    @Test
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);

        String roleName = randomString();
        TestListener.test.get().pass("Enter role name :");
        rp.add(roleName);
        TestListener.test.get().pass("Enter task name and charge  :");
        rp.addTaskAndCharge(randomString(),randomAmount());
        rp.verifyRoleInTable(roleName);
        System.out.println(" Role added and verified: " + roleName);

        rp.nextBtn();

     /*   String editRole = randomString();
        rp.editclick(editRole);
        System.out.println(" Role edited to: " + editRole);


        Thread.sleep(1000);
        rp.toFindDuplicate("master");
        System.out.println(" Checked for duplicate role: master");

        rp.moveToNextPage();
        System.out.println(" Moved to next page after role tests"); */

    }
}
