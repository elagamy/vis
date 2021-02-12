package pageObjectModel.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    private WebDriver driver;
    By homePage_Link = By.className("home");
    
    public HomePage(WebDriver driver) {
	this.driver = driver;
    }

    public void navigateTo_HomePage() {
	driver.findElement(homePage_Link).click();
    }

}
