package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

//In this class tooltip message is validated and color of the pass and fail percentages

public class TC04_ProductPercentage extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	RandomNumber random = new RandomNumber();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	WebDriver driver = null;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method a list is created to display the tooltip message by mouse
	 * hovering and validate the message and display the color of the pass
	 * percentage and the fail percentage
	 */
	@SuppressWarnings( "static-access" )
	@Test
	public void percentageOfProduct() throws Exception {
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: Mouse hovering over the pass%Trend of the product");
	     page.mouseOver(read.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the pass%trend");
	     browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Displaying the pass%trend message for the products");	
	     String product=page.getText(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		 System.out.println("productname: "+product);
	     String actualtooltipmessage=propReader.getValue("loc.pass%trendmessage.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     String expectedtooltipmessage=page.getdata_fromExcel(product, "Validation Text", "Pass%Trend");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	     System.out.println(expectedtooltipmessage);
	log.info("STEP#3: Mouse hovering the pass percent of the product and diplayed the value");
		 page.mouseOver(read.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	   	 report.info("Successfully mouse hovered over the pass percent");
	   	String actualpasspercentmessage=propReader.getValue("loc.passpercent.txt");
	     String passpercentmessage=browser.getFindFromBrowser().findElementByXpath(actualpasspercentmessage).getText();
	     System.out.println(passpercentmessage);
	log.info("STEP#4: Displaying the color of the pass pecrntage");
		 String color=propReader.getValue("loc.passpercentcolor.txt");
		 String actualcolor=browser.getFindFromBrowser().findElementByXpath(color).getCssValue("background-color");
		 System.out.println("Color:"+actualcolor);
	log.info("STEP#5: Veifying the color of the pass percentage"); 
		 String expectedcolor= page.getdata_fromExcel(product, "Validation Text", "Pass percent color");
		 Verify.verifyString(actualcolor, expectedcolor, "Successfully validated the color of the skip test cases box");
		 System.out.println(expectedcolor);
		 report.info("Successfully validated the color of the skip test cases box");  
		 browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#6: Mouse hovering the fail percent of the product");
	     page.mouseOver(read.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered over the fail percent and displayed the value");
	     String actualfailpercentmessage=propReader.getValue("loc.failpercent.txt");
	     String failpercentmessage=browser.getFindFromBrowser().findElementByXpath(actualfailpercentmessage).getText();
	     System.out.println(failpercentmessage);
    log.info("STEP#7: Displaying the color of the fail pecrntage");
	     String failcolor=propReader.getValue("loc.failpercentcolor.txt");
	     String actualfailcolor=browser.getFindFromBrowser().findElementByXpath(failcolor).getCssValue("background-color");
	     System.out.println("Color:"+actualfailcolor);
    log.info("STEP#8: Veifying the color of the pass percentage"); 
	     String expectedfailcolor= page.getdata_fromExcel(product, "Validation Text", "Fail percent color");
	     Verify.verifyString(actualfailcolor, expectedfailcolor, "Successfully validated the color of the skip test cases box");
	     System.out.println(expectedfailcolor);
	     report.info("Successfully validated the color of the skip test cases box"); 
	}
}
