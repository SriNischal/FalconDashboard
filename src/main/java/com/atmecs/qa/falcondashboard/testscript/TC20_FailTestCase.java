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
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;
//In this class the error message of the fail test case is displayed and validated 
public class TC20_FailTestCase extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	ReadLocators read = new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	/*
	 * In this method the product is clicked and selected the fail test case and
	 * validated the test case name and clicked on the test case name and clicked on
	 * the error option and validated the error message
	 */
	@Test
	public void failTestCasesOfProduct() throws Exception {
		Pageactions page = new Pageactions(browser);
		DropdownValidation validate=new DropdownValidation(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.failselectstatus.btn");
	log.info("STEP#2: Slecting the status option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the status option"); 
	log.info("STEP#3: Validating the status option");	
		 validate.validateFailStatus();
		report.info("Successfully validated status");
	    Waits.isElementVisible(browser.getDriver(), "loc.testcase.btn");
	log.info("STEP#4: Clicking on the test case of the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on test case");
	log.info("STEP#3: Validating the panel title of the test case");
	    Waits.isElementVisible(browser.getDriver(), "validate.paneltitle.txt");
		validate.validateProductPanelTitle();
		report.info("Successfully validated paneltitle");
	log.info("STEP#5: Clicking on the error option of the test case");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.error.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		Waits.isElementVisible(browser.getDriver(), "validate.errormessage.txt");
	log.info("STEP#6: Validating the error message of the test case ");
		validate.validateErrorMessage();
		report.info("Successfully validated error message");

	}
}