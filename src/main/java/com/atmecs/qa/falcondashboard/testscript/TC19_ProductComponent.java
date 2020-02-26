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
//In this class the product component is displayed and validated 
public class TC19_ProductComponent extends SampleTestSuiteBase {
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	/*
	 * In this method the components of the products are displayed and clicked on
	 * the recent runs and created a list to display the components and clicked on
	 * the components for sorting the values and created a list to display the
	 * sorted order of the components and compared both the values
	 */
	@Test
	public void componentOfProduct() throws Exception {
		ElementsList list=new ElementsList(browser);
		RecentrunsValidation validate = new RecentrunsValidation(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.componentofproduct.btn");
	log.info("STEP#1: Creating the list to display the components of the products ");
		String componentslist = propReader.getValue("loc.componentofproduct.btn");
		list.listofElements(componentslist);
	log.info("STEP#2: Clicking on the recent runs option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		Waits.isElementVisible(browser.getDriver(), "loc.component.btn");
	log.info("STEP#3: Creating the list to display the components of the products");
		String components = propReader.getValue("loc.componentlist.txt");
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
		String componentstext= propReader.getValue("loc.componentlist.txt");
		list.listofElements(componentstext);
	log.info("STEP#8: Comparing the lists to see whether both the list are same or  not");
		boolean compare = componentstext.equals(components);
		System.out.println(compare);
	}

}