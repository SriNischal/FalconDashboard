package com.atmecs.qa.falcondashboard.testscript;

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

public class TC04_PercentageOfProduct extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	RandomNumber random = new RandomNumber();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	WebDriver driver = null;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url=load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings( "static-access" )
	@Test
	public void percentageOfProduct() throws Exception {
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: Clicking on the pass%Trend of the product");
		page.clickOnElement(read.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The percentage of product completed and pass % trend are displayed");
		browser.getWait().safeWait(3000);
	log.info("STEP#2: Displaying the pass%trend message for the products");	
	     String actualtooltipmessage=propReader.getValue("loc.pass%trendmessage.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     System.out.println(message);
	     String expectedtooltipmessage=page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Pass%Trend");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	     System.out.println(expectedtooltipmessage);
	log.info("STEP#3: Mouse hovering the pass percent of the product");
		 page.mouseOver(read.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	   	 report.info("Successfully mouse hovered over the pass percent");
	log.info("STEP#4: Displaying the color of the pass pecrntage");
	     browser.getWait().safeWait(2000);
		 String color=propReader.getValue("loc.passpercentcolor.txt");
		 String actualcolor=browser.getFindFromBrowser().findElementByXpath(color).getCssValue("background-color");
		 System.out.println("Color:"+actualcolor);
	log.info("STEP#5: Veifying the color of the pass percentage"); 
		 String expectedcolor= page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Pass percent color");
		 Verify.verifyString(actualcolor, expectedcolor, "Successfully validated the color of the skip test cases box");
		 System.out.println(expectedcolor);
		 report.info("Successfully validated the color of the skip test cases box");  
	log.info("STEP#6: Mouse hovering the fail percent of the product");
	     page.mouseOver(read.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered over the fail percent");
    log.info("STEP#4: Displaying the color of the pass pecrntage");
	     browser.getWait().safeWait(2000);
	     String failcolor=propReader.getValue("loc.failpercentcolor.txt");
	     String actualfailcolor=browser.getFindFromBrowser().findElementByXpath(failcolor).getCssValue("background-color");
	     System.out.println("Color:"+actualfailcolor);
    log.info("STEP#5: Veifying the color of the pass percentage"); 
	     String expectedfailcolor= page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Fail percent color");
	     Verify.verifyString(actualfailcolor, expectedfailcolor, "Successfully validated the color of the skip test cases box");
	     System.out.println(expectedfailcolor);
	     report.info("Successfully validated the color of the skip test cases box"); 
		/*
		 * log.info("STEP#6: Clicking on the recent runs option");
		 * page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn",
		 * ProjectBaseConstantPaths.LOCATORS_FILE));
		 * report.info("Successfully clicked on recent runs");
		 * browser.getWait().safeWait(2000);
		 * log.info("STEP#7: Validating the recent runs text"); validate.validateText();
		 * report.info("Successfully validated recent runs");
		 * log.info("STEP#8: Validating the pass percent of the product");
		 * validate.validatePassPercent();
		 * report.info("Successfully validated pass percent");
		 * log.info("STEP#9: Validatinng the percentage of the product completed");
		 * validate.validatePercentageCompleted();
		 * report.info("Successfully validated percentage completed");
		 * log.info("STEP#10: Sorting the pass percent in recent runs ");
		 * page.clickOnElement(read.getPropertyvalue("loc.recentpasspercent.btn",
		 * ProjectBaseConstantPaths.LOCATORS_FILE));
		 * report.info("Successfully clicked on pass percent");
		 * log.info("STEP#11: Validating the data after sorting for the first time");
		 * validate.validateSortingPassPercent();
		 * report.info("Successfully validated the data after sorting");
		 * log.info("STEP#12: Creating a list to display the test cases of the product"
		 * ); String testcases=propReader.getValue("loc.testcase.txt"); List<WebElement>
		 * passpercentagelist =
		 * browser.getFindFromBrowser().findElementsByXpath(testcases);
		 * log.dateinfo(passpercentagelist.size()); List<String> passpercentagetext =
		 * passpercentagelist.stream().map(WebElement::getText).collect(Collectors.
		 * toList()); log.info(passpercentagetext);
		 * log.info("STEP#13: Clicking on the test cases of  the product");
		 * page.clickOnElement(read.getPropertyvalue("loc.tests.btn",
		 * ProjectBaseConstantPaths.LOCATORS_FILE));
		 * report.info("Successfully clicked on testcases");
		 * log.info("STEP#14: Clicking on the test cases of the product");
		 * page.clickOnElement(read.getPropertyvalue("loc.tests.btn",
		 * ProjectBaseConstantPaths.LOCATORS_FILE));
		 * report.info("Successfully clicked on test cases");
		 * log.info("STEP#15: Creating a list to display the test cases after sorting");
		 * List<WebElement> passpercentlist =
		 * browser.getFindFromBrowser().findElementsByXpath(testcases);
		 * log.dateinfo(passpercentlist.size()); List<String> passpercenttext =
		 * passpercentlist.stream().map(WebElement::getText).collect(Collectors.toList()
		 * ); log.info(passpercenttext);
		 * log.info("STEP#16: Comparing both the lists to verify that both are not same"
		 * ); boolean compare=passpercentagetext.equals(passpercenttext);
		 * System.out.println(compare);
		 */
	}
}
