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
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 20-01-2020
 * @updatedDate : 10-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T14]
 *  
 */

//In this class the fail test cases are displayed 
public class TC14_FailedTestCases extends TestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String products;
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the status option is selected or not 
	 * 3. Validating the value of the status drop down of the product
	 * 4. List to display the failed test cases 
	 */ 
	@Test
	public void dropdownFailedTestCases() throws Exception {
		ElementsList list=new ElementsList(browser);
		DropdownValidation validate=new DropdownValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
        page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.failselectstatus.btn");
	log.info("STEP#2: Slecting the status option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the fail status option"); 
	log.info("STEP#3: Validating the status option");	
		 validate.validateFailStatus();
		report.info("Successfully validated fail status");
		Waits.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#4: Creating a list to display the failed test cases");
	    products=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(products);
	   report.info("Successfully displayed the fail test cases");
}
}