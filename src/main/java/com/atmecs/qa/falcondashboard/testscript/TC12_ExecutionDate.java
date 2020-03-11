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
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Splitting;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 10-01-2020
 * @updatedDate : 07-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T12]
 *  
 */

//In this class the date of last execution of the product is displayed and validated
public class TC12_ExecutionDate extends TestSuiteBase{
	ReadLocators read=new ReadLocators();
	LoadProperties load = new LoadProperties();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	LogReport log=new LogReport();
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String expected;
	String result;
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the dash board slider is selected or not 
	 * 3. Validating the environment of the product
	 */
	@Test
	public void dateOfExecution() throws Exception {
		 Splitting split=new Splitting(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(), "loc.product.txt");
	log.info("STEP#2: Splitting the array and displaying the day and  date of the product");
		result=split.splitofdatetime(2);
	log.info("STEP#3: Validating the date of the product");	 
	     page.writedata_toExcel(sheetname, columnname,21, result);
		 expected=page.getdata_fromExcel(sheetname, columnname, "Date");
		 Verify.verifyString(result, expected, "Validating the date of the product is same as expected or not");
		 report.info("Successfully validated the date");
		}
	}
