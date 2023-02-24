package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderMenuPage {
    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile'] /li[1]/a")
    public WebElement productComputers;

    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile'] /li[2]/a")
    public WebElement productElectronics;

    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile'] /li[3]/a")
    public WebElement productApparel;
}
