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
import commons.GlobalConstants;
import pageObject.AdminDashboardPageOject;
import pageObject.AdminLoginPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_07_Apply_Switch_Users extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, validPassword,wrongPassword, validEmail,adminEmail,adminPass ,invalidEmail,emailNotFound, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 
	LoginPageObject loginPageObject;
	AdminLoginPageObject adminLoginPageObject;
	AdminDashboardPageOject adminDashboardPageOject;

	
	@Parameters("browser")
	@BeforeClass
	 public void beforeClass(String browserName) {
		
	    driver = getBrowserDriver(browserName);
		
		
		firstName="Phuong";
		lastName="Nguyen";
		validEmail="phuong"+RandomEmail()+"@gmail.com";
		invalidEmail = "abc.com";
		emailNotFound="abc@123.com";
		validPassword="123456";
		wrongPassword="654321";
		day="18";
		month="July";
		year="1994";
		countryName="United States";
		state="California";
		city="bala";
		address="23 bla california, US";
		zipcode="0987";
		phonenumber="0987654444";
		adminEmail="admin@yourstore.com";
		adminPass="admin";
		
		homePageObject = PageObjectGeneratorManager.getHomePageObject(driver);
		
		registerPageObject =  homePageObject.clickToRegisterLink();
       
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(validPassword);
		registerPageObject.inputToConfirmPasswordTextbox(validPassword);
		  
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		
		
		
		homePageObject = PageObjectGeneratorManager.getHomePageObject(driver);
		
	}

	
	@Test
	public void Login_01_Login_User() {
		loginPageObject = homePageObject.clickLoginLink(); 
		
		homePageObject = loginPageObject.loginAsUser(validEmail, validPassword);
   
        Assert.assertTrue(homePageObject.isMyAccountDisplay());		
        
        homePageObject.clickLogOutLink();
								
       
	}
	
	@Test
	public void Login_02_Login_Admin() {
		
		homePageObject.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);	
		
		adminLoginPageObject = PageObjectGeneratorManager.getAdminLoginPageObject(driver);
		
		adminDashboardPageOject = adminLoginPageObject.loginAsAdmin(adminEmail, adminPass);
		
		 Assert.assertTrue(adminDashboardPageOject.isDashboardDisplay());	
       
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

