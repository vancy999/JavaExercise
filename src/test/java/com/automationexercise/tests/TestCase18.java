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
@Feature("Check Category")
public class TestCase18 extends TestBasic {

    @Test(description = "Test Case 18: View Category Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: View Category Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that categories are visible on left side bar
            4. Click on 'Women' category
            5. Click on any category link under 'Women' category, for example: Dress
            6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
            7. On left side bar, click on any sub-category link of 'Men' category
            8. Verify that user is navigated to that category page""")
    public void viewCategoryProducts() throws IOException, ParseException, InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifyCategoriesAreVisible();
        clickWomanCategory();
        dressCategoryClick();
        clickMenCategory();
        clickTshirtCategory();
    }
    @Step("Verify that categories are visible on left side bar")
    public static void verifyCategoriesAreVisible() {
        boolean categoryVisible = new HomePage(getDriver())
                .getCategories()
                .isDisplayed();
        Assert.assertTrue(categoryVisible, "Verify that categories are visible on left side bar");
    }

    @Step("Click Woman Category")
    public static void clickWomanCategory() {
        new HomePage(getDriver()).womenCategoryClick();
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - All Products", "Verify product detail is opened");
    }

    @Step("Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS")
    public static void dressCategoryClick() {
        String dressCategoryClick = new HomePage(getDriver())
                .dressCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(dressCategoryClick, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'");
    }

    @Step("Verify click men category")
    public static void clickMenCategory() {
        new ProductsPage(getDriver()).menCategoryClick();
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Dress Products", "Verify click men category");
    }
    @Step("Verify that user is navigated to men category page")
    public static void clickTshirtCategory() {
        String clickTshirtCategory = new ProductsPage(getDriver())
                .tShirtsCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(clickTshirtCategory, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to men category page");
    }
}
