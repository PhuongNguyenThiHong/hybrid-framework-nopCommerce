package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	
	private WebDriver dirver;

	public HomePageObject(WebDriver dirver) {
		this.dirver = dirver;
	}



	public void clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(dirver, HomePageUI.REGISTER_LINK);
		clickToElement(dirver, HomePageUI.REGISTER_LINK);
	}


	public void clickLoginLink() {
		waitForElementClickable(dirver, HomePageUI.LOGIN_LINK);
		clickToElement(dirver, HomePageUI.LOGIN_LINK);
		
	}



	public boolean isMyAccountDisplay() {
		waitForElementVisible(dirver,  HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(dirver, HomePageUI.MY_ACCOUNT_LINK);
	}



	public void clickLogOutLink() {
		waitForElementClickable(dirver, HomePageUI.LOGOUT_LINK);
		clickToElement(dirver, HomePageUI.LOGOUT_LINK);
		
	}

}
