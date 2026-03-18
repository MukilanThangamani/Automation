package Utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("Fabriplay Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
