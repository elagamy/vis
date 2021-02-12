package test.gui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.gui.CheckoutItem;
import pageObjectModel.gui.HomePage;
import pageObjectModel.gui.SignIn;

public class Checkout {
    WebDriver driver;
    HomePage homePageObject;
    CheckoutItem checkoutObject;
    SignIn signInObject;
    String url = "http://automationpractice.com/index.php";
    
    String email = "ahmed.abc@yahoo.com";
    String password = "ali123";

    @Test()
    public void CheckoutItem() {
	homePageObject.navigateTo_HomePage();
	checkoutObject.addItemToCard("Blouse", "1", "L", "white");
	checkoutObject.checkout();
    }

    @BeforeClass
    public void startDriver() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.navigate().to(url);
	checkoutObject = new CheckoutItem(driver);
	homePageObject = new HomePage(driver);
	signInObject = new SignIn(driver);
	signInObject.signIn(email, password);
    }

    @AfterClass
    public void stopDriver() {
	driver.quit();
    }
}
