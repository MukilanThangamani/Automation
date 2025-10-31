package TestBase;

import PageObjects.ProductPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductPageTest extends BaseClass {

    @Test(priority = 9)
    public void testProductTypes() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        SoftAssert softAssert = new SoftAssert();

        String[] prod = {"Pant","Blouse","Skirt"};
        String[] gen = {"Female", "Female","Female"};


        for (int i = 0; i < prod.length; i++) {
            System.out.println("Adding product: " + prod[i]);

            pp.addProduct(prod[i], gen[i]);

            pp.printDuplicateProductErrorMessage(softAssert);

            pp.verifyProductInList(prod[i], 1);
        }

        pp.edit(randomString());
        pp.backButton();
        softAssert.assertAll();


    }
}
