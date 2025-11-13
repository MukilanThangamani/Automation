package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CrmPage extends BasePage{

    public CrmPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()=' Orders']")
    WebElement order;

    @FindBy(xpath = "//h3[text()='The Atelier Edits']" )
    WebElement boutiques;

    @FindBy(xpath = "//li[text()='The Atelier Edits']" )
    WebElement clickOneBoutique;

    //Locator
    @FindBy(xpath = "//span[text()='CRM']")
    WebElement clickCrm;

    @FindBy(xpath = "//span[text()='Add Client']")
    WebElement addCustomer;

    @FindBy(id = "clientName")
    WebElement clientname;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement tele;

    @FindBy(id = "reference")
    WebElement ref;

    @FindBy(xpath = "//div[@title='Others']/div[@class='ant-select-item-option-content']")
    WebElement refOption;

    @FindBy(id = "otherReference")
    WebElement otherName;

    @FindBy(id = "address")
    WebElement add;

    @FindBy(id = "preference")
    WebElement preference;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement subBtn;

    @FindBy(xpath = "//button[text()='Measurements']")
    WebElement meas;

    @FindBy(xpath = "//span[text()='Add Product']")
    WebElement addProduct;

    @FindBy(id = "products_0_productTypeId")
    WebElement prodType;


    @FindBy(css =  "#__next > div > div:nth-child(2) > section > div > div > main > section > div > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(8) > div > svg")
    WebElement editIcon;

    @FindBy(xpath = "//span[text()='Save Measurements']")
    WebElement save;

    @FindBy(xpath = "//label[text()='Product Type']/following::button[span[text()='Close']]")
    WebElement close;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//span[text()='Download Selected']")
    WebElement download;

    @FindBy(xpath = "//span[text()='Download Excel']")
    WebElement downloadExcel;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement search;

    @FindBy(css = "#__next > div > div:nth-child(2) > section > div > div > main > section > div > div > div:nth-child(2) > div > div:nth-child(1) > span > span > span.ant-input-group-addon > button > svg")
    WebElement searchIcon;

    //Action
    public void clickCrm(String name,String phone,String other,String address,String prefer) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        order.click();
        Thread.sleep(2000);
        boutiques.click();
        Thread.sleep(2000);
        clickOneBoutique.click();
        Thread.sleep(2000);
        System.out.println("Crm button is visible :"+clickCrm.isDisplayed());
        clickCrm.click();
        Thread.sleep(1000);
        System.out.println("Add customer button is displayed :"+addCustomer.isDisplayed());
        addCustomer.click();
        Thread.sleep(1000);
        System.out.println("client name field is visible :"+clientname.isDisplayed());
        clientname.sendKeys(name);
        Thread.sleep(1000);
        System.out.println("Phone number field is visible :"+tele.isDisplayed());
        tele.sendKeys(phone);
        Thread.sleep(1000);
        System.out.println("Reference field is visible :"+ref.isDisplayed());
        ref.click();
        Thread.sleep(1000);
        System.out.println("RefOption is visible :"+refOption.isDisplayed());
        refOption.click();

        System.out.println("Other field :"+otherName.isDisplayed());
        otherName.sendKeys(other);

        System.out.println("Address field is visible:"+add.isDisplayed());
        add.sendKeys(address);

        System.out.println("Preference field is visible:"+preference.isDisplayed());
        preference.sendKeys(prefer);

        System.out.println("Submit in client detail :"+subBtn.isDisplayed());
       // close.click();

        subBtn.submit();  //--> uncomment this for final execution
    }

    public void measurement() throws InterruptedException {
        Thread.sleep(1000);
        addProduct.click();
        Thread.sleep(1000);
        prodType.click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div")));
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        WebElement selectProduct = options.get(randomIndex);
        selectProduct.click();

        List<WebElement> measurementFields = driver.findElements(By.xpath("//input[contains(@placeholder, 'Enter')]"));

        for (WebElement field : measurementFields) {
            String placeholder = field.getAttribute("placeholder");
            System.out.println("Filling: " + placeholder);

            if (placeholder.toLowerCase().contains("length"))
                field.sendKeys("8");
            else if (placeholder.toLowerCase().contains("waist"))
                field.sendKeys("7");
            else if (placeholder.toLowerCase().contains("hip"))
                field.sendKeys("9");
            else
                field.sendKeys("7");
        }
        System.out.println("Sav measurement button is displayed:"+save.isDisplayed());
        Thread.sleep(1000);
        save.click();
        System.out.println("Close button is visible :"+close.isDisplayed());
        Thread.sleep(1000);
        close.click();
    }
    public void search(String name) throws InterruptedException {
        driver.navigate().refresh();
        search.sendKeys(name);
        Thread.sleep(1000);
        searchIcon.click();
        driver.navigate().refresh();
    }

    public void edit(String updatePref) throws InterruptedException {
        System.out.println("Edit for 1st client in the table :"+editIcon.isDisplayed());
        Thread.sleep(1000);
        editIcon.click();
        Thread.sleep(1000);
        System.out.println("Preference is displayed when edit is clicked :"+preference.isDisplayed());
        preference.clear();
        Thread.sleep(1000);
        preference.sendKeys(updatePref);
        Thread.sleep(1000);
        System.out.println("Submit the updated :"+subBtn.isDisplayed());
        subBtn.click();
        Thread.sleep(1000);
        close.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
}