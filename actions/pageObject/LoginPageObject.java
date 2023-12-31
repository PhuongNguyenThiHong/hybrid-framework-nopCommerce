package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return  new HomePageObject(driver);
		return PageObjectGeneratorManager.getHomePageObject(driver);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,  LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageLogin() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_LOGIN);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_LOGIN);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver,  LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	public HomePageObject loginAsUser (String email, String password) {
		inputEmailTextBox(email);
		inputPasswordTextBox (password);
		return clickToLoginButton();
	}






}
