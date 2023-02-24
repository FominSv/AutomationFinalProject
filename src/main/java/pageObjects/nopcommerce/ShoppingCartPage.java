package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ShoppingCartPage {
    @FindBy(how = How.CSS, using = "a[class='ico-cart']")
    public WebElement shoppingCart;

    @FindBy(how = How.XPATH, using = "//table[@class='cart']/tbody/tr")
    public List<WebElement> rowsCart;

}
