package pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectGeneratorManager {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

}