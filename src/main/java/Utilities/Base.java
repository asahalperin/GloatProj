package Utilities;

import Platforms.MetricConvertion.PageObjects.HomePage;
import Platforms.MetricConvertion.PageObjects.ResultPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Base {
    public double unitCalc;
    public static WebDriver driver;
    public static WebElement elem;
    public static Map<WebElement, String> elementTranslator = new HashMap<>();
    public static ExtentTest logger;
    public static String elemName;

    public static HomePage homePage;
    public static ResultPage resultPage;
}
