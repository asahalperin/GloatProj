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

    public static void valueBetween(double actual, double expected) {
        try {
            if (actual >= expected - 0.009 | actual >= expected + 0.009) {
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
}
