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
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;
//In this class the passed test cases are displayed
public class TC13_PassedTestCases extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	//In this method the product is clicked and created list display the pass test cases 
	@SuppressWarnings("static-access")
	@Test
	public void dropdownPassedTestCases() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		DropdownValidation validate=new DropdownValidation(browser);
		Pageactions page=new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		wait.isElementVisible(browser.getDriver(), "loc.passselectstatus.btn");
	log.info("STEP#2: Slecting the status option from the dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.passselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the pass status option"); 
	log.info("STEP#3: Validating the status option");	
		 validate.validatePassStatus();
		report.info("Successfully validated pass status");
		wait.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#4: Creating a list to display the passed test cases");
	    String products=propReader.getValue("loc.numberoftestcases.txt");
		list.listofElements(products);
	   report.info("Successfully validated the list of pass test cases");
		
	}
}
