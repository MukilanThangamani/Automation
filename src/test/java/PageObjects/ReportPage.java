package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ReportPage extends BasePage{
    public ReportPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Reports']")
    WebElement report;

    @FindBy(xpath = "//input[@placeholder='Select month']")
    WebElement selectMonth;

    @FindBy(xpath = "//h5[normalize-space(text())='Product-wise Report']")
    WebElement product;

    @FindBy(xpath = "//h5[normalize-space(text())='Employee Productivity Report']")
    WebElement employeeReport;

    @FindBy(xpath = "//h5[contains(.,'Client Report 2026')]")
    WebElement clientReport;

    @FindBy(xpath = "//h5[normalize-space(text())='Yearly Order & Product Summary']")
    WebElement yearlySummary;

    @FindBy(xpath = "//h5[normalize-space(text())='Yearly Revenue & Expense Report']")
    WebElement yearlyReport;

    public void verifyModule() {
        System.out.println("Verify report module is displayed :"+report.isDisplayed());
        report.click();
    }

    public void verifyMonth() {
        System.out.println("Verify select month is displayed :"+selectMonth.isDisplayed());
    }

    public void verifyReport() {
        System.out.println("Verify product report text is visible :"+product.isDisplayed());
    }

    public void verifyEmployeeReport(){
        System.out.println("Verify employee report is visible :"+employeeReport.isDisplayed());
    }

    public void verifyClientReport() {
        System.out.println("Verify client report is visible :"+clientReport.isDisplayed());
    }

    public void verifyYearlySummary(){
        System.out.println("Verify yearly summary is visible :"+yearlySummary.isDisplayed());
    }

    public void verifyYearlyReport() {
        System.out.println("Verify yearly report is visible :"+yearlyReport.isDisplayed());
    }
}