package pageObjectModel.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutItem {

    private WebDriver driver;

    By addToCart_Button = By.xpath("//p[@id='add_to_cart']//button");
    By quantity_Input = By.id("quantity_wanted");
    By whiteColor_Link = By.id("color_8");
    By blackColor_Link = By.id("color_11");
    By proceedToCheckout_Button = By.linkText("Proceed to checkout");
    By proceedAddress_Button = By.xpath("//button[@name='processAddress']");
    By proceedShipping_Button = By.xpath("//button[@name='processCarrier']");
    By termsOfService_checkBox = By.id("cgv");
    By PayByBank_Link = By.className("bankwire");
    By confirmOrder_Button = By.xpath("//p[@id='cart_navigation']//button");
    By orderConfirmation_Message = By.xpath("//div[@id='center_column']//h1");
    
    public CheckoutItem(WebDriver driver) {
	this.driver = driver;
    }

    public void addItemToCard(String itemName, String quantity, String size, String color) {
	By item_Name = By.linkText(itemName);
	driver.findElement(item_Name).click();
	driver.findElement(quantity_Input).clear();
	driver.findElement(quantity_Input).sendKeys(quantity);
	Select size_DropDown = new Select(driver.findElement(By.id("group_1")));
	size_DropDown.selectByVisibleText(size);
	if (color == "white") {
	    driver.findElement(whiteColor_Link).click();
	} else if (color == "black") {
	    driver.findElement(blackColor_Link).click();
	}
	driver.findElement(addToCart_Button).click();
    }

    public void checkout() {
	driver.findElement(proceedToCheckout_Button).click();
	driver.findElement(proceedToCheckout_Button).click();
	driver.findElement(proceedAddress_Button).click();
	driver.findElement(termsOfService_checkBox).click();
	driver.findElement(proceedShipping_Button).click();
	driver.findElement(PayByBank_Link).click();
	driver.findElement(confirmOrder_Button).click();
    }

    public String assertThatOrderCompletedSuccessfully() {
	return driver.findElement(orderConfirmation_Message).getText();
    }
}