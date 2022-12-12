package Web;

import Utilities.Base;
import Utilities.CommonOps;
import org.testng.annotations.Test;

public class ConversionTests extends CommonOps {

    @Test(priority = 1, testName = "Verify Celsius to Fahrenheit conversion -Valid")
    public void VerifyCelsiusToFahrenheit() {
        Base farenheitConvertion = new Base();
        farenheitConvertion.unitCalc = (1 * 1.8) + 32;

    }
}
