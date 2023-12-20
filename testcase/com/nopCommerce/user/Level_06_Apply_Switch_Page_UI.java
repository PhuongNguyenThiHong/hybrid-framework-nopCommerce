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
import pageObject.MyProductReviewPageObject;
import pageObject.OrdersPageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_06_Apply_Switch_Page_UI extends BaseTest{
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

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePageObject = PageObjectGeneratorManager.getHomePageObject(driver);
		
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
		
		
	}

	
	@Test
	public void Register_03_Successfully() {
          
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		  
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		
		customerInfoPageObject = registerPageObject.clickMyAccountLink();
		
		// cus ==> address
		
		addressesPageObject = customerInfoPageObject.openAddressesPage(driver);
		
		//address ==> Order
		
		ordersPageObject = addressesPageObject.openOrdersPage(driver);
		
		//Order ==> Myrev
		
		myProductReviewPageObject = ordersPageObject.openMyProductReviewPage(driver);
		
		//My ==> Address
		
		addressesPageObject = myProductReviewPageObject.openAddressesPage(driver);
		
		//Address ==> cuss
		
		customerInfoPageObject = addressesPageObject.openCustomerInfoPage(driver);
					
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

