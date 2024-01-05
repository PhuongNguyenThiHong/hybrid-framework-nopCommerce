package snapPageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import snapNewsPageUI.PoePageUI;

public class HomePageObjectSnapNews extends BasePage{
private WebDriver driver;
	
	public HomePageObjectSnapNews(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChatBot() {
		waitForElementVisible(driver, PoePageUI.CHAT_BOT);
		clickToElement(driver, PoePageUI.CHAT_BOT);
		
	}
	
	public String getResultSummaryArtist() {
		waitForElementVisible(driver, PoePageUI.RESULT_SUMMARY_REPORT );
		return getElementText(driver, PoePageUI.RESULT_SUMMARY_REPORT );
		
	}


	

}
