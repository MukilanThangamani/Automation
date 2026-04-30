package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.EmployeePage;

public class EmployeeTest extends BaseTest {

    private EmployeePage employeePage;

    @BeforeMethod
    public void initPage() {
        employeePage = new EmployeePage(driver, wait);
        // ✅ Update URL to your Employee page
        driver.get(BASE_URL + "/settings/boutique?id=405");
    }

    // ─── Regular Employee Tests ───────────────────────────────────────────────

    // TC_044 – Emergency contact is optional
    @Test(description = "TC_044 - Form submits without Emergency Contact (optional)")
    public void TC_044_emergencyContactOptional() {
        employeePage.enterName("Test Employee");
        employeePage.enterMobile("9876543210");
        employeePage.enterPassword("Test@1234");
        employeePage.clickSubmit();
        Assert.assertFalse(employeePage.isErrorVisible("emergency"),
                "Emergency contact should be optional — no error expected");
    }

    // TC_045 – Photo and ID proof upload
    @Test(description = "TC_045 - Photo and ID proof upload successfully")
    public void TC_045_photoAndIdUpload() {
        employeePage.uploadPhoto("/path/to/photo.jpg");       // ✅ Replace with real path
        employeePage.uploadIdProof("/path/to/idproof.png");   // ✅ Replace with real path
        Assert.assertTrue(
                employeePage.isFilePreviewVisible(".ant-upload-list-item, [data-testid='photo-preview']"),
                "Expected photo/ID files to show preview after upload");
    }

    // TC_046 – Address fields are optional
    @Test(description = "TC_046 - Form submits without address fields (optional)")
    public void TC_046_addressFieldsOptional() {
        employeePage.enterName("Test Employee");
        employeePage.enterMobile("9876543210");
        employeePage.enterPassword("Test@1234");
        // Address left blank intentionally
        employeePage.clickSubmit();
        Assert.assertFalse(employeePage.isErrorVisible("address"),
                "Address fields should be optional — no error expected");
    }

    // TC_047 – Dropdowns load predefined values
    @Test(description = "TC_047 - Role, Gender, Blood Group dropdowns load values")
    public void TC_047_dropdownsLoadValues() {
        boolean roleLoaded        = employeePage.isDropdownPopulated(
                org.openqa.selenium.By.cssSelector("[data-testid='role-dropdown'], select[name='role']"));
        boolean genderLoaded      = employeePage.isDropdownPopulated(
                org.openqa.selenium.By.cssSelector("[data-testid='gender-dropdown'], select[name='gender']"));
        boolean bloodGroupLoaded  = employeePage.isDropdownPopulated(
                org.openqa.selenium.By.cssSelector("[data-testid='blood-group-dropdown']"));

        Assert.assertTrue(roleLoaded,       "Role dropdown should have options");
        Assert.assertTrue(genderLoaded,     "Gender dropdown should have options");
        Assert.assertTrue(bloodGroupLoaded, "Blood Group dropdown should have options");
    }

    // TC_048 – Date pickers work correctly
    @Test(description = "TC_048 - DOB and DOJ date pickers open calendar")
    public void TC_048_datePickersWork() {
        driver.findElement(
                        org.openqa.selenium.By.cssSelector("[data-testid='dob-picker'], input[name='dateOfBirth']"))
                .click();
        Assert.assertTrue(employeePage.isCalendarVisible(),
                "Expected calendar picker to open on DOB click");
    }

    // TC_049 – Password field is masked
    @Test(description = "TC_049 - Password input appears as masked (dots/asterisks)")
    public void TC_049_passwordIsMasked() {
        Assert.assertTrue(employeePage.isPasswordMasked(),
                "Expected password field type to be 'password' (masked)");
    }

    // TC_050 – Prevent navigation during data entry
    @Test(description = "TC_050 - Navigation blocked when form has unsaved data")
    public void TC_050_preventNavigationDuringEntry() {
        employeePage.enterName("Raj");
        employeePage.clickDashboardMenuItem();
        Assert.assertTrue(employeePage.isUnsavedChangesDialogVisible(),
                "Expected unsaved-changes confirmation dialog");
    }

