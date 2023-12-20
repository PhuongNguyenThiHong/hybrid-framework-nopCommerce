package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminDashboardPageOject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return  new HomePageObject(driver);
		return PageObjectGeneratorManager.getDashboardAdmin(driver);
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
	
	public AdminDashboardPageOject loginAsAdmin (String email, String password) {
		inputEmailTextBox(email);
		inputPasswordTextBox (password);
		return clickToLoginButton();
	}






}
