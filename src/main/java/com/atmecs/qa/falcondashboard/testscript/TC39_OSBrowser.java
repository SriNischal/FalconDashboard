package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;

public class TC39_OSBrowser extends TestSuiteBase {
	LogReport log = new LogReport();
	boolean oslocator;
	boolean browserlocaor;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String osvalue;
    String browservalue;
    @Test
	public void osBrowser() throws Exception {
		DropdownValidation validate = new DropdownValidation(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		Waits.isElementVisible(browser.getDriver(), "loc.os.ddn");
	log.info("STEP#2: Selecting and validating the os option from the dropdown");
		oslocator = browser.getDropdown().isdropDownPresent(LocatorType.XPATH,ReadLocators.getPropertyvalue("loc.os.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		if (oslocator == true) {
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.os.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
			report.info("Successfully selected os dropdown");
			osvalue = ReadLocators.getPropertyvalue("loc.osvalue.ddn", ProjectBaseConstantPaths.LOCATORS_FILE);
			page.clickOnElement(osvalue);
			report.info("Successfully selected the os option");
			Waits.isElementVisible(browser.getDriver(), "loc.browser.ddn");
			log.info("STEP#5: Validating the module drop down value");
			validate.validateOS();
			report.info("Successfully validated os");
		} else {
			report.info("Value is not present so it entered the else loop");
		}
		Waits.isElementVisible(browser.getDriver(), "loc.browser.ddn");
	log.info("STEP#3: Selecting and validating the browser option from the dropdown");
	    browserlocaor = browser.getDropdown().isdropDownPresent(LocatorType.XPATH,ReadLocators.getPropertyvalue("loc.browser.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
		if (browserlocaor == true) {
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.browser.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
			report.info("Successfully selected browser dropdown");
			browservalue = ReadLocators.getPropertyvalue("loc.browservalue.ddn", ProjectBaseConstantPaths.LOCATORS_FILE);
			page.clickOnElement(browservalue);
			report.info("Successfully selected the browser option");
			log.info("STEP#5: Validating the module drop down value");
			validate.validateBrowser();
			report.info("Successfully validated browser");
		} else {
			report.info("Value is not present so it entered the else loop");
		}
	}

}
