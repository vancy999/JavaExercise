package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Remove Order")
public class TestCase17 extends TestBasic {

    @Test(description = "Test Case 17: Remove Products From Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Login before Checkout")
    @Description("""
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Add products to cart
        5. Click 'Cart' button
        6. Verify that cart page is displayed
        7. Click 'X' button corresponding to particular product
        8. Verify that product is removed from the cart""")
    public void RemoveProductsFromCart() throws IOException, ParseException, InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase12.addProductsInCart();
        removeXbutton();
        verifyProductIsRemoved();
    }
    @Step("Click 'X' button corresponding to particular product")
    public static void removeXbutton() throws InterruptedException {
        CartPage cartPage = new CartPage(getDriver())
                .deleteAllAddedProducts();
    }
    @Step("Verify that product is removed from the cart")
    public static void verifyProductIsRemoved() throws InterruptedException {
        boolean cartPageEmpty = new CartPage(getDriver())
                .getEmptyCartSpan()
                .isDisplayed();
        Assert.assertTrue(cartPageEmpty, "Verify that product is removed from the cart");
    }
}
