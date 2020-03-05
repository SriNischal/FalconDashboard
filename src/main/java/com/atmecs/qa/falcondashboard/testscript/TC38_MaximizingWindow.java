package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;


import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 30-01-2020
 * @updatedDate : 26-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T38]
 *  
 */

//In this class the maximize window option is clicked and validated 
public class TC38_MaximizingWindow extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	
	
	/* 
	 * This test script covers the following functionalities of dashboard page.
	 * 1. Verifying whether the expand option is clicked or not
	 * 2. "Dashboard" text validation
	 * 3. Verifying whether the refresh option is clicked or not 
	 * 4. Atmecs logo test validation
	 */
	@Test
	public void maximizeWindow() throws Exception {
		Pageactions page=new Pageactions(browser);
		DashboardPageValidation validate = new DashboardPageValidation(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.expand.btn");
	log.info("STEP#1: Clicking on the expand button");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	log.info("STEP#2: Dashboard Text validation");
		validate.validateDashboard();
	log.info("STEP#3: Clicking on the refresh option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		report.info("Successfully validated dashboard text");
	log.info("STEP#4: Atmecs Text validation");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
		Waits.isElementVisible(browser.getDriver(), "loc.expand.btn");
	log.info("STEP#5: Clicking on the expand button");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.expand.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the expand button");
	}
}