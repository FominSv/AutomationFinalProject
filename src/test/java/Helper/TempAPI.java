package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class TempAPI {
    RequestSpecification httpRequest;
    Response response;


    @Test
    public void testingAPI() {
      httpRequest = RestAssured.given();
    }
}
