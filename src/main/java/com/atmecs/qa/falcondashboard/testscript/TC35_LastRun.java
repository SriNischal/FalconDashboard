package com.atmecs.qa.falcondashboard.testscript;

import org.openqa.selenium.WebDriver;
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
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 29-01-2020
 * @updatedDate : 25-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T35]
 *  
 */

//In this classes the last runs in the recent runs page is clicked and validated the last runs
public class TC35_LastRun extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	WebDriver driver; 
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	
	
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the recent runs is clicked or not 
	 * 2. Validating the last runs in the recent runs page
	 * 3. List to display the last runs of the products
	 * 4. Verifying the arrows of the last runs are clicked or not 
	 * 5. List to display the product last runs after sorting
	 * 6. Comparing both the values before and after sorting the values
	 */
	@Test
	public void lastRun() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		wait.implicitWait();
	log.info("STEP#2: Validating the last run");
	    validate.validateLastRun();
	    report.info("Successfully validated the last run");
	log.info("STEP#3: Creating a list to display the last run of the product");
	    String lastruns=propReader.getValue("loc.lastrun.txt");
		list.listofElements(lastruns);
		wait.implicitWait();
	log.info("STEP#4 Clicking on the last run");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the last runs");
	   wait.implicitWait();
	log.info("STEP#5: Creating the list to display the last runs after sorting");
	    String lastrunsaftersorting=propReader.getValue("loc.lastrun.txt");
	   list.listofElements(lastrunsaftersorting);
	log.info("STEP#6: Comparing the last runs before and after sorting");
	    boolean compare=lastrunsaftersorting.equals(lastruns);
	    System.out.println(compare);
	}
}