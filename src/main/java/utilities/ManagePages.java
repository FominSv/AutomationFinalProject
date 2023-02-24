package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.nopcommerce.EditProductItemPage;
import pageObjects.nopcommerce.HeaderMenuPage;
import pageObjects.nopcommerce.ProductItemPage;
import pageObjects.nopcommerce.ShoppingCartPage;

public class ManagePages extends Base{

    public static void initNopcommerce(){
        nopcommerceRegistration = PageFactory.initElements(driver, pageObjects.nopcommerce.RegistrationPage.class);
        nopcommerceLogin = PageFactory.initElements(driver, pageObjects.nopcommerce.LoginPage.class);
        nopcommerceMain = PageFactory.initElements(driver, pageObjects.nopcommerce.MainPage.class);
        nopcommerceHeaderMenu = PageFactory.initElements(driver, HeaderMenuPage.class);
        nopcommerceShoppingCart = PageFactory.initElements(driver, ShoppingCartPage.class);
        nopcommerceProductItem = PageFactory.initElements(driver, ProductItemPage.class);
        nopcommerceEditProductItem = PageFactory.initElements(driver, EditProductItemPage.class);
    }

    public static void initMortgage(){
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    public static void initToDo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
