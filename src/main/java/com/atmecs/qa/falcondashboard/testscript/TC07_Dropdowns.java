package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 08-01-2020
 * @updatedDate : 05-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T07]
 *  
 */

//In this class the drop downs are displayed and validated
public class TC07_Dropdowns extends TestSuiteBase {
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String locatorvalue;
	static ExtentTest test;
	static ExtentReports extentreport;
	String actualtitle;
	@BeforeClass
	public static void startTest() {
		extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		test = extentreport.startTest("Dropdowns");
	}
	/* 
	 * This test script covers the following functionalities of product page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. The value from the customer drop down is selected 
	 * 3. Validating the customer drop down value
	 * 4. The value from the module drop down is selected 
	 * 5. Validating the module drop down value
	 * 6. The value from the status drop down is selected 
	 * 7. Validating the status drop down value 
	 */
	@Test
	public void dropdown() throws Exception {
		DropdownValidation validate = new DropdownValidation(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
		actualtitle = browser.getCurrentPageTitle();
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
	    Waits.isElementVisible(browser.getDriver(), "loc.customer.txt");
	log.info("STEP#2: Selecting the customer option from the dropdown");
	    locatorvalue=ReadLocators.getPropertyvalue("loc.customer.txt", ProjectBaseConstantPaths.LOCATORS_FILE);
		page.clickOnElement(locatorvalue);
		report.info("Successfully selected customer option");
	log.info("STEP#3: Validating the customer dropdown  value");	
		validate.validateCustomer();
		report.info("Successfully validated customer");
	log.info("STEP#4: Selecting the module option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.module.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the module option");
	log.info("STEP#5: Validating the module drop down value");	
		 validate.validateModule(); 
		 report.info("Successfully validated module");
	log.info("STEP#6: Slecting the status option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the status option"); 
	log.info("STEP#7: Validating the status drop down option");	
		 validate.validateFailStatus();
		report.info("Successfully validated status");
		page.windowHandle();
		if (browser.getDriver().getTitle().equals(actualtitle)) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endTest() {
		extentreport.endTest(test);
		extentreport.flush();
	}
	}