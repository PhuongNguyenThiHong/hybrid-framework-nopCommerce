package jQueryPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageObjectGeneratorManagerJQuery extends BasePage {
	
public static HomePageObjectJQuery getHomePageJQuery(WebDriver driver) {
		return new HomePageObjectJQuery(driver);
	}

}
