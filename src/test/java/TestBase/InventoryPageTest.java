package TestBase;

import PageObjects.InventoryPage;
import org.apache.commons.io.input.BOMInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass {

    @Test(priority = 1)
    public void verifyInventoryModule(){
        InventoryPage ip = new InventoryPage(driver);
        ip.inventoryClick();
    }

    @Test(priority = 2)
    public void verifyStatus() {
        boolean groupTitle = driver.findElement(By.xpath("//h3[normalize-space(text())='Groups']")).isDisplayed();
        System.out.println("Group title is displayed :"+groupTitle);
    }

    @Test(priority = 3)
    public void verifyActiveItem(){
        boolean status = driver.findElement(By.xpath("//span[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Verify active item is displayed :"+status);
    }

    @Test(priority = 4)
    public void verifyInactiveItem(){
        boolean radioBtn = driver.findElement(By.xpath("(//span[@class='ant-radio-button-label'])[2]")).isDisplayed();
        System.out.println("Verify inactive item is displayed :"+radioBtn);
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

    @Test(priority = 22)
    public void verifyActiveGroup(){
        boolean activeGroup = driver.findElement(By.xpath("//h5[normalize-space(text())='Active Group Items']")).isDisplayed();
        System.out.println("Verify active group field is displayed :"+activeGroup);
    }

    @Test(priority = 23)
    public void verifyAddBtn(){
        boolean addBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Add']")).isDisplayed();
        System.out.println("Verify add button is displayed :"+addBtn);
    }

    @Test(priority = 24)
    public void verifyAddEditBtn(){
        boolean editBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Edit']")).isDisplayed();
        System.out.println("Verify edit button is visible :"+editBtn);
    }

    @Test(priority = 25)
    public void verifyAddCategoryBtn(){
        boolean addCategory = driver.findElement(By.xpath("//span[normalize-space(text())='Add Category']")).isDisplayed();
        System.out.println("Verify add category button is visible :"+addCategory);
    }

    @Test(priority = 26)
    public void verifyDeleteBtn(){
        boolean deleteBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Delete']")).isDisplayed();
        System.out.println("Verify delete Button is displayed:"+deleteBtn);
    }

    @Test(priority = 27)
    public void verifyItemDetail(){
        WebElement item = driver.findElement(By.xpath("//td[@class='ant-table-cell']//button[1]"));
        System.out.println("Item detail is displayed :"+item.isDisplayed());
        item.click();
    }

    @Test(priority = 28)
    public void verifyOverview(){
        boolean overview = driver.findElement(By.xpath("//div[normalize-space(text())='Overview']")).isDisplayed();
        System.out.println("Verify overview is visible :"+overview);
    }

    @Test(priority = 29)
    public void verifyPrimary(){
        boolean details = driver.findElement(By.xpath("//h5[normalize-space(text())='Primary Details']")).isDisplayed();
        System.out.println("Verify transaction tab is displayed :"+details);
    }

    @Test(priority = 30)
    public void verifyItemGroup(){
        boolean itemName = driver.findElement(By.xpath("//span[normalize-space(text())='Item Group']")).isDisplayed();
        System.out.println("Verify itemname is displayed :"+itemName);
    }

    @Test(priority = 31)
    public void verifyUnitField(){
        boolean unit = driver.findElement(By.xpath("//span[normalize-space(text())='Unit']")).isDisplayed();
        System.out.println("Verify unit is displayed :"+unit);
    }

    @Test(priority = 32)
    public void verifySKU(){
        boolean sku = driver.findElement(By.xpath("//span[normalize-space(text())='SKU']")).isDisplayed();
        System.out.println("Verify sku field is displayed :"+sku);
    }

    @Test(priority = 33)
    public void verifyItemCategory(){
        boolean category = driver.findElement(By.xpath("//span[normalize-space(text())='Category']")).isDisplayed();
        System.out.println("Verify category is displayed :"+category);
    }

    @Test(priority = 34)
    public void verifyDescrip(){
        boolean description = driver.findElement(By.xpath("//span[normalize-space(text())='Description']")).isDisplayed();
        System.out.println("Verify description is visible :"+description);
    }

    @Test(priority = 35)
    public void verifyPriceInfo(){
        boolean price = driver.findElement(By.xpath("//h5[normalize-space(text())='Price Information']")).isDisplayed();
        System.out.println("Verify price info header is visible :"+price);
    }

    @Test(priority = 36)
    public void verifyOpeningStock(){
        boolean stock = driver.findElement(By.xpath("//span[normalize-space(text())='Opening Stock Rate']")).isDisplayed();
        System.out.println("Verify opening stock field is visible:"+stock);
    }

    @Test(priority = 37)
    public void verifyCostPrice(){
        boolean cost = driver.findElement(By.xpath("//span[normalize-space(text())='Cost Price/Unit']")).isDisplayed();
        System.out.println("Verify cost price is visible :"+cost);
    }

    @Test(priority = 38)
    public void verifySelling(){
        boolean selling = driver.findElement(By.xpath("//span[normalize-space(text())='Selling Price']")).isDisplayed();
        System.out.println("Verify selling is visible :"+selling);
    }

    @Test(priority = 39)
    public void verifyVendor(){
        boolean vendor = driver.findElement(By.xpath("//span[normalize-space(text())='Preferred Vendor']")).isDisplayed();
        System.out.println("Verify vendor field is displayed :"+vendor);
    }

    @Test(priority = 40)
    public void verifyAttributes(){
        boolean attr = driver.findElement(By.xpath("//h5[normalize-space(text())='Attributes']")).isDisplayed();
        System.out.println("Verify attribute is displayed :"+attr);
    }

    @Test(priority = 41)
    public void verifyTransaction(){
        WebElement transaction = driver.findElement(By.xpath("//div[normalize-space(text())='Transactions']"));
        System.out.println("Verify transaction tab is visible :"+transaction.isDisplayed());
        transaction.click();
    }

    @Test(priority = 42)
    public void verifyDraft(){
        boolean draftStatus = driver.findElement(By.xpath("//span[normalize-space(text())='Draft']")).isDisplayed();
        System.out.println("Verify draft status is visible :"+draftStatus);
    }

    @Test(priority = 43)
    public void verifyAddHeader(){
        boolean add = driver.findElement(By.xpath("//th[normalize-space(text())='Add']")).isDisplayed();
        System.out.println("Verify add header is visible :"+add);
    }

    @Test(priority = 44)
    public void verifyDateHeader(){
        boolean  date= driver.findElement(By.xpath("//th[normalize-space(text())='Date']")).isDisplayed();
        System.out.println("Verify date header is visible :"+date);
    }

    @Test(priority = 45)
    public void verifyRemoveHeader(){
        boolean  remove= driver.findElement(By.xpath("//th[normalize-space(text())='Remove']")).isDisplayed();
        System.out.println("Verify remove header is visible :"+remove);
    }

    @Test(priority = 46)
    public void verifyTotalHeader(){
        boolean  total= driver.findElement(By.xpath("//th[normalize-space(text())='Total']")).isDisplayed();
        System.out.println("Verify total header is visible :"+total);
    }

    @Test(priority = 47)
    public void verifyStatusHeader(){
        boolean  status= driver.findElement(By.xpath("//th[normalize-space(text())='Status']")).isDisplayed();
        System.out.println("Verify status header is visible :"+status);
    }

    @Test(priority = 47)
    public void verifyRemarksHeader(){
        boolean  remarks= driver.findElement(By.xpath("//th[normalize-space(text())='Remarks']")).isDisplayed();
        System.out.println("Verify remarks header is visible :"+remarks);
    }

    @Test(priority = 48)
    public void verifyActionHeader(){
        boolean  action= driver.findElement(By.xpath("//th[normalize-space(text())='Action']")).isDisplayed();
        System.out.println("Verify action header is visible :"+action);
    }

    @Test(priority = 49)
    public void verifyEditBtn(){
        boolean  editBtn= driver.findElement(By.xpath("//span[normalize-space(text())='Edit']")).isDisplayed();
        System.out.println("Verify edit button is visible :"+editBtn);
    }

    @Test(priority = 50)
    public void verifyAdjustStock(){
        WebElement  adjust= driver.findElement(By.xpath("//span[normalize-space(text())='Adjust Stock']"));
        System.out.println("Verify adjust button is visible :"+adjust.isDisplayed());
        adjust.click();
    }

    @Test(priority = 51)
    public void verifyAdjustmentType() {
        WebElement adjustType = driver.findElement(By.xpath("//label[@for='adjustment']"));
        System.out.println("Verify adjust type header is visible :"+adjustType);
    }

    @Test(priority = 52)
    public void verifyAddRadioBtn(){
        boolean addRadioBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Add']")).isDisplayed();
        System.out.println("Verify add radio button is visible :"+addRadioBtn);
    }

    @Test(priority = 53)
    public void verifyRemoveRadioBtn(){
        boolean removeRadioBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Remove']")).isDisplayed();
        System.out.println("Verify remove radio button is visible :"+removeRadioBtn);
    }

    @Test(priority = 54)
    public void verifydate(){
        boolean date = driver.findElement(By.xpath("//input[@placeholder='Select date']")).isDisplayed();
        System.out.println("Verify date field is visible :"+date);
    }

    @Test(priority = 55)
    public void verifyReference(){
        boolean reference = driver.findElement(By.id("referenceNumber")).isDisplayed();
        System.out.println("Verify reference field is visible :"+reference);
    }

    @Test(priority = 56)
    public void VerifyQuan(){
        boolean quantity = driver.findElement(By.id("quantityAvailable")).isDisplayed();
        System.out.println("Verify quantity field is visible :"+quantity);
    }

    @Test(priority = 56)
    public void VerifyQuanRemoved(){
        boolean quantityRemove = driver.findElement(By.id("quantityRemoved")).isDisplayed();
        System.out.println("Verify quantity removed field is visible :"+quantityRemove);
    }

    @Test(priority = 57)
    public void verifyTotalStock(){
        boolean totalstock = driver.findElement(By.id("totalQuantity")).isDisplayed();
        System.out.println("Verify total stock field is visible :"+totalstock);
    }

    @Test(priority = 58)
    public void verifyCostprice(){
        boolean costprice = driver.findElement(By.id("costPrice")).isDisplayed();
        System.out.println("Verify cost price field is visible :"+costprice);
    }

    @Test(priority = 59)
    public void verifyReason(){
        boolean reason = driver.findElement(By.xpath("//input[@type='search']")).isDisplayed();
        System.out.println("Verify reason field is visible :"+reason);
    }

    @Test(priority = 59)
    public void verifyDescriptionField(){
        boolean description = driver.findElement(By.id("description")).isDisplayed();
        System.out.println("Verify description field is visible :"+description);
    }

    @Test(priority = 60)
    public void verifySaveDraftField(){
        boolean save = driver.findElement(By.xpath("//span[normalize-space(text())='Save as Draft']")).isDisplayed();
        System.out.println("Verify save draft field is visible :"+save);
    }

    @Test(priority = 61)
    public void verifyConvertAdjustField(){
        WebElement convert = driver.findElement(By.xpath("//span[normalize-space(text())='Convert to Adjusted']"));
        System.out.println("Verify convert field is visible :"+convert.isDisplayed());
        convert.click();
    }

    @Test(priority = 62)
    public void verifyCancel(){
        boolean cancelBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Cancel']")).isDisplayed();
        System.out.println("Verify cancel button is visible :"+cancelBtn);
    }

    @Test(priority = 63)
    public void validateFillAdjustment() throws InterruptedException {
        InventoryPage ip = new InventoryPage(driver);
        ip.fillAdjustment("22/04/2026",randomLength(),randomOne(),randomString());
    }








}