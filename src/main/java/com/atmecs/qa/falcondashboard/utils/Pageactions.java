package com.atmecs.qa.falcondashboard.utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class Pageactions  {
	RandomNumber random=new RandomNumber();
	LogReport log = new LogReport();
	ReadLocators read=new ReadLocators();
	Browser browser = null;
	ReadDataFromExcel reader = getsheet(ProjectBaseConstantPaths.EXCEL_FILE);
	
	public Pageactions(Browser browser) {
		this.browser = browser;
	}
	  
	  
	public ReadDataFromExcel getsheet(String sheetname) {
		ReadDataFromExcel read = new ReadDataFromExcel();
		try {
			read.setPath(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}
	  public String getdata_fromExcel(String sheetname,String columnname, String rowname) {
	  String datavalue = reader.getCellDataByColumnName(sheetname,columnname, rowname); 
	  return datavalue;
	  }
	  
	  public String writedata_toExcel(String sheetname,String columnname, int rownumber, String value) {
		  String datavalue =reader.setCellData(sheetname, columnname, rownumber, value); 
		  return datavalue;
		  }
	  
	 public String getdatabycellvalue(String sheetName,int colNum,int i) {
		 String datavalue=reader.getCellData(sheetName, colNum, i);
		 return datavalue;	 
	 }
	  
	  public WebElement getLocator(String locatorType) {
			String[] locator = locatorType.split(":");
			
		/*
		 * System.out.println("In Select locators::***************");
		 * System.out.println("Key::"+locator[0]);
		 * System.out.println("value::"+locator[1]);
		 */
			
			
			WebElement webElement = null;	
			
			switch (locator[0]) {
			case "id":
				webElement=browser.getFindFromBrowser().findElementById(locator[1]);
				break;
			case "name":
				webElement=browser.getFindFromBrowser().findElementByName(locator[1]);
				break;
			case "className":
				webElement=browser.getFindFromBrowser().findElementByClassName(locator[1]);
				break;
			case "linkText":
				webElement=browser.getFindFromBrowser().findElementByLinkText(locator[1]);
				break;
			case "partialLinkText":
				webElement=browser.getFindFromBrowser().findElementByPartialLinkText(locator[1]);
				break;
			case "tagName":
				webElement=browser.getFindFromBrowser().findElementByTagName(locator[1]);
				break;
			case "cssSelector":
				webElement=browser.getFindFromBrowser().findElementByCssSelector(locator[1]);
				break;
			case "xpath":
				webElement=browser.getFindFromBrowser().findElementByXpath(locator[1]);
				break;
			}
			return webElement;
		}

		public void clickOnElement(String element) {
			WebElement webElement = getLocator(element);
			webElement.click();
		}
		 
		public String getText(String element) {
			WebElement webElement = getLocator(element);
			return webElement.getText();

		}
		public String getCssValue(String element,String value) {
			WebElement webElement = getLocator(element);
			return webElement.getCssValue(value);

		}
		
		public void mouseOver(String element) {
			Actions action = new Actions(browser.getDriver());
			WebElement webElement = getLocator(element);
			action.moveToElement(webElement).perform();

		}
		public String randomnumber(String locator) throws Exception {
			int randomnumber = random.generateRandomNumber();
			System.out.println(randomnumber);
			String number = Integer.toString(randomnumber);
			System.out.println(number);
			String locatorvalue = read.getPropertyvalue(locator, ProjectBaseConstantPaths.LOCATORS_FILE);
			System.out.println(locatorvalue + ".....xpath");
			String Locator = locatorvalue.replace("*", number);
			System.out.println(Locator);
			return Locator;
		}
		
		
		public WebElement waitElementToBeClickable(Browser browser, String locator, long waitingTime) {
			WebDriverWait wait = new WebDriverWait(browser.getDriver(), waitingTime);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getLocator(locator)));
			return element;
		}
		
		public WebElement textToBePresentInElement(Browser browser, String locator, long waitingTime) {
			WebDriverWait wait = new WebDriverWait(browser.getDriver(), waitingTime);
			WebElement webElement = getLocator(locator);
			wait.until(ExpectedConditions.textToBePresentInElement(getLocator(locator) , "text to be present"));
			return webElement;
			
		}
		public void pageLoadTimeout(long waitingTime) {
			browser.getDriver().manage().timeouts().pageLoadTimeout(waitingTime, TimeUnit.SECONDS);
		}
		public void windowHandle() {
			Set<String> allWindowHandles = browser.getDriver().getWindowHandles();
			 
			 for(String handle : allWindowHandles)
			 {
			 browser.getDriver().switchTo().window(handle);
			 System.out.println("Window handle - > " + handle);
			 }
		}
}