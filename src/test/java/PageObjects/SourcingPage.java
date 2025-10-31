package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SourcingPage extends BasePage{

    public SourcingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Sourcing']")
    WebElement sourcingmodbtn;

    @FindBy(xpath = "//span[text()='Add Sourcing']")
    WebElement addBtn;

    @FindBy(xpath = "//label[text()='Product']/following::div[@role='combobox'][1]")
    WebElement prodclick;

    @FindBy(xpath = "//li[text()='1509']")
    WebElement dropOptions;

    @FindBy(xpath = "//label[text()='Sourcing Type']/following-sibling::div//div[@role='combobox']")
    WebElement sourceclick;

    @FindBy(xpath = "//li[text()='Trims']")
    WebElement srcoptions;

    @FindBy(name = "quantity")
    WebElement quant;

    @FindBy(name = "total")
    WebElement totalamt;

    @FindBy(xpath = "//button[text()='Save Sourcing']")
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
        System.out.println("Sourcing button is visible :"+sourcingmodbtn.isDisplayed());
        Thread.sleep(2000);
        sourcingmodbtn.click();
        Thread.sleep(3000);
        System.out.println("Add sourcing button is visible :"+addBtn.isDisplayed());
        addBtn.click();
        Thread.sleep(1000);
        System.out.println("Product type is visible :"+prodclick.isDisplayed());
        prodclick.click();
        Thread.sleep(1500);
        System.out.println("drop option is visible :"+dropOptions.isDisplayed());
        dropOptions.click();
        System.out.println("Sourcing type is visible :"+sourceclick.isDisplayed());
        sourceclick.click();
        Thread.sleep(1000);
        System.out.println("Drop options in sourcing :"+srcoptions.isDisplayed());
        Thread.sleep(1000);
        srcoptions.click();
        Thread.sleep(1000);
        System.out.println("Quantity field is visible :"+quant.isDisplayed());
        quant.sendKeys(quantity);
        System.out.println("Total amount is visible :"+totalamt.isDisplayed());
        Thread.sleep(1000);
        totalamt.sendKeys(amt);
        System.out.println("Save sourcing button  is visible :"+savebtn.isDisplayed());
        System.out.println("Save sourcing button  is enabled :"+savebtn.isEnabled());
        //  Thread.sleep(1000);//--->next give save for final
        savebtn.click();
        Thread.sleep(1000);
        // close.click();
        System.out.println("Start to inprogress :"+strtl.isDisplayed());
        strtl.click();
        System.out.println("CLicking in progress");
        System.out.println("IN progress is visible :"+toInPro.isDisplayed());
        Thread.sleep(1000);
        toInPro.click();
        System.out.println("STart in above is visible :"+topStart.isDisplayed());
        Thread.sleep(1000);
        topStart.click();
        Thread.sleep(1000);
        toInPro.click();
//        Thread.sleep(1000);
//        products.click();
//        Thread.sleep(1000);
//        dropOptions.click();
        System.out.println("Download excel button is visible :"+download.isDisplayed());
        Thread.sleep(1000);
        download.click();
      /*  System.out.println("Edit is visible:"+edit.isDisplayed());
        Thread.sleep(1000);
        edit.click();
        Thread.sleep(1000);
        quant.clear();
        Thread.sleep(1000);
        quant.sendKeys(updatequant);
        Thread.sleep(1000);
        savebtn.click();*/

        //span[text()='Expense']
    }
}