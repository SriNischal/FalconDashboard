package com.atmecs.qa.falcondashboard.testscript;

import org.testng.Assert;

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
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 29-01-2020
 * @updatedDate : 24-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T34]
 *  
 */

//In this class the view page is clicked and validated the functionalities present
public class TC34_ViewPage extends TestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	
	/* 
	 * This test script covers the following functionalities of dashboard page.
	 * 1. Validating the view option
	 * 2. Verifying whether the view option is clicked or not
	 * 3. Validating the panel title of the views page 
	 * 4. Verifying whether the dash board slider is selected or not
	 * 5. Verifying whether the download option is clicked or not
	 */
	@Test
	public void viewPage() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		MainNavigationValidation validation=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.view.btn");
		test=extentreport.createTest("viewPage");
		Assert.assertTrue(true);
	log.info("STEP#1: Validating the view  option");	
		validate.validateText();
		report.info("Successfully validated views");
	log.info("STEP#2: Clicking on the views option");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		Waits.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#3: Validating the panel title of the views page");
	    validation.validateViewPanelTitle();
	    report.info("Successfully validated the views panel title");
    log.info("STEP#4: Selecting the dashboard slider option");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#5: Clicking on the download option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");	
	}
	}
