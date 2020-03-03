package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 27-01-2020
 * @updatedDate : 20-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T29]
 *  
 */

//In this the content of passed test cases is displayed and validated
public class TC29_PassedTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	
	
	/* 
	 * This test script covers the following functionalities
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the dash board slider option is selected or not 
	 * 3. Displaying the color of the pass test cases box
	 * 4. Verifying the color of the pass test case box
	 */
	@Test
	public void passTestCases() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on pass test cases");
		page.clickOnElement(read.getPropertyvalue("loc.passedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked pass test cases");
	log.info("STEP#4: Validating the number of pass test cases");	
		validate.validatePassTestCases();
		report.info("Successfully validated passed test cases");
	log.info("STEP#5: Validating the pass percentage of the product");	
		validate.validatePassPercent();
		report.info("Successfully validated pass percentage");
		wait.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#6: Creating a list to display all the test cases present");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(testcases);	
	}
}