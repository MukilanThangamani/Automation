package TestBase;

import PageObjects.RolePage;
import org.testng.annotations.Test;

public class RolePageTest extends BaseClass {

    @Test
    public void testAddRole() throws InterruptedException {
        RolePage rp = new RolePage(driver);

        String roleName = randomString();
        rp.add(roleName);
        rp.verifyRoleInTable(roleName);
        System.out.println(" Role added and verified: " + roleName);

        rp.nextBtn();

        String editRole = randomString();
        rp.editclick(editRole);
        System.out.println(" Role edited to: " + editRole);


        Thread.sleep(1000);
        rp.toFindDuplicate("master");
        System.out.println(" Checked for duplicate role: master");

        rp.moveToNextPage();
        System.out.println(" Moved to next page after role tests");

    }
}
