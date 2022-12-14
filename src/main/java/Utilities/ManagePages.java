package Utilities;

import Platforms.MetricConvertion.PageObjects.HomePage;
import Platforms.MetricConvertion.PageObjects.Popups;
import Platforms.MetricConvertion.PageObjects.ResultPage;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {
    public static void initWeb() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        resultPage = PageFactory.initElements(driver, ResultPage.class);
        popups = PageFactory.initElements(driver, Popups.class);
    }
}
