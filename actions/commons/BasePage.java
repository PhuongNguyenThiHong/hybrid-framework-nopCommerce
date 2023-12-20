package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.AddressesPageObject;
import pageObject.CustomerInfoPageObject;
import pageObject.MyProductReviewPageObject;
import pageObject.OrdersPageObject;
import pageObject.PageObjectGeneratorManager;
import pageUIs.BasePageUI;
import pageUIs.RegisterPageUI;

public class BasePage {
	//chua cac ham dung chung cho PageObject
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	
	//Nhiem vu la mo ra 1 URL
		public void openPageUrl(WebDriver driver, String pageUrl){
			driver.get(pageUrl);
		}
		
		public String getPageTitle(WebDriver driver){
			return driver.getTitle();
		}
		
		public String getPageSourceCode(WebDriver driver){
			return driver.getPageSource();
		}
		
		public void backToPage(WebDriver driver){
			driver.navigate().back();;
		}
		
		public void forwardToPage(WebDriver driver){
			driver.navigate().forward();
		}
		
		public void refreshToPage(WebDriver driver){
			driver.navigate().refresh();
		}
		
		public Alert waitForAlertPresence(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			return explicitWait.until(ExpectedConditions.alertIsPresent());
			
		}
		
		public void alertAccept(WebDriver driver) {
			waitForAlertPresence(driver).accept();
		}
		
		public void alertCancel(WebDriver driver) {
			waitForAlertPresence(driver).dismiss();
		}
		
		public String alertGetText(WebDriver driver) {
			return waitForAlertPresence(driver).getText();
		}
		
		public void alertSendKey(WebDriver driver, String textValue) {
			waitForAlertPresence(driver).sendKeys(textValue);
		}
		
		public void closeAllWindowExceptionParent(WebDriver driver,String ParentID) {
			
		    Set<String> allWindowIDs = driver.getWindowHandles();
		    for (String ID : allWindowIDs) {
		    	if (!ID.equals(ParentID)) {
		    		driver.switchTo().window(ID);
					driver.close();
					sleepInSecond(2);
		    	}
				
			}
		    driver.switchTo().window(ParentID);
		    
		}
		
