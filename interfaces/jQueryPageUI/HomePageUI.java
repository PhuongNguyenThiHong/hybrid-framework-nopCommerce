package jQueryPageUI;

public class HomePageUI {
	public static final String PAGING_URL="//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String TOTAL_PAGE="//li[@class='qgrd-pagination-page']";
	public static final String ENTER_VALUE="//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGING_ACTIVE_BY_NUMBER="//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TEXT_VALUE_BY_COLUMNNAME="//tr[not(@style='display: none;')]//td[@data-key='%s']";
	public static final String TOTAL_ROWS_IN_EACH_PAGE="//tbody//tr";
	
	//
	public static final String INDEX_BY_COLUMNNAME="//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_AND_ROW_INDEX="//tbody/tr[%s]/td[%s]/input";
	public static final String SELECT_BY_COLUMN_AND_ROW_INDEX="//tbody/tr[%s]/td[%s]//select";
	public static final String CHECK_BOX_BY_COLUMN_AND_ROW_INDEX="//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	

}
