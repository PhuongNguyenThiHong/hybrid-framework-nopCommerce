package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DashboardUI;
import pageUIs.HomePageUI;

public class AdminDashboardPageOject extends BasePage{
	
	private WebDriver driver;
	
	public AdminDashboardPageOject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDashboardDisplay() {
		waitForElementVisible(driver,  DashboardUI.DASHBOARD_TEXT);
		return isElementDisplay(driver, DashboardUI.DASHBOARD_TEXT);
	}

}
