package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.aventstack.extentreports.*;
import TestBase.BaseClass;

import java.awt.*;
import java.io.File;

public class TestListener implements ITestListener {

    public static ExtentReports extent = ExtendManager.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass) currentClass).getDriver();

        String path = ScreenShotUtil.capture(driver, result.getMethod().getMethodName());

        test.get().fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        try {
            File report = new File("test-output/ExtentReport.html");
            Desktop.getDesktop().browse(report.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
