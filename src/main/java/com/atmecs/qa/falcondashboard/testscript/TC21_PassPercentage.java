package com.atmecs.qa.falcondashboard.testscript;

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
//In this class the pass percent of the products is displalyed 
public class TC21_PassPercentage extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the recent runs is clicked and validated the pass percent
	 * title and and created a list to display the pass percentages of the products
	 * and clicked on the pass percent for sorting the values and created another
	 * list to get the sorted list and compared both the lists
	 */
	@Test
	public void rececntPassPercentage() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		wait.implicitWait();
	log.info("STEP#2: Validating the pass percent");
	    validate.validatePassPercent();
	    report.info("Successfully validated the pass percent");
	log.info("STEP#3: Creating a list to display the test cases of the product");
	    String productnames=propReader.getValue("loc.passpercentage.txt");
		list.listofElements(productnames);
		wait.implicitWait();
	log.info("STEP#4 Clicking on the pass percentage");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentpasspercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the pass percentage");
	log.info("STEP#6: Creating the list to display the product names after sorting");
	    String productnamesaftersorting=propReader.getValue("loc.passpercentage.txt");
	   list.listofElements(productnamesaftersorting);
	log.info("STEP#7: Comparing the product names before and after sorting");
	    boolean compare=productnamesaftersorting.equals(productnames);
	    System.out.println(compare);
	}

}
