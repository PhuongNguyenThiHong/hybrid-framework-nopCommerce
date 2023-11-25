package com.nopCommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

@Test
public class Level_04_Apply_Multiple_Browsers extends BaseTest{
	WebDriver driver;

	
	//String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject; 

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName ) {
		
		driver = getBrowserDriver(browserName);
		
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
		
		
		
	}

	public void Register_01_Empty_Data() {
		
        homePageObject.clickToRegisterLink();  
		
		registerPageObject.clickToRegisterButton();
		
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
		
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

