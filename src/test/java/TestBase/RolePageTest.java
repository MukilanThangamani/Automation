package TestBase;

import PageObjects.RolePage;
import org.testng.annotations.Test;

public class RolePageTest extends BaseClass {

    @Test(priority = 6)
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);

        //        Add and verify role
        String roleName = randomString();
        rp.add(roleName);
        rp.verifyRoleInTable(roleName);
        System.out.println(" Role added and verified: " + roleName);

        // Navigate to next page
        rp.nextBtn();

        // Edit role test
        String editRole = randomString();
        rp.editclick(editRole);
        System.out.println(" Role edited to: " + editRole);

        //  Duplicate role test
        Thread.sleep(1000);
        rp.toFindDuplicate("master");
        System.out.println(" Checked for duplicate role: master");

        //  Navigation to next page
        rp.moveToNextPage();
        System.out.println(" Moved to next page after role tests");

        //Just
      //  rp.just();
    }
}
