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
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;

public class TC34_ViewPage extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	ReadingData data=new ReadingData();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
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
	@SuppressWarnings("static-access")
	@Test
	public void viewPage() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Validating the view  option");	
		validate.validateText();
		report.info("Successfully validated views");
	log.info("STEP#2: Clicking on the views option");	
		page.clickOnElement(read.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#3: Selecting the dashboard slider option");	
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#4: Validating the test cases text");	
		validate.validateTestCases();
		report.info("Successfully validated test cases");
	log.info("STEP#5: Validating the time taken to run the product");	
		validate.validateTime();
		report.info("Successfully validated the run time");
	log.info("STEP#6: Validating the number of pass test cases");	
		validate.validatePassTestCases();
		report.info("Successfully validated passed test cases");
	log.info("STEP#7: Validating the pass percentage of the product");	
		validate.validatePassPercent();
		report.info("Successfully validated pass percentage");
	log.info("STEP#8: Validating the number fail test cases");	
		validate.validateFailTestCases();
		report.info("Successfully validated Failed test cases");
	log.info("STEP#9: Validating the fail message ");	
		validate.validateFailMessage();
		report.info("Successfully validated fail message");
	log.info("STEP#10: Validating the number of skipped test cases");	
		validate.validateSkipTestCases();
		report.info("Successfully validated Skipped test cases");
	log.info("STEP#1: Validating the skip text");	
	    validate.validateSkipMessage();
		report.info("Successfully validated skip message");

	}
}
