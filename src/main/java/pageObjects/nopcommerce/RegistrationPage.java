package pageObjects.nopcommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    @FindBy(how = How.CSS, using = "button[class='button-1 register-button']")
    public WebElement first_btn_registration;

    @FindBy(how = How.ID, using = "FirstName")
    public WebElement txt_firstName;

    @FindBy(how = How.ID, using = "LastName")
    public WebElement txt_lastName;

    @FindBy(how = How.ID, using = "Email")
    public WebElement email;

   @FindBy(how = How.ID, using = "Password")
    public WebElement password;

    @FindBy(how = How.ID, using = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(how = How.ID, using = "register-button")
    public WebElement register_button;

}
