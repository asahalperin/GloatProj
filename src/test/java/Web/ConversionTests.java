package Web;

import Extensions.Selenium.Update;
import Extensions.Verify.Verify;
import Platforms.MetricConvertion.Workflows.Conversion;
import Utilities.Base;
import Utilities.CommonOps;
import org.testng.annotations.Test;
import java.text.DecimalFormat;

public class ConversionTests extends CommonOps {
    @Test(priority = 1, testName = "Verify Celsius to Fahrenheit conversion - Valid")
    public void VerifyCelsiusToFahrenheit() throws Exception {
        numberFormat = new DecimalFormat("#.00000");
        double conversionValue = 20.98976;
        Base fahrenheitConversion = new Base();
        double calc = Double.parseDouble(numberFormat.format(fahrenheitConversion.unitCalc = (conversionValue * 1.8) + 32));
        Conversion.calculateFlow("Celsius", "Fahrenheit", conversionValue);
        String actualResult = Update.takeText(resultPage.resultText());
        String actualResult1 = actualResult.substring(actualResult.indexOf("= ")).replaceAll("[^\\d.]", "");
        Verify.textEquals(actualResult1, String.valueOf(calc));
    }

    @Test(priority = 2, testName = "Verify Meters to Feet conversion - Valid")
    public void VerifyMetersToFeet() throws Exception {
        double conversionValue = 1.85;
        String calc = convertMetric(conversionValue);
        Conversion.calculateFlow("Meters", "Feet", conversionValue);
        String actualResult = Update.takeText(resultPage.resultText());
        String actualResult1 = actualResult.substring(actualResult.indexOf("=") +2);
        Verify.textEquals(actualResult1.substring(0, actualResult1.indexOf(" ")), calc.substring(0, calc.indexOf(" ")));
        double actual = StringToDouble(actualResult1, "ft", 3, 2);
        double expected = StringToDouble(calc, "ft", 3, 2);
        Verify.valueBetweenNumericValue(actual, expected, 0.009);
    }

    @Test(priority = 3, testName = "Verify Ounces to Grams conversion - Valid")
    public void VerifyOuncesToGram() throws Exception {
        numberFormat = new DecimalFormat("#.00000");
        double conversionValue = 3.0987;
        Base OuncesConversion = new Base();
        double calc = Double.parseDouble(numberFormat.format(OuncesConversion.unitCalc = conversionValue * 28.34952));
        Conversion.calculateFlow("Ounces", "Grams", conversionValue);
        String actualResult = Update.takeText(resultPage.resultText());
        String actualResult1 = actualResult.substring(actualResult.indexOf("= ")).replaceAll("[^\\d.]", "");
        Verify.valueBetweenNumericValue(Double.parseDouble(actualResult1), calc, 0.009);
    }
}
