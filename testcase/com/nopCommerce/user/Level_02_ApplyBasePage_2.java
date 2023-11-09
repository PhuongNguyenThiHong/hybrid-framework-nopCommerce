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

public class Level_02_ApplyBasePage_2 {
	WebDriver driver;
	//Declard
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	

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
		// che giau di viec khoi tao 1 doi tuong
	   basePage = BasePage.getBasePageObject();
		
		firstName="Phuong";
		lastName="Nguyen";
		email="phuong"+RandomEmail()+"@gmail.com";
		password="123456a@";
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
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
				
		
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
	    basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Phuong");
	    basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Nguyen");
	    basePage.sendKeyToElement(driver, "//input[@id='Email']", "huong123@");
	    basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
	    basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	    
	    basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
		

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
					
	}
	
	@Test
	public void TC_03_Register_Successfully() {
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
	    basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Phuong");
	    basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Nguyen");
	    basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
	    basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
	    basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	    
	    basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
		

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
					
	}
	
	@Test
	public void TC_04_Register_Exist_Email() {
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
	    basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Phuong");
	    basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Nguyen");
	    basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
	    basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
	    basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	    
	    basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
		

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
					
	}
	
	@Test
	public void TC_05_Register_Password_Less_Than_6Characters() {
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
	    basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Phuong");
	    basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Nguyen");
	    basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
	    basePage.sendKeyToElement(driver, "//input[@id='Password']", "123");
	    basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	    
	    basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
	    

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
					
	}
	
	@Test
	public void TC_06_Register_Invalid_ConfirmPass() {
          
		basePage.waitForElementClickable(driver, "//a[text()='Register']");
		basePage.clickToElement(driver, "//a[text()='Register']");
		
	    basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Phuong");
	    basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Nguyen");
	    basePage.sendKeyToElement(driver, "//input[@id='Email']", email);
	    basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
	    basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");
	    
	    basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver,  "//button[@id='register-button']");
	   	
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
					
	}

	
	public void TC_02_AddAddress() {
		driver.findElement(By.xpath("//a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		
		driver.findElement(By.id("Address_FirstName")).sendKeys(firstName);
		driver.findElement(By.id("Address_LastName")).sendKeys(lastName);
		driver.findElement(By.id("Address_Email")).sendKeys(email);
		new Select (driver.findElement(By.id("Address_CountryId"))).selectByVisibleText(countryName);
		new Select (driver.findElement(By.id("Address_StateProvinceId"))).selectByVisibleText(state);
		
		driver.findElement(By.id("Address_City")).sendKeys(city);
		driver.findElement(By.id("Address_Address1")).sendKeys(address);
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(zipcode);
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phonenumber);
		
		//click save 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		sleepInSecond(5);
		
	//Verify
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='name']")).getText(), firstName+" "+lastName);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='email']")).getText().contains(email));
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='phone']")).getText().contains(phonenumber));
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='address1']")).getText(), address);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText().contains(city));
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText().contains(zipcode));
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='city-state-zip']")).getText().contains(state));
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='country']")).getText(), countryName);
		
		sleepInSecond(3);
		

		
	}

	//@Test
	public void TC_03_() {
		
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

