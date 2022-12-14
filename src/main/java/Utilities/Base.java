package Utilities;

import Platforms.MetricConvertion.PageObjects.HomePage;
import Platforms.MetricConvertion.PageObjects.Popups;
import Platforms.MetricConvertion.PageObjects.ResultPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Base {
    public double unitCalc;
    protected static WebDriver driver;
    protected static WebElement elem;
    protected static Map<WebElement, String> elementTranslator = new HashMap<>();
    protected static ExtentTest logger;
    protected static String elemName;
    static String suiteName;
    static ExtentReports extent;
    static ExtentSparkReporter extentSparkReporter;

    // Init pages
    protected static HomePage homePage;
    protected static ResultPage resultPage;
    protected static Popups popups;
    static String testName;
    static String platform = System.getProperty("platform");
    static String timeStamp = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss").format(Calendar.getInstance().getTime());

    protected static DecimalFormat numberFormat;

}
