package Platforms.MetricConvertion.PageObjects;

import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Popups extends Base {
    @FindAll({
            @FindBy(xpath = "//div[@id='ezmobfooter']/span[text() ='x']")
    })
    public List<WebElement> footerPopup;
}
