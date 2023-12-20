package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{

    private WebDriver driver;
   
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToRegisterButton() {
		
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageObjectGeneratorManager.getHomePageObject(driver);
		
	}
	
    public CustomerInfoPageObject clickMyAccountLink() {
		
		waitForElementClickable(driver, RegisterPageUI.ACCOUNT_LINK);
		clickToElement(driver, RegisterPageUI.ACCOUNT_LINK);
		return PageObjectGeneratorManager.getCustomerInfoPageObject(driver);
		
	}
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_FIRSTNAME);
		sendKeyToElement(driver, RegisterPageUI.INPUT_FIRSTNAME, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_LASTNAME);
		sendKeyToElement(driver, RegisterPageUI.INPUT_LASTNAME, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_EMAIL);
		sendKeyToElement(driver, RegisterPageUI.INPUT_EMAIL, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_PASSWORD);
		sendKeyToElement(driver, RegisterPageUI.INPUT_PASSWORD, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmpassword) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_CONFIRMPASSWORD);
		sendKeyToElement(driver, RegisterPageUI.INPUT_CONFIRMPASSWORD, confirmpassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getExistEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXIST_EMAIL_MESSAGE);
	}



}
