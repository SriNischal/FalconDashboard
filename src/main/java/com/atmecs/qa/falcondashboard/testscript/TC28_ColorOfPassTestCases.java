package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 27-01-2020
 * @updatedDate : 19-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T28]
 *  
 */

//In this class the color of the passed test cases is displayed and validated 
public class TC28_ColorOfPassTestCases extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String actualcolor;
	String color;
	String expectedcolor;
	/* 
	 * This test script covers the following functionalities
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the dash board slider option is selected or not 
	 * 3. Displaying the color of the pass test cases box
	 * 4. Verifying the color of the pass test case box
	 */  
	@Test
	public void colorofPassedTestCases() throws Exception {
	    Pageactions page=new Pageactions(browser);
	    Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
    log.info("STEP#1: Clicking on the product");
        page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#3: Displaying the color of the pass test case box");
	    Waits.isElementVisible(browser.getDriver(), "validate.colorofpasstestcases.txt");
	    color=propReader.getValue("validate.colorofpasstestcases.txt");
	    actualcolor=browser.getFindFromBrowser().findElementByXpath(color).getCssValue("background-color");
	log.info("STEP#4: Veifying the color of the pass test case box");
	    page.writedata_toExcel(sheetname, columnname, 32, actualcolor);
	    expectedcolor= page.getdata_fromExcel(sheetname, columnname, "Color of pass test cases");
	    Verify.verifyString(actualcolor, expectedcolor, "Validating the color of the pass test cases is same as expected or not");
	    report.info("Successfully validated the color of the pass  test cases box");
	}
	}