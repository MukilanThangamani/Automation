package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class EndToEnd {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.fabriplay.com");

        WebElement clk = driver.findElement(By.xpath("//span[text()='Explore for Free']"));
        clk.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement enterphonenumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_username']")));
        enterphonenumber.sendKeys("6369188818");

        WebElement enterpassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_password']")));
        enterpassword.sendKeys("Mukilan@2003");

        WebElement clkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        clkLogin.click();

        WebElement rej = driver.findElement(By.xpath("//button[text()='Reject']"));
        rej.click();

        WebElement cross = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-modal')]//div[text()='Timezone Missing!']/ancestor::div[contains(@class,'ant-modal')]//button[@aria-label='Close']")));
        cross.click();

        WebElement ord = driver.findElement(By.xpath("//span[text()=' Orders']"));
        ord.click();

        WebElement cre = driver.findElement(By.xpath("//span[text()='Create Order']"));
        cre.click();
        Thread.sleep(1000);
        WebElement tel = driver.findElement(By.xpath("//input[@type='tel']"));
        tel.sendKeys("9878965738");
        WebElement nex = driver.findElement(By.xpath("//span[text()='Next']"));
        nex.click();

        boolean isMobileErr = !driver.findElements(By.xpath("//div[text()='Mobile Number is required']")).isEmpty();
        System.out.println(isMobileErr);
        boolean isNameErr = !driver.findElements(By.xpath("//div[text()='Name is required']")).isEmpty();
        System.out.println(isNameErr);
        boolean isAddressErr = !driver.findElements(By.xpath("//div[text()='Address is required']")).isEmpty();

        if(isMobileErr || isNameErr || isAddressErr ){
            System.out.println("Fill the mandatory fields!!");
            WebElement cl = driver.findElement(By.id("clientName"));
            cl.sendKeys("gfdsa");
            WebElement add = driver.findElement(By.id("address"));
            add.sendKeys("gfdew");
        }
        else {
        }

        System.out.println("Completed test validation!");
        WebElement gallery = driver.findElement(By.xpath("//div[text()='Gallery']"));
        gallery.click();

        WebElement allDropdown = driver.findElement(By.xpath("//span[text()='All Images']"));
        allDropdown.click();

        WebElement allImage = driver.findElement(By.xpath("//div[text()='All Images']"));
        allImage.click();

        WebElement  common  = driver.findElement(By.xpath("//span[text()='+ Add Common Images']"));
        common.click();

        WebElement newimage = driver.findElement(By.xpath("//span[text()='Create New Image']"));
        newimage.click();

        WebElement uplo = driver.findElement(By.xpath("//span[text()='Upload']//following::button[2]"));
        uplo.click();

        WebElement imagename = driver.findElement(By.xpath("//input[@placeholder='Enter image name']"));
        imagename.sendKeys("mmh");

        WebElement  cate = driver.findElement(By.id("category"));
        cate.click();

//        WebElement newcat = driver.findElement(By.xpath("//span[text()='Create New Category']"));
//        newcat.click();
//
//        WebElement catname = driver.findElement(By.id("categoryName"));
//        catname.sendKeys(",m");
//
//        WebElement add = driver.findElement(By.xpath("//span[text()='Add']"));
//        add.click();
//
//        WebElement catego = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));
//        catego.click();

        List<WebElement> categoryList = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div"));
        Random random = new Random();
        int randomIndx = random.nextInt(categoryList.size());
        WebElement selectCategory = categoryList.get(randomIndx);
        selectCategory.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileInput = wait1.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']"))
        );
        fileInput.sendKeys("/Users/apple/Downloads/shi2.jpeg");

//        WebElement fileInput = driver.findElement(By.cssSelector("body > div:nth-child(13) > div > div.ant-modal-wrap.ant-modal-centered > div > div:nth-child(1) > div > div.ant-modal-body > form > div:nth-child(3) > div > div.ant-col.ant-form-item-control.css-198drv2 > div > div > span > div > div > span > button > svg"));
//        fileInput.click();
//        fileInput.sendKeys("/Users/apple/Downloads/shi1.jpeg");

    //   WebElement uplo = driver.findElement(By.xpath("//span[text()='Upload']//following::button[2]"));
       uplo.click();


    }
}
