package com.atmecs.qa.falcondashboard.testscript;

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
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
//In this class the expand option is clicked and validated 
public class TC38_MaximizingWindow extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the expand option is clicked and validated whether all the
	 * content is displayed correctly by expanding option
	 */	@SuppressWarnings("static-access")
	@Test
	public void maximizeWindow() throws Exception {
		 Waits wait=new Waits(browser);
		Pageactions page=new Pageactions(browser);
		DashboardPageValidation validate = new DashboardPageValidation(browser);
		wait.isElementVisible(browser.getDriver(), "loc.expand.btn");
	log.info("STEP#1: Clicking on the expand button");	
		page.clickOnElement(read.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	log.info("STEP#2: Dashboard Text validation");
		validate.validateDashboard();
	log.info("STEP#3: Clicking on the refresh option");
		page.clickOnElement(read.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		report.info("Successfully validated dashboard text");
	log.info("STEP#4: Atmecs Text validation");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
		wait.isElementVisible(browser.getDriver(), "loc.expand.btn");
	log.info("STEP#5: Clicking on the expand button");	
		page.clickOnElement(read.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	}
}
