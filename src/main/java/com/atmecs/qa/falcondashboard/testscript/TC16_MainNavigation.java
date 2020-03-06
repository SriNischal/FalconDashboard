package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 21-01-2020
 * @updatedDate : 11-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T16]
 *  
 */

//In this class the main navigation options are clicked and validated 
public class TC16_MainNavigation extends TestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	static ExtentTest test;
	static ExtentReports extentreport;
	String actualtitle;
	@BeforeClass
	public static void startTest() {
		extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		test = extentreport.startTest("MainNavigation");
	}
	
	
	/* 
	 * This test script covers the following functionalities of dash board page.
	 * 1. Verifying whether the main navigation bar is clicked or not
	 * 2. Validating the dash board text
	 * 3. Validating on the recent runs option
	 * 4. Verifying whether the recent runs option is clicked  or not
	 * 5. Validating the recent runs text
	 * 6. Validating the recent runs panel title
	 * 7. Validating the view option in the main navigation bar
	 * 8. Verifying whether the view option is clicked or not 
	 * 9. Validating the view page panel title
	 * 10. Validating the product snapshot in the main navigation bar
	 */  
	@Test
	public void mainNavigation() throws Exception {
		Waits wait=new Waits(browser);
		MainNavigationValidation validate=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.mainnavigation.btn");
		actualtitle = browser.getCurrentPageTitle();
	log.info("STEP#1: Clicking on the main navigation bar");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		Waits.isElementVisible(browser.getDriver(), "loc.mainnavigation.btn");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		wait.implicitWait();
	log.info("STEP#2: Validating the dashboard text");	
		validate.validateDashboard();
		report.info("Successfully validated dashboard"); 
		Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#3: Validating on the recent runs option");	
		validate.validateRecentruns();
		report.info("Successfully validated recent runs");
	log.info("STEP#4: Clicking on the recent runs option");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    Waits.isElementVisible(browser.getDriver(), "validate.text.txt");
	log.info("STEP#5: Validating the recent runs text");	
		validate.validateRecentRunsText();
		report.info("Successfully validated recentruns");
	log.info("STEP#6: Validating the recent runs panel title");	
		validate.validateRecentRunsPanelTitle();
		report.info("Successfully validated recent runs panel title");
	log.info("STEP#7: Validating the view option in main navigation");		
		validate.validateView();
		report.info("Successfully validated View");
	log.info("STEP#8: Clicking on the views option");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		wait.implicitWait();
	log.info("STEP#9: Validating the views panel title");	
		validate.validateViewPanelTitle();
		report.info("Successfully validated panelview");
		Waits.isElementVisible(browser.getDriver(), "validate.productsnapshot.txt");
	log.info("STEP#10: Validating the product snapshot text");	
		validate.validateProductSnapshotText();
		report.info("Successfully validated product snapshot");
		if (browser.getDriver().getTitle().equals(actualtitle)) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endTest() {
		extentreport.endTest(test);
		extentreport.flush();
	}
	}

