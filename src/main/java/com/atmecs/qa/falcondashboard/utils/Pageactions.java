package com.atmecs.qa.falcondashboard.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;

public class Pageactions  {
	RandomNumber random=new RandomNumber();
	LogReport log = new LogReport();
	WebElement webElement;
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
	  public String getdata_fromExcel(String sheetname, String columnname, String rowname) {
	 
	  String datavalue = reader.getCellDataByColumnName(sheetname, columnname, rowname); 
	  return datavalue;
	  }
	 public String getdatabycellvalue(String sheetName,int colNum,int i) {
		 String datavalue=reader.getCellData(sheetName, colNum, i);
		 return datavalue;	 
	 }
	  
	  public WebElement selectLocators(String locatorType) {
			String[] locator = locatorType.split(":");
			
		/*
		 * System.out.println("In Select locators::***************");
		 * System.out.println("Key::"+locator[0]);
		 * System.out.println("value::"+locator[1]);
		 */
			
			
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
			webElement = selectLocators(element);
			webElement.click();
		}
		
		public String getText(String element) {
			webElement = selectLocators(element);
			return webElement.getText();

		}
		
		public void mouseOver(String element) {
			Actions action = new Actions(browser.getDriver());
			webElement = selectLocators(element);
			action.moveToElement(webElement).perform();

		}
		public String randomnumber(String locator) throws Exception {
			int randomnumber = random.generateRandomNumber();
			System.out.println(randomnumber);
			String number = Integer.toString(randomnumber);
			System.out.println(number);
			String locatorvalue = ReadLocators.getPropertyvalue(locator, ProjectBaseConstantPaths.LOCATORS_FILE);
			System.out.println(locatorvalue + ".....xpath");
			String Locator = locatorvalue.replace("*", number);
			System.out.println(Locator);
			return Locator;
		}
}