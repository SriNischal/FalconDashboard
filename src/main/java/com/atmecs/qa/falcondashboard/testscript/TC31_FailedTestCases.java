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
//In this class the content of the failed test cases is displayed and validated
public class TC31_FailedTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the product is clicked and dash board slider is selected and
	 * clicked on the failed test cases and validated the failed test cases and the
	 * fail message and displayed the failed test cases
	 */
	@SuppressWarnings("static-access")
	@Test
	public void failTestCases() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		wait.safeWait();
		Thread.sleep(7000);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		wait.implicitWait();
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on fail test cases");
		page.clickOnElement(read.getPropertyvalue("loc.failedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked fail test cases");
	log.info("STEP#5: Validating the number fail test cases");	
		validate.validateFailTestCases();
		report.info("Successfully validated Failed test cases");
	log.info("STEP#6: Validating the fail message ");	
		validate.validateFailMessage();
		report.info("Successfully validated fail message");
		wait.safeWait();
	log.info("STEP#7: Creating a list to display all the test cases present");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(testcases);	
	}
}
