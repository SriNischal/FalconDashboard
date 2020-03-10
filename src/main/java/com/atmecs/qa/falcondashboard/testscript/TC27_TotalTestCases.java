package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
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
 * @createdDate : 27-01-2020
 * @updatedDate : 19-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T27]
 *  
 */

//In this class the content of total test cases is displayed and displayed
public class TC27_TotalTestCases extends TestSuiteBase{
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
	 * 3. Verifying whether the total test cases option is clicked or not
	 * 4. Validating the test cases text 
	 * 5. Validating the time taken to run the product
	 * 6. List to display all the test cases of the product
	 */  
	@Test
	public void totalTestCases() throws Exception {
		ElementsList list=new ElementsList(browser);
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		test=extentreport.createTest("totalTestCases");
		Assert.assertTrue(true);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
		Waits.isElementVisible(browser.getDriver(), "loc.totaltestcases.txt");
	log.info("STEP#3: Clicking on total test cases");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.totaltestcases.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked total test cases");
	log.info("STEP#4: Validating the test cases text");	
		validate.validateTestCases();
		report.info("Successfully validated test cases");
	log.info("STEP#5: Validating the time taken to run the product");	
		validate.validateTime();
		report.info("Successfully validated the run time");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#6: Creating a list to display all the test cases present");
	    testcases=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(testcases);	
	}
	}
