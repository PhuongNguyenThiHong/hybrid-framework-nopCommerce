package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageObjectGeneratorManager extends BasePage{
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	
	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewPageObject(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPageObject (WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageOject getDashboardAdmin (WebDriver driver) {
		return new AdminDashboardPageOject(driver);
	}

}
