package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
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

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 03-01-2020
 * @updatedDate : 03-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T03]
 *  
 */

//In this list of the total test cases is displayed and validated and tooltip message test  cases is validated
public class TC03_TestCases extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	/* 
	 * This test script covers the following functionalities of dashboard page.
	 * 1. List of the products available and the size of the test cases of the products
	 * 2. The list of test cases converted into string of products
	 * 3. Verifying the list of test cases of the products
	 * 4. Mouse hovered over the test cases to display the tool tip message 
	 * 5. Validating the tool tip message of the products
	 */
	@Test
	public void numberofTestCasesOfProduct() throws Exception {
		ElementsList lists=new ElementsList(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.totaltestcase.txt");
	log.info("STEP#1: Creating list to display total test cases of the products");	
		String products=propReader.getValue("loc.totaltestcase.txt");
		lists.listofElements(products);
	log.info("STEP#2: Converting the list of products into string products");	
		lists.separatingElements(products);
    log.info("STEP#3: Verifying the list of product test cases");
		String result = lists.separatingElements(products);
		page.writedata_toExcel(sheetname,columnname, 13, result);
		String expedctedproducts=page.getdata_fromExcel(sheetname, columnname, "Total test cases");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the test cases");
		report.info("Successfully valdated all the test cases");
	log.info("STEP#4: Mouse hovering the testcases for the products");
	     page.mouseOver(ReadLocators.getPropertyvalue("loc.testcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the test cases");
	log.info("STEP#5: Displaying the testcases message for the products");	
	     String actualtooltipmessage=propReader.getValue("loc.testcasemessage.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     page.writedata_toExcel(sheetname, columnname, 56, message);
	     String expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Tooltip message");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	     page.windowHandle();
	}

}