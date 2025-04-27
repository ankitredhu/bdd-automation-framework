package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.Utilities;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Hooks extends BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;
    Properties prop;

    @Before
    public void setUp(Scenario scenario) {
        // Browser initialization
    	prop = ConfigReader.initializeProperties();
    	 String browser = prop.getProperty("browser");
        initializeBrowser(browser);

        // Start Extent report
        extent = ExtentReportManager.getInstance();
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
        	byte[] screenshot = Utilities.takeScreenshot();
            scenario.attach(screenshot, "image/png", scenario.getName());
            test.fail("Test Failed");
        } else {
            test.pass("Test Passed");
        }

        quitBrowser();
        extent.flush();
    }
}
