package Platforms.MetricConvertion.PageObjects;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utilities.CommonOps.storeWebElemInDictionary;

public class HomePage extends Base {
    @FindBy(id = "queryFrom")
    private static WebElement convertFromField;
    public WebElement convertFromField() throws Exception {
        storeWebElemInDictionary(convertFromField, "Convert from field");
        return elem;
    }

    @FindBy(id = "queryTo")
    private static WebElement convertToField;
    public WebElement convertToField() throws Exception {
        storeWebElemInDictionary(convertToField, "Convert to field");
        return elem;
    }

    @FindBy(xpath = "//input[@class='argument']")
    private static WebElement conversionField;
    public WebElement conversionField() throws Exception {
        storeWebElemInDictionary(conversionField, "Conversion field");
        return elem;
    }

    @FindBy(xpath = "//a[text() = 'Convert']")
    private static WebElement convertButton;
    public WebElement convertButton() throws Exception {
        storeWebElemInDictionary(convertButton, "Convert button");
        return elem;
    }
    @FindBy
    private static WebElement dynamicButton;
    public WebElement dynamicButton(String convertFrom, String convertTo) throws Exception {
        storeWebElemInDictionary(convertButton, "Convert " + convertFrom + " to " + convertTo + " button");
        String xpath = "//div[@class = 'convertForm']/a[contains(@href, '" + convertFrom.toLowerCase() + "-to-" + convertTo.toLowerCase() + ".htm') and not(contains(text(), 'Click here'))]";
        return driver.findElement(By.xpath(xpath));
    }
}
