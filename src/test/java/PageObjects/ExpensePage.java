package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensePage extends BasePage{

    public ExpensePage(WebDriver driver){
        super(driver);
    }

    //locator
    @FindBy(xpath = "//span[text()='Expense']")
    WebElement expenseMod;

    @FindBy(xpath = "//button[text()='+ Add Expense']")
    WebElement addexpense;

    @FindBy(name = "expenseType")
    WebElement expensetype;

    @FindBy(xpath = "//option[text()='Rent']")
    WebElement rent;

    @FindBy(name = "paymentMethod")
    WebElement paymentmethod;

    @FindBy(xpath = "//option[text()='UPI']")
    WebElement upi;

    @FindBy(name = "remarks")
    WebElement remarks;

    @FindBy(name = "expenseDate")
    WebElement expensedate;

    @FindBy(name = "expenseAmount")
    WebElement expamt;

    @FindBy(name = "paymentStatus")
    WebElement paymentstatus;

    @FindBy(xpath = "//option[text()='Partially Paid']")
    WebElement payment;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submit;

    @FindBy(xpath = "//button[text()='Close']")
    WebElement close;

    @FindBy(xpath = "//span[text()='PAID']")
    WebElement topstatus;

    @FindBy(xpath = "#__next > div > section > div > div > main > section > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiTableContainer-root.table-container-style.css-13xy2my > div:nth-child(1) > div > div.ant-select.ant-select-outlined.css-3rel02.ant-select-single.ant-select-allow-clear.ant-select-show-arrow > span.ant-select-clear > span > svg > path")
    WebElement clear;

    @FindBy(xpath = "//input[@type='search']")
    WebElement search;

    @FindBy(xpath = "//div[@name='Partially Paid']")
    WebElement filterstatus;

    @FindBy(xpath = "#__next > div > section > div > div > main > section > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiTableContainer-root.table-container-style.css-13xy2my > table > tbody > tr:nth-child(1) > td.MuiTableCell-root.MuiTableCell-body.MuiTableCell-sizeMedium.css-wjwotp > div > svg")
    WebElement edit;

    @FindBy(xpath = "//option[text()='Paid']")
    WebElement updatepayment;

    //Action
    public void expenseDetail(String rem,String date,String amt) throws InterruptedException{
        System.out.println("Expense module is visible :"+expenseMod.isDisplayed());
        Thread.sleep(2000);
        expenseMod.click();
        System.out.println("Add expense button is visible :"+addexpense.isDisplayed());
        Thread.sleep(1000);
        addexpense.click();
        System.out.println("Expense type is visible :"+expensetype.isDisplayed());
        Thread.sleep(1000);
        expensetype.click();
        System.out.println("Rent in dropdown is visible :"+rent.isDisplayed());
        Thread.sleep(1000);
        rent.click();
        System.out.println("Payment method is visible :"+paymentmethod.isDisplayed());
        Thread.sleep(1000);
        paymentmethod.click();
        System.out.println("UPI in dropdown is visible :"+upi.isDisplayed());
        Thread.sleep(1000);
        upi.click();
        System.out.println("Remarks field is visible :"+remarks.isDisplayed());
        Thread.sleep(1000);
        remarks.sendKeys(rem);
        System.out.println("Expense date is visible :"+expensedate.isDisplayed());
        Thread.sleep(1000);
        expensedate.sendKeys(date);
        System.out.println("Expense amount is visible :"+expamt.isDisplayed());
        Thread.sleep(1000);
        expamt.sendKeys(amt);
        System.out.println("Payment method field is visible :"+paymentstatus.isDisplayed());
        Thread.sleep(1000);
        paymentstatus.click();
        System.out.println("Payment dropdown is visible :"+payment.isDisplayed());
        Thread.sleep(1000);
        payment.click();
        System.out.println("Submit button is visible :"+submit.isDisplayed());
        Thread.sleep(1000);
        submit.click();
        System.out.println("Close button is visible :"+close.isDisplayed());
//        Thread.sleep(1000);
//        close.click();
        System.out.println("Payment status in top is visible :"+topstatus.isDisplayed());
        Thread.sleep(1000);
        topstatus.click();
        System.out.println("Filter status in top is visible :"+filterstatus.isDisplayed());
        Thread.sleep(1000);
        filterstatus.click();
    }

 /*   public void toUpdate() throws InterruptedException {
        System.out.println("Edit button is visible :"+edit.isDisplayed());
        Thread.sleep(1000);
        edit.click();
        Thread.sleep(1000);
        payment.click();
        Thread.sleep(1000);
        updatepayment.click();
        Thread.sleep(1000);
        submit.click();
    } */

}