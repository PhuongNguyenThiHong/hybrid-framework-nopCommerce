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
import pageObject.HomePageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_05_Apply_Page_Object_Register_3 extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 

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
		
		
	}

	@Test
	public void Register_01_Empty_Data() {
		
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
		
	}
	
	@Test
	public void Register_02_Invalid_Email() {
          
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox("abc123");
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
	
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
					
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
		
					
	}
	
	@Test
	public void Register_04_Exist_Email() {
	     
		registerPageObject = homePageObject.clickToRegisterLink();  
			
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
			
		registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getExistEmailMessage(), "The specified email already exists");
					
	}
	
	@Test
	public void Register_05_Password_Less_Than_6Characters() {
          
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox("123");
		
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
					
	}
	
	@Test
	public void Register_06_Invalid_ConfirmPass() {
          
		registerPageObject = homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox("123457");
		
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
		
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

