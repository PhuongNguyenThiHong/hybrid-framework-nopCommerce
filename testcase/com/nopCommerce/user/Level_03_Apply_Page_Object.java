package com.nopCommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Level_03_Apply_Page_Object extends BasePage{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);
		
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
		
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
        homePageObject.clickToRegisterLink();  
		
		registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
		
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
          
		homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox("abc123");
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
	
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
					
	}
	
	@Test
	public void TC_03_Register_Successfully() {
          
		homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		  
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
					
	}
	
	@Test
	public void TC_04_Register_Exist_Email() {
	     
	    homePageObject.clickToRegisterLink();  
			
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
			
		registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getExistEmailMessage(), "The specified email already exists");
					
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6Characters() {
          
		homePageObject.clickToRegisterLink();  
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(email);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox("123");
		
		registerPageObject.clickToRegisterButton();

		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
					
	}
	
	@Test
	public void TC_06_Register_Invalid_ConfirmPass() {
          
        homePageObject.clickToRegisterLink();  
		
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

