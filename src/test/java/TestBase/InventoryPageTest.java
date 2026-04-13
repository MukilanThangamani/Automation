package TestBase;

import PageObjects.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass {

    @Test(priority = 1)
    public void verifyInventoryModule(){
        InventoryPage ip = new InventoryPage(driver);
        ip.inventoryClick();
    }

    @Test(priority = 2)
    public void verifyStatus() throws InterruptedException {
        WebElement status = driver.findElement(By.xpath("(//span[@class='ant-select-selection-item'])[1]"));
        System.out.println("Verify status is displayed:"+status.isDisplayed());
        Thread.sleep(1000);
        status.click();
    }

    @Test(priority = 3)
    public void verifyActiveItem(){
        boolean activeItem = driver.findElement(By.xpath("//div[normalize-space(text())='Active Items']")).isDisplayed();
        System.out.println("Verify active item is displayed :"+activeItem);
    }

    @Test(priority = 4)
    public void verifyInactiveItem(){
        boolean inActiveItem = driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).isDisplayed();
        System.out.println("Verify inactive item is displayed :"+inActiveItem);
    }

    @Test(priority = 5)
    public void verifyNameHeader(){
        boolean name = driver.findElement(By.xpath("//th[normalize-space(text())='Name']")).isDisplayed();
        System.out.println("Verify name header is displayed :"+name);
    }

    @Test(priority = 6)
    public void verifyImageHeader(){
        boolean image = driver.findElement(By.xpath("//th[normalize-space(text())='Image']")).isDisplayed();
        System.out.println("Verify image header is displayed:"+image);
    }

    @Test(priority = 7)
    public void verifyUnitHeader(){
        boolean unit = driver.findElement(By.xpath("//th[normalize-space(text())='Unit']")).isDisplayed();
        System.out.println("Verify unit is displayed:"+unit);
    }

    @Test(priority = 8)
    public void verifyAction(){
        boolean action = driver.findElement(By.xpath("//th[normalize-space(text())='Action']")).isDisplayed();
        System.out.println("Verify action is displayed:"+action);
    }

    @Test(priority = 9)
    public void verifyAddNewGroup(){
        WebElement newgroup = driver.findElement(By.xpath("//span[normalize-space(text())='Add New Group']"));
        System.out.println("Verify newgroup is displayed :"+newgroup.isDisplayed());
        newgroup.click();
    }

    @Test(priority = 10)
    public void verifyGroupName(){
        boolean groupname = driver.findElement(By.id("itemGroupName")).isDisplayed();
        System.out.println("Verify groupname is displayed:"+groupname);
    }

    @Test(priority = 11)
    public void verifyUnit(){
        boolean unit = driver.findElement(By.id("unit")).isDisplayed();
        System.out.println("Verify unit is displayed :"+unit);
    }

    @Test(priority = 12)
    public void verifyDescription(){
        boolean description = driver.findElement(By.id("description")).isDisplayed();
        System.out.println("Verify description is displayed :"+description);
    }

    @Test(priority = 13)
    public void verifyImage(){
        boolean image = driver.findElement(By.xpath("//button[contains(.,'Upload')]")).isDisplayed();
        System.out.println("Verify image uploader is visible :"+image);
    }

    @Test(priority = 14)
    public void verifyCategory(){
        boolean category = driver.findElement(By.id("categories_0_categoryName")).isDisplayed();
        System.out.println("Verify category is visible :"+category);
    }

    @Test(priority = 15)
    public void verifyAttribute(){
        boolean attribute = driver.findElement(By.id("categories_0_attributes_0_attributeName")).isDisplayed();
        System.out.println("Verify attribute is visible :"+attribute);
    }

    @Test(priority = 16)
    public void verifyOptions(){
        boolean options = driver.findElement(By.xpath("(//span[@class='ant-select-selection-wrap']//div)[1]")).isDisplayed();
        System.out.println("Verify option is visible :"+options);
    }

    @Test(priority = 17)
    public void verifyAddAttribute(){
        boolean addAttribute = driver.findElement(By.xpath("//span[normalize-space(text())='+ Add Attribute']")).isDisplayed();
        System.out.println("Verify add attribute is visible :"+addAttribute);
    }

    @Test(priority = 18)
    public void verifyAddCategory(){
        boolean addCategory = driver.findElement(By.xpath("//span[normalize-space(text())='+ Add Category']")).isDisplayed();
        System.out.println("Verify add category is visible :"+addCategory);
    }

    @Test(priority = 19)
    public void verifyBackButton(){
        boolean backBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Back']")).isDisplayed();
        System.out.println("Verify back button is visible :"+backBtn);
    }

    @Test(priority = 20)
    public void verifySubmitButton(){
        WebElement submitButton = driver.findElement(By.xpath("//span[normalize-space(text())='Submit']"));
        System.out.println("Verify submit button is displayed :"+submitButton.isDisplayed());
        submitButton.click();
    }

    @Test(priority = 21)
    public void verifyItemGroupData() throws InterruptedException {
        InventoryPage ip1 = new InventoryPage(driver);
        ip1.groupFields(randomString(),randomString(),randomString(),randomAmount(),randomString());

    }




}
