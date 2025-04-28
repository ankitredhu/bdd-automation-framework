package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

    // ThreadLocal for parallel execution and retry-safe driver handling
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties prop;

    public void initializeBrowser(String browserName) {
        prop = ConfigReader.initializeProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            System.out.println("Invalid browser! Running Chrome by default.");
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://automationexercise.com/");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void quitBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Very important to avoid memory leaks
        }
    }
}
