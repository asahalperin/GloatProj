package Extensions.Selenium;

import Utilities.CommonOps;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static Platforms.MetricConvertion.Workflows.HandlePopup.closePopUp;
import static org.testng.Assert.fail;

public class WaitFor extends CommonOps {
    public static void waitUntilVisible(WebElement elem, int timeOutSeconds, int pollingEveryMillis) {
        try {
            closePopUp();
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(timeOutSeconds))
                    .pollingEvery(Duration.ofMillis(pollingEveryMillis))
                    .withMessage("Fluent wait to element '" + elem + "' to be visible")
                    .ignoring(NoSuchElementException.class, AssertionError.class).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.visibilityOf(elem));
        } catch (Exception e) {
            logger.log(Status.FAIL, "Element: '" + elemName + "' is not visible after " + timeOutSeconds + " seconds. See details: " + e + ". Screenshot: ", screenShot());
            fail(e + "Wait for element to be visible was failed, elem: " + elemName);
        }
    }

    public static void waitUntilClickable(WebElement elem, int timeOutSeconds, int pollingEveryMillis) {
        try {
            closePopUp();
            FluentWait wait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(timeOutSeconds))
                    .pollingEvery(Duration.ofMillis(pollingEveryMillis))
                    .withMessage("Fluent wait to element '" + elem + "' to be visible")
                    .ignoring(NoSuchElementException.class, AssertionError.class).ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        } catch (Exception e) {
            logger.log(Status.FAIL, "Element: '" + elemName + "' is not visible after " + timeOutSeconds + " seconds. See details: " + e + ". Screenshot: ", screenShot());
            fail(e + "Wait for element to be visible was failed, elem: " + elemName);
        }
    }

    public static void threadSleep(int milliseconds) {
        try {
            closePopUp();
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            logger.log(Status.FAIL, e.getMessage(), screenShot());
            fail(e.getMessage());
        }
    }

    public static void implicitWait(int seconds) {
        try {
            closePopUp();
            new WebDriverWait(driver, Duration.ofSeconds(seconds));
        } catch (Exception e) {
            logger.log(Status.FAIL, e.getMessage(), screenShot());
            fail(e.getMessage());
        }
    }

    public static void numberOfElementsToBeMoreThan(String xpath, int seconds) {
        try {
            closePopUp();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 0));
        } catch (Exception e) {
            logger.log(Status.FAIL, e.getMessage(), screenShot());
            fail(e.getMessage());
        }
    }
}
