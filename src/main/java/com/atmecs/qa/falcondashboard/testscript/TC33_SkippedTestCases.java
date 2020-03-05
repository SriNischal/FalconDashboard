package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
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
 * @createdDate : 28-01-2020
 * @updatedDate : 24-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T33]
 *  
 */

//In this class the content of the skip test cases are displayed and validated
public class TC33_SkippedTestCases extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String testcases;
	
	
	/* 
	 * This test script covers the following functionalities
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the dash board slider option is selected or not 
	 * 3. Displaying the color of the skip test cases box
	 * 4. Verifying the color of the skip test case box
	 * 5. Validating the time taken to run the product
	 * 6. List to display all the skip test cases of the product
	 */
	@Test
	public void skippedTestCases() throws Exception {
		ElementsList list=new ElementsList(browser);
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on skip test cases");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.skipedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked pass test cases");
	log.info("STEP#4: Validating the number of skipped test cases");	
		validate.validateSkipTestCases();
		report.info("Successfully validated Skipped test cases");
	log.info("STEP#5: Validating the skip text");	
	    validate.validateSkipMessage();
		report.info("Successfully validated skip message");
		Waits.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#6: Creating a list to display all the test cases present");
	    testcases=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(testcases);	
	}
}