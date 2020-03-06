package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ExtentReport;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//In this the functionalities of the dash board page are validated they are text,logo text and verified the refresh option

public class TC01_DashBoardPage extends TestSuiteBase {

	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	ReadingData data = new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String actualtitle;
	String expectedtitle; 
	static ExtentTest test;
	static ExtentReports extentreport;
	
	
	/* 
	 * This test script covers the following functionalities of dashboard page.
	 * 1. Page title validation
	 * 2. "Dashboard" text validation
	 * 3. Verifying whether the refresh option is clicked or not 
	 * 4. Atmecs logo test validation
	 */
	@Test
	public void dashboardPage() throws Exception {
		ExtentReport reports=new ExtentReport(browser);
		Pageactions page = new Pageactions(browser);
		DashboardPageValidation validate = new DashboardPageValidation(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.refresh.btn");
	log.info("STEP#1: Page title validation");
		actualtitle = browser.getCurrentPageTitle();
	    expectedtitle = data.getdata_fromExcel(sheetname, columnname, "Page URL");
		Verify.verifyString(actualtitle, expectedtitle, "Validting page url is same as expected or not ");
		report.info("successfully validated page title");
		reports.extentReport(actualtitle);
	log.info("STEP#2: Dashboard Text validation");
		validate.validateDashboard();
		report.info("Successfully validated the dashboard text");
	log.info("STEP#3: Clicking on the refresh option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
	log.info("STEP#4: Atmecs logo Text validation");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
	}
	@AfterClass
	public static void endTest() {
		extentreport.endTest(test);
		extentreport.flush();
	}

}