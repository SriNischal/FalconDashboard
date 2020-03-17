package com.atmecs.qa.falcondashboard.testscript;

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
 * @createdDate : 22-01-2020
 * @updatedDate : 12-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T18]
 *  
 */

//In this  class the product names are displayed and validated 
public class TC18_ProductName extends TestSuiteBase {
	LoadProperties load = new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String productnamesaftersorting;
	String productnames;
	
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the recent runs is clicked or not 
	 * 2. Validating the product names in the recent runs page
	 * 3. List to display the names of the products
	 * 4. Verifying the arrows of the recent runs page are clickedS
	 * 5. List to display the product names after sorting
	 * 6. Comparing both the values before and after sorting the values
	 */  
	@Test
	public void productName() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		Waits.isElementVisible(browser.getDriver(), "loc.productnames.txt");
	log.info("STEP#2: Validating the product names");
	    validate.validateProductName();
	    report.info("Successfully validated the product name");
	log.info("STEP#3: Creating a list to display the names of the product");
	    productnames=propReader.getValue("loc.productnames.txt");
		list.listofElements(productnames);
		wait.implicitWait();
	log.info("STEP#4: Clicking on the product name");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.productnamestext.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Succesfully clicked on the product");
	log.info("STEP#5: Creating the list to display the product names after sorting");
	   productnamesaftersorting=propReader.getValue("loc.productnames.txt");
	   list.listofElements(productnamesaftersorting);
	log.info("STEP#6: Comparing the product names before and after sorting");
	    boolean compare=productnamesaftersorting.equals(productnames);
	    System.out.println(compare);
	}
	}