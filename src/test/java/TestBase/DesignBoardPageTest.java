package TestBase;

import PageObjects.DesignBoardPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DesignBoardPageTest extends  BaseClass{

    @Test(priority = 1)
    public void verifyDesignModule(){
        DesignBoardPage dp = new DesignBoardPage(driver);
        boolean design = driver.findElement(By.xpath("//span[text()=' Design board']")).isDisplayed();
        System.out.println("DesignBoard Module is displayed :"+design);
        dp.clickDesignBoard();
    }

    @Test(priority = 2)
    public void verifySearchInput(){
        boolean search = driver.findElement(By.xpath("//input[@placeholder='Search designs...']")).isDisplayed();
        System.out.println("Search field is displayed :"+search);
    }

    @Test(priority = 3)
    public void verifyAddDesign(){
        boolean addDesign = driver.findElement(By.xpath("//span[text()='Add New Design']")).isDisplayed();
        System.out.println("Add design is displayed:"+addDesign);
    }

}
