package Utilities;

import Extensions.Selenium.WaitFor;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class CommonOps extends Base {
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
}
