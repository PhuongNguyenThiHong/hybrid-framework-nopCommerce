package SnapNews;

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
import snapPageObject.HomePageObjectSnapNews;
import snapPageObject.PageObjectGeneratorManagerSnapNews;

public class Level_01_SnapNews extends BaseTest{
	WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	HomePageObjectSnapNews homePageObjectSnapNews;
	

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);
		homePageObjectSnapNews = PageObjectGeneratorManagerSnapNews.getHomePageObjectSnapNews(driver);
		
	}


	@Test
	public void Copy_artist() {
		
		homePageObjectSnapNews.clickToChatBot();
		homePageObjectSnapNews.getResultSummaryArtist();
		System.out.println(homePageObjectSnapNews.getResultSummaryArtist());
		
	}
	
	
	public void Table_02_Enter_Value_Finding() {
		
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

