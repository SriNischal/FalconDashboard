package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;
//In this class the dropdowns are checked
public class TC07_Dropdowns extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	//ReadDataFromExcel readData = new ReadDataFromExcel();
	//Filters filters = readData.getFiltersData(browser).get(locator);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the value from the drop downs are selected and validated the
	 * values of the drop downs
	 */
	@Test
	public void dropdown() throws Exception {
		DropdownValidation validate = new DropdownValidation(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
	    Waits.isElementVisible(browser.getDriver(), "loc.customer.txt");
	log.info("STEP#2: Selecting the customer option from the dropdown");
	String locatorvalue=ReadLocators.getPropertyvalue("loc.customer.txt", ProjectBaseConstantPaths.LOCATORS_FILE);
	    System.out.println(locatorvalue);
		page.clickOnElement(locatorvalue);
		report.info("Successfully selected customer option");
	log.info("STEP#3: Validating the customer value");	
		validate.validateCustomer();
		report.info("Successfully validated customer");
	log.info("STEP#4: Selecting the module option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.module.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the module option");
	log.info("STEP#5: Validating the module value");	
		 validate.validateModule(); 
		 report.info("Successfully validated module");
	log.info("STEP#6: Slecting the status option from the dropdown");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the status option"); 
	log.info("STEP#7: Validating the status option");	
		 validate.validateFailStatus();
		report.info("Successfully validated status");
	}

}
