package Extensions.Selenium;

import Utilities.CommonOps;

public class BrowserOps extends CommonOps {
    public static void cleanBrowser() {
        try {
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Clean browser failed");
        }

    }
}
