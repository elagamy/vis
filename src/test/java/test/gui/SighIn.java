package test.gui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.gui.SignIn;

public class SighIn {

    WebDriver driver;
    SignIn signInObject;
    String url = "http://automationpractice.com/index.php";

    String firstName = "ali";
    String lastName = "ali";
    String email = "ahmed.abc@yahoo.com";
    String password = "ali123";

    @Test()
    public void signIn() {
	signInObject.signIn(email, password);
	Assert.assertEquals(signInObject.assertThatSignInDoneSuccessfully(firstName, lastName),
		firstName + " " + lastName);
    }

    @BeforeClass
    public void startDriver() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	signInObject = new SignIn(driver);
	driver.navigate().to(url);
    }

    @AfterClass
    public void stopDriver() {
	driver.quit();
    }
}
