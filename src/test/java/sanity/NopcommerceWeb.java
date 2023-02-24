package sanity;


import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class NopcommerceWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This Test registration, login and verifies the main header")
    public void test01_verifyHeader(){
        WebFlows.loginOrRegistration("Svetlana","Fomin","fomina21@gmail.com", "123456");
        Verifications.verifyTextInElement(nopcommerceMain.head_Welcome, "Welcome to our store");
    }

    @Test(description = "Test02 - Verify New Item In Shopping Cart")
    @Description("This Test verifies a new item has been added in shopping cart")
    public void test02_verifyNewItemInShoppingCart(){
        UIActions.mouseHover(nopcommerceHeaderMenu.productComputers, nopcommerceProductItem.productDesktops);
        WebFlows.addToShoppingCart();
        Verifications.numberOfElements(nopcommerceShoppingCart.rowsCart, 2);
    }

    @Test(description = "Test03 - Verify Item Deletion")
    @Description("This Test verifies the deletion of the item")
    public void test03_verifyItemDeletion(){
        UIActions.mouseHover(nopcommerceHeaderMenu.productComputers, nopcommerceProductItem.productDesktops);
        WebFlows.addToShoppingCart();
        WebFlows.deleteLastItem();
        Verifications.numberOfElements(nopcommerceShoppingCart.rowsCart, 1);
    }

    @Test(description = "Test04 - Verify Product Items Sorted")
    @Description("This Test verifies that items was sorted")
    public void text04_verifyProductItemsSorted() {
        String[] expItems = {"Lenovo IdeaCentre 600 All-in-One PC", "Build your own computer", "Digital Storm VANQUISH 3 Custom Performance PC"};
        UIActions.mouseHover(nopcommerceHeaderMenu.productComputers, nopcommerceProductItem.productDesktops);
        WebFlows.sortItems(nopcommerceProductItem.sortItem, "Price: Low to High");
        Verifications.verifyProductSelector(nopcommerceProductItem.namesItems, expItems);
    }

    @Test(description = "Test05 - Verify Product Rating")
    @Description("This Test verifies the product rating is high")
    public void text05_verifyProductRating(){
        UIActions.mouseHover(nopcommerceHeaderMenu.productComputers, nopcommerceProductItem.productDesktops);
        Verifications.verifyProductRatingStars(nopcommerceProductItem.stars);
    }

    @Test(description = "Test06 - Verify Header Links")
    @Description("This Test verifies the default header links are displayed (using soft assertion)")
    public void text06_verifyHeaderLinks(){
        Verifications.visibilityOfElements(nopcommerceMain.list_headerLinks);
    }

    @Test(description = "Test07 - Verify Logo")
    @Description("This Test verifies the logo Image Using Sikuli tool")
    public void text07_verifyLogo(){
        Verifications.visualElement("Logo");
    }

    @Test(description = "Test08 - Search Products", dataProvider = "data-provider-products", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Products using DDT")
    public void text08_searchProducts(String product, String shouldExist){
       WebFlows.searchAndVerifyProduct(product, shouldExist);
    }
}

