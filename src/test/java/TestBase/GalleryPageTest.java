package TestBase;

import PageObjects.GalleryPage;
import org.testng.annotations.Test;

public class GalleryPageTest extends BaseClass{

    //@Test(priority = 17)
    @Test
    public void testGalleryPage() throws InterruptedException {
        GalleryPage gp = new GalleryPage(driver);
        gp.toTestGalleryPage(randomString(),randomString());
    }

    //@Test(priority = 18)
    @Test
    public void testImageUploader() throws InterruptedException{
        GalleryPage gp1 = new GalleryPage(driver);
        gp1.imageValidation();
    }

}
