package PageObjects;

import org.apache.logging.log4j.core.config.Order;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class OrderPage extends BasePage{

    public OrderPage(WebDriver driver){
        super(driver);
    }

    //locators:
    @FindBy(xpath = "//span[normalize-space(text())='Orders & Outsourcing']")
    WebElement orderAndOutsourcing;

    @FindBy(xpath = "//span[normalize-space(text())='Orders']")
    WebElement orders;

    @FindBy(xpath = "//div[normalize-space(text())='Current']")
    WebElement currentTab;

    @FindBy(xpath = "//h3[text()='The Atelier Edits']" )
    WebElement boutiques;

    @FindBy(xpath = "//li[text()='The Atelier Edits']" )
    WebElement clickOneBoutique;

    @FindBy(xpath = "//span[text()='Create Order']")
    WebElement createOrder;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phoneNUmber;

    @FindBy(id = "clientName")
    WebElement clientName;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "reference")
    WebElement ref;

    @FindBy(xpath = "//div[text()='Instagram']")
    WebElement refOption;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;

    @FindBy(id = "products_0_productTypeId")
    WebElement prodType;

    @FindBy(id = "products_0_productName")
    WebElement productName;

    @FindBy(id = "products_0_deliveryDate")
    WebElement delDate;

    @FindBy(id = "products_0_productAmount")
    WebElement prodAmount;

    @FindBy(id = "products_0_rushOrder")
    WebElement rushorder;

    @FindBy(id="products_0_measurements_Sleeve Length")
    WebElement length;

    @FindBy(xpath = "//textarea[@placeholder='Type your custom instructions here...']")
    WebElement Notes;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement nxtButton;

    @FindBy(xpath = "//span[text()='Previous']")
    WebElement previous;

    @FindBy(id = "orderAmount")
    WebElement orderamt;

    @FindBy(id = "advanceReceived")
    WebElement advance;

    @FindBy(xpath = "//span[text()='Create Order']")
    WebElement orderSubmission;

    @FindBy(xpath = "//span[text()='Add Product']")
    WebElement addItem;

    @FindBy(xpath = "//span[normalize-space(text())='Dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "//div[text()='Deliveries To Date']")
    WebElement todaysDelivery;

    @FindBy(xpath = "//div[text()='Bills Pending To Date']")
    WebElement billspending;

    @FindBy(xpath = "//div[@class='small-card appointments']//div[1]")
    WebElement appointments;

    String naame,num;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void dashboard() throws InterruptedException {
        String pagetitle = driver.getTitle();
        System.out.println("The page title is :"+pagetitle);

        dashboard.click();
        Thread.sleep(1000);

        WebElement totalProducts = driver.findElement(By.xpath("//div[text()='Total Products']/following-sibling::div[@class='count']"));
        String count = totalProducts.getText();
        System.out.println("Total Products count: " + count);
        Thread.sleep(1000);

        WebElement newproducts = driver.findElement(By.xpath("//div[text()='New Products']//following-sibling::div[@class='count']"));
        String newcount = newproducts.getText();
        System.out.println("New product count :"+newcount);
        Thread.sleep(1000);

        String deliverycount = todaysDelivery.getText();
        System.out.println("Today's delivery count :"+deliverycount);
        Thread.sleep(1000);

        String billcount = billspending.getText();
        System.out.println("Bills pending count :"+billcount);
        Thread.sleep(1000);

        String appointmentcount = appointments.getText();
        System.out.println("Appointments count :"+appointmentcount);
        Thread.sleep(1000);
    }

    public void getClient(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#rc-tabs-0-panel-current > div > div.ant-table-wrapper.custom-antd-table.css-ac2jek > div > div > div > div > div.ant-table-header.ant-table-sticky-holder > table")
                )
        );
        List<WebElement> headers = table.findElements(By.tagName("th"));

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        List<WebElement> allRows = driver.findElements(
                By.xpath("//div[contains(@class,'ant-table')]//tbody/tr[td]")
        );

        for (WebElement row : allRows) {

            List<WebElement> columns = row.findElements(By.tagName("td"));

            String firstColumnText = columns.get(0).getText();
            System.out.println(firstColumnText);
        }
    }

    public void clickCurrentTab() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(currentTab)).click();
    }

    //Action
    public void orderModuleClient(String number,String name,String add) throws InterruptedException {
        System.out.println("Order button is displayed or not :" + createOrder.isDisplayed());
        createOrder.click();
        Thread.sleep(2000);
        nextButton.click();

        boolean isMobileErr = !driver.findElements(By.xpath("//div[text()='Mobile Number is required']")).isEmpty();
        boolean isNameErr = !driver.findElements(By.xpath("//div[text()='Name is required']")).isEmpty();
        boolean isAddressErr = !driver.findElements(By.xpath("//div[text()='Address is required']")).isEmpty();

        if(isMobileErr || isNameErr || isAddressErr) {
            System.out.println("Validation triggered: Filling mandatory fields...");
            System.out.println("Phone field is present:" + phoneNUmber.isDisplayed());
            phoneNUmber.sendKeys(number);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Client name field is enabled :" + clientName.isEnabled());
            clientName.sendKeys(name);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Address field is present or not :" + address.isDisplayed());
            address.sendKeys(add);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(2000);
            System.out.println("Reference dropdown is displayed :" + ref.isDisplayed());
            ref.click();
            Thread.sleep(1000);

          /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            List<WebElement> refOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div")));
            Random random = new Random();
            int randomIndex = random.nextInt(refOptions.size());
            WebElement selectReference = refOptions.get(randomIndex);
            Thread.sleep(1000);
            selectReference.click();*/

            refOption.click();
            Thread.sleep(1000);
            System.out.println("Next button in client details :" + nextButton.isDisplayed());
            nextButton.click();
        }
        else {}
        System.out.println("proceeding to next screen..");
    }

    public void checkValueOfOrderDetail() throws InterruptedException {
        System.out.println("Checking values of order details:");
        Thread.sleep(1000);
        String ph = phoneNUmber.getAttribute("value");
        System.out.println(ph);
        System.out.println("Entered PhNo:"+ph);
        Thread.sleep(1000);
        String cName = driver.findElement(By.id("clientName")).getAttribute("value");
        System.out.println("Entered client name :"+cName);
        Thread.sleep(1000);
        String addre = driver.findElement(By.id("address")).getAttribute("value");
        System.out.println("Entered address :"+addre);
        Thread.sleep(1000);
        System.out.println("values checked completely in order page");
        nextButton.click();
    }

    public void checkValueOfProductDetail(){
        System.out.println("Checking values of product details:");

        String Pname = driver.findElement(By.id("products_0_productName")).getAttribute("value");
        System.out.println("Entered value: " + Pname);
        String Ddate = driver.findElement(By.id("products_0_deliveryDate")).getAttribute("value");
        System.out.println("Entered value: " + Ddate);
        String pAmount = driver.findElement(By.id("products_0_productAmount")).getAttribute("value");
        System.out.println("Entered value: " + pAmount);
        String l = length.getAttribute("value");
        System.out.println("length :"+l);
        System.out.println("values checked completely in product page");
    }

    public void checkValueOfPaymentDetail(){
        System.out.println("Checking value in paymentDetail:");
        String amount = driver.findElement(By.id("orderAmount")).getAttribute("value");
        System.out.println("Order Amount: " + amount);
        String advanceReceived = driver.findElement(By.id("advanceReceived")).getAttribute("value");
        System.out.println("Advance Received: " + advanceReceived);
        System.out.println("Checking completed in paymentDetail:");
    }

    public void previousPage() throws InterruptedException {
        previous.click();
        System.out.println("Im in  order page ..");
        Thread.sleep(1200);
        checkValueOfOrderDetail();
        System.out.println("Next in my order page ..");
        checkValueOfProductDetail();
        Thread.sleep(2000);
        nextButton.click();
    }

    public void previousPage1() throws InterruptedException {
        previous.click();
        System.out.println("In product detail");
        previous.click();
        Thread.sleep(1000);
        System.out.println("In order detail");
        System.out.println("In order detail next button is displayed:"+nextButton.isDisplayed());
        nextButton.click();
        Thread.sleep(1000);
        System.out.println("In product detail next button is displayed:"+nextButton.isDisplayed());
        nextButton.click();
    }

    public void ProductDetail(String productname,String date,String amount,String len,String notes) throws InterruptedException {
        Thread.sleep(1000);
        nextButton.click();

        boolean isProductTypeErr = !driver.findElements(By.xpath("//div[text()='Product Type Required']")).isEmpty();
        boolean isProductNameErr = !driver.findElements(By.xpath("//div[text()='Product Name Required']")).isEmpty();
        boolean isDeliveryDateErr = !driver.findElements(By.xpath("//div[text()='Delivery Date Required']")).isEmpty();
        boolean isProductAmtErr = !driver.findElements(By.xpath("//div[text()='Product Amount Required']")).isEmpty();

        if(isProductTypeErr || isProductNameErr || isDeliveryDateErr || isProductAmtErr) {
            System.out.println("Product type is displayed : " + prodType.isDisplayed());
            prodType.click();
            Thread.sleep(1000);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement selectProduct = driver.findElement(By.xpath("(//div[@title='Blouse']//div)[1]"));
            selectProduct.click();

            Thread.sleep(1000);
            productName.sendKeys(productname);
            Thread.sleep(1000);
            delDate.sendKeys(date);
            Thread.sleep(1000);
            prodAmount.sendKeys(amount);
            System.out.println("checkbox is displayed :" + rushorder.isDisplayed());
            rushorder.click();
            Thread.sleep(2000);
            System.out.println("Length measurement is displayed :" + length.isDisplayed());
            length.sendKeys(len);
            Thread.sleep(1000);

            System.out.println("Notes field is measurement :" + Notes.isDisplayed());
            Notes.sendKeys(notes);
        }

        else{
            System.out.println("Moving to previous page");
        }
        System.out.println("Next button in product details :" + nxtButton.isDisplayed());
        Thread.sleep(1000);
        previousPage();
        Thread.sleep(1000);
        Thread.sleep(1000);

    }

    public void paymentDetails(String advamt) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Order amount is not enabled right :"+orderamt.isDisplayed());
        System.out.println("Order amount is not enabled right :"+orderamt.isEnabled());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Advance field is displayed :"+advance.isEnabled());
        Thread.sleep(1000);
        advance.sendKeys(advamt);
        System.out.println("moving from payment to order");
        previousPage1();
        Thread.sleep(1000);
        checkValueOfPaymentDetail();
        System.out.println("payment to order and returned");
        System.out.println("Create order in order submit :"+orderSubmission.isDisplayed());
        Thread.sleep(1000);
        orderSubmission.submit();
        Thread.sleep(5000);
    }

    public void clickProduct() throws InterruptedException {
        WebElement addProduct = driver.findElement(By.xpath("//span[text()='Add Product']"));
        Thread.sleep(1000);
        addProduct.click();
    }

    public void closeTab() throws InterruptedException {
        WebElement closeModal = driver.findElement(By.xpath("//span[@aria-label='Close']"));
        System.out.println("Verify close modal is visible:"+closeModal.isDisplayed());
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        orderAndOutsourcing.click();
    }

    public void clientMob(String mobile) throws InterruptedException {
        WebElement element = driver.findElement(By.id("phone"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(mobile);
    }

    public void clientname(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clientName")));

        el.click();

        el.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        el.sendKeys(Keys.DELETE);

        el.sendKeys(name);
    }

    public void nextBtn() {
        WebElement nextInClient = driver.findElement(By.xpath("//span[normalize-space(text())='Next']"));
        nextInClient.click();
    }

    public void selectProductType() {
        prodType.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement selectProduct = driver.findElement(By.xpath("(//div[@title='Blouse']//div)[1]"));
        selectProduct.click();
    }

    public void enterProductName(String prodName) throws InterruptedException {
        WebElement element = driver.findElement(By.id("products_0_productName"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(prodName);
    }

    public void enterDeliveryDate(String deliveryDate) throws InterruptedException {
        WebElement element = driver.findElement(By.id("products_0_deliveryDate"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(deliveryDate);
    }

    public void selectSourcingType() {
      WebElement selectType = driver.findElement(By.xpath("(//label[normalize-space(text())='Sourcing Type']/following::input)[1]"));
      selectType.click();
      WebElement sourceOption = driver.findElement(By.xpath("//div[normalize-space(text())='Trims']"));
      sourceOption.click();
    }

    public void enterQuantity(String quantity) throws InterruptedException {
        WebElement element = driver.findElement(By.id("sourcing_0_quantity"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(quantity);
    }

    public void enterTotalAmt(String amount) throws InterruptedException {
        WebElement element = driver.findElement(By.id("sourcing_0_total"));

        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.DELETE);

        Thread.sleep(500);

        element.sendKeys(amount);
    }

    public void clickSave() {
        WebElement saveBtn = driver.findElement(By.xpath("//span[normalize-space(text())='Save All']"));
        saveBtn.click();
    }

    public void clickCreateOrder() {
         createOrder.click();
    }
}