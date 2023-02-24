package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.ID, using = "Email")
    public WebElement txt_email;

    @FindBy(how = How.ID, using = "Password")
    public WebElement txt_password;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
    public WebElement btn_loginMenu;

    @FindBy(how = How.CSS, using = "button[class='button-1 login-button']")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "//div[@class='message-error validation-summary-errors']/ul/li")
    public WebElement error_login;

}

