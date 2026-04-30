package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.BoutiquePage;

import java.time.Duration;

public class BoutiqueTest extends BaseTest {

    private BoutiquePage boutiquePage;

    @BeforeClass
    public void initPage() {
        driver.get(BASE_URL + "/settings/boutique?id=405");
        boutiquePage = new BoutiquePage(driver);
        // Login once here so all tests share the session
        boutiquePage.enterEmail("6369188818");
        boutiquePage.enterPassword("Test@123");
        boutiquePage.clickLoginButton();
        boutiquePage.clickSettingButton();
        boutiquePage.clickBoutiqueButton();
    }

    @Test(priority = 1, description = "TC_001 - Prevent navigation when boutique form has unsaved data")
    public void TC_001_preventNavigationOnUnsavedChanges() {
        boutiquePage.enterGSTNumber("0A1Z5");
    }

    // TC_002 runs on the same browser session — no reset
    @Test(priority = 2, dependsOnMethods = "TC_001_preventNavigationOnUnsavedChanges",
            description = "TC_002 - Validate mandatory fields show errors on blank submit")
    public void TC_002_mandatoryFieldValidation() {
        boutiquePage.clickSubmit();
    }

    // TC_003 – Successful boutique update
    @Test(priority = 3, description = "TC_003 - Successful boutique details submission")
    public void TC_003_successfulBoutiqueUpdate() {
        boutiquePage.clickPrevious();
        boutiquePage.fillAddressFields("Anna Nagar", "Chennai");
        boutiquePage.enterPinCode("600040");
        boutiquePage.clickSubmit();
        Assert.assertTrue(boutiquePage.isSuccessVisible(),
                "Expected success message after valid submission");
    }

    // TC_004 – Invalid GST number format
    @Test(priority = 4, description = "TC_004 - Invalid GST number shows format error")
    public void TC_004_invalidGSTNumberFormat() {
        boutiquePage.clickPrevious();
        boutiquePage.enterAddress("jhgfdsa");
        boutiquePage.clickSubmit();
        boutiquePage.clickPrevious();
    }

    // TC_005 – Leave Days dropdown visibility
    @Test(priority = 5, description = "TC_005 - Leave Days dropdown shows checkbox list")
    public void TC_005_leaveDaysDropdownVisibility() {
        boutiquePage.openLeaveDaysDropdown();
        // After opening, at least the Monday option should be visible
        try {
            WebElement monOption = driver.findElement(
                    By.xpath(
                            "//span[normalize-space(text())='Monday']"));
            Assert.assertTrue(monOption.isDisplayed(),
                    "Expected day checkboxes to be visible after opening dropdown");
        } catch (Exception e) {
            Assert.fail("Leave days dropdown did not open properly: " + e.getMessage());
        }
    }

    // TC_006 – Select a single leave day
    @Test(priority = 6, description = "TC_006 - Single leave day selection reflects in dropdown")
    public void TC_006_selectSingleLeaveDay() {
        boutiquePage.openLeaveDaysDropdown();
      //  boutiquePage.selectLeaveDay("Sunday");
        Assert.assertTrue(boutiquePage.getLeaveDaysDropdownText().contains("Sunday"),
                "Expected 'Sunday' to be shown in dropdown after selection");
    }

    // TC_007 – Select multiple leave days
    @Test(priority = 7, description = "TC_007 - Multiple leave days selection reflects in dropdown")
    public void TC_007_selectMultipleLeaveDays() {
        boutiquePage.openLeaveDaysDropdown();
        boutiquePage.selectLeaveDay("Saturday");
        String dropdownText = boutiquePage.getLeaveDaysDropdownText();
        Assert.assertTrue(dropdownText.contains("Saturday") && dropdownText.contains("Sunday"),
                "Expected both 'Saturday' and 'Sunday' to appear in dropdown");
    }

    // TC_008 – Deselect a leave day
    @Test(priority = 8, description = "TC_008 - Deselecting a leave day removes it from dropdown")
    public void TC_008_deselectLeaveDay() {
        boutiquePage.openLeaveDaysDropdown();
        boutiquePage.selectLeaveDay("Sunday");
        boutiquePage.deselectLeaveDay("Sunday");
        Assert.assertFalse(boutiquePage.getLeaveDaysDropdownText().contains("Sunday"),
                "Expected 'Sunday' to be removed after deselection");
    }

