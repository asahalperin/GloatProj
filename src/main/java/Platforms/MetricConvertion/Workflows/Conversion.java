package Platforms.MetricConvertion.Workflows;

import Extensions.Selenium.Click;
import Extensions.Selenium.Update;
import Extensions.Verify.Verify;
import Utilities.CommonOps;

public class Conversion extends CommonOps {

    public static void calculateFlow(String convertFrom, String convertTo, double convertValue) throws Exception {
        Update.text(homePage.convertFromField(), convertFrom);
        Update.text(homePage.convertToField(), convertTo);
        Update.text(homePage.conversionField(), String.valueOf(convertValue));
        Click.go(homePage.dynamicButton(convertFrom, convertTo));
        String actualText = Update.takeText(resultPage.convertField());
        Verify.textContains(actualText, convertFrom + " to " + convertTo);
    }
}
