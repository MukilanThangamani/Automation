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

public class GalleryPage extends BasePage{

    public GalleryPage(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(xpath = "//div[text()='Gallery']")
    WebElement galleryMod;

    @FindBy(id = "editFolder_folderName")
    WebElement foldername;

    @FindBy(xpath = "//span[text()='Add Folder']")
    WebElement addFolder;

    @FindBy(xpath = "(//button[@type='button']//span)[3]")
    WebElement folderinClient;

    @FindBy(xpath = "//span[text()='Update']")
    WebElement update;

    @FindBy(xpath = "//div[normalize-space(text())='Client Images']")
    WebElement clientImage;

    @FindBy(xpath ="//div[normalize-space(text())='VFSXL - 9731312671']")
    WebElement client;

    @FindBy(id = "editFolder_clientId")
    WebElement dropdownclick;

    @FindBy(xpath = "//span[normalize-space(text())='Close']")
    WebElement close;

    public void moduleClick() throws InterruptedException {
        Thread.sleep(1000);
        galleryMod.click();
    }

    public void clickAddFolder() {
        System.out.println("FolderName is displayed :"+addFolder.isDisplayed());
        addFolder.click();
    }

    public void addName(String name) throws InterruptedException {
        Thread.sleep(1000);
        foldername.sendKeys(name);
        update.click();
    }

    public void clientFolder() {
        clientImage.click();
        folderinClient.click();
    }

    public void selectClientName() {
        dropdownclick.click();
        client.click();
        update.click();

    }

    public void closeBtn() {
        close.click();
    }

    public void clientImageFolder(){
        folderinClient.click();
    }
}