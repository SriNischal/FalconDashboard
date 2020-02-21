package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

//In this class the total test cases of the product are displayed
public class TC03_TestCases extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;
	/*
	 * In this method we create list to display the test cases and validate the test
	 * cases and validate the tool tip message by mouse hovering over the test cases
	 */ 
	@SuppressWarnings("static-access")
	@Test
	public void numberofTestCasesOfProduct() throws Exception {
		ValidationHelper helper=new ValidationHelper(browser);
		ElementsList lists=new ElementsList(browser);
		Pageactions page = new Pageactions(browser);
		Waits wait=new Waits(browser);
		wait.isElementVisible(browser.getDriver(), "loc.totaltestcase.txt");
	log.info("STEP#1: Creating list to display total test cases of the products");	
		String products=propReader.getValue("loc.totaltestcase.txt");
		lists.listofElements(products);
	log.info("STEP#2: Converting the list of products into string products");	
		lists.separatingElements(products);
    log.info("STEP#3: Verifying the list of product test cases");
        String product=helper.getData();
		String result = lists.separatingElements(products);
		page.writedata_toExcel(product,"Validation Text", 13, result);
		String expedctedproducts=page.getdata_fromExcel(product, "Validation Text", "Total test cases");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the test cases");
		report.info("Successfully valdated all the test cases");
	log.info("STEP#4: Mouse hovering the testcases for the products");
	     page.mouseOver(ReadLocators.getPropertyvalue("loc.testcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the test cases");
	log.info("STEP#5: Displaying the testcases message for the products");	
	     String actualtooltipmessage=propReader.getValue("loc.testcasemessage.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     page.writedata_toExcel(product, "Validation Text", 56, message);
	     String expectedtooltipmessage=page.getdata_fromExcel(product, "Validation Text", "Tooltip message");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	}

}
