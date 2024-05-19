package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ExtentManager {

    private static ExtentReports extentReport;
    private static ExtentHtmlReporter extentHtmlReporter;

    private ExtentTest test;

    public static ExtentReports getReportInstance() {
        if (extentReport == null) {
            extentReport = new ExtentReports();
            extentHtmlReporter = new ExtentHtmlReporter("target/extentReport/extentReport.html");
            extentReport.attachReporter(extentHtmlReporter);
        }
        return extentReport;
    }

    @Before
    public void setup() {
        getReportInstance();
        test = extentReport.createTest("Cars Guide Test");
    }

    @After
    public void tearDown() {
        extentReport.flush();
    }

}
