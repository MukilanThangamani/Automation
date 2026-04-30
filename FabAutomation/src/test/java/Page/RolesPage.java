package Page;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RolesPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public RolesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ─── Locators ────────────────────────────────────────────────────────────
    private final By clickNext       = By.xpath("//span[normalize-space(text())='Next']");
    private final By addRolesButton       = By.xpath("//span[normalize-space(text())='Add Role']");
    private final By roleNameInput        = By.id("roles_roleName");
    private final By submitButton         = By.cssSelector("button[type='submit']");
    private final By errorMessages        = By.cssSelector(".ant-form-item-explain-error, .error-message");
    private final By successToast         = By.cssSelector(".ant-message-success, .success-toast");
    private final By roleListItems        = By.cssSelector(".role-list-item, table tbody tr");
    private final By editIcons            = By.cssSelector("button.edit-btn, [data-testid='edit-role']");
    private final By paginationNext       = By.cssSelector(".ant-pagination-next, button.pagination-next");
    private final By unsavedChangesDialog = By.cssSelector(".ant-modal-confirm, [data-testid='unsaved-dialog']");
    private final By dashboardMenuItem    = By.cssSelector("li[data-menu='dashboard'], a[href*='dashboard']");



    // ─── Actions ─────────────────────────────────────────────────────────────

    public void clickNext(){
        wait.until(ExpectedConditions.elementToBeClickable(clickNext)).click();
    }

    public void clickAddRoles() {
        wait.until(ExpectedConditions.elementToBeClickable(addRolesButton)).click();
    }

    public void enterRoleName(String name) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(roleNameInput));
        input.clear();
        input.sendKeys(name);
    }

    public void clearRoleName() {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(roleNameInput));
        input.clear();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void addRole(String roleName) {
        clickAddRoles();
        enterRoleName(roleName);
        clickSubmit();
    }

    public void clickEditIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(editIcons));
        icons.get(index).click();
    }

    public void clickNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(paginationNext)).click();
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

    public boolean isRoleInList(String roleName) {
        return driver.findElements(roleListItems).stream()
                .anyMatch(row -> row.getText().contains(roleName));
    }

    public boolean isUnsavedChangesDialogVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(unsavedChangesDialog)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isPaginationNextEnabled() {
        try {
            WebElement btn = driver.findElement(paginationNext);
            return btn.isEnabled() && !btn.getAttribute("class").contains("disabled");
        } catch (Exception e) { return false; }
    }
}