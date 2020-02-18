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
//In this class the recent runs is clicked and validated 
public class TC17_RecentRuns extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadingData data=new ReadingData();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the recent runs option is clicked and validated whether the
	 * user landed on to the recent runs page and validated the content present in
	 * the recent runs page
	 */
	@Test
	public void recentrun() throws Exception {
		Waits wait=new Waits(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the recent runs option");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		wait.safeWait();
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
