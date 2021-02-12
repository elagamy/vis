package pageObjectModel.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Registration {

    private WebDriver driver;

    By signIn_Button = By.linkText("Sign in");
    By emailAddress_Input = By.id("email_create");
    By createAccount_Button = By.id("SubmitCreate");
    By genderMale_RadioBox = By.id("id_gender1");
    By customerFirstName_Input = By.id("customer_firstname");
    By customerLastName_Input = By.id("customer_lastname");
    By password_Input = By.id("passwd");
    By newsLetter_CheckBox = By.id("newsletter");
    By receiveSpecialOffers_CheckBox = By.id("optin");
    By firstName_Input = By.id("firstname");
    By lastName_Input = By.id("lastname");
    By company_Input = By.id("company");
    By address1_Input = By.id("address1");
    By address2_Input = By.id("address2");
    By city_Input = By.id("city");
    By postalCode_Input = By.id("postcode");
    By additionalInformation_textArea = By.id("other");
    By homePhone_Input = By.id("phone");
    By mobilePhone_Input = By.id("phone_mobile");
    By aliasAddress_Input = By.id("alias");
    By submitAccount_button = By.id("submitAccount");
    By registrationForm_header = By.xpath("//form[@id='account-creation_form']//div[1]//h3");

    public Registration(WebDriver driver) {
	this.driver = driver;
    }

    public void createNewAccount(String email) {
	driver.findElement(signIn_Button).click();
	driver.findElement(emailAddress_Input).sendKeys(email);
	driver.findElement(createAccount_Button).submit();
    }

    public String assertThatAccountAddedSuccessfully() {
	return driver.findElement(registrationForm_header).getText();
    }

    public void register(String customerFirstName, String customerLastName, String password, String birthDateDay,
	    String birthDateMonth, String birthDateYear, boolean newsLetter, boolean receiveSpecialOffers,
	    String company, String address1, String address2, String city, String state, String postCode,
	    String country, String additionalInformation, String homePhone, String mobilePhone, String aliasAddress) {
	driver.findElement(genderMale_RadioBox).click();
	driver.findElement(customerFirstName_Input).sendKeys(customerFirstName);
	driver.findElement(customerLastName_Input).sendKeys(customerLastName);
	driver.findElement(password_Input).sendKeys(password);
	Select days_DropDown = new Select(driver.findElement(By.id("days")));
	days_DropDown.selectByValue(birthDateDay);
	Select months_DropDown = new Select(driver.findElement(By.id("months")));
	months_DropDown.selectByValue(birthDateMonth);
	Select years_DropDown = new Select(driver.findElement(By.id("years")));
	years_DropDown.selectByValue(birthDateYear);
	if (newsLetter == true) {
	    driver.findElement(newsLetter_CheckBox).click();
	}
	if (receiveSpecialOffers == true) {
	    driver.findElement(receiveSpecialOffers_CheckBox).click();
	}
	driver.findElement(company_Input).sendKeys(company);
	driver.findElement(address1_Input).sendKeys(address1);
	driver.findElement(address2_Input).sendKeys(address2);
	driver.findElement(city_Input).sendKeys(city);
	Select state_DropDown = new Select(driver.findElement(By.id("id_state")));
	state_DropDown.selectByVisibleText(state);
	driver.findElement(postalCode_Input).sendKeys(postCode);
	Select country_DropDown = new Select(driver.findElement(By.id("id_country")));
	country_DropDown.selectByVisibleText(country);
	driver.findElement(additionalInformation_textArea).sendKeys(additionalInformation);
	driver.findElement(homePhone_Input).sendKeys(homePhone);
	driver.findElement(mobilePhone_Input).sendKeys(mobilePhone);
	driver.findElement(aliasAddress_Input).clear();
	driver.findElement(aliasAddress_Input).sendKeys(aliasAddress);
	driver.findElement(submitAccount_button).click();
    }

    public String assertThatRegistrationDoneSuccessfully(String firstName, String lastName) {
	return driver.findElement(By.linkText(firstName + " " + lastName)).getText();
    }

}