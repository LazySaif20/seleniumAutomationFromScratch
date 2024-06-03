package utilities;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CommonActions {
    private static WebDriverWait wait;
    static WebDriver driver;
    public void clickOnElement(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        takeScreenShot(element);
    }

    public void checkIfElementIsDisplayed(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        takeScreenShot(element);
    }

    public void takeScreenShot(WebElement element){
        File file = element.findElement(By.xpath("../..")).getScreenshotAs(OutputType.FILE);
        String picName = ".\\screenshots\\pic_"+
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+".jpg";
        FileUtils.copyFile(file, new File(picName.
                replace(" ","").replace(":","").replace("-","")));
    }
}
