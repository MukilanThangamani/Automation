package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.RolesPage;

public class RoleTest extends BaseTest{

    private RolesPage rolesPage;

    @BeforeClass
    public void initPage() {
        driver.get(BASE_URL + "/settings/boutique?id=405");

        rolesPage = new RolesPage(driver); // ✅ correct driver from BaseTest
    }

    // TC_018 – Prevent navigation with unsaved role
    @Test(priority = 15, description = "TC_018 - Block navigation when role form has unsaved data")
    public void TC_015_preventNavigationOnUnsavedRole() {
        rolesPage.clickNext();
        rolesPage.clickAddRoles();
        rolesPage.enterRoleName("Finisher");
     //   rolesPage.clickDashboardMenuItem();
    }

    // TC_019 – Add new valid role
    @Test(description = "TC_019 - Add a valid role and verify in list")
    public void TC_019_addValidRole() {
        rolesPage.addRole("Finisher_" + System.currentTimeMillis()); // unique name
        Assert.assertTrue(rolesPage.isSuccessVisible(),
                "Expected success message after adding valid role");
    }
/*
    // TC_020 – Add role with empty name
    @Test(description = "TC_020 - Submit empty role name shows required error")
    public void TC_020_addRoleWithEmptyName() {
        rolesPage.clickAddRoles();
        rolesPage.clickSubmit();
        Assert.assertTrue(rolesPage.isErrorVisible("required") ||
                        rolesPage.isErrorVisible("role name"),
                "Expected 'Role name is required' error");
    }

    // TC_021 – Add duplicate role
    @Test(description = "TC_021 - Adding duplicate role shows already-exists error")
    public void TC_021_addDuplicateRole() {
        rolesPage.addRole("Tailor"); // assumes Tailor already exists in the system
        Assert.assertTrue(rolesPage.isErrorVisible("already exists") ||
                        rolesPage.isErrorVisible("duplicate"),
                "Expected 'Role already exists' error");
    }

    // TC_022 – Add role with special characters
    @Test(description = "TC_022 - Role with special characters is restricted or shows error")
    public void TC_022_addRoleWithSpecialCharacters() {
        rolesPage.clickAddRoles();
        rolesPage.enterRoleName("@#$%^&");
        rolesPage.clickSubmit();
        Assert.assertTrue(rolesPage.isErrorVisible("invalid") ||
                        rolesPage.isErrorVisible("special") ||
                        !rolesPage.isRoleInList("@#$%^&"),
                "Expected restriction or error for special character role name");
    }

    // TC_023 – Add role with alphanumeric name
    @Test(description = "TC_023 - Role with alphanumeric name is added if allowed")
    public void TC_023_addRoleWithAlphanumericName() {
        String roleName = "Role123_" + System.currentTimeMillis();
        rolesPage.addRole(roleName);
        // Either succeeds or shows appropriate error – both are valid per spec
        boolean added   = rolesPage.isRoleInList(roleName) || rolesPage.isSuccessVisible();
        boolean errored = rolesPage.isErrorVisible("invalid");
        Assert.assertTrue(added || errored,
                "Expected either role to be added or a meaningful error message");
    }

    // TC_024 – Edit existing role successfully
    @Test(description = "TC_024 - Edit role name and verify updated in list")
    public void TC_024_editExistingRoleSuccessfully() {
        rolesPage.clickEditIcon(0); // Edit first role in the list
        rolesPage.enterRoleName("Lead Tailor_" + System.currentTimeMillis());
        rolesPage.clickSubmit();
        Assert.assertTrue(rolesPage.isSuccessVisible(),
                "Expected success message after editing role");
    }

    // TC_025 – Edit role with blank name
    @Test(description = "TC_025 - Clearing role name during edit shows required error")
    public void TC_025_editRoleWithBlankName() {
        rolesPage.clickEditIcon(0);
        rolesPage.clearRoleName();
        rolesPage.clickSubmit();
        Assert.assertTrue(rolesPage.isErrorVisible("required") ||
                        rolesPage.isErrorVisible("role name"),
                "Expected 'Role name is required' error on blank edit");
    }

    // TC_026 – Edit role to duplicate name
    @Test(description = "TC_026 - Editing role to existing name shows duplicate error")
    public void TC_026_editRoleToDuplicateName() {
        rolesPage.clickEditIcon(0);
        rolesPage.enterRoleName("Designer"); // assumes Designer already exists
        rolesPage.clickSubmit();
        Assert.assertTrue(rolesPage.isErrorVisible("already exists") ||
                        rolesPage.isErrorVisible("duplicate"),
                "Expected 'Role already exists' error");
    }

    // TC_027 – Pagination check with many roles
    @Test(description = "TC_027 - Pagination loads next page of roles")
    public void TC_027_paginationCheck() {
        if (rolesPage.isPaginationNextEnabled()) {
            rolesPage.clickNextPage();
            Assert.assertTrue(driver.findElements(
                            org.openqa.selenium.By.cssSelector(".role-list-item, table tbody tr")).size() > 0,
                    "Expected roles to load on next page");
        } else {
            System.out.println("TC_027 SKIPPED: Pagination not present (fewer than 1 page of roles)");
        }
    }

    // TC_028 – Case-insensitive duplicate prevention
    @Test(description = "TC_028 - Duplicate role check is case-insensitive (TAILOR vs tailor)")
    public void TC_028_caseInsensitiveDuplicatePrevention() {
        rolesPage.addRole("TAILOR"); // expects 'tailor' already exists
        Assert.assertTrue(rolesPage.isErrorVisible("already exists") ||
                        rolesPage.isErrorVisible("duplicate"),
                "Expected duplicate error even for case-variant role name");
    }
    */
}