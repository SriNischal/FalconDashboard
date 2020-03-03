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
import com.atmecs.qa.falcondashboard.validationresults.ProductStepsValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 24-01-2020
 * @updatedDate : 17-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T25]
 *  
 */

//In this class the steps of the product are displayed and validated 
public class TC25_StepsOfProduct extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the product is clicked or not
	 * 2. Verifying the pass option from the status drop down is selected or not
	 * 3. List to display the test cases and duration of each test cases
	 * 4. List to display the status of the products
	 * 5. Verifying the test cases of the product is clicked or not
	 * 6. Validating the status option
	 * 7. Validating the details option
	 * 8. Validating the test case option
	 * 9. Validating the request body text
	 */  
	@Test
	public void stepsOfProduct() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		Pageactions page=new Pageactions(browser);
		ProductStepsValidation validate=new ProductStepsValidation(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the pass option from the status dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.passselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected pass option");
		 wait.isElementVisible(browser.getDriver(), "loc.duration.txt");
	log.info("STEP#3: Creating the list for the test cases and duration of each test case of the product");	
	    String duration=propReader.getValue("loc.duration.txt");
		list.listofElements(duration);
	log.info("STEP#4: Creating the list for the status of the product");
	     String passtestcases=propReader.getValue("loc.passtestcases.txt");
		list.listofElements(passtestcases);
	log.info("STEP#5: Clicking on the test case of the product");
		page.clickOnElement(read.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the testcase");
	log.info("STEP#6: Validating the status option");
		validate.validateStatusOption();
		report.info("Successfully validated Status option");
	log.info("STEP#7: Validating the details option");
		validate.validateDetailsOption();
		report.info("Successfully validated Details option");
	log.info("STEP#8: Validating the test case option");
		validate.validateTestCase();
		report.info("Successfully validated the test case");
	log.info("STEP#9: Validating the Request body text");
		validate.validateRequestBody();
		report.info("Successfully validated Request Body");
		
		
	}

}
