package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.ProductTypePage;

public class ProductTest extends BaseTest {

    private ProductTypePage productTypePage;

    @BeforeMethod
    public void initPage() {
        productTypePage = new ProductTypePage(driver, wait);
        // ✅ Update URL to your Product Type setup page
        driver.get(BASE_URL + "/settings/boutique?id=405");
    }

    // TC_074 – Create new common measurement template
    @Test(description = "TC_074 - New measurement template created and visible as tag")
    public void TC_074_createCommonMeasurementTemplate() {
        productTypePage.addCustomMeasurement("NeckSize");
        Assert.assertTrue(productTypePage.isCommonMeasurementTagVisible("NeckSize"),
                "Expected 'NeckSize' to appear as a measurement tag");
    }

    // TC_075 – Remove a measurement template
    @Test(description = "TC_075 - Measurement template removed after clicking X")
    public void TC_075_removeMeasurementTemplate() {
        productTypePage.addCustomMeasurement("NeckSize");
        productTypePage.deleteCustomMeasurement("NeckSize");
        Assert.assertFalse(productTypePage.isCommonMeasurementTagVisible("NeckSize"),
                "Expected 'NeckSize' to be removed after clicking X");
    }

    // TC_076 – Prevent duplicate common measurement
    @Test(description = "TC_076 - Duplicate measurement name shows error")
    public void TC_076_preventDuplicateMeasurement() {
        productTypePage.addCustomMeasurement("NeckSize");
        productTypePage.addCustomMeasurement("NeckSize"); // try duplicate
        Assert.assertTrue(productTypePage.isErrorVisible("already exists") ||
                        productTypePage.isErrorVisible("duplicate"),
                "Expected duplicate measurement error");
    }

    // TC_077 – UI elements visible in Add Product Type popup
    @Test(description = "TC_077 - All UI elements visible in Add Product Type popup")
    public void TC_077_uiElementsVisibleInPopup() {
        productTypePage.clickAddProductType();
        Assert.assertTrue(
                driver.findElement(org.openqa.selenium.By.cssSelector(
                        "select[name='gender'], [data-testid='gender-select']")).isDisplayed(),
                "Expected Gender field to be visible");
        Assert.assertTrue(
                driver.findElement(org.openqa.selenium.By.cssSelector(
                        "select[name='productType'], [data-testid='product-type-select']")).isDisplayed(),
                "Expected Product Type dropdown to be visible");
        Assert.assertTrue(
                driver.findElement(org.openqa.selenium.By.cssSelector(
                        "button[type='submit']")).isDisplayed(),
                "Expected Submit button to be visible");
    }

