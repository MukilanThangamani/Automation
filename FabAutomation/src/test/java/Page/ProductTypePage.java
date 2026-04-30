package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductTypePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // ─── Locators ────────────────────────────────────────────────────────────
    private final By addProductTypeButton      = By.cssSelector("button[data-testid='add-product-type'], button.add-product-type-btn");
    private final By genderDropdown            = By.cssSelector("select[name='gender'], [data-testid='gender-select']");
    private final By productTypeDropdown       = By.cssSelector("select[name='productType'], [data-testid='product-type-select']");
    private final By newProductTypeInput       = By.cssSelector("input[name='newProductType'], input[placeholder*='New Product']");
    private final By measurementInput          = By.cssSelector("input[name='measurement'], input[placeholder*='measurement']");
    private final By addMeasurementButton      = By.cssSelector("button[data-testid='add-measurement'], button.add-measurement-btn");
    private final By measurementTags           = By.cssSelector(".measurement-tag, [data-testid='measurement-tag']");
    private final By addTaskButton             = By.cssSelector("button[data-testid='add-task-flow'], button.add-task-flow-btn");
    private final By taskDeleteIcons           = By.cssSelector("[data-testid='delete-task-flow'], button.delete-task-btn");
    private final By taskOrderItems            = By.cssSelector(".task-order-item, [data-testid='task-order-item']");
    private final By submitButton              = By.cssSelector("button[type='submit']");
    private final By closeButton               = By.cssSelector("button.close-btn, button[data-testid='close']");
    private final By backButton                = By.cssSelector("button.back-btn, button[data-testid='back']");
    private final By errorMessages             = By.cssSelector(".ant-form-item-explain-error, .error-message");
    private final By successToast              = By.cssSelector(".ant-message-success, .success-toast");
    private final By productTypeTableRows      = By.cssSelector(".product-type-table tbody tr, [data-testid='product-type-row']");
    private final By editIcons                 = By.cssSelector("[data-testid='edit-product-type'], button.edit-btn");
    private final By deleteIcons               = By.cssSelector("[data-testid='delete-product-type'], button.delete-btn");
    private final By confirmDeleteButton       = By.cssSelector(".ant-modal-confirm-btns .ant-btn-primary, button[data-testid='confirm-delete']");
    private final By customMeasurementInput    = By.cssSelector("input[data-testid='custom-measurement'], input[placeholder*='Add Custom measurement']");
    private final By saveMeasurementButton     = By.cssSelector("button[data-testid='save-measurement'], button.save-measurement-btn");
    private final By commonMeasurementTags     = By.cssSelector(".common-measurement-tag, [data-testid='common-measurement-tag']");
    private final By finalTaskOrderPreview     = By.cssSelector(".task-order-preview, [data-testid='task-order-preview']");

    public ProductTypePage(WebDriver driver, WebDriverWait wait) {
        this.driver  = driver;
        this.wait    = wait;
        this.actions = new Actions(driver);
    }

    // ─── Actions ─────────────────────────────────────────────────────────────

    public void clickAddProductType() {
        wait.until(ExpectedConditions.elementToBeClickable(addProductTypeButton)).click();
    }

    public void selectGender(String gender) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(genderDropdown)))
                .selectByVisibleText(gender);
    }

    public void selectProductType(String type) {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(productTypeDropdown)))
                .selectByVisibleText(type);
    }

    public void enterNewProductTypeName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(newProductTypeInput));
        el.clear(); el.sendKeys(name);
    }

    public void addMeasurement(String measurement) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(measurementInput));
        el.clear(); el.sendKeys(measurement);
        wait.until(ExpectedConditions.elementToBeClickable(addMeasurementButton)).click();
    }

    public void addCustomMeasurement(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(customMeasurementInput));
        el.clear(); el.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(saveMeasurementButton)).click();
    }

    public void deleteCustomMeasurement(String name) {
        By tagX = By.xpath(
                "//span[contains(@class,'common-measurement-tag') and contains(text(),'" + name + "')]" +
                        "/following-sibling::span[@class='close' or @aria-label='close']" +
                        "| //*[@data-testid='common-measurement-tag' and contains(text(),'" + name + "')]//button");
        wait.until(ExpectedConditions.elementToBeClickable(tagX)).click();
    }

    public void clickAddTask() {
        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton)).click();
    }

    public void deleteTaskFromFlow(int index) {
        List<WebElement> icons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(taskDeleteIcons));
        icons.get(index).click();
    }

    public void dragAndDropTask(int fromIndex, int toIndex) {
        List<WebElement> items = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(taskOrderItems));
        actions.dragAndDrop(items.get(fromIndex), items.get(toIndex)).perform();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
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

    public boolean isProductTypeInList(String name) {
        return driver.findElements(productTypeTableRows).stream()
                .anyMatch(row -> row.getText().contains(name));
    }

    public boolean isMeasurementTagVisible(String name) {
        return driver.findElements(measurementTags).stream()
                .anyMatch(tag -> tag.getText().contains(name));
    }

    public boolean isCommonMeasurementTagVisible(String name) {
        return driver.findElements(commonMeasurementTags).stream()
                .anyMatch(tag -> tag.getText().contains(name));
    }

    public boolean isDialogClosed() {
        try {
            return driver.findElements(By.cssSelector(".ant-modal, [role='dialog']")).isEmpty();
        } catch (Exception e) { return true; }
    }

    public boolean isTaskOrderPreviewUpdated(String taskName) {
        try {
            return driver.findElement(finalTaskOrderPreview).getText().contains(taskName);
        } catch (Exception e) { return false; }
    }

    public boolean isConfirmDialogVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".ant-modal-confirm, [data-testid='confirm-dialog']"))).isDisplayed();
        } catch (Exception e) { return false; }
    }
}