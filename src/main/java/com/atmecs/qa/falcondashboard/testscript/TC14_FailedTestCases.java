package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
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
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.DropdownValidation;
//In this class the fail test cases are displayed 
public class TC14_FailedTestCases extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);

	/*
	 * In this method product is clicked and fail option from the status dropdown is
	 * selected and created a list to display the fail test cases
	 */ 
	@SuppressWarnings("static-access")
	@Test
	public void dropdownFailedTestCases() throws Exception {
		DropdownValidation validate=new DropdownValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Slecting the status option from the dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.failselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the fail status option"); 
	log.info("STEP#3: Validating the status option");	
		 validate.validateFailStatus();
		report.info("Successfully validated fail status");
		browser.getWait().safeWait(2000);
	log.info("STEP#4: Creating a list to display the failed test cases");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");;
		List<WebElement> faillist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(faillist.size());
		List<String> failtexts = faillist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(failtexts);
}
}
