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

public class SourcingPage extends BasePage{

    public SourcingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Sourcing']")
    WebElement sourcingmodbtn;

    @FindBy(xpath = "//span[text()='Add Sourcing']")
    WebElement addBtn;

    @FindBy(id = "sourcing_productId")
    WebElement prodclick;

    @FindBy(id = "sourcing_sourcingType")
    WebElement sourceclick;

    @FindBy(id = "sourcing_quantity")
    WebElement quant;

    @FindBy(id = "sourcing_total")
    WebElement totalamt;

    @FindBy(xpath = "//span[text()='Save Sourcing']")
    WebElement savebtn;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement close;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/section/div/div/main/section/div[2]/table/tbody/tr/td[5]/div/div/span[2]")
    WebElement strtl;

    @FindBy(xpath = "//div[text()='In-progress']")
    WebElement toInPro;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/section/div/div/main/section/div[2]/div[1]/div[2]/div[2]/div/span[2]")
    WebElement topStart;

    @FindBy(xpath = "//button[text()='Download Excel']")
    WebElement download;

    @FindBy(xpath = "#__next > div > section > div > div > main > section > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiTableContainer-root.table-container-style.css-13xy2my > table > tbody > tr > td.MuiTableCell-root.MuiTableCell-body.MuiTableCell-sizeMedium.css-wjwotp > div > svg")
    WebElement edit;

    @FindBy(xpath = "//*[@id=\"rc_select_1\"]")
    WebElement products;

    public void sourcingDetails(String quantity,String amt,String updatequant) throws InterruptedException{
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);
        System.out.println("Sourcing button is visible :"+sourcingmodbtn.isDisplayed());
        Thread.sleep(2000);
        sourcingmodbtn.click();
        Thread.sleep(3000);
        System.out.println("Add sourcing button is visible :"+addBtn.isDisplayed());
        addBtn.click();
        Thread.sleep(1000);
        System.out.println("Product type is visible :"+prodclick.isDisplayed());
        prodclick.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("/html/body/div[3]/div/div/div[2]/div[1]/div/div")
                )
        );

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());  // random index from 0 to size-1
        WebElement randomOption = options.get(randomIndex);

        randomOption.click();

        System.out.println("Sourcing type is visible :"+sourceclick.isDisplayed());
        sourceclick.click();

        Thread.sleep(1500);

        List<WebElement> sourcetype = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div")));
        WebElement sourceoption = sourcetype.get(randomIndex);
        sourceoption.click();

        Thread.sleep(1000);
        System.out.println("Quantity field is visible :"+quant.isDisplayed());
        quant.sendKeys(quantity);
        System.out.println("Total amount is visible :"+totalamt.isDisplayed());
        Thread.sleep(1000);
       // totalamt.sendKeys(amt);
        System.out.println("Save sourcing button  is visible :"+savebtn.isDisplayed());
        System.out.println("Save sourcing button  is enabled :"+savebtn.isEnabled());
        savebtn.click();
        Thread.sleep(1000);
        boolean isTotalAmount = !driver.findElements(By.xpath("//div[text()='Total Amount is required']")).isEmpty();
        if(isTotalAmount){
            totalamt.sendKeys(amt);
        }
        savebtn.click();

    }
}