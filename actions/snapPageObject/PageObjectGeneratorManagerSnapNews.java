package snapPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageObjectGeneratorManagerSnapNews extends BasePage {
	
public static HomePageObjectSnapNews getHomePageObjectSnapNews(WebDriver driver) {
		return new HomePageObjectSnapNews(driver);
	}

}
