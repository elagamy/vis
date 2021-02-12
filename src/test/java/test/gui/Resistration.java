package test.gui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.gui.Registration;

public class Resistration {
    WebDriver driver;
    Registration authObject;
    String url = "http://automationpractice.com/index.php";
    
    String firstName = "ali";
    String lastName = "ali";
    String email= "ahmed.abc@yahoo.com";
    String password = "ali123";

    @Test
    public void newUserRegistration() {
	authObject.createNewAccount(email);
	Assert.assertEquals(authObject.assertThatAccountAddedSuccessfully(), "YOUR PERSONAL INFORMATION");

	authObject.register(firstName, lastName, password, "1", "1", "2020", false, false, "alex", "alex", "alex",
		"ales", "California", "00000", "United States", "", "00000", "01111111111", "alex");
	Assert.assertEquals(authObject.assertThatRegistrationDoneSuccessfully(firstName, lastName),
		firstName + " " + lastName);
    }

    @BeforeClass
    public void startDriver() {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	authObject = new Registration(driver);
	driver.navigate().to(url);
    }

    @AfterClass
    public void stopDriver() {
	driver.quit();
    }
}