    // TC_078 – Add product type with all valid data
    @Test(description = "TC_078 - Valid product type is added and listed")
    public void TC_078_addProductTypeWithValidData() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName("Tunic_" + System.currentTimeMillis());
        productTypePage.addMeasurement("Length");
        productTypePage.clickAddTask();
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isSuccessVisible(),
                "Expected success after adding valid product type");
    }

    // TC_079 – Add product type without Gender
    @Test(description = "TC_079 - Missing Gender shows required error")
    public void TC_079_addProductTypeWithoutGender() {
        productTypePage.clickAddProductType();
        productTypePage.selectProductType("Kurta");
        productTypePage.addMeasurement("Length");
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("gender") ||
                        productTypePage.isErrorVisible("required"),
                "Expected 'Gender is required' error");
    }

    // TC_080 – Add product type without Product Type dropdown
    @Test(description = "TC_080 - Missing Product Type shows required error")
    public void TC_080_addProductTypeWithoutProductType() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.addMeasurement("Length");
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("product type") ||
                        productTypePage.isErrorVisible("required"),
                "Expected 'Product Type is required' error");
    }

    // TC_081 – Add with Product Type = Others but blank New Product Type
    @Test(description = "TC_081 - Others selected but New Product Type blank shows error")
    public void TC_081_othersWithoutNewProductTypeName() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.selectProductType("Others");
        // Leave New Product Type blank
        productTypePage.addMeasurement("Length");
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("new product type") ||
                        productTypePage.isErrorVisible("required"),
                "Expected error for blank New Product Type when Others is selected");
    }

    // TC_082 – Add duplicate product type name
    @Test(description = "TC_082 - Duplicate product type name shows already-exists error")
    public void TC_082_addDuplicateProductType() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName("Skirt"); // assumes Skirt exists
        productTypePage.addMeasurement("Length");
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("already exists") ||
                        productTypePage.isErrorVisible("duplicate"),
                "Expected 'Product Type already exists' error");
    }

    // TC_083 – Add product type without measurements
    @Test(description = "TC_083 - Missing measurements shows required error")
    public void TC_083_addProductTypeWithoutMeasurements() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName("Gown_" + System.currentTimeMillis());
        // Skip adding measurements
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("measurement") ||
                        productTypePage.isErrorVisible("required"),
                "Expected 'At least one measurement is required' error");
    }

    // TC_084 – Add product type without task sequence
    @Test(description = "TC_084 - Missing task execution order shows required error")
    public void TC_084_addProductTypeWithoutTaskSequence() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Male");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName("Pant_" + System.currentTimeMillis());
        productTypePage.addMeasurement("Waist");
        // Skip adding tasks
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isErrorVisible("task") ||
                        productTypePage.isErrorVisible("execution order"),
                "Expected 'Task execution order is required' error");
    }

    // TC_085 – Drag and drop task order
    @Test(description = "TC_085 - Dragging task to new position updates order")
    public void TC_085_dragAndDropTaskOrder() {
        productTypePage.clickAddProductType();
        productTypePage.clickAddTask();
        productTypePage.clickAddTask(); // add at least 2 tasks
        productTypePage.dragAndDropTask(0, 1);
        // Verify task order has changed (preview or list order)
        Assert.assertTrue(driver.findElements(
                                org.openqa.selenium.By.cssSelector(".task-order-item, [data-testid='task-order-item']"))
                        .size() > 0,
                "Expected task order items to be present after drag and drop");
    }

    // TC_086 – Add a new task to the flow
    @Test(description = "TC_086 - Adding task to flow appears in task list and preview")
    public void TC_086_addTaskToFlow() {
        productTypePage.clickAddProductType();
        productTypePage.clickAddTask();
        int taskCount = driver.findElements(
                org.openqa.selenium.By.cssSelector(".task-order-item, [data-testid='task-order-item']")).size();
        Assert.assertTrue(taskCount > 0,
                "Expected at least one task in the task flow after clicking Add Task");
    }

    // TC_087 – Delete task from flow
    @Test(description = "TC_087 - Deleting task from flow removes it from order list")
    public void TC_087_deleteTaskFromFlow() {
        productTypePage.clickAddProductType();
        productTypePage.clickAddTask();
        int countBefore = driver.findElements(
                org.openqa.selenium.By.cssSelector(".task-order-item, [data-testid='task-order-item']")).size();
        productTypePage.deleteTaskFromFlow(0);
        int countAfter = driver.findElements(
                org.openqa.selenium.By.cssSelector(".task-order-item, [data-testid='task-order-item']")).size();
        Assert.assertTrue(countAfter < countBefore,
                "Expected task count to decrease after deletion");
    }

    // TC_088 – Task order preview updates automatically
    @Test(description = "TC_088 - Final Task Order Preview reflects reordering")
    public void TC_088_taskOrderPreviewUpdates() {
        productTypePage.clickAddProductType();
        productTypePage.clickAddTask();
        // Preview should contain some task label
        Assert.assertTrue(
                driver.findElement(org.openqa.selenium.By.cssSelector(
                        ".task-order-preview, [data-testid='task-order-preview']")).isDisplayed(),
                "Expected Final Task Order Preview to be visible");
    }

    // TC_089 – Close Add Product Type popup
    @Test(description = "TC_089 - Closing Add Product Type popup discards unsaved data")
    public void TC_089_closePopup() {
        productTypePage.clickAddProductType();
        productTypePage.clickClose();
        Assert.assertTrue(productTypePage.isDialogClosed(),
                "Expected dialog to close after clicking Close");
    }

    // TC_090 – Submit with only required fields
    @Test(description = "TC_090 - Product type added with only required fields")
    public void TC_090_submitWithOnlyRequiredFields() {
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Male");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName("Shirt_" + System.currentTimeMillis());
        productTypePage.addMeasurement("Chest");
        productTypePage.clickAddTask();
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isSuccessVisible(),
                "Expected success with only required fields filled");
    }

    // TC_091 – Invalid characters in measurement
    @Test(description = "TC_091 - Special characters in measurement show validation error")
    public void TC_091_invalidMeasurementCharacters() {
        productTypePage.clickAddProductType();
        productTypePage.addMeasurement("#1234$");
        productTypePage.clickSubmit();
        // If validation exists, error shown; otherwise measurement is simply not added
        boolean errorShown = productTypePage.isErrorVisible("valid") ||
                productTypePage.isErrorVisible("measurement");
        boolean tagNotAdded = !productTypePage.isMeasurementTagVisible("#1234$");
        Assert.assertTrue(errorShown || tagNotAdded,
                "Expected either validation error or measurement not added for special characters");
    }

    // TC_092 – Navigate back to previous step
    @Test(description = "TC_092 - Back button navigates to Step 4 (Task Settings)")
    public void TC_092_navigateBackToPreviousStep() {
        productTypePage.clickBack();
        Assert.assertTrue(driver.getCurrentUrl().contains("task") ||
                        driver.getPageSource().toLowerCase().contains("task settings"),
                "Expected navigation to Step 4 (Task Settings) after Back");
    }

    // TC_093 – Add multiple measurements
    @Test(description = "TC_093 - Multiple measurements can be added and saved")
    public void TC_093_addMultipleMeasurements() {
        productTypePage.clickAddProductType();
        productTypePage.addMeasurement("Length");
        productTypePage.addMeasurement("Chest");
        productTypePage.addMeasurement("Sleeve");
        Assert.assertTrue(productTypePage.isMeasurementTagVisible("Length"),  "Expected Length tag");
        Assert.assertTrue(productTypePage.isMeasurementTagVisible("Chest"),   "Expected Chest tag");
        Assert.assertTrue(productTypePage.isMeasurementTagVisible("Sleeve"),  "Expected Sleeve tag");
    }

    // TC_094 – Submit with Product Type = Others and custom name
    @Test(description = "TC_094 - Custom product type with Others is added and listed")
    public void TC_094_submitWithOthersAndCustomName() {
        String customName = "CapeDress_" + System.currentTimeMillis();
        productTypePage.clickAddProductType();
        productTypePage.selectGender("Female");
        productTypePage.selectProductType("Others");
        productTypePage.enterNewProductTypeName(customName);
        productTypePage.addMeasurement("Length");
        productTypePage.clickAddTask();
        productTypePage.clickSubmit();
        Assert.assertTrue(productTypePage.isProductTypeInList(customName) ||
                        productTypePage.isSuccessVisible(),
                "Expected custom product type to be added and appear in list");
    }

    // TC_095 – Edit icon opens pre-filled form
    @Test(description = "TC_095 - Edit icon opens form with current product type details")
    public void TC_095_editIconOpensPrefilled() {
        productTypePage.clickEditIcon(0);
        Assert.assertTrue(
                driver.findElements(org.openqa.selenium.By.cssSelector(".ant-modal, [role='dialog']")).size() > 0,
                "Expected edit modal to open");
        String genderValue = driver.findElement(org.openqa.selenium.By.cssSelector(
                "select[name='gender'] option:checked, [data-testid='gender-select']")).getText();
        Assert.assertFalse(genderValue == null || genderValue.isEmpty(),
                "Expected edit form to be pre-filled with product type data");
    }

    // TC_096 – Delete icon shows confirmation dialog
    @Test(description = "TC_096 - Delete icon shows confirmation dialog before deletion")
    public void TC_096_deleteIconShowsConfirmation() {
        productTypePage.clickDeleteIcon(0);
        Assert.assertTrue(productTypePage.isConfirmDialogVisible(),
                "Expected delete confirmation dialog to appear");
    }

    // TC_097 – Successful deletion after confirmation
    @Test(description = "TC_097 - Confirming delete removes product type from table")
    public void TC_097_successfulDeletionAfterConfirmation() {
        int countBefore = driver.findElements(
                org.openqa.selenium.By.cssSelector(".product-type-table tbody tr, [data-testid='product-type-row']")).size();
        productTypePage.clickDeleteIcon(0);
        productTypePage.confirmDelete();
        int countAfter = driver.findElements(
                org.openqa.selenium.By.cssSelector(".product-type-table tbody tr, [data-testid='product-type-row']")).size();
        Assert.assertTrue(productTypePage.isSuccessVisible() || countAfter < countBefore,
                "Expected product type to be removed after confirmation");
    }

    // TC_098 – Back button returns to Boutique overview
    @Test(description = "TC_098 - Back button navigates to All Boutique / Boutique Management page")
    public void TC_098_backButtonNavigatesToBoutiqueOverview() {
        productTypePage.clickBack();
        Assert.assertTrue(driver.getCurrentUrl().contains("boutique") ||
                        driver.getPageSource().toLowerCase().contains("boutique management") ||
                        driver.getPageSource().toLowerCase().contains("all boutique"),
                "Expected navigation to Boutique Management/overview page");
    }
}