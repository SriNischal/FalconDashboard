package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;

public class TC38_MaximizingWindow extends SampleTestSuiteBase{
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
	@SuppressWarnings("static-access")
	@Test
	public void maximizeWindow() throws Exception {
		Pageactions page=new Pageactions(browser);
		DashboardPageValidation validate = new DashboardPageValidation(browser);
	log.info("STEP#1: Clicking on the expand button");	
		page.clickOnElement(read.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	log.info("STEP#2: Dashboard Text validation");
		validate.validateDashboardtext();
	log.info("STEP#3: Clicking on the refresh option");
		page.clickOnElement(read.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		report.info("Successfully validated dashboard text");
	log.info("STEP#4: Atmecs Text validation");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
		browser.getWait().safeWait(2000);
	log.info("STEP#5: Clicking on the expand button");	
		page.clickOnElement(read.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	}
}
