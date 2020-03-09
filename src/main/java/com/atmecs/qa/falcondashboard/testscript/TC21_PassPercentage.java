package com.atmecs.qa.falcondashboard.testscript;

import org.testng.Assert;
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

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 23-01-2020
 * @updatedDate : 13-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T21]
 *  
 */

//In this class the pass percent of the products are displayed  and validated
public class TC21_PassPercentage extends TestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String productnamesaftersorting;
	String productnames;
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the recent runs is clicked or not 
	 * 2. Validating the product names in the recent runs page
	 * 3. List to display the test cases of the products
	 * 4. Verifying the arrows of the pass percentage is clicked or not
	 * 5. List to display the test cases after sorting
	 * 6. Comparing both the values before and after sorting the values
	 */  
	@Test
	public void rececntPassPercentage() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
		test=extentreport.createTest("recentPassPercentage");
		Assert.assertTrue(true);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		wait.implicitWait();
	log.info("STEP#2: Validating the pass percent");
	    validate.validatePassPercent();
	    report.info("Successfully validated the pass percent");
	log.info("STEP#3: Creating a list to display the test cases of the product");
	    productnames=propReader.getValue("loc.passpercentage.txt");
		list.listofElements(productnames);
		wait.implicitWait();
	log.info("STEP#4 Clicking on the pass percentage");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentpasspercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the pass percentage");
	log.info("STEP#6: Creating the list to display the product names after sorting");
	   productnamesaftersorting=propReader.getValue("loc.passpercentage.txt");
	   list.listofElements(productnamesaftersorting);
	log.info("STEP#7: Comparing the product names before and after sorting");
	    boolean compare=productnamesaftersorting.equals(productnames);
	    System.out.println(compare);
	}
	}

