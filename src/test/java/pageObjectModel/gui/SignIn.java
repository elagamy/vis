package pageObjectModel.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {

    private WebDriver driver;

    By signIn_Button = By.linkText("Sign in");
    By email_Input = By.id("email");
    By password_Input = By.id("passwd");
    By submitLogin_button = By.id("SubmitLogin");

    public SignIn(WebDriver driver) {
	this.driver = driver;
    }

    public void signIn(String email, String password) {
	driver.findElement(signIn_Button).click();
	driver.findElement(email_Input).sendKeys(email);
	driver.findElement(password_Input).sendKeys(password);
	driver.findElement(submitLogin_button).click();
    }

    public String assertThatSignInDoneSuccessfully(String firstName, String lastName) {
	return driver.findElement(By.linkText(firstName + " " + lastName)).getText();
    }
}