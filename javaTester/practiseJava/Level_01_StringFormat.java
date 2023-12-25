package practiseJava;

public class Level_01_StringFormat {
	
	public static  String CUSTOMER_INFOR_LINK="//div[@class='listbox']//a[text()='Customer info']";
	public static  String ADDRESSES_LINK="//div[@class='listbox']//a[text()='Addresses']";
	public static  String ORDERS_LINK="//div[@class='listbox']//a[text()='Orders']";
	public static  String MYPRODUCT_REVIEW_LINK="//div[@class='listbox']//a[text()='My product reviews']";
	
	public static String DYNAMIC_SIDEBAR_LINK="//div[@class='listbox']//a[text()='%s']";
	
	public static void clickToSidebarLink(String locator) {
		
		System.out.println("Click to "+ locator);
	}
	
	public static void clickToSidebarLink(String dynamicLink, String pageName) {
		String locator = String.format(dynamicLink, pageName);
		
		System.out.println("Click to "+ locator);
	}
	
	public static void clickToSidebarLink(String dynamicLink, String...paramsValue) {
		String locator = String.format(dynamicLink, (Object[]) paramsValue);
		
		System.out.println("Click to "+ locator);
	}
	
public static void main(String[]args) {
		
		clickToSidebarLink(DYNAMIC_SIDEBAR_LINK, "Customer info");
		clickToSidebarLink(DYNAMIC_SIDEBAR_LINK, "Addresses");
		clickToSidebarLink(DYNAMIC_SIDEBAR_LINK,"Orders" );
		clickToSidebarLink(DYNAMIC_SIDEBAR_LINK,"My product reviews" );
	}


}
