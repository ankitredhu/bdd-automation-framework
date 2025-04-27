package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReports/extent-report.html");
        reporter.config().setReportName("Automation Testing Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Ankit");

        return extent;
    }
}
