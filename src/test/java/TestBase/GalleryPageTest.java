package TestBase;

import PageObjects.GalleryPage;
import org.testng.annotations.Test;

public class GalleryPageTest extends BaseClass{

    @Test(priority = 17)
    public void testGalleryPage() throws InterruptedException {
        GalleryPage gp = new GalleryPage(driver);
        gp.toTestGalleryPage(randomString(),randomString(),"/home/encipherhealth/Downloads/jeanmodel.jpeg");
    }

}
