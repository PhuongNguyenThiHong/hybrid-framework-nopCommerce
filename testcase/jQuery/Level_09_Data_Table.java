package jQuery;

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
import jQueryPageObject.HomePageObjectJQuery;
import jQueryPageObject.PageObjectGeneratorManagerJQuery;
import pageObject.AddressesPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyProductReviewPageObject;
import pageObject.OrdersPageObject;
import pageObject.PageObjectGeneratorManager;
import pageObject.RegisterPageObject;

public class Level_09_Data_Table extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, password, email, day,month, year, countryName, state, city, address, zipcode, phonenumber;
	
	HomePageObjectJQuery homePageObjectJQuery;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePageObjectJQuery = PageObjectGeneratorManagerJQuery.getHomePageJQuery(driver);
		
	}


	
	public void Table_01_Paging() {
		//open page 7
		
		homePageObjectJQuery.openPagingByPageNumber("7");
		homePageObjectJQuery.sleepInSecond(3);
		
		Assert.assertTrue(homePageObjectJQuery.isPagingActive("7"));
		
		//open page 10
		homePageObjectJQuery.openPagingByPageNumber("10");
		homePageObjectJQuery.sleepInSecond(3);
		Assert.assertTrue(homePageObjectJQuery.isPagingActive("10"));
		
		//open page 12
		homePageObjectJQuery.openPagingByPageNumber("12");
		homePageObjectJQuery.sleepInSecond(3);
		Assert.assertTrue(homePageObjectJQuery.isPagingActive("12"));
		//open page 6
		homePageObjectJQuery.openPagingByPageNumber("6");
		homePageObjectJQuery.sleepInSecond(3);
		Assert.assertTrue(homePageObjectJQuery.isPagingActive("6"));
		
		//open page 15
		homePageObjectJQuery.openPagingByPageNumber("15");
		homePageObjectJQuery.sleepInSecond(3);
		Assert.assertTrue(homePageObjectJQuery.isPagingActive("16"));
		 
	}
	
	@Test
	public void Table_02_Enter_Value_Finding() {
		homePageObjectJQuery.findingByFieldName("Country","Argentina");
		homePageObjectJQuery.findingByFieldName("Females","338282");
		homePageObjectJQuery.findingByFieldName("Total","687522");

		Assert.assertEquals(homePageObjectJQuery.getTextValueByFieldName("country"), "Argentina");
		
		
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

