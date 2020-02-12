package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
//In this the start time of the product is dispalyed and validated 
public class TC36_StartTime extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);

	// In this method the browser is invoked and url is opened
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	/*
	 * In this method the product is clicked and dash board slider is selected and
	 * displayed the start time text and splited the date and time of the product
	 * and validated the start date of the product
	 */
	@SuppressWarnings("static-access")
	@Test
	public void startTime() throws Exception {
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#3: Displaying the start time text");
	    String starttime=propReader.getValue("loc.starttime.txt");
	    String time=browser.getTextField().readTextByXPath(LocatorType.XPATH, starttime);
	    report.info(time);
	    report.info("Successfully displayed the start time text");
	log.info("STEP#4: Validating the start time text");
	    String expectedstarttext=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Start Text");
	    Verify.verifyString(expectedstarttext, time, "Successfully validated the text");
	    report.info("Successfully validated the text");
	log.info("STEP#5: Splitting the array and displaying the day and  date of the product");
		String product = propReader.getValue("validate.starttime.txt");
		String value = browser.getTextField().readTextByXPath(LocatorType.XPATH, product);
		report.info(value);
		report.info("Successfully displayed day and date of product");
		 String s1[]=value.split("[ ]");
		 String result=s1[0] + s1[1] + s1[2];
		 report.info(result);
	log.info("STEP#6: Validating the date of execution of the product");
	     String expected=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Date");
	     Verify.verifyString(result, expected, "Successfully validated the date");
	     report.info("Successfully validated the date");
	}
}