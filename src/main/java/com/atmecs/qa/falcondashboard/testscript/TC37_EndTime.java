package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Splitting;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 29-01-2020
 * @updatedDate : 26-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T37]
 *  
 */

//In this class the end time of the product is displayed and validated 
public class TC37_EndTime extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the dash board slider is selected or not 
	 * 3. Displaying the end time text
	 * 4. Validating the end time text
	 * 5. Splitting and displaying the day and date of the product
	 * 6. Validating the date of execution of the product
	 */
	@Test
	public void endTime() throws Exception {
		 Waits wait=new Waits(browser);
		 Splitting split=new Splitting(browser);
		Pageactions page = new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#3: Displaying the end time text");
	    String endtime=propReader.getValue("loc.endtime.txt");
	    String time=browser.getTextField().readTextByXPath(LocatorType.XPATH, endtime);
	    report.info(time);
	    report.info("Successfully displayed the end time text");
	log.info("STEP#4: Validating the start time text");
	    String expectedendtext=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "End Text");
	    Verify.verifyString(expectedendtext, time, "Successfully validated the text");
	    report.info("Successfully validated the text");
	log.info("STEP#5: Splitting the array and displaying the day and  date of the product");
	     String result=split.splitofdatetime(2);
	log.info("STEP#6: Validating the date of execution of the product");
	     page.writedata_toExcel("REST API TEST RESULT", "Validation Text",21, result);
	     String expected=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Date");
	     Verify.verifyString(result, expected, "Successfully validated the date");
	     report.info("Successfully validated the date");
	}
}