package Extensions.Selenium;

import Utilities.Base;

public class BrowserOps extends Base {
    public static void cleanBrowser() {
        try {
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        } catch (Exception e) {
            System.out.println("Clean browser failed");
        }

    }
}
