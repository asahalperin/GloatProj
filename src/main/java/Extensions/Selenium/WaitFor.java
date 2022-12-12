package Extensions.Selenium;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class WaitFor extends Base {
    public static void waitUntilVisible(WebElement elem, int timeOutSeconds, int pollingEveryMillis) {
        try {
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
}
