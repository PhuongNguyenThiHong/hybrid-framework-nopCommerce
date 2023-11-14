package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver dirver;

	public HomePageObject(WebDriver dirver) {
		this.dirver = dirver;
	}



	public void clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(dirver, HomePageUI.REGISTER_LINK);
		clickToElement(dirver, HomePageUI.REGISTER_LINK);
	}

}
