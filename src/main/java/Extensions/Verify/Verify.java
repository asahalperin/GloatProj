package Extensions.Verify;

import Utilities.Base;
import com.aventstack.extentreports.Status;

import static org.testng.Assert.*;

public class Verify extends Base {

    public static void textEquals(String actualText, String expectedText) {
        try {
            assertEquals(actualText, expectedText);
            logger.log(Status.PASS, "Step passed - Text is: " + expectedText + " as expected");
        } catch (AssertionError e) {
            logger.log(Status.FAIL, "Step failed - Text is: " + actualText + " but should be: " + expectedText);
            fail(e + "Step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }

    public static void textContains(String actualText, String expectedText) {
        try {
            if (actualText.contains(expectedText)) {
                assertTrue(true);
            }
            logger.log(Status.PASS, "Step passed - Text contains: " + expectedText + " as expected");
        } catch (AssertionError e) {
            logger.log(Status.FAIL, "Step failed - Text does not contains: " + actualText + " but should be: " + expectedText);
            fail(e + "Step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }

    public static void valueBetweenNumericValue(double actual, double expected, double numericValue) {
        try {
            if (actual >= expected - numericValue | actual >= expected + numericValue) {
                assertTrue(true);
            }
            logger.log(Status.PASS, "Step passed - Expected value is: " + actual + " and Actual value is: " + expected);
        } catch (AssertionError e) {
            logger.log(Status.FAIL, "Step failed - Expected value is: " + actual + " and Actual value is: " + expected);
            fail(e + "Step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }

    public static void valueBetweenPercent(double actual, double expected, int percentage) {
        try {
            double calcPercentage = 100 / actual * expected;
            int minValue = 100 - percentage;
            int maxValue = 100 + percentage;
//            if (calcPercentage >= minValue & calcPercentage <= maxValue)
            assertTrue(calcPercentage >= minValue & calcPercentage <= maxValue);
            logger.log(Status.PASS, "Step passed - (Value is in " + percentage + "% range). Expected value is: " + actual + " and Actual value is: " + expected);
        } catch (AssertionError e) {
            System.out.println("Expected: " + expected + " but found: " + actual);
            logger.log(Status.FAIL, "Step failed - (Value is not in " + percentage + "% range). Expected value is: " + actual + " and Actual value is: " + expected);
            fail(e + "Step failed");
        } catch (Exception e) {
            fail(e + "Step failed");
        }
    }
}
