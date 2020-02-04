package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;

public class TC05_Dropdowns extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	//ReadDataFromExcel readData = new ReadDataFromExcel();
	//Filters filters = readData.getFiltersData(browser).get(locator);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url=load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings("static-access")
	@Test
	public void dropdown() throws Exception {
		DropdownValidation validate = new DropdownValidation(browser);
		Pageactions page = new Pageactions(browser);
		//String locator = page.randomnumber("loc.product.btn");
		//page.clickOnElement(locator);
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the customer option from the dropdown");		
		page.clickOnElement(read.getPropertyvalue("loc.customer.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected customer option");
	log.info("STEP#3: Validating the customer value");	
		validate.validateCustomer();
		report.info("Successfully validated customer");
	log.info("STEP#4: Selecting the module option from the dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.module.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the module option");
	log.info("STEP#5: Validating the module value");	
		 validate.validateModule(); report.info("Successfully validated module");
	log.info("STEP#6: Slecting the status option from the dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the status option"); 
	log.info("STEP#7: Validating the status option");	
		 validate.validateStatus();
		report.info("Successfully validated status");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#8: Clicking on the test case of the product");	
		page.clickOnElement(read.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on test case");
	log.info("STEP#9: Validating the panel title of the test case");	
		 validate.validateProductPanelTitle();
		report.info("Successfully validated paneltitle");
	log.info("STEP#10: Clicking on the error option of the test case");	
		page.clickOnElement(read.getPropertyvalue("loc.error.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#11: Validating the error message of the test case ");	
		 validate.validateErrorMessage();
		report.info("Successfully validated error message");

	}

}
