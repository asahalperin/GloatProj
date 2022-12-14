package Platforms.MetricConvertion.Workflows;

import Extensions.Selenium.Click;
import Utilities.CommonOps;

public class HandlePopup extends CommonOps {

    public static void closePopUp() {
        if(popups.footerPopup.size() > 0) {
            Click.popupClose(popups.footerPopup.get(0));
        }
    }
}
