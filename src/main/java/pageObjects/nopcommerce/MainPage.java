package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.XPATH, using = "//div[@class='topic-block-title']/h2")
    public WebElement head_Welcome;

    @FindBy(how = How.CSS, using = "div[class='result']")
    public WebElement head_registration;

    @FindBy(how = How.CSS, using = "div[class='header-links']>ul>li")
    public List<WebElement> list_headerLinks;

    @FindBy(how = How.CSS, using = "input[id='small-searchterms']")
    public WebElement txt_search;

    @FindBy(how = How.CSS, using = "ul[id='ui-id-1']>li")
    public List<WebElement> rowsSearch;

}
