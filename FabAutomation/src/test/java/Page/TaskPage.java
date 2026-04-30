package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TaskPage {

    private WebDriver driver;
    private WebDriverWait wait;


    // ─── Locators ────────────────────────────────────────────────────────────
    private final By taskNameInput      = By.cssSelector("input[name='taskName'], input[placeholder*='task name']");
    private final By chargesInput       = By.cssSelector("input[name='charges'], input[name='chargesPerHour']");
    private final By bufferCheckbox     = By.cssSelector("input[type='checkbox'][name='bufferTime']");
    private final By idleTimeInput      = By.cssSelector("input[name='idleBufferTime']");
    private final By idleTypeSelect     = By.cssSelector("select[name='idleType'], [data-testid='idle-type']");
    private final By rushTimeInput      = By.cssSelector("input[name='rushBufferTime']");
    private final By rushTypeSelect     = By.cssSelector("select[name='rushType'], [data-testid='rush-type']");
    private final By roleDropdown       = By.cssSelector("select[name='role'], [data-testid='role-select']");
    private final By submitButton       = By.cssSelector("button[type='submit']");
    private final By closeButton        = By.cssSelector("button.close-btn, button[data-testid='close-dialog']");
    private final By errorMessages      = By.cssSelector(".ant-form-item-explain-error, .error-message");
    private final By successToast       = By.cssSelector(".ant-message-success, .success-toast");
    private final By taskListRows       = By.cssSelector(".task-list table tbody tr, [data-testid='task-row']");
    private final By editIcons          = By.cssSelector("button.edit-task, [data-testid='edit-task']");
    private final By previousButton     = By.cssSelector("button.prev-btn, button[data-testid='previous']");
    private final By nextButton         = By.cssSelector("button.next-btn, button[data-testid='next']");

    public TaskPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
    }

    // ─── Actions ─────────────────────────────────────────────────────────────

    public void enterTaskName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(taskNameInput));
        el.clear();
        el.sendKeys(name);
    }

    public void enterCharges(String charges) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(chargesInput));
        el.clear();
        el.sendKeys(charges);
    }

    public void checkBufferCheckbox() {
        WebElement cb = wait.until(ExpectedConditions.elementToBeClickable(bufferCheckbox));
        if (!cb.isSelected()) cb.click();
    }

    public void enterIdleTime(String time) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(idleTimeInput));
        el.clear();
        el.sendKeys(time);
    }

    public void selectIdleType(String type) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(idleTypeSelect)))
                .selectByVisibleText(type);
    }

    public void enterRushTime(String time) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(rushTimeInput));
        el.clear();
        el.sendKeys(time);
    }

    public void selectRushType(String type) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(rushTypeSelect)))
                .selectByVisibleText(type);
    }

    public void selectRole(String role) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(roleDropdown)))
                .selectByVisibleText(role);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public void clickPrevious() {
        wait.until(ExpectedConditions.elementToBeClickable(previousButton)).click();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void clickEditIcon(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(editIcons));
        icons.get(index).click();
    }

    public void fillValidTask(String name, String charges, String role) {
        enterTaskName(name);
        enterCharges(charges);
        selectRole(role);
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

    public boolean isTaskInList(String taskName) {
        return driver.findElements(taskListRows).stream()
                .anyMatch(row -> row.getText().contains(taskName));
    }

    public boolean isDialogClosed() {
        try {
            return driver.findElements(By.cssSelector(".ant-modal, [role='dialog']")).isEmpty();
        } catch (Exception e) { return true; }
    }
}