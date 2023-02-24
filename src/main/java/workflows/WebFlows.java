package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

       @Step("Business Flow: Registration")
    public static void registration(String firstName, String lastName, String email,String password) {
        UIActions.click(nopcommerceRegistration.first_btn_registration);
        UIActions.updateText(nopcommerceRegistration.txt_firstName, firstName);
        UIActions.updateText(nopcommerceRegistration.txt_lastName, lastName);
        UIActions.updateText(nopcommerceRegistration.email, email);
        UIActions.updateText(nopcommerceRegistration.password, password);
        UIActions.updateText(nopcommerceRegistration.confirmPassword, password);
        UIActions.click(nopcommerceRegistration.register_button);
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
    }

    @Step("Business Flow: Login")
    public static void login(String email, String password) {
        UIActions.click(nopcommerceLogin.btn_loginMenu);
        UIActions.updateText(nopcommerceLogin.txt_email, email);
        UIActions.updateText(nopcommerceLogin.txt_password, password);
        UIActions.click(nopcommerceLogin.btn_login);
    }

    @Step("Business Flow: Choose Login Or Registration")
    public static void loginOrRegistration(String firstName, String lastName, String email, String password){
           login(email,password);
           if(!nopcommerceMain.head_Welcome.getText().equalsIgnoreCase("Welcome to our store")){
               if(nopcommerceLogin.error_login.isDisplayed())
               {
                   registration(firstName, lastName, email, password);
                   login(email,password);
               }
           }
       }

    @Step("Business Flow: Login to Nopcommerce with DB Credentials")
    public static void loginDB() {
        String query ="SELECT email,password FROM Employees WHERE comments='good'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.click(nopcommerceLogin.btn_loginMenu);
        UIActions.updateText(nopcommerceLogin.txt_email, cred.get(0));
        UIActions.updateText(nopcommerceLogin.txt_password, cred.get(1));
        UIActions.click(nopcommerceLogin.btn_login);
    }

    @Step("Business Flow: RegistrationDB")
    public static void registrationDB() {
        String query ="SELECT email,password,firstName,lastName FROM Employees WHERE comments='good'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.click(nopcommerceRegistration.first_btn_registration);
        UIActions.updateText(nopcommerceRegistration.txt_firstName, cred.get(2));
        UIActions.updateText(nopcommerceRegistration.txt_lastName, cred.get(3));
        UIActions.updateText(nopcommerceRegistration.email, cred.get(0));
        UIActions.updateText(nopcommerceRegistration.password, cred.get(1));
        UIActions.updateText(nopcommerceRegistration.confirmPassword, cred.get(1));
        UIActions.click(nopcommerceRegistration.register_button);
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
    }

    @Step("Business Flow: Choose LoginDB Or RegistrationDB")
    public static void loginDBOrRegistrationDB(){
          loginDB();
        if(!nopcommerceMain.head_Welcome.getText().equalsIgnoreCase("Welcome to our store")){
            if(nopcommerceLogin.error_login.isDisplayed())
            {
                registrationDB();
                loginDB();
            }
        }
    }

    @Step("Business Flow: Add To Shopping Cart")
    public static void addToShoppingCart() {
        UIActions.click(nopcommerceProductItem.addToCart);
        Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
        UIActions.click(nopcommerceProductItem.addToCart2);
        Uninterruptibles.sleepUninterruptibly(4000, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(nopcommerceShoppingCart.shoppingCart));
        UIActions.click(nopcommerceShoppingCart.shoppingCart);
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
    }

    @Step("Business Flow: Open Shopping Cart")
    public static void openShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(nopcommerceShoppingCart.shoppingCart));
        UIActions.click(nopcommerceShoppingCart.shoppingCart);
    }

    @Step("Business Flow: Delete Last Item")
    public static void deleteLastItem() {
        wait.until(ExpectedConditions.elementToBeClickable(nopcommerceEditProductItem.btn_deleteProduct));
        UIActions.click(nopcommerceEditProductItem.btn_deleteProduct);
    }


    @Step("Business Flow: Sort Items")
    public static void sortItems(WebElement elem, String text) {
        UIActions.updateDropDown(elem, text);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Search And Verify Product")
    public static void searchAndVerifyProduct(String product, String shouldExist){
        UIActions.updateTextHuman(nopcommerceMain.txt_search, product);
        if(shouldExist.equalsIgnoreCase("exist"))
            Verifications.existenceOfElement(nopcommerceMain.rowsSearch);
        else if(shouldExist.equalsIgnoreCase("not-exist"))
            Verifications.nonExistenceOfElement(nopcommerceMain.rowsSearch);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven testing, Should be exist or not-exist");
}
}