		public void sleepInSecond(long inSecond) {
			try {
				Thread.sleep(inSecond*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void switchToWindowByID(WebDriver driver, String currentWindownID) {
			
			Set<String> allWindowIDs = driver.getWindowHandles();
			
			for (String windowid : allWindowIDs) {
				
			    String actualTitle = driver.getTitle();
		
				if (!windowid.equals(currentWindownID)) {
					driver.switchTo().window(windowid);
					
					break;
					
				}
			}
			
		}
		
		public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
			
			Set<String> allWindowIDs = driver.getWindowHandles();
			
			for (String windowid : allWindowIDs) {
				
				driver.switchTo().window(windowid);
				
			    String actualTitle = driver.getTitle();
				
				if (actualTitle.equals(expectedWindowTitle)) {
					break;
					
				}
			}
			
		}
		
		private By getByXpath(String xpathLocator) {
			return By.xpath(xpathLocator);
		}
		
		private WebElement getWebElement(WebDriver driver, String xpathLocator) {
			return driver.findElement(getByXpath(xpathLocator));
		}
		
		public void clickToElement(WebDriver driver, String xpathLocator) {
			getWebElement(driver, xpathLocator).click();
			
		}
		
		public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
			
			WebElement element = getWebElement(driver, xpathLocator);
			element.clear();
			element.sendKeys(textValue);
			
		}
		
		public String getElementText(WebDriver driver, String xpathLocator) {
			return getWebElement(driver, xpathLocator).getText();
			
		}
		
		
		public void selectItemDefaultDropDown(WebDriver driver, String xpathLocator, String textItem) {
			
			Select select = new Select(getWebElement(driver, xpathLocator)) ;
			select.selectByValue(textItem);
			
		}
		
		public String getSelectItemDefaultDropDown(WebDriver driver, String xpathLocator) {
			
			Select select = new Select(getWebElement(driver, xpathLocator)) ;
			return select.getFirstSelectedOption().getText();
			
		}
		
		public boolean isDropDownMultiple(WebDriver driver, String xpathLocator) {
			Select select = new Select(getWebElement(driver, xpathLocator)) ;
			return select.isMultiple();
		}
		
		

		public void selectDropDown(WebDriver driver, String xpathLocator, String listItems, String expectedText) {
			

			getWebElement(driver, xpathLocator).click();
			
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			
			List<WebElement> listMenu= explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listItems)));
			
			for (WebElement tempItem : listMenu) {
				String itemText = tempItem.getText();
				
				if (itemText.trim().equals(expectedText)) {
					tempItem.click();
					break;
				}
				
			}
			
		}
		
	    public void selectAndEditDropDown(WebDriver driver, String xpathLocator, String listItems, String expectedText) {
			
		  getWebElement(driver, xpathLocator).sendKeys(expectedText);

			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			
			List<WebElement> listMenu= explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(listItems)));
		
			for (WebElement tempItem : listMenu) {
				String itemText = tempItem.getText();
				
				if (itemText.trim().equals(expectedText)) {
					tempItem.click();
					break;
				}
				
			}
			
		}
		
	    public String getElementAttribute (WebDriver driver, String xpathLocator, String name) {
	    	return getWebElement(driver, xpathLocator).getAttribute(name);
	    }
	    
	    public String getElementCssValue (WebDriver driver, String xpathLocator, String propertyName) {
	    	return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	    }
	    
	    public String getHexaColorByRgbaColor(String rgbaValue) {
	    	return Color.fromString(rgbaValue).asHex().toUpperCase();
	    }
	    
	    private List<WebElement> getListElement(WebDriver driver, String xpathLocator) {
	    	return driver.findElements(getByXpath(xpathLocator));
	    }
	    
	    public int getElementSize(WebDriver driver, String xpathLocator) {
	    	return getListElement(driver, xpathLocator).size();
	    	
	    }
	    
	    public void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
	    	WebElement element = getWebElement(driver, xpathLocator);
	    	if (!element.isSelected()) {
	    		element.click();
	    	}
	    	
	    }
	    
	    public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
	    	WebElement element = getWebElement(driver, xpathLocator);
	    	if (element.isSelected()) {
	    		element.click();
	    	}
	    	
	    }
	    
	    public boolean isElementDisplay(WebDriver driver, String xpathLocator) {
	    	return getWebElement(driver,xpathLocator).isDisplayed();
	    }
	    
	    public boolean isElementEnable(WebDriver driver, String xpathLocator) {
	    	return getWebElement(driver,xpathLocator).isEnabled();
	    }
	    
	    public boolean isElementSelect(WebDriver driver, String xpathLocator) {
	    	return getWebElement(driver,xpathLocator).isSelected();
	    }
	    
	    public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
	    	driver.switchTo().frame(getWebElement(driver,xpathLocator));
	    }
	    
	    public void switchToDefaultContent(WebDriver driver) {
	    	driver.switchTo().defaultContent();
	    }
	    
	    public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(getWebElement(driver,xpathLocator)).perform();
	    }
	    


		public void scrollToBottomPage(WebDriver driver) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}

		public void highlightElement(WebDriver driver, String xpathLocator) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement element = getWebElement(driver, xpathLocator);
			String originalStyle = element.getAttribute("style");
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
			sleepInSecond(1);
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
		}

		public void clickToElementByJS(WebDriver driver, String xpathLocator) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
		}

		public void scrollToElement(WebDriver driver, String xpathLocator) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
		}

		public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
		}

		public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					try {
						return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
					} catch (Exception e) {
						return true;
					}
				}
			};

			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
				}
			};

			return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		}

		public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
		}

		public boolean isImageLoaded(WebDriver driver, String locator) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
			if (status) {
				return true;
			} else {
				return false;
			}
		}
		
		public void waitForElementVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
		}
		
		public void waitAllElementVisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
		}
		
		public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
		}
		
		public void waitAllElementInvisible(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,xpathLocator)));
		}
		
		public void waitForElementClickable(WebDriver driver, String xpathLocator) {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
		}
		

		public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_LINK);
			clickToElement(driver, BasePageUI.CUSTOMER_INFOR_LINK);
			return PageObjectGeneratorManager.getCustomerInfoPageObject(driver);
			
		}
		
		public AddressesPageObject openAddressesPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.ADDRESSES_LINK);
			clickToElement(driver, BasePageUI.ADDRESSES_LINK);
			return PageObjectGeneratorManager.getAddressesPageObject(driver);
			
		}
		
		public OrdersPageObject openOrdersPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.ORDERS_LINK);
			clickToElement(driver, BasePageUI.ORDERS_LINK);
			return PageObjectGeneratorManager.getOrdersPageObject(driver);
			
		}
		
		public MyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
			waitForElementClickable(driver, BasePageUI.MYPRODUCT_REVIEW_LINK);
			clickToElement(driver, BasePageUI.MYPRODUCT_REVIEW_LINK);
			return PageObjectGeneratorManager.getMyProductReviewPageObject(driver);
			
		}
		
		private long longTimeout =30;
		private long shortTimeout =5;

}
