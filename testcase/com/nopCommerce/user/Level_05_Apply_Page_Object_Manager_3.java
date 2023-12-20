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
import pageObject.LoginPageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_05_Apply_Page_Object_Manager_3 extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, validPassword,wrongPassword, validEmail ,invalidEmail,emailNotFound, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 
	LoginPageObject loginPageObject;

	
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
	public void Login_01_Empty_Data() {
       
		loginPageObject = homePageObject.clickLoginLink();
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Please enter your email");
		
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPageObject = homePageObject.clickLoginLink();
		
		loginPageObject.inputEmailTextBox(invalidEmail);
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextBox(), "Wrong email");
	
	}
	
	@Test
	public void Login_03_Email_Not_Register() {
          
		loginPageObject = homePageObject.clickLoginLink(); 
	
        loginPageObject.inputEmailTextBox(emailNotFound);
		
		loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");			
	}
	
	@Test
	public void Login_04_Password_Not_Input() {
	     
		loginPageObject = homePageObject.clickLoginLink(); 
		
        loginPageObject.inputEmailTextBox(validEmail);
        loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");			
					
	}
	
	@Test
	public void Login_05_Password_Input_Wrong() {
		loginPageObject = homePageObject.clickLoginLink(); 
			
	    loginPageObject.inputEmailTextBox(validEmail);
	    loginPageObject.inputPasswordTextBox(wrongPassword);
        loginPageObject.clickToLoginButton();
		
		Assert.assertEquals(loginPageObject.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");			
								
	}
	
	@Test
	public void Login_06_Successfully() {
		loginPageObject = homePageObject.clickLoginLink(); 
			
	    loginPageObject.inputEmailTextBox(validEmail);
	    loginPageObject.inputPasswordTextBox(validPassword);
	    
	    homePageObject = loginPageObject.clickToLoginButton();
   
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

