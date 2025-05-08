package hooks;

import java.util.Properties;
import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.HeaderPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelReader;
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

    @Before(order = 1)
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
    
    @Before(value = "@LoggedIn", order = 2)
    public void loginBeforeScenario() {
        log.info("Performing login as scenario is tagged with @LoggedIn");

        LoginPage loginPage = new LoginPage(getDriver());
        HeaderPage headerPage = new HeaderPage(getDriver());
        String[][] data = ExcelReader.readExcelData("Sheet1");

        // You can use first row (0 index) or parameterize later
        headerPage.clickSignupLoginLink();
        loginPage.enterLoginEmail(data[0][0]);
        loginPage.enterLoginPassword(data[0][1]);
        loginPage.clickLoginButton();
        log.info("Login completed");
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