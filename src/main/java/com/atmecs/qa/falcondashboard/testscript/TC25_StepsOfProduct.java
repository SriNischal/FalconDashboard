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
//In this class the steps of the product are displayed and validated 
public class TC25_StepsOfProduct extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the product is clicked and selected the status option from the
	 * drop down and created a list to display the test cases and clicked on the test
	 * case and validated the data present under the steps option
	 */
	@SuppressWarnings("static-access")
	@Test
	public void stepsOfProduct() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		Pageactions page=new Pageactions(browser);
		ProductStepsValidation validate=new ProductStepsValidation(browser);
		wait.safeWait();
		Thread.sleep(7000);
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		wait.implicitWait();
	log.info("STEP#2: Selecting the pass option from the status dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.passselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected pass option");
		 Thread.sleep(5000);
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