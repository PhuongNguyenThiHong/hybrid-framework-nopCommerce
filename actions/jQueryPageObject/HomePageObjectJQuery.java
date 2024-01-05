package jQueryPageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import jQueryPageUI.HomePageUI;

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

	public ArrayList getAllRowsInAllPages() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGE);
		List<String> allRowsInAllPages = new ArrayList<String>();
		for (int i = 1; i <= totalPage; i++) {
			
			waitForElementVisible(driver, HomePageUI.PAGING_URL, String.valueOf(i));
			clickToElement(driver, HomePageUI.PAGING_URL, String.valueOf(i));
			
			List<WebElement> allRowsEachPage = getListElement(driver, HomePageUI.TOTAL_ROWS_IN_EACH_PAGE);
			for (WebElement eachRow : allRowsEachPage) {
				allRowsInAllPages.add(eachRow.getText());
			}
			
		}
		
		for (String row : allRowsInAllPages) {
			System.out.println("-------------------");
			System.out.println(row);
			
		}
		
		return (ArrayList) allRowsInAllPages;
		
	}

	public void inputDataInAnyRowInTable(String columnName, String rowNumber, String valueInputText) {
		int indexColumn = getElementSize(driver, HomePageUI.INDEX_BY_COLUMNNAME, columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber,String.valueOf(indexColumn));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_AND_ROW_INDEX, valueInputText, rowNumber, String.valueOf(indexColumn));
		
		
	}

	public void selectDataInDropDownInAnyRow(String columnName, String rowNumber, String valueSelected) {
		int indexColumn = getElementSize(driver, HomePageUI.INDEX_BY_COLUMNNAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.SELECT_BY_COLUMN_AND_ROW_INDEX, rowNumber,String.valueOf(indexColumn));
		selectItemDefaultDropDown(driver, HomePageUI.SELECT_BY_COLUMN_AND_ROW_INDEX, valueSelected, rowNumber, String.valueOf(indexColumn));
		
	}

	public void checkBoxInAnyRow(String columnName, String rowNumber) {
		int indexColumn = getElementSize(driver, HomePageUI.INDEX_BY_COLUMNNAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECK_BOX_BY_COLUMN_AND_ROW_INDEX, rowNumber,String.valueOf(indexColumn));
		checkToDefaultCheckBoxRadio(driver, HomePageUI.CHECK_BOX_BY_COLUMN_AND_ROW_INDEX, rowNumber,String.valueOf(indexColumn));
		
	}

}
