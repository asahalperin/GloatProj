package Platforms.MetricConvertion.Workflows;

import Extensions.Selenium.Click;
import Extensions.Selenium.WaitFor;
import Utilities.CommonOps;

public class HandlePopup extends CommonOps {

    public static void closePopUp() {
        for (int i = 0; i < popups.footerPopup.size(); i++) {
            Click.popupClose(popups.footerPopup.get(i));
            WaitFor.implicitWait(5);
        }
    }
}
