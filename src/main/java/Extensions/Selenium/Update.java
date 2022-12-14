package Extensions.Selenium;

import Utilities.Base;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import static Platforms.MetricConvertion.Workflows.HandlePopup.closePopUp;
import static Utilities.CommonOps.screenShot;
import static org.testng.Assert.fail;

public class Update extends Base {
    public static void text(WebElement elem, String value) {
        try
        {
            closePopUp();
            elemName = elementTranslator.get(elem);
            WaitFor.waitUntilVisible(elem, 30, 350);
            elem.sendKeys(value);
            logger.log(Status.PASS, "Text value '"+ value +"' sent to element: " + elemName);
        }
        catch (Exception e) {
            logger.log(Status.FAIL,e + "Failed to send text to element: " + elemName + " with value: " + value + ". Screenshot: " + screenShot());
            fail(e + "Failed to update text field: " + elemName);
        }
    }

    public static String takeText(WebElement elem) {
        String str = "";
        try {
            elemName = elementTranslator.get(elem);
            WaitFor.waitUntilVisible(elem, 30, 350);
            str = elem.getText();
            logger.log(Status.PASS, "Take text from " + elemName + ", value: " + str + " successfully");
        }
        catch (Exception e) {
            logger.log(Status.FAIL,e + "Failed to take text from element: " + elemName + ". Screenshot: " + screenShot());
            fail(e + "Failed to take text from element: " + elemName);
        }
        return str;
    }
}
