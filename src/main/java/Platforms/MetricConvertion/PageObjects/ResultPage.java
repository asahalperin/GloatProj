package Platforms.MetricConvertion.PageObjects;

import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utilities.CommonOps.storeWebElemInDictionary;

public class ResultPage extends Base {
    @FindBy(id = "answer")
    private static WebElement resultText;
    public WebElement resultText() throws Exception {
        storeWebElemInDictionary(resultText, "Result text");
        return elem;
    }

    @FindBy(id = "userConvert")
    private static WebElement convertField;
    public WebElement convertField() throws Exception {
        storeWebElemInDictionary(convertField, "Convert field");
        return elem;
    }
}
