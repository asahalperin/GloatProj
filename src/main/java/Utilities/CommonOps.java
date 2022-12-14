package Utilities;

import Extensions.Selenium.BrowserOps;
import Extensions.Selenium.WaitFor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Objects;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class CommonOps extends Base {

    @BeforeSuite
    public void startSuite(ITestContext ctx) {
        suiteName = ctx.getSuite().getName();
        extent = new ExtentReports();
        switch (platform.toLowerCase()) {
            case "web":
                extentSparkReporter = new ExtentSparkReporter("../WebReports/" + timeStamp + "/Report.html");
                extent.attachReporter(extentSparkReporter);
                initBrowser();
                BrowserOps.cleanBrowser();
                ManagePages.initWeb();
                break;
            case "api":
                extentSparkReporter = new ExtentSparkReporter("../ApiReports/" + timeStamp + "/Report.html");
                extent.attachReporter(extentSparkReporter);
                break;
        }
    }

    @AfterSuite()
    public void endSuite() {
        if (platform.toLowerCase().equals("web"))
            driver.quit();
    }

    @BeforeMethod()
    public void doBeforeMethod(Method method) {
        String name = method.getAnnotation(Test.class).testName();
        logger = extent.createTest(name);
        testName = name;
        driver.get("https://www.metric-conversions.org/");
    }

    @AfterMethod()
    public void doAfterMethod(Method method) {
        try {
            Thread.sleep(1000);
            extent.flush();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void initBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void storeWebElemInDictionary(WebElement webElem, String elemName) throws Exception {
        WaitFor.waitUntilVisible(webElem, 20, 350);
        elem = webElem;
        elementTranslator.put(elem, elemName);
    }

    public static Media screenShot() {
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        Media storedImage = MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build();
        return storedImage;
    }

    public static String convertMetric(double meter) {
        String finalText = feet(meter) + "ft " + inches(meter) + "in";
        return finalText;
    }

    private static String feet(double meter) {
        double feet = 3.281 * meter;
        String feetToString = String.valueOf((int)feet);
        return feetToString;
    }

    private static String inches(double meter) {
        double inch = 3.281 * meter;
        String translateInch = String.valueOf(inch);
        String replacement = "0";
        String replaceTo0 = String.valueOf(Double.parseDouble(replacement.concat(translateInch.substring(1))) * 12);
        return replaceTo0;
    }

    public static double StringToDouble(String value, String cutFrom, int indexValueBefore, int indexValueEnd) {
        double actualValue = 0;
        String cutBeforeActual = value.substring(value.indexOf(cutFrom) +indexValueBefore);
        String cutAfterActual = cutBeforeActual.substring(0, cutBeforeActual.length() -indexValueEnd);
        actualValue = Double.valueOf(cutAfterActual);
        return actualValue;
    }
}
