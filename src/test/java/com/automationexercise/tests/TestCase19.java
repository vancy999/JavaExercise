package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import io.qameta.allure.*;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("View & Cart Brand Products")
public class TestCase19 extends TestBasic {

    @Test(description = "Test Case 19: View & Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: View & Cart Brand Products")
    @Description("""
          1. Launch browser
          2. Navigate to url 'http://automationexercise.com'
          3. Click on 'Products' button
          4. Verify that Brands are visible on left side bar
          5. Click on any brand name
          6. Verify that user is navigated to brand page and brand products are displayed
          7. On left side bar, click on any other brand link
          8. Verify that user is navigated to that brand page and can see products""")
    public void viewAndCartBrandProduct() throws IOException, ParseException, InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifyBrandsAreVisible();
        clickBrandName();
        clickOtherBrandName();
    }

    @Step("Verify that brands are visible on left side bar")
    public static void verifyBrandsAreVisible() {
        boolean brandsVisible = new ProductsPage(getDriver())
                .getBrands()
                .isDisplayed();
        Assert.assertTrue(brandsVisible, "Verify that brands are visible on left side bar");
    }

    @Step("Click on any brand name and verify that user is navigated to brand page and brand products are displayed")
    public static void clickOtherBrandName() {
        new ProductsPage(getDriver()).madameBrandClick();
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Madame Products", "Click on any other brand name and verify that user is navigated to brand page and brand products are displayed");
    }

    @Step("Click on any other brand name and verify that user is navigated to brand page and brand products are displayed")
    public static void clickBrandName() {
        new ProductsPage(getDriver()).poloBrandClick();
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Polo Products", "Click on any brand name and verify that user is navigated to brand page and brand products are displayed");
    }

}
