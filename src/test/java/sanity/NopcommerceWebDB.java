package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class NopcommerceWebDB extends CommonOps {

    @Test(description = "Test01 - Login to Nopcommerce with DB Credentials")
    @Description("This Test login with DB Credentials and verifies the main header")
    public void test01_loginDBAndVerifyHeader(){
        WebFlows.loginDBOrRegistrationDB();
        Verifications.verifyTextInElement(nopcommerceMain.head_Welcome, "Welcome to our store");
    }
}
