package hooks;

import java.util.Properties;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ExtentReportManager;
import utils.RetryScenario;
import utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public static ExtentReports extent;
    public static ExtentTest test;
    Properties prop;
    RetryScenario retryScenario = new RetryScenario();

    @Before
    public void setUp(Scenario scenario) {
        logger.info("Starting scenario: {}", scenario.getName());
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
            if (retryScenario.shouldRetry(scenario)) {
                logger.info("Scenario failed: {}. Marked for retry in failedrerun.txt", scenario.getName());
                
            }
            byte[] screenshot = Utilities.takeScreenshot(getDriver());
            scenario.attach(screenshot, "image/png", scenario.getName());
            test.fail("Test Failed");
            logger.error("Scenario failed: {}", scenario.getName());
        } else {
            test.pass("Test Passed");
            logger.info("Scenario passed: {}", scenario.getName());
        }

        quitBrowser();
        extent.flush();
    }
}