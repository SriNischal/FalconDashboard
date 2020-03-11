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
 * @createdDate : 23-01-2020
 * @updatedDate : 14-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T23]
 *  
 */

//In this class the refresh option is clicked and verified
public class TC23_Refresh extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Validating the dash board text 
	 * 2. Verifying whether the refresh option is clicked or not
	 */  
	@Test
	public void refresh() throws Exception {
		DashboardPageValidation validate=new DashboardPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.refresh.btn");
	log.info("STEP#1: Dashboard Text validation");
		validate.validateDashboard();
		report.info("Successfully validated dashboard text");
		Waits.isElementVisible(browser.getDriver(), "loc.refresh.btn");
	log.info("STEP#2: Clicking on the refresh option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the refresh option");
	}
}