package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ExpensePage extends BasePage{

    public ExpensePage(WebDriver driver){
        super(driver);
    }

    //locator
    @FindBy(xpath = "//span[text()='Expense']")
    WebElement expenseMod;

    @FindBy(xpath = "//span[text()='Add Category']")
    WebElement addCategory;

    @FindBy(id = "name")
    WebElement categoryName;

    @FindBy(xpath = "//span[text()='Create']")
    WebElement create;

    @FindBy(xpath = "//span[text()='Add Expense']")
    WebElement addexpense;

    @FindBy(id = "expenseCategoryId")
    WebElement expenseCategory;//html/body/div[3]/div/div/div[2]/div/div/div

    @FindBy(id = "paymentMethod")
    WebElement paymentMethod; //html/body/div[4]/div/div/div[2]/div/div/div

    @FindBy(id = "remarks")
    WebElement remarks;

    @FindBy(id = "expenseDate")
    WebElement expenseDate;

    @FindBy(id = "expenseAmount")
    WebElement expenseAmount;

    @FindBy(id = "paymentStatus")
    WebElement paymentStatus;

    //Action
    public void addCategory(String s) throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        System.out.println("Expense module button is displayed :"+expenseMod.isDisplayed());
        Thread.sleep(1000);
        expenseMod.click();
        Thread.sleep(1000);
        System.out.println("Add category button is displayed :"+addCategory.isDisplayed());
        addCategory.click();
        Thread.sleep(1000);
        System.out.println("Category name is displayed :"+categoryName.isDisplayed());
        categoryName.sendKeys(s);
        System.out.println("Create button is displayed :"+create.isDisplayed());
        Thread.sleep(1000);
        create.click();
    }

    public void addExpense(String s,String date,String amt) throws InterruptedException {
        System.out.println("Add Expense button is displayed :"+addexpense.isDisplayed());
        addexpense.click();
        Thread.sleep(1000);
        System.out.println(" Expense category  dropdown is displayed :"+addCategory.isDisplayed());
        expenseCategory.click();
        Thread.sleep(1000);

        List<WebElement> categoryOptions = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div"));
        Random random = new Random();
        int randomIndex = random.nextInt(categoryOptions.size());
        WebElement selectedCategory = categoryOptions.get(randomIndex);
        selectedCategory.click();

        System.out.println("Payment method dropdown is displayed :"+paymentMethod.isDisplayed());
        paymentMethod.click();

        Thread.sleep(1000);

        List<WebElement> paymentmethod = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div"));
        int randomIdx = random.nextInt(paymentmethod.size());
        WebElement selectedPayment = paymentmethod.get(randomIdx);
        selectedPayment.click();

        System.out.println("Remarks field is displayed :"+remarks.isDisplayed());
        remarks.click();
        Thread.sleep(1000);
        remarks.sendKeys(s);
        Thread.sleep(1000);
        System.out.println("ExpenseDate field is displayed :"+expenseDate.isDisplayed());
        expenseDate.sendKeys(date);
        Thread.sleep(1000);
        System.out.println("ExpenseAmount field is displayed :"+expenseAmount.isDisplayed());
        expenseAmount.click();
        Thread.sleep(1000);
        expenseAmount.sendKeys(amt);
        Thread.sleep(1000);
        System.out.println("Payment status dropdown is displayed :"+paymentStatus.isDisplayed());
        paymentStatus.click();
        Thread.sleep(1000);

        List<WebElement> paymentStatus = driver.findElements(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div"));
        int ranIdx = random.nextInt(paymentStatus.size());
        WebElement status = paymentStatus.get(ranIdx);
        status.click();

        System.out.println("Create button is displayed :"+create.isDisplayed());
        Thread.sleep(1000);
        create.click();

    }
}
