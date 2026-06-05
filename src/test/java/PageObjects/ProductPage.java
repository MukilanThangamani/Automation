package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Add Custom measurement']")
    WebElement common;

    @FindBy(xpath = "//span[text()='Save']")
    WebElement save;

    @FindBy(xpath = "//span[normalize-space(text())='Add Product Type']")
    WebElement prodBtn;

    @FindBy(xpath = "//span[text()='Others']")
    WebElement othClick;

    @FindBy(xpath = "//label[text()='Gender']/following::div[1]")
    WebElement genderdrp;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement subInProd;

    @FindBy(xpath = "//span[text()='Done']")
    WebElement DoneButton;

    @FindBy(id = "newProductType")
    WebElement newProductTypeInput;

    @FindBy(xpath = "//span[normalize-space(text())='Add Notes']")
    WebElement addNotesBtn;

    @FindBy(id = "noteName")
    WebElement notename;

    SoftAssert softAssert = new SoftAssert();

    public void customMeasurement(String custom) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Common field is displayed :"+common.isDisplayed());
        common.click();
        Thread.sleep(1000);
        common.sendKeys(custom);
        Thread.sleep(1000);
        System.out.println("Save button is displayed:+"+save.isDisplayed());
        Thread.sleep(1000);
        save.click();

    }


    public void addProduct(String produc, String gender) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        prodBtn.click();
        Thread.sleep(1000);

        othClick.click();
        Thread.sleep(1000);

        WebElement type = driver.findElement(By.xpath("//div[text()='" + produc + "']"));
        type.click();

        genderdrp.click();
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        WebElement selectGender = driver.findElement(By.xpath("//div[contains(@class,'ant-select-item-option') and @title='Female']"));
        selectGender.click();

        subInProd.click();
    }


    public void printDuplicateProductErrorMessage(SoftAssert softAssert) {
        By errorMessage = By.xpath(
                "//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'already exists') " +
                        "or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'duplicate') " +
                        "or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'product type already exists') " +
                        "or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'something went wrong')]"
        );
        By closeButton = By.xpath("//span[text()='Close']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            String duplicateMessage = error.getText().trim().toLowerCase();
            System.out.println("Duplicate Product Error Message captured: " + duplicateMessage);

            boolean isDuplicate = duplicateMessage.contains("already exists")
                    || duplicateMessage.contains("duplicate")
                    || duplicateMessage.contains("product type already exists")
                    || duplicateMessage.contains("something went wrong");

            softAssert.assertTrue(isDuplicate && !duplicateMessage.isEmpty(),
                    "Expected duplicate error message not shown! Found: " + duplicateMessage);

            try {
                WebElement closeBtn = driver.findElement(closeButton);
                closeBtn.click();
                System.out.println(" Product modal closed.");
            } catch (NoSuchElementException nse) {
                System.out.println("ℹ Close button not found. Maybe it was a toast notification.");
            }
        } catch (TimeoutException te) {
            System.out.println("No duplicate product error message displayed within wait time.");
            softAssert.fail("Duplicate error message not displayed.");
        } catch (Exception e) {
            System.out.println("Unexpected error while checking duplicate product message.");
            e.printStackTrace();
            softAssert.fail("Unexpected exception: " + e.getMessage());
        }
    }

    public void verifyProductInList(String expectedProduct, int columnIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//table//tr/td[" + columnIndex + "]")
                )
        );

        int i = 1;
        boolean found = false;
        for (WebElement cell : products) {
            String cellText = cell.getText().trim();
            System.out.println("Row " + i + " → " + cellText);
            if (cellText.equalsIgnoreCase(expectedProduct)) {
                found = true;
                break;
            }
            i++;
        }

        softAssert.assertTrue(found, "Product not found: " + expectedProduct);

        if (found) {
            System.out.println("Product '" + expectedProduct + "' is present in the list.");
        } else {
            System.out.println("Product '" + expectedProduct + "' is NOT found in the list!");
        }
    }

    public void backButton()  {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(DoneButton));
        System.out.println("Done button is displayed or not :"+DoneButton.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",DoneButton);
    }

    public void assertAll() {
        softAssert.assertAll();
    }

    public void selectGender() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//span[@class='ant-select-selection-item'])[2]")
        ));
        dropdown.click();

        // ✅ Step 2: Wait for dropdown options and select
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@title='Male']//div[1]")
        ));
        option.click();
    }

    public void selectProductType() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space(text())='Others']")
        ));
        dropdown.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[normalize-space(text())='Others']")
        )).click();
    }

    public void enterNewProductType(String value) {
        newProductTypeInput.click();
        newProductTypeInput.sendKeys(Keys.COMMAND + "a");
        newProductTypeInput.sendKeys(Keys.DELETE);
        newProductTypeInput.sendKeys(value);
    }

    public void addNotes(String note) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement notesInput = driver.findElement(By.xpath("(//label[normalize-space(text())='New Product Type']/following::input)[2]"));
        notesInput.sendKeys(note);
        addNotesBtn.click();
    }

    public void clickAddProduct() {
        prodBtn.click();
    }

    public void clickSubmit() {
        subInProd.click();
    }

    public void clickClose() {
        WebElement closeBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Close']"));
        closeBtn.click();
    }

    public void nextToNotes() {
        WebElement next = driver.findElement(By.xpath("//span[normalize-space(text())='Next']"));
        next.click();
    }

    public void addProductbtn(){
        prodBtn.click();
    }

    public void enterNote(String s) {
        notename.click();
        notename.sendKeys(Keys.COMMAND + "a");
        notename.sendKeys(Keys.DELETE);
        notename.sendKeys(s);
    }

}