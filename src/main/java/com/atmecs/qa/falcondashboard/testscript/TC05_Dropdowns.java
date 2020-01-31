package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;

public class TC05_Dropdowns extends SampleTestSuiteBase {
	String locator;
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	//ReadDataFromExcel readData = new ReadDataFromExcel();
	//Filters filters = readData.getFiltersData(browser).get(locator);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
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
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.customer.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected customer option");
		validate.validatecustomer();
		report.info("Successfully validated customer");
		page.clickOnElement(read.getPropertyvalue("loc.module.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the module option");
		 validate.validatemodule(); report.info("Successfully validated module");
		page.clickOnElement(read.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the status option"); 
		 validate.validatestatus();
		report.info("Successfully validated status");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on test case");
		 validate.validateproductpaneltitle();
		report.info("Successfully validated paneltitle");
		page.clickOnElement(read.getPropertyvalue("loc.error.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		 validate.validateerrormessage();
		report.info("Successfully validated error message");

	}

}
