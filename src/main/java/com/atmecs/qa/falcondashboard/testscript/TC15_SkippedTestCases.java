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
//In this class the skip test cases are displayed
public class TC15_SkippedTestCases extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the product is clicked and the skip option from the status
	 * drop down is selected and created a list to display the skip test cases of a
	 * product
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void dropdownSkippedTestCases() throws Exception {
		DropdownValidation validate=new DropdownValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Slecting the status option from the dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.skipselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Selected the skip status option"); 
	log.info("STEP#3: Validating the status option");	
		 validate.validateSkipStatus();
		report.info("Successfully validated skip status");
		browser.getWait().safeWait(2000);
	log.info("STEP#4: Creating a list to display the skipped test cases");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");;
		List<WebElement> skiplist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(skiplist.size());
		List<String> skiptexts = skiplist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(skiptexts);
}
}