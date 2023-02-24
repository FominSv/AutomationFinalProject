package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditProductItemPage {
    @FindBy(how = How.XPATH, using = "//button[@class='remove-btn']")
    public WebElement btn_deleteProduct;
}
