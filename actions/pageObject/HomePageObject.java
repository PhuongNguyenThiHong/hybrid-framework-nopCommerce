package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}



	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
		return PageObjectGeneratorManager.getRegisterObject(driver);
	}


	public LoginPageObject clickLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		// cach 2 - return new LoginPageObject(driver);
		return PageObjectGeneratorManager.getLoginPageObject(driver);
	}



	public boolean isMyAccountDisplay() {
		waitForElementVisible(driver,  HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}



	public void clickLogOutLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		
	}

}