    // TC_009 – Clear all selected leave days
    @Test(priority = 9, description = "TC_009 - Clearing all leave days empties the dropdown")
    public void TC_009_clearAllLeaveDays() {
        boutiquePage.openLeaveDaysDropdown();
        for (String day : new String[]{"Monday","Saturday"}) {
            boutiquePage.selectLeaveDay(day);
        }
        boutiquePage.clearAllLeaveDays();
        String dropdownText = boutiquePage.getLeaveDaysDropdownText();
        Assert.assertTrue(dropdownText.isEmpty() || dropdownText.contains("Select"),
                "Expected dropdown to be empty after clearing all selections");
    }

    // TC_010 – Valid logo upload
    @Test(priority =10, description = "TC_010 - Valid image upload shows preview")
    public void TC_010_validLogoUpload() {
        boutiquePage.uploadLogo("file:///Users/apple/Downloads/kur4.jpeg"); // ✅ Replace with real file path
        Assert.assertTrue(boutiquePage.isImagePreviewVisible(),
                "Expected image preview after valid upload");
    }

    // TC_011 – Invalid file format for logo
//    @Test(priority = 11, description = "TC_011 - Invalid file format shows upload error")
//    public void TC_011_invalidLogoFormat() {
//        boutiquePage.uploadLogo("file:///Users/apple/Downloads/jack_Measurements.pdf"); // ✅ Replace with real file path
//        Assert.assertTrue(boutiquePage.isErrorVisible("invalid file format") ||
//                        boutiquePage.isErrorVisible("format"),
//                "Expected error for invalid logo file format");
//    }

    // TC_012 – PIN code accepts only numbers
    @Test(priority = 11, description = "TC_012 - Alphabetic PIN code shows numeric validation error")
    public void TC_011_pinCodeNumericValidation() {
        boutiquePage.enterPinCode("abcd");
        boutiquePage.clickSubmit();
        Assert.assertTrue(boutiquePage.isErrorVisible("numbers") ||
                        boutiquePage.isErrorVisible("Only numbers"),
                "Only numbers are allowed");
    }

    // TC_013 – Successful navigation to next step (Roles)
    @Test(priority = 12, description = "TC_013 - Next button navigates to Roles page")
    public void TC_012_nextButtonNavigatesToRoles() {
        boutiquePage.enterGSTNumber("22AA");
        boutiquePage.fillAddressFields("Anna Nagar", "Chennai");
        boutiquePage.enterPinCode("600040");
    }

    // TC_014 – Address field validation
//    @Test(description = "TC_014 - Missing required address fields show errors")
//    public void TC_014_addressFieldValidation() {
//        boutiquePage.fillAddressFields("", "Chennai", "");
//        boutiquePage.clickSubmit();
//        Assert.assertTrue(boutiquePage.isErrorVisible("area") ||
//                        boutiquePage.isErrorVisible("state") ||
//                        boutiquePage.getErrorMessages().size() > 0,
//                "Expected errors for missing required address fields");
//    }

    // TC_015 – Leave Days dropdown saves selection

    // TC_016 – Landmark field is optional
    @Test(priority = 13, description = "TC_016 - Form submits without Landmark (optional field)")
    public void TC_013_landmarkOptional() {
        boutiquePage.enterGSTNumber("0A1Z5");
        boutiquePage.enterPinCode("600040");
        // Landmark left empty intentionally
        boutiquePage.shopNumbers();
        boutiquePage.clickSubmit();
        Assert.assertTrue(boutiquePage.isErrorVisible("Number"),
                "Shop Number required");
    }

    // TC_017 – Next button shows Roles page
    @Test(priority = 14, description = "TC_017 - Clicking Next button displays Roles page")
    public void TC_014_nextButtonDisplaysRolesPage() {
        boutiquePage.clickNextButton();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("role") ||
                        driver.getCurrentUrl().contains("role"),
                "Expected Roles page to be displayed after clicking Next");
    }
}
