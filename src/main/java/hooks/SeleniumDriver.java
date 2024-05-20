package hooks;

import java.time.Duration;
import java.util.logging.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {

    public static SeleniumDriver seleniumDriver;

    private static WebDriver driver;

    //private static WebDriverWait wait;

    public final static int TIME_OUT = 30;

    public final static int PAGE_LOAD_TIMEOUT = 30;

    static Logger logger = Logger.getLogger(SeleniumDriver.class.getName());

    private SeleniumDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    }

    public static void openPage(String Url) {
        driver.get(Url);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    @Before
    public static void setupDriver() {
        logger.info("Setting Up Driver");
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
        }
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        seleniumDriver = null;
        logger.info("Browser has been closed");
    }

}
