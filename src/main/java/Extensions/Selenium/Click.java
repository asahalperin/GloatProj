package Extensions.Selenium;

import Utilities.CommonOps;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import static Platforms.MetricConvertion.Workflows.HandlePopup.closePopUp;
import static org.testng.Assert.fail;

public class Click extends CommonOps {
    public static void go(WebElement elem) {
        try {
            closePopUp();
            WaitFor.waitUntilClickable(elem, 32, 350);
            elemName = elementTranslator.get(elem);
            elem.click();
            logger.log(Status.PASS, elemName + " Clicked successfully");
        } catch (Exception e) {
            logger.log(Status.FAIL,e + ". Failed to click on: " + elemName + ". Screenshot: ", screenShot());
            fail(e.getMessage() + "Failed to click: " + elemName);
        }
    }

    public static void popupClose(WebElement elem) {
        try {
            elemName = elementTranslator.get(elem);
            elem.click();
            logger.log(Status.PASS, "Popup Closed successfully");
        } catch (Exception e) {
            logger.log(Status.FAIL,e + ". Failed to close Popup: " + ". Screenshot: ", screenShot());
            fail(e.getMessage() + "Failed to click: " + elemName);
        }
    }
}
