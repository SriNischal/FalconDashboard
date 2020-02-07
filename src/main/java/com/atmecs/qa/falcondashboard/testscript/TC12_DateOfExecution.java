package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;

public class TC12_DateOfExecution extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	LoadProperties load = new LoadProperties();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	LogReport log=new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;
	

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
	@SuppressWarnings("static-access")
	@Test
	public void dateOfExecution() throws Exception {
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getWait().safeWait(2000);
	log.info("STEP#2: Splitting the array and displaying the day and  date of the product");
		String product = propReader.getValue("loc.product.txt");
		String value = browser.getTextField().readTextByXPath(LocatorType.XPATH, product);
		String[] arrOfStr = value.split(":", 3);
		String date=arrOfStr[2];
		System.out.println(date);
		report.info("Successfully displayed day and date of product");
		 String s1[]=date.split("[ ]");
		 String result=s1[1] + s1[2] + s1[3];
		 System.out.println(result);
	log.info("STEP#3: Validating the date of the product");	 
		 String expected=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Date");
		 Verify.verifyString(result, expected, "Successfully validated the date");
		 report.info("Successfully validated the date");
	}
}
