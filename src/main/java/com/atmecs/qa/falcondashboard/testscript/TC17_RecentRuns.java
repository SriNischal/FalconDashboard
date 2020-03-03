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
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 21-01-2020
 * @updatedDate : 12-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T17]
 *  
 */

//In this class the recent runs is clicked and validated 
public class TC17_RecentRuns extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadingData data=new ReadingData();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	
	
	/* 
	 * This test script covers the following functionalities of dash board page.
	 * 1. Verifying whether the recent runs option  is clicked or not
	 * 2. Validating the title of the recent runs page
	 * 3. Validating the panel title of the recent runs page
	 * 4. Validating the product title in the recent runs page
	 * 5. Validating the component of the recent runs page
	 * 6. Validating the test cases of the product in the recent runs page
	 * 7. Validating the pass percentage of the products in the recent runs page
	 * 8. Validating the last runs of the products in the recent runs page
	 */  
	@Test
	public void recentrun() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits wait=new Waits(browser);
		wait.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#1: Clicking on the recent runs option");	
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
	log.info("STEP#2: Validating the title of the page");	
	    validate.validateText();
		report.info("Successfully validated recentruns");
	log.info("STEP#3: Validating the panel title of the page");	
	    validate.validatePanelTitle();
		report.info("Successfully validated reports");
	log.info("STEP#4: Validating the product title in the recent runs page");
		validate.validateProductName();
		report.info("Successfully validated product name");
	log.info("STEP#5: Validating the component of the page");
		validate.validateComponent();
		report.info("Successfully validated the component text");
	log.info("STEP#6: Validating the test case of the page");
		validate.validateTestCase();
		report.info("Successfully validated textcases with # symbol");
	log.info("STEP#7: Validating the pass percent of the page");
		validate.validatePassPercent();
		report.info("Successfully validated the passpercent with % symbol");
	log.info("STEP#8: Validating the last run of the page");
		validate.validateLastRun();
		report.info("Successfully validated lastruns");
	}
}