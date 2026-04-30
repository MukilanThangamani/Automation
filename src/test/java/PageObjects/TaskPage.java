package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage{

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space(text())='Tasks']")
    WebElement task;

    public void moduleClick() {
        System.out.println("Task page is displayed:"+task.isDisplayed());
        task.click();
    }



}