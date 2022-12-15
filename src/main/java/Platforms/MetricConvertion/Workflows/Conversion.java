package Platforms.MetricConvertion.Workflows;

import Extensions.Selenium.Click;
import Extensions.Selenium.Update;
import Extensions.Selenium.WaitFor;
import Extensions.Verify.Verify;
import Utilities.CommonOps;

public class Conversion extends CommonOps {

    public static void calculateFlow(String convertFrom, String convertTo, double convertValue) throws Exception {
        int count = 0;
        int maxTries = 3;
        while (true) {
            try {
                Update.text(homePage.convertFromField(), convertFrom);
                Update.text(homePage.convertToField(), convertTo);
                WaitFor.numberOfElementsToBeMoreThan("//a[text()='Convert']", 20);
                Update.text(homePage.conversionField(), String.valueOf(convertValue));
                Click.go(homePage.dynamicButton(convertFrom, convertTo));
                String actualText = Update.takeText(resultPage.convertField());
                Verify.textContains(actualText, convertFrom + " to " + convertTo);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Trying again");
                if (++count == maxTries) throw e;
            }
        }
    }
}