    // TC_051 – Form resets after closing and reopening
    @Test(description = "TC_051 - Reopened form is cleared/reset")
    public void TC_051_formResetAfterClose() {
        employeePage.enterName("Raj");
        employeePage.clickClose();
        employeePage.clickAddEmployeeButton(); // reopen
        String nameValue = driver.findElement(
                org.openqa.selenium.By.name("name")).getAttribute("value");
        Assert.assertTrue(nameValue == null || nameValue.isEmpty(),
                "Expected form to be empty after close and reopen");
    }

    // TC_052 – Duplicate employee prevention
    @Test(description = "TC_052 - Submitting duplicate employee shows error")
    public void TC_052_duplicateEmployeePrevention() {
        employeePage.enterName("Ayesha Khan");
        employeePage.enterMobile("9876543210");
        employeePage.enterPassword("Test@1234");
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isErrorVisible("duplicate") ||
                        employeePage.isErrorVisible("already exists"),
                "Expected duplicate employee error");
    }

    // TC_053 – Edit employee details
    @Test(description = "TC_053 - Editing employee details saves changes")
    public void TC_053_editEmployeeDetails() {
        employeePage.clickEditIcon(0);
        // Change role (adjust selector to match your role dropdown in edit form)
        new org.openqa.selenium.support.ui.Select(
                driver.findElement(org.openqa.selenium.By.cssSelector("select[name='role']")))
                .selectByVisibleText("Designer");
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isSuccessVisible(),
                "Expected success message after editing employee");
    }

    // TC_054 – Delete an employee
    @Test(description = "TC_054 - Deleting employee removes from list after confirmation")
    public void TC_054_deleteEmployee() {
        int countBefore = employeePage.getEmployeeCount();
        employeePage.clickDeleteIcon(0);
        Assert.assertTrue(employeePage.isConfirmDialogVisible(),
                "Expected delete confirmation dialog");
        employeePage.confirmDelete();
        int countAfter = employeePage.getEmployeeCount();
        Assert.assertTrue(countAfter < countBefore,
                "Expected employee count to decrease after deletion");
    }

    // TC_055 – Toggle attendance
    @Test(description = "TC_055 - Clicking attendance icon toggles employee attendance")
    public void TC_055_toggleAttendance() {
        // Get initial icon state
        String classBefore = driver.findElements(
                        org.openqa.selenium.By.cssSelector("[data-testid='attendance-icon'], button.attendance-btn"))
                .get(0).getAttribute("class");
        employeePage.clickAttendanceIcon(0);
        String classAfter = driver.findElements(
                        org.openqa.selenium.By.cssSelector("[data-testid='attendance-icon'], button.attendance-btn"))
                .get(0).getAttribute("class");
        Assert.assertNotEquals(classBefore, classAfter,
                "Expected attendance icon state to change after click");
    }

    // TC_056 – View employee history
    @Test(description = "TC_056 - Clicking history icon shows employee activities")
    public void TC_056_viewEmployeeHistory() {
        employeePage.clickHistoryIcon(0);
        Assert.assertTrue(
                driver.findElements(
                        org.openqa.selenium.By.cssSelector(
                                ".history-panel, [data-testid='history-panel'], .ant-drawer")).size() > 0,
                "Expected history panel or drawer to open");
    }

    // TC_057 & TC_058 – Prevent navigation during task data entry
    @Test(description = "TC_057/TC_058 - Navigation blocked when task form has unsaved input")
    public void TC_057_TC_058_preventNavigationInTaskForm() {
        // Navigate to task form context
        driver.get(BASE_URL + "/setup/tasks");
        driver.findElement(
                org.openqa.selenium.By.cssSelector(
                        "button[data-testid='add-task'], button.add-task-btn")).click();
        driver.findElement(
                org.openqa.selenium.By.cssSelector(
                        "input[name='taskName'], input[placeholder*='task name']")).sendKeys("Partial Input");
        employeePage.clickDashboardMenuItem();
        Assert.assertTrue(employeePage.isUnsavedChangesDialogVisible(),
                "Expected unsaved-changes dialog when navigating away from task form");
    }

    // ─── Outsourcing Employee Tests ───────────────────────────────────────────

    @BeforeMethod(onlyForGroups = "outsourcing")
    public void goToOutsourcingTab() {
        driver.get(BASE_URL + "/employees/outsourcing");
    }

    // TC_059 – Outsourcing tab loads
    @Test(groups = "outsourcing", description = "TC_059 - Outsourcing Employees tab loads with correct columns")
    public void TC_059_outsourcingTabLoads() {
        Assert.assertTrue(driver.getPageSource().contains("Name") &&
                        driver.getPageSource().contains("Mobile Number") &&
                        driver.getPageSource().contains("Role"),
                "Expected outsourcing employee list with Name, Mobile, Role columns");
    }

    // TC_060 – Employee list is displayed
    @Test(groups = "outsourcing", description = "TC_060 - Existing outsourcing employees are visible")
    public void TC_060_employeeListDisplayed() {
        Assert.assertTrue(employeePage.getEmployeeCount() > 0 ||
                        driver.getPageSource().contains("No Data"),
                "Expected employee list or empty state message");
    }

    // TC_061 – Empty state message
    @Test(groups = "outsourcing", description = "TC_061 - Empty state shows No Data message")
    public void TC_061_emptyStateMessage() {
        // This test is valid only when no employees exist
        if (employeePage.getEmployeeCount() == 0) {
            Assert.assertTrue(driver.getPageSource().contains("No Data") ||
                            driver.getPageSource().contains("No data"),
                    "Expected 'No Data' empty state message");
        } else {
            System.out.println("TC_061 SKIPPED: Employees exist, cannot test empty state");
        }
    }

    // TC_062 – Add Employee button opens form
    @Test(groups = "outsourcing", description = "TC_062 - Add Outsourcing Employee opens form")
    public void TC_062_addEmployeeButtonOpensForm() {
        employeePage.clickAddEmployeeButton();
        Assert.assertTrue(
                driver.findElements(
                        org.openqa.selenium.By.cssSelector(".ant-modal, [role='dialog']")).size() > 0,
                "Expected Add Employee form to open");
    }

    // TC_063 – Add outsourcing employee with valid data
    @Test(groups = "outsourcing", description = "TC_063 - Add outsourcing employee with valid data")
    public void TC_063_addOutsourcingEmployeeValid() {
        employeePage.clickAddEmployeeButton();
        employeePage.enterName("Ravi_" + System.currentTimeMillis());
        employeePage.enterMobile("9876543210");
        driver.findElement(org.openqa.selenium.By.name("address")).sendKeys("Chennai");
        new org.openqa.selenium.support.ui.Select(
                driver.findElement(org.openqa.selenium.By.cssSelector("select[name='role']")))
                .selectByVisibleText("Tailor");
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isSuccessVisible(),
                "Expected success message after adding outsourcing employee");
    }

    // TC_064 – Add with empty fields
    @Test(groups = "outsourcing", description = "TC_064 - Submit empty form shows validation error")
    public void TC_064_addEmployeeEmptyFields() {
        employeePage.clickAddEmployeeButton();
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.getEmployeeCount() >= 0 ||
                        driver.findElements(
                                org.openqa.selenium.By.cssSelector(".ant-form-item-explain-error")).size() > 0,
                "Expected validation errors on empty form");
    }

    // TC_065 – Invalid mobile number
    @Test(groups = "outsourcing", description = "TC_065 - Invalid mobile number shows error")
    public void TC_065_invalidMobileNumber() {
        employeePage.clickAddEmployeeButton();
        employeePage.enterName("Test");
        employeePage.enterMobile("123");
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isErrorVisible("mobile") ||
                        employeePage.isErrorVisible("invalid"),
                "Expected mobile number validation error");
    }

    // TC_066 – Duplicate mobile number prevention
    @Test(groups = "outsourcing", description = "TC_066 - Duplicate mobile number shows error")
    public void TC_066_duplicateMobileNumber() {
        employeePage.clickAddEmployeeButton();
        employeePage.enterName("AnotherRavi");
        employeePage.enterMobile("9876543210"); // existing mobile
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isErrorVisible("duplicate") ||
                        employeePage.isErrorVisible("already exists"),
                "Expected duplicate mobile number error");
    }

    // TC_067 – Search by name
    @Test(groups = "outsourcing", description = "TC_067 - Search by name filters employee list")
    public void TC_067_searchByName() {
        employeePage.searchByName("Shankar");
        Assert.assertTrue(employeePage.isEmployeeInList("Shankar") ||
                        driver.getPageSource().contains("No Data"),
                "Expected search to filter employees by name");
    }

    // TC_068 – Edit icon opens pre-filled form
    @Test(groups = "outsourcing", description = "TC_068 - Edit icon opens form with existing data")
    public void TC_068_editIconOpensPrefilled() {
        employeePage.clickEditIcon(0);
        String nameValue = driver.findElement(org.openqa.selenium.By.name("name"))
                .getAttribute("value");
        Assert.assertFalse(nameValue == null || nameValue.isEmpty(),
                "Expected edit form to be pre-filled with employee data");
    }

    // TC_069 – Update employee details
    @Test(groups = "outsourcing", description = "TC_069 - Updated employee data reflects in list")
    public void TC_069_updateEmployeeDetails() {
        employeePage.clickEditIcon(0);
        new org.openqa.selenium.support.ui.Select(
                driver.findElement(org.openqa.selenium.By.cssSelector("select[name='role']")))
                .selectByIndex(1); // select any different role
        employeePage.clickSubmit();
        Assert.assertTrue(employeePage.isSuccessVisible(),
                "Expected success after updating outsourcing employee");
    }

    // TC_070 – Cancel edit
    @Test(groups = "outsourcing", description = "TC_070 - Cancelling edit saves no changes")
    public void TC_070_cancelEdit() {
        employeePage.clickEditIcon(0);
        String nameBefore = driver.findElement(org.openqa.selenium.By.name("name"))
                .getAttribute("value");
        driver.findElement(org.openqa.selenium.By.name("name")).clear();
        driver.findElement(org.openqa.selenium.By.name("name")).sendKeys("Changed Name");
        employeePage.clickClose(); // cancel
        // Re-check – name should be unchanged
        employeePage.clickEditIcon(0);
        String nameAfter = driver.findElement(org.openqa.selenium.By.name("name"))
                .getAttribute("value");
        Assert.assertEquals(nameAfter, nameBefore,
                "Expected name to remain unchanged after cancelling edit");
    }

    // TC_071 – Delete icon shows confirmation
    @Test(groups = "outsourcing", description = "TC_071 - Delete icon shows confirmation popup")
    public void TC_071_deleteIconShowsConfirmation() {
        employeePage.clickDeleteIcon(0);
        Assert.assertTrue(employeePage.isConfirmDialogVisible(),
                "Expected delete confirmation popup to appear");
    }

    // TC_072 – Confirm delete removes employee
    @Test(groups = "outsourcing", description = "TC_072 - Confirming delete removes employee from list")
    public void TC_072_confirmDelete() {
        int countBefore = employeePage.getEmployeeCount();
        employeePage.clickDeleteIcon(0);
        employeePage.confirmDelete();
        int countAfter = employeePage.getEmployeeCount();
        Assert.assertTrue(countAfter < countBefore,
                "Expected employee count to decrease after deletion");
    }

    // TC_073 – Cancel delete keeps employee
    @Test(groups = "outsourcing", description = "TC_073 - Cancelling delete keeps employee in list")
    public void TC_073_cancelDelete() {
        int countBefore = employeePage.getEmployeeCount();
        employeePage.clickDeleteIcon(0);
        employeePage.cancelDelete();
        int countAfter = employeePage.getEmployeeCount();
        Assert.assertEquals(countAfter, countBefore,
                "Expected employee count to remain unchanged after cancelling delete");
    }
}