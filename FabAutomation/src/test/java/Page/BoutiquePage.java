package Page;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BoutiquePage  {

    private WebDriver driver;
    private WebDriverWait wait;

    public BoutiquePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ─── Locators ────────────────────────────────────────────────────────────
    private final By getemail = By.id("basic_username");
    private final By getPassword = By.id("basic_password");
    private final By login = By.xpath("//span[normalize-space(text())='Login']");
    private final By settings = By.cssSelector("#__next > div > div > div > section > div > header > div:nth-child(2) > div:nth-child(5) > svg");
    private final By selectBoutique        = By.xpath("(//button[contains(., 'View Details')])[1]");
    private final By gstNumberField        = By.id("boutique_gstNumber");
    private final By pinCodeField          = By.id("boutique_pincode");
    private final By leaveDaysDropdown     = By.xpath("(//span[@class='ant-select-selection-wrap']//div)[1]");
    private final By logoUploadInput       = By.xpath("(//button[@type='button'])[1]");
    private final By areaField             = By.id("boutique_address");
    private final By cityField             = By.id("boutique_city");
    private final By stateField            = By.xpath("//span[@title='Tamil Nadu']");
    private final By getShopNumber         = By.id("boutique_shopNumber");
    private final By shopNumber            = By.xpath("(//label[normalize-space(text())='Shop Number']/following::input)[1]");
    private final By nextButton            = By.xpath("//span[normalize-space(text())='Next']");
    private final By submitButton          = By.xpath("//span[normalize-space(text())='Submit']");
    private final By previous              = By.xpath("//span[normalize-space(text())='Previous']");
    private final By errorMessages         = By.cssSelector(".ant-form-item-explain-error, .error-message");
    private final By successAlert          = By.xpath("//span[normalize-space(text())='Boutique updated successfully!']");
    private final By unsavedChangesDialog  = By.cssSelector(".ant-modal-confirm, [data-testid='unsaved-dialog']");
    private final By dashboardMenuItem     = By.cssSelector("li[data-menu='dashboard'], a[href*='dashboard']");

    // ─── Actions ─────────────────────────────────────────────────────────────

    public void enterEmail(String mail){
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(getemail));
        email.sendKeys(mail);
    }

    public void enterPassword(String password) {
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(getPassword));
        pass.sendKeys(password);
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }

    public void clickSettingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
    }

    public void clickBoutiqueButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selectBoutique)).click();
    }

    public void enterGSTNumber(String gst) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(gstNumberField));
        el.clear();
        el.sendKeys(gst);
    }

    public void enterAddress(String address) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(shopNumber));
        el.clear();
        el.sendKeys(address);
    }

    public void shopNumbers() {
       WebElement shop = wait.until(ExpectedConditions.visibilityOfElementLocated(shopNumber));
       shop.clear();
    }

    public void enterPinCode(String pin) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(pinCodeField));
        el.clear();
        el.sendKeys(pin);
    }

    public void clickPrevious() {
        wait.until(ExpectedConditions.elementToBeClickable(previous)).click();
    }

    public void openLeaveDaysDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveDaysDropdown)).isDisplayed();
    }

    public void selectLeaveDay(String day) {
        // Step 1 — Click the dropdown to open it
        wait.until(ExpectedConditions.elementToBeClickable(leaveDaysDropdown)).click();

        // Step 2 — Wait for dropdown options to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'ant-select-dropdown')]")
        ));

        // Step 3 — Click the specific day option
        By dayOption = By.xpath("//span[normalize-space(text())='" + day + "']");
        wait.until(ExpectedConditions.elementToBeClickable(dayOption)).click();

        System.out.println("Selected leave day: " + day);
    }

    public void deselectLeaveDay(String day) {
        By closeBtn = By.xpath(
                "//span[contains(@class,'ant-select-selection-item') and " +
                        ".//span[normalize-space(text())='" + day + "']]" +
                        "//span[contains(@class,'ant-select-selection-item-remove')]"
        );

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        System.out.println("Deselected: " + day);
    }

    public void clearAllLeaveDays() {
        List<WebElement> closeBtns = driver.findElements(
                By.xpath("//div[contains(@class,'ant-select')]//span[@aria-label='close']")
        );
        System.out.println("Total selected days to remove: " + closeBtns.size());
        for (WebElement btn : closeBtns) {
            btn.click();
        }
    }

    public void uploadLogo(String filePath) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(logoUploadInput));
        input.sendKeys(filePath);
    }

    public void fillAddressFields(String area, String city) {
        if (area  != null) { WebElement el = driver.findElement(areaField);  el.clear(); el.sendKeys(area);  }
        if (city  != null) { WebElement el = driver.findElement(cityField);  el.clear(); el.sendKeys(city);  }
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void clickDashboardMenuItem() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardMenuItem)).click();
    }

    // ─── Assertions helpers ──────────────────────────────────────────────────

    public List<WebElement> getErrorMessages() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages));
        return driver.findElements(errorMessages);
    }

    public boolean isErrorVisible(String partialText) {
        return getErrorMessages().stream()
                .anyMatch(e -> e.getText().toLowerCase().contains(partialText.toLowerCase()));
    }

    public boolean isSuccessVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public boolean isUnsavedChangesDialogVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(unsavedChangesDialog)).isDisplayed();
        } catch (Exception e) { return false; }
    }

    public String getLeaveDaysDropdownText() {
        return driver.findElement(leaveDaysDropdown).getText();
    }

    public boolean isImagePreviewVisible() {
        try {
            WebElement preview = driver.findElement(
                    By.cssSelector(".ant-upload-list-item, img.logo-preview, [data-testid='logo-preview']"));
            return preview.isDisplayed();
        } catch (Exception e) { return false; }
    }


}