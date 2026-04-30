package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Inventory']")
    WebElement inventory;

    @FindBy(id = "itemGroupName")
    WebElement itemgroupname;

    @FindBy(xpath = "(//input[@class='ant-select-selection-search-input'])[1]")
    WebElement status;

    @FindBy(id = "unit")
    WebElement unit;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "categories_0_categoryName")
    WebElement category;

    @FindBy(xpath = "//div[normalize-space(text())='Inch']")
    WebElement inch;

    @FindBy(id = "categories_0_attributes_0_attributeName")
    WebElement attribute;

    @FindBy(xpath = "//*[contains(@class, 'ant-select-selection-overflow')]")
    WebElement option;

    @FindBy(xpath = "//span[normalize-space(text())='Submit']")
    WebElement submit;

    @FindBy(xpath = "//span[normalize-space(text())='Add']")
    WebElement add;

    @FindBy(xpath = "//input[@placeholder='Select date']")
    WebElement date;

    @FindBy(id = "referenceNumber")
    WebElement  ref;

    @FindBy(id = "quantityAdded")
    WebElement quantadd;

    @FindBy(id = "description")
    WebElement getDescription;

    @FindBy(xpath = "//span[normalize-space(text())='Convert to Adjusted']")
    WebElement convertAdjust;

    @FindBy(xpath = "//input[@type='search']")
    WebElement reason;

    @FindBy(xpath = "//div[@title='From Purchase order']//div[1]")
    WebElement selectReason;

    public void inventoryClick() {
        System.out.println("Inventory module is visible "+inventory.isDisplayed());
        inventory.click();
    }

    public void groupFields(String groupname, String descrip, String catename, String attr, String opt) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Item group name
        itemgroupname.sendKeys(groupname);
        Thread.sleep(500);

        // Unit dropdown → select Inch
        unit.click();
        Thread.sleep(500);
        inch.click();
        Thread.sleep(500);

        // Description
        description.sendKeys(descrip);
        Thread.sleep(500);

        // Category
        category.sendKeys(catename);
        Thread.sleep(500);

        // Attribute
        attribute.sendKeys(attr);
        Thread.sleep(500);

        // Option (Ant Design multi-select)
        option.click();  // click the dropdown container to open it
        Thread.sleep(1000);

        // Type inside the inner input that appears after clicking
        WebElement optionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".ant-select-selection-overflow input, .ant-select-search__field")
        ));
        optionInput.sendKeys(opt);
        Thread.sleep(1000);

        // Press Enter to add the tag/option
        optionInput.sendKeys(Keys.ENTER);
        Thread.sleep(500);

        // Submit
        submit.click();
        Thread.sleep(1000);
    }


    public void fillAdjustment(String selectdate, String reference, String added, String descrip) throws InterruptedException {
        add.click();
        Thread.sleep(1000);
        date.sendKeys(selectdate);
        Thread.sleep(1000);
        ref.sendKeys(reference);
        Thread.sleep(1000);
        quantadd.sendKeys(added);
        Thread.sleep(1000);
        reason.click();
        Thread.sleep(1000);
        selectReason.click();
        Thread.sleep(1000);
        getDescription.sendKeys(descrip);
        Thread.sleep(1000);
        convertAdjust.click();
    }
}