package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 22-01-2020
 * @updatedDate : 12-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T19]
 *  
 */

//In this class the product components are  displayed and validated 
public class TC19_ProductComponent extends TestSuiteBase {
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String components;
	String componentslist;
	String componentstext;
	static ExtentTest test;
	static ExtentReports extentreport;
	String actualtitle;
	@BeforeClass
	public static void startTest() {
		extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		test = extentreport.startTest("ProductComponent");
	}
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the recent runs is clicked or not 
	 * 2. Validating the product names in the recent runs page
	 * 3. List to display the components of the products
	 * 4. Verifying the arrows of the recent runs page are clicked or not 
	 * 5. List to display the product components after sorting
	 * 6. Comparing both the values before and after sorting the values
	 */  
	@Test
	public void componentOfProduct() throws Exception {
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate = new RecentrunsValidation(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.componentofproduct.btn");
		actualtitle = browser.getCurrentPageTitle();
	log.info("STEP#1: Creating the list to display the components of the products ");
		componentslist = propReader.getValue("loc.componentofproduct.btn");
		list.listofElements(componentslist);
	log.info("STEP#2: Clicking on the recent runs option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		Waits.isElementVisible(browser.getDriver(), "loc.componentlist.txt");
	log.info("STEP#3: Creating the list to display the components of the products");
		components = propReader.getValue("loc.componentlist.txt");
		list.listofElements(components);
	log.info("STEP#4: Clicking on the component for sorting the data");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
	log.info("STEP#5: Validating the component of the product");
		validate.validateComponent();
		report.info("Successfully validated component text");
	log.info("STEP#6: Clicking on the component of the project for sorting the data ");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.component.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on component");
	log.info("STEP#7: Creating the list to display the component of the products");
		componentstext= propReader.getValue("loc.componentlist.txt");
		list.listofElements(componentstext);
	log.info("STEP#8: Comparing the lists to see whether both the list are same or  not");
		boolean compare = componentstext.equals(components);
		System.out.println(compare);
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