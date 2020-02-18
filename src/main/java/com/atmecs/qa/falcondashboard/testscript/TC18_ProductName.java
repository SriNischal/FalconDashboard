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
//In this  class the product name is validated
public class TC18_ProductName extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the recent runs option is clicked and the list is created to
	 * display the product names and clicked on the product names to sort the values
	 * and created another list to display the sorted names and compared both the
	 * values to see that both the lists are different
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void productName() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		wait.implicitWait();
	log.info("STEP#2: Validating the product names");
	    validate.validateProductName();
	    report.info("Successfully validated the product name");
	log.info("STEP#3: Creating a list to display the names of the product");
	    String productnames=propReader.getValue("loc.productnames.txt");
		list.listofElements(productnames);
		wait.implicitWait();
	log.info("STEP#5: Clicking on the product name");
	    page.clickOnElement(read.getPropertyvalue("loc.productnamestext.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Succesfully clicked on the product");
	log.info("STEP#6: Creating the list to display the product names after sorting");
	    String productnamesaftersorting=propReader.getValue("loc.productnames.txt");
	   list.listofElements(productnamesaftersorting);
	log.info("STEP#7: Comparing the product names before and after sorting");
	    boolean compare=productnamesaftersorting.equals(productnames);
	    System.out.println(compare);
	}

}
