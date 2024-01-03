package jQueryPageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import jQueryPageUI.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObjectJQuery extends BasePage {
	
	private WebDriver driver;
	
	public HomePageObjectJQuery(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_URL, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_URL, pageNumber);
		
	}
	
	public void findingByFieldName(String columnName, String findValue) {
		waitForElementVisible(driver, HomePageUI.ENTER_VALUE, columnName);
		sendKeyToElement(driver, HomePageUI.ENTER_VALUE, findValue, columnName);
		//pressKeyToElement(driver, HomePageUI.ENTER_VALUE, Keys.ENTER, columnName);
	}
	
	public boolean isPagingActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_ACTIVE_BY_NUMBER, pageNumber);
		return true;
	}

	public String getTextValueByFieldName(String columnName) {
		waitForElementVisible(driver, HomePageUI.TEXT_VALUE_BY_COLUMNNAME, columnName);
		return getElementText(driver, HomePageUI.TEXT_VALUE_BY_COLUMNNAME, columnName);

	}



}
