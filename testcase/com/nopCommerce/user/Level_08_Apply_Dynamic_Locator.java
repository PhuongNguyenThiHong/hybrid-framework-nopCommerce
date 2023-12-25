package com.nopCommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.AddressesPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyProductReviewPageObject;
import pageObject.OrdersPageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_08_Apply_Dynamic_Locator extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 
	CustomerInfoPageObject customerInfoPageObject;
	AddressesPageObject addressesPageObject;
	OrdersPageObject ordersPageObject;
	MyProductReviewPageObject myProductReviewPageObject;
	LoginPageObject loginPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName="Phuong";
		lastName="Nguyen";
		email="phuong"+RandomEmail()+"@gmail.com";
		password="123456";
		day="18";
		month="July";
		year="1994";
		countryName="United States";
		state="California";
		city="bala";
		address="23 bla california, US";
		zipcode="0987";
		phonenumber="0987654444";
		
		homePageObject = PageObjectGeneratorManager.getHomePageObject(driver);
        
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		  
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		
		
	}

	
	@Test
	public void Dynamic_Locator_02_Nhieu_Pages() {
		
	    registerPageObject.openPagesAtHearderLinkbyName(driver, "Log in");
		loginPageObject = PageObjectGeneratorManager.getLoginPageObject(driver);
		 
		 ////////////////// login account

		loginPageObject.loginAsUser(email, password);
		homePageObject= PageObjectGeneratorManager.getHomePageObject(driver);
		
		homePageObject.openPagesAtHearderLinkbyName(driver, "My account");
		customerInfoPageObject= PageObjectGeneratorManager.getCustomerInfoPageObject(driver);
	
		customerInfoPageObject.openPagesAtMyAccountPagebyName(driver, "Customer info");
			
			// cus ==> address
			
		customerInfoPageObject.openPagesAtMyAccountPagebyName(driver, "Addresses");
		addressesPageObject = PageObjectGeneratorManager.getAddressesPageObject(driver)	;
			//address ==> Order
			
		addressesPageObject.openPagesAtMyAccountPagebyName(driver, "Orders");
		ordersPageObject = PageObjectGeneratorManager.getOrdersPageObject(driver);
			
			//Order ==> Myrev
			
		ordersPageObject.openPagesAtMyAccountPagebyName(driver, "My product reviews");
		myProductReviewPageObject = PageObjectGeneratorManager.getMyProductReviewPageObject(driver);
			
			//My ==> Address
			
		myProductReviewPageObject.openPagesAtMyAccountPagebyName(driver, "Addresses");
		addressesPageObject = PageObjectGeneratorManager.getAddressesPageObject(driver);
			
			//Address ==> cuss
			
		addressesPageObject.openPagesAtMyAccountPagebyName(driver, "Customer info");
		customerInfoPageObject =  PageObjectGeneratorManager.getCustomerInfoPageObject(driver);
		 
	}
		
	public void Dynamic_Locator_01_It_Pages() {
		
		loginPageObject = (LoginPageObject)registerPageObject.openPagesAtHearderLinkbyName(driver, "Log in");
		 
		 ////////////////// login account

		homePageObject= loginPageObject.loginAsUser(email, password);
		customerInfoPageObject=  (CustomerInfoPageObject) homePageObject.openPagesAtHearderLinkbyName(driver, "My account");
	
		customerInfoPageObject.openPagesAtMyAccountPagebyName(driver, "Customer info");
	
			
			// cus ==> address
			
			addressesPageObject = (AddressesPageObject)customerInfoPageObject.openPagesAtMyAccountPagebyName(driver, "Addresses");
			
			//address ==> Order
			
			ordersPageObject = (OrdersPageObject)addressesPageObject.openPagesAtMyAccountPagebyName(driver, "Orders");
			
			//Order ==> Myrev
			
			myProductReviewPageObject = (MyProductReviewPageObject)ordersPageObject.openPagesAtMyAccountPagebyName(driver, "My product reviews");
			
			//My ==> Address
			
			addressesPageObject = (AddressesPageObject)myProductReviewPageObject.openPagesAtMyAccountPagebyName(driver, "Addresses");
			
			//Address ==> cuss
			
			customerInfoPageObject = (CustomerInfoPageObject)addressesPageObject.openPagesAtMyAccountPagebyName(driver, "Customer info");
		 
		
	}

	
	public void sleepInSecond(long minutes) {
		try {
			Thread.sleep(minutes*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int RandomEmail() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
}

