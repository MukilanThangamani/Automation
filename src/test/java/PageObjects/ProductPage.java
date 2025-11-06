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

    @FindBy(xpath = "//span[text()='Add Product Type']")
    WebElement prodBtn;

    @FindBy(xpath = "//span[text()='Others']")
    WebElement othClick;

    @FindBy(xpath = "//label[text()='Gender']/following::div[1]")
    WebElement genderdrp;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subInProd;

    @FindBy(xpath = "//span[text()='Back']")
    WebElement backButton;

    @FindBy(xpath = "//*[contains(@class,'toast') or contains(text(),'exists') or contains(text(),'duplicate')]")
    WebElement duplicateErrorToast;

    @FindBy(xpath = "//span[text()='Close']")
    WebElement close;

    @FindBy(xpath = "//span[text()='+ Add Measurement']")
    WebElement addMeasurement;

    @FindBy(id = "measurements_3_measurement")
    WebElement giveMeasurement;

    SoftAssert softAssert = new SoftAssert();


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

        Random random = new Random();
        List<WebElement> genderOption = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div")));
        int randomIdx = random.nextInt(genderOption.size());
        WebElement selectGender = genderOption.get(randomIdx);
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

    public void edit(String measure) throws InterruptedException {
        System.out.println("Edit product type : ");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#__next > div > div:nth-child(2) > section > div > div > main > section > div:nth-child(3) > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(1) > button > span > svg")));
        System.out.println("Edit icon is displayed or not :"+edit.isDisplayed());
        edit.click();
        System.out.println("Edit icon is clicked");
        System.out.println("addMeasurement field is displayed or not :"+addMeasurement.isDisplayed());
        Thread.sleep(1300);
        addMeasurement.click();
        Thread.sleep(1300);
        System.out.println("give measurement field is displayed or not :"+giveMeasurement.isDisplayed());
        Thread.sleep(1300);
        giveMeasurement.sendKeys(measure);
        Thread.sleep(1000);
        subInProd.click();
    }

    public void backButton()  {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(backButton));
        System.out.println("Back button is displayed or not :"+backButton.isDisplayed());
        backButton.click();
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
