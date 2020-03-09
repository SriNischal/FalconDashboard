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

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 24-01-2020
 * @updatedDate : 17-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T24]
 *  
 */

//In this class the product snapshot bar is clicked and validated the tool tip message 
public class TC24_ProductSnapShot extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the product snapshot option is clicked or not 
	 * 2. Validating the product snapshot in the dash board page
	 */  
	@Test
	public void productSnapShot() throws Exception {
		Waits wait=new Waits(browser);
		MainNavigationValidation validate=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.snapshotbar.btn");
		test=extentreport.createTest("productSnapShot");
		Assert.assertTrue(true);
	log.info("STEP#1: Clicking on the product snapshot option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.snapshotbar.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product snapshot bar");
		wait.implicitWait();
	log.info("STEP#2: Validating the product snapshot text");	
		validate.validateProductSnapshot();
		report.info("Successfully validated product snapshot");
	}
	}