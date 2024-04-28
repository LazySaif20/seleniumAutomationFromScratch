package hooks;

import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class SeleniumDriver {

    public static SeleniumDriver seleniumDriver;

    private static WebDriver driver;

    private static WebDriverWait wait;

    public final static int TIME_OUT = 30;

    public final static int PAGE_LOAD_TIMEOUT = 30;

    private SeleniumDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
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
        System.out.println("Setting Up Driver");
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
    }

}
