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

    @FindBy(xpath = "//div[text()='All Images']")
    WebElement allImages;

    @FindBy(xpath = "//span[text()='+ Add Common Images']")
    WebElement addCommonImages;

    @FindBy(xpath = "//span[text()='Back to Gallery']")
    WebElement backToGallery;

    @FindBy(xpath = "//span[text()='Create New Image']")
    WebElement createNewImage;

    @FindBy(xpath = "//label[text()='Image Name']")
    WebElement imagename;

    @FindBy(xpath = "//label[text()='Category']")
    WebElement category;

    @FindBy(xpath = "//span[text()='Create New Category']")
    WebElement createNewCategory;

    @FindBy(xpath = "//label[text()='Category Name']")
    WebElement categoryName;

    @FindBy(xpath = "//span[text()='Add']")
    WebElement addBtn;

    @FindBy(xpath = "//span[text()='Add']/preceding::button[1]")
    WebElement cancelBtn;

    @FindBy(xpath = "//span[text()='Cancel']")
    WebElement cancel;

    @FindBy(xpath = "//span[text()='Upload']//following::button[2]")
    WebElement uploadBtn;

    @FindBy(xpath = "//input[@type='search']")
    WebElement filter;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void toTestGalleryPage(String imageName,String categoryname,String image) throws InterruptedException {
        System.out.println("In Gallery module");
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        System.out.println("Gallery module button is displayed :"+galleryMod.isDisplayed());
        Thread.sleep(1000);
        galleryMod.click();
        Thread.sleep(1000);

        System.out.println("All images dropdown is displayed:"+allImages.isDisplayed());
        Thread.sleep(1000);
        allImages.click();
        Thread.sleep(1000);

        List<WebElement> imageOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div")));
        int imageSize = imageOptions.size();
        System.out.println("Total images dropdown in gallery:"+imageSize);
        Random random = new Random();
        WebElement option = imageOptions.get(random.nextInt(imageSize));
        option.click();
        Thread.sleep(1000);

        System.out.println("Add common images button is displayed:"+addCommonImages.isDisplayed());
        Thread.sleep(1000);
        addCommonImages.click();
        Thread.sleep(2000);

        System.out.println("Back to gallery button is displayed:"+backToGallery.isDisplayed());
        Thread.sleep(1000);
        backToGallery.click();
        Thread.sleep(2000);
        addCommonImages.click();

        System.out.println("Create new image button is displayed:"+createNewImage.isDisplayed());
        Thread.sleep(1000);
        createNewImage.click();
        Thread.sleep(2000);

        System.out.println("Filling details for new image");
        System.out.println("Image name field is displayed:"+imagename.isDisplayed());
        imagename.sendKeys(imageName);
        System.out.println("Category dropdown is displayed:"+category.isDisplayed());
        Thread.sleep(1000);
        category.click();
        Thread.sleep(1000);

        System.out.println("Create new category button is displayed:"+createNewCategory.isDisplayed());
        Thread.sleep(1000);
        createNewCategory.click();
        Thread.sleep(2000);

        System.out.println("Category name field is displayed:"+categoryName.isDisplayed());
        Thread.sleep(1000);
        categoryName.sendKeys(categoryname);
        Thread.sleep(1000);
        System.out.println("Add button is displayed:"+addBtn.isDisplayed());
        Thread.sleep(10000);
        System.out.println("Cancel button is displayed:"+cancelBtn.isDisplayed());
        Thread.sleep(1000);
        addBtn.click();

        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        Thread.sleep(2000);
        fileInput.sendKeys(image);
        Thread.sleep(1000);
        System.out.println("Upload button is displayed:"+uploadBtn.isDisplayed());
        uploadBtn.click();
        Thread.sleep(1000);

        System.out.println("Filter by category is displayed:"+filter.isDisplayed());
        Thread.sleep(1000);
        filter.click();
        List<WebElement> filterOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div")));
        int filterSize = filterOptions.size();
        WebElement filteredCategory = filterOptions.get(random.nextInt(filterSize));
        Thread.sleep(1000);
        filteredCategory.click();
        Thread.sleep(1000);

    }

}