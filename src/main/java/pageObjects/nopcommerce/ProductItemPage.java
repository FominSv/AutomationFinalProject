package pageObjects.nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductItemPage {
    @FindBy(how = How.XPATH, using = "//ul[@class='top-menu notmobile']/li[1]/ul[1]/li[1]/a")
    public WebElement productDesktops;

    @FindBy(how = How.XPATH, using = "//div[@class='item-box'][2]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//div[@class='item-box'][3]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement addToCart2;

    @FindBy(how = How.ID, using = "products-orderby")
    public WebElement sortItem;

    @FindBy(how = How.CLASS_NAME, using = "product-title")
    public List<WebElement> namesItems;

    @FindBy(how = How.CLASS_NAME, using = "//div[@class='rating']/div")
    public List<WebElement> stars;


}
