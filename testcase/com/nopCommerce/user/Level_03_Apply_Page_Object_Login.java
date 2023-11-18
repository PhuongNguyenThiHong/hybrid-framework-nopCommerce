package com.nopCommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Level_03_Apply_Page_Object_Login extends BasePage{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, validPassword,wrongPassword, validEmail ,invalidEmail,emailNotFound, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 
	LoginPageObject loginPageObject;

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
		
		driver.get("https://demo.nopcommerce.com/");
		
		homePageObject = new HomePageObject(driver);
		
        homePageObject.clickToRegisterLink();
        
    	registerPageObject = new RegisterPageObject(driver);
		
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(validEmail);
		registerPageObject.inputToPasswordTextbox(validPassword);
		registerPageObject.inputToConfirmPasswordTextbox(validPassword);
		  
	    registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		
		
		
		homePageObject = new HomePageObject(driver);
		
	}

	@Test
	public void Login_01_Empty_Data() {
       
		homePageObject.clickLoginLink();
		
		loginPageObject = new LoginPageObject(driver);
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Please enter your email");
		
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		homePageObject.clickLoginLink();
		
		loginPageObject = new LoginPageObject(driver);
		
		loginPageObject.inputEmailTextBox(invalidEmail);
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Wrong email");
	
	}
	
	@Test
	public void Login_03_Email_Not_Register() {
          
		homePageObject.clickLoginLink(); 
		
		loginPageObject = new LoginPageObject(driver);
		
        loginPageObject.inputEmailTextBox(emailNotFound);
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");			
	}
	
	@Test
	public void Login_04_Password_Not_Input() {
	     
        homePageObject.clickLoginLink(); 
		
		loginPageObject = new LoginPageObject(driver);
		
        loginPageObject.inputEmailTextBox(validEmail);
        loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");			
					
	}
	
	@Test
	public void Login_05_Password_Input_Wrong() {
	    homePageObject.clickLoginLink(); 
		
		loginPageObject = new LoginPageObject(driver);
			
	    loginPageObject.inputEmailTextBox(validEmail);
	    loginPageObject.inputPasswordTextBox(wrongPassword);
        loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");			
								
	}
	
	@Test
	public void Login_06_Successfully() {
        homePageObject.clickLoginLink(); 
		
		loginPageObject = new LoginPageObject(driver);
			
	    loginPageObject.inputEmailTextBox(validEmail);
	    loginPageObject.inputPasswordTextBox(validPassword);
        loginPageObject.clickToLoginButton();
        
        homePageObject = new HomePageObject(driver);
        
        Assert.assertTrue(homePageObject.isMyAccountDisplay());		
        
        homePageObject.clickLogOutLink();
								
       
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

