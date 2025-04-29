package hooks;

import java.util.Properties;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.LoggerUtility;
import utils.RetryScenario;
import utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Hooks extends BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;
    Properties prop;
    RetryScenario retryScenario = new RetryScenario();
    org.apache.logging.log4j.Logger log = LoggerUtility.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
    	
        
        prop = ConfigReader.initializeProperties();
        String browser = prop.getProperty("browser");
        initializeBrowser(browser);
        log.info("Running scenario: " + scenario.getName());
        log.info("Browser from config: " + browser);

        // Start Extent report
        extent = ExtentReportManager.getInstance();
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            if (retryScenario.shouldRetry(scenario)) {
            	log.error("Scenario failed: " + scenario.getName());
                
            }
            byte[] screenshot = Utilities.takeScreenshot(getDriver());
            scenario.attach(screenshot, "image/png", scenario.getName());
            test.fail("Test Failed");
        } else {
            test.pass("Test Passed");
            log.info("Scenario passed: " + scenario.getName());
        }

        quitBrowser();
        extent.flush();
    }
}