package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ─── Locators ────────────────────────────────────────────────────────────
    private final By nameField              = By.name("name");
    private final By mobileField            = By.name("mobileNumber");
    private final By emergencyContactField  = By.name("emergencyContact");
    private final By passwordField          = By.name("password");
    private final By addressLine1Field      = By.name("addressLine1");
    private final By pinCodeField           = By.name("pinCode");
    private final By photoUploadInput       = By.cssSelector("input[type='file'][name='photo']");
    private final By idProofUploadInput     = By.cssSelector("input[type='file'][name='idProof']");
    private final By roleDropdown           = By.cssSelector("[data-testid='role-dropdown'], select[name='role']");
    private final By genderDropdown         = By.cssSelector("[data-testid='gender-dropdown'], select[name='gender']");
    private final By bloodGroupDropdown     = By.cssSelector("[data-testid='blood-group-dropdown']");
    private final By dobPicker              = By.cssSelector("[data-testid='dob-picker'], input[name='dateOfBirth']");
    private final By dojPicker              = By.cssSelector("[data-testid='doj-picker'], input[name='dateOfJoining']");
    private final By submitButton           = By.cssSelector("button[type='submit']");
    private final By closeButton            = By.cssSelector("button.close-btn, button[data-testid='close']");
    private final By errorMessages          = By.cssSelector(".ant-form-item-explain-error, .error-message");
    private final By successToast           = By.cssSelector(".ant-message-success, .success-toast");
    private final By employeeRows           = By.cssSelector(".employee-table tbody tr, [data-testid='employee-row']");
    private final By editIcons              = By.cssSelector("[data-testid='edit-employee'], button.edit-btn");
    private final By deleteIcons            = By.cssSelector("[data-testid='delete-employee'], button.delete-btn");
    private final By attendanceIcons        = By.cssSelector("[data-testid='attendance-icon'], button.attendance-btn");
    private final By historyIcons           = By.cssSelector("[data-testid='history-icon'], button.history-btn");
    private final By confirmDeleteButton    = By.cssSelector(".ant-modal-confirm-btns .ant-btn-primary, button[data-testid='confirm-delete']");
    private final By cancelDeleteButton     = By.cssSelector(".ant-modal-confirm-btns .ant-btn:not(.ant-btn-primary)");
    private final By confirmDialog          = By.cssSelector(".ant-modal-confirm, [data-testid='confirm-dialog']");
    private final By unsavedChangesDialog   = By.cssSelector(".ant-modal-confirm, [data-testid='unsaved-dialog']");
    private final By dashboardMenuItem      = By.cssSelector("li[data-menu='dashboard'], a[href*='dashboard']");
    private final By searchField            = By.cssSelector("input[placeholder*='search'], input[name='search']");
    private final By addEmployeeButton      = By.cssSelector("button[data-testid='add-outsource-employee'], button.add-employee-btn");
    private final By addAddressField        = By.name("address");

    public EmployeePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
    }

    // ─── Actions ─────────────────────────────────────────────────────────────

    public void enterName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        el.clear(); el.sendKeys(name);
    }

    public void enterMobile(String mobile) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
        el.clear(); el.sendKeys(mobile);
    }

    public void enterPassword(String password) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        el.clear(); el.sendKeys(password);
    }

    public void uploadPhoto(String filePath) {
        driver.findElement(photoUploadInput).sendKeys(filePath);
    }

    public void uploadIdProof(String filePath) {
        driver.findElement(idProofUploadInput).sendKeys(filePath);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public void clickEditIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(editIcons));
        icons.get(index).click();
    }

    public void clickDeleteIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(deleteIcons));
        icons.get(index).click();
    }

    public void confirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }

    public void cancelDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelDeleteButton)).click();
    }

    public void clickAttendanceIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(attendanceIcons));
        icons.get(index).click();
    }

    public void clickHistoryIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(historyIcons));
        icons.get(index).click();
    }

    public void clickAddEmployeeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
    }

    public void searchByName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        el.clear(); el.sendKeys(name);
    }

    public void clickDashboardMenuItem() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardMenuItem)).click();
    }

    // ─── Assertion helpers ───────────────────────────────────────────────────

    public boolean isErrorVisible(String partialText) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages));
            return driver.findElements(errorMessages).stream()
                    .anyMatch(e -> e.getText().toLowerCase().contains(partialText.toLowerCase()));
        } catch (Exception e) { return false; }
    }

    public boolean isSuccessVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isEmployeeInList(String name) {
        return driver.findElements(employeeRows).stream()
                .anyMatch(row -> row.getText().contains(name));
    }

    public boolean isConfirmDialogVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDialog)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isUnsavedChangesDialogVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(unsavedChangesDialog)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isPasswordMasked() {
        WebElement el = driver.findElement(passwordField);
        return "password".equals(el.getAttribute("type"));
    }

    public boolean isFilePreviewVisible(String previewSelector) {
        try {
            return driver.findElement(By.cssSelector(previewSelector)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isCalendarVisible() {
        try {
            return driver.findElement(By.cssSelector(".ant-picker-dropdown, .calendar-dropdown")).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isDropdownPopulated(By dropdownBy) {
        try {
            driver.findElement(dropdownBy).click();
            List<WebElement> options = driver.findElements(
                    By.cssSelector(".ant-select-item-option, option"));
            return options.size() > 0;
        } catch (Exception e) { return false; }
    }

    public int getEmployeeCount() {
        return driver.findElements(employeeRows).size();
    }
}