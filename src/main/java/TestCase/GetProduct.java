package TestCase;

import jdk.jfr.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProduct extends BaseTest{
    @Test(priority = 1)
    public void getPrice() {
        //tes dan assert harga smartphone samsung galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//a[.='Phones']"));
        phonesCat.click();

        WebElement samsung = driver.get().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        samsung.click();

        //assert/validate price
        WebElement price = explicitwait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue(price.getText().contains("$360"));
    }

    @Test(priority = 3)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitwait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();
        Alert alert = explicitwait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }
    @Test(priority = 2)
    @Description("Test Description: add to cart")
    public void testAddItem() {
        WebElement addtoCart = driver.get().findElement(By.xpath("//a[.='Add to cart']"));addtoCart.click();
        Alert alert = explicitwait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue(alertMessage.equals("Product added") || alertMessage.equals("error"), "Alert message was not as expected: " + alertMessage);
        alert.accept();
    }




}