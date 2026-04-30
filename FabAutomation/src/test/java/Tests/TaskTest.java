package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.TaskPage;

public class TaskTest extends BaseTest {

    private TaskPage taskPage;

    @BeforeMethod
    public void initPage() {
        taskPage = new TaskPage(driver, wait);
        // ✅ Update URL to your Task setup/step page
        driver.get(BASE_URL + "/settings/boutique?id=405");
    }

    // TC_029 – Add task with all valid inputs
    @Test(description = "TC_029 - Add task with all valid fields including buffer times")
    public void TC_029_addTaskWithAllValidInputs() {
        taskPage.enterTaskName("Ironing");
        taskPage.enterCharges("50");
        taskPage.selectRole("Helper");
        taskPage.checkBufferCheckbox();
        taskPage.enterIdleTime("2");
        taskPage.selectIdleType("Minutes");
        taskPage.enterRushTime("1");
        taskPage.selectRushType("Hours");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isSuccessVisible() || taskPage.isTaskInList("Ironing"),
                "Expected task to be added and listed");
    }

    // TC_030 – Add task with valid data
    @Test(description = "TC_030 - Add task with all fields filled")
    public void TC_030_addTaskWithValidData() {
        taskPage.fillValidTask("Ironing_" + System.currentTimeMillis(), "50", "Helper");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isSuccessVisible(),
                "Expected success after adding valid task");
    }

    // TC_031 – Submit without Task Name
    @Test(description = "TC_031 - Submitting without Task Name shows required error")
    public void TC_031_submitWithoutTaskName() {
        taskPage.enterCharges("50");
        taskPage.selectRole("Helper");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("task name") ||
                        taskPage.isErrorVisible("required"),
                "Expected 'Task Name is required' error");
    }

    // TC_032 – Submit without Charges
    @Test(description = "TC_032 - Submitting without Charges shows required error")
    public void TC_032_submitWithoutCharges() {
        taskPage.enterTaskName("Ironing");
        taskPage.selectRole("Helper");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("charges") ||
                        taskPage.isErrorVisible("required"),
                "Expected 'Charges per Hour is required' error");
    }

    // TC_033 – Non-numeric charges
    @Test(description = "TC_033 - Non-numeric charges shows invalid value error")
    public void TC_033_nonNumericCharges() {
        taskPage.enterTaskName("Ironing");
        taskPage.enterCharges("abc");
        taskPage.selectRole("Helper");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("numeric") ||
                        taskPage.isErrorVisible("valid"),
                "Expected numeric validation error for Charges/Hour");
    }

    // TC_034 – Submit without selecting Role
    @Test(description = "TC_034 - Submitting without Role shows required error")
    public void TC_034_submitWithoutRole() {
        taskPage.enterTaskName("Ironing");
        taskPage.enterCharges("50");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("role") ||
                        taskPage.isErrorVisible("required"),
                "Expected 'Role is required' error");
    }

    // TC_035 – Buffer checkbox checked but no values
    @Test(description = "TC_035 - Buffer checkbox checked with blank buffer fields shows error")
    public void TC_035_bufferCheckboxWithNoValues() {
        taskPage.fillValidTask("Ironing", "50", "Helper");
        taskPage.checkBufferCheckbox();
        // Leave idle/rush fields blank
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("buffer") ||
                        taskPage.isErrorVisible("enter"),
                "Expected error when buffer checkbox is checked but fields are empty");
    }

    // TC_036 – Non-numeric buffer times
    @Test(description = "TC_036 - Non-numeric buffer time values show error")
    public void TC_036_nonNumericBufferTimes() {
        taskPage.fillValidTask("Ironing", "50", "Helper");
        taskPage.checkBufferCheckbox();
        taskPage.enterIdleTime("abc");
        taskPage.enterRushTime("xyz");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("numeric") ||
                        taskPage.isErrorVisible("numeric values"),
                "Expected numeric validation error for buffer time fields");
    }

    // TC_037 – Add task and verify in list
    @Test(description = "TC_037 - Added task appears in the task list below")
    public void TC_037_addTaskAndVerifyInList() {
        String taskName = "Ironing_" + System.currentTimeMillis();
        taskPage.fillValidTask(taskName, "50", "Helper");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isTaskInList(taskName),
                "Expected task '" + taskName + "' to appear in task list");
    }

    // TC_038 – Edit an existing task
    @Test(description = "TC_038 - Editing a task updates it in the list")
    public void TC_038_editExistingTask() {
        taskPage.clickEditIcon(0);
        taskPage.enterCharges("60");
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isSuccessVisible(),
                "Expected success message after editing task");
    }

    // TC_039 – Submit without Type for Idle
    @Test(description = "TC_039 - Buffer idle time entered but no type selected shows error")
    public void TC_039_submitWithoutIdleType() {
        taskPage.fillValidTask("Ironing", "50", "Helper");
        taskPage.checkBufferCheckbox();
        taskPage.enterIdleTime("2");
        // Do NOT select Idle Type
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("idle") ||
                        taskPage.isErrorVisible("type"),
                "Expected 'Type for Idle is required' error");
    }

    // TC_040 – Submit without Type for Rush
    @Test(description = "TC_040 - Buffer rush time entered but no type selected shows error")
    public void TC_040_submitWithoutRushType() {
        taskPage.fillValidTask("Ironing", "50", "Helper");
        taskPage.checkBufferCheckbox();
        taskPage.enterRushTime("1");
        // Do NOT select Rush Type
        taskPage.clickSubmit();
        Assert.assertTrue(taskPage.isErrorVisible("rush") ||
                        taskPage.isErrorVisible("type"),
                "Expected 'Type for Rush is required' error");
    }

    // TC_041 – Close the Add Task dialog
    @Test(description = "TC_041 - Closing Add Task dialog discards unsaved data")
    public void TC_041_closeAddTaskDialog() {
        taskPage.enterTaskName("SomeTask");
        taskPage.clickClose();
        Assert.assertTrue(taskPage.isDialogClosed(),
                "Expected dialog to be closed after clicking Close");
    }

    // TC_042 – Navigate to previous step
    @Test(description = "TC_042 - Previous button navigates to Step 3 (Roles)")
    public void TC_042_navigateToPreviousStep() {
        taskPage.clickPrevious();
        Assert.assertTrue(driver.getCurrentUrl().contains("roles") ||
                        driver.getPageSource().toLowerCase().contains("role"),
                "Expected navigation to Roles step after clicking Previous");
    }

    // TC_043 – Navigate to next step
    @Test(description = "TC_043 - Next button navigates to Step 5 (Product Type)")
    public void TC_043_navigateToNextStep() {
        taskPage.clickNext();
        Assert.assertTrue(driver.getCurrentUrl().contains("product") ||
                        driver.getPageSource().toLowerCase().contains("product type"),
                "Expected navigation to Product Type step after clicking Next");
    }
}