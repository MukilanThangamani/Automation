package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DesignBoardPage extends BasePage {

    public DesignBoardPage(WebDriver driver){
        super(driver);
    }

    public void clickDesignBoard() {
        WebElement design = driver.findElement(By.xpath("//span[text()=' Design board']"));
        design.click();
    }

}
