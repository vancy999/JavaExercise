package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search Products and Verify Cart After Login")
public class TestCase20 extends TestBasic {

    @Test(description = "Test Case 20: Search Products and Verify Cart After Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Search Products and Verify Cart After Login")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Enter product name in search input and click search button
            6. Verify 'SEARCHED PRODUCTS' is visible
            7. Verify all the products related to search are visible
            8. Add those products to cart
            9. Click 'Cart' button and verify that products are visible in cart
            10. Click 'Signup / Login' button and submit login details
            11. Again, go to Cart page
            12. Verify that those products are visible in cart after login as well""")
    public void searchProductandVerifyCartAfterLogin() throws IOException, ParseException, InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase9.searchProduct();
        TestCase12.verifyBothProductsAreAddedToCart();
        TestCase2.verifyLoginToYourAccountIsVisible();
        TestCase2.verifyThatLoggedInAsUsernameIsVisible();
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyBothProductsAreAddedToCartAfterLogin();

    }
    @Step("Verify both products are added to Cart")
    public static void verifyBothProductsAreAddedToCartAfterLogin() {
        List<String> cartItems = new ProductsPage(getDriver())
                .viewCartPage()
                .getProductsNames();
        Assert.assertEquals(cartItems.size(), 2, "Verify both products are added to Cart");
    }

}
