package TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    //Declare driver (membuka browser)
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitwait = new ThreadLocal<>();

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        //add setter and getter
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize(); // maximize window
        driver.get().get("https://demoblaze.com");
        explicitwait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();

    }
}