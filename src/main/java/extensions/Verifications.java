package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public  static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals( elem.getText(), expected);
    }

    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expected);
    }

    @Step("Verify Product Selector")
    public static void verifyProductSelector(List<WebElement> elems, String[] expItems){
        for (int i = 0; i < elems.size(); i++) {
            Assert.assertEquals(elems.get(i).findElement(By.tagName("a")).getText(), expItems[i]);
        }
    }

    @Step("Verify Product Rating Stars")
    public static void verifyProductRatingStars(List<WebElement> stars) {
        for (int i = 0; i < stars.size(); i++) {
            System.out.println(stars.get(i).getAttribute("style"));
            String value = stars.get(i).getAttribute("style").split(": ")[1].split("%")[0];
            System.out.println(value);
            assertTrue(Integer.parseInt(value) >= 60, "Verification failed Rating not bigger than 70");
        }
    }

    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elements){
        for(WebElement elem: elements){
            softAssert.assertTrue(elem.isDisplayed(),"Sorry "+elem.getText()+" not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName)  {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        }catch (FindFailed findFailed){
            System.out.println("Error Comparing Image File: " + findFailed);
            fail("Error Comparing Image File: " + findFailed);
        }
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements){
        assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements){
        assertFalse(elements.size() > 0);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected){
        assertEquals(actual,expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected){
        assertEquals(actual,expected);
    }
}
