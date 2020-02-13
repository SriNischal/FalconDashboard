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
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;
//In this the content of passed test cases is displayed and validated
public class TC29_PassedTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the product is clicked and the dashboard slider is selected
	 * and pass test cases is selected and validated the number of pass test cases
	 * and pass percentage and created the list to display the passed test cases
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void passTestCases() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on pass test cases");
		page.clickOnElement(read.getPropertyvalue("loc.passedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked pass test cases");
	log.info("STEP#4: Validating the number of pass test cases");	
		validate.validatePassTestCases();
		report.info("Successfully validated passed test cases");
	log.info("STEP#5: Validating the pass percentage of the product");	
		validate.validatePassPercent();
		report.info("Successfully validated pass percentage");
		browser.getWait().safeWait(2000);
	log.info("STEP#6: Creating a list to display all the test cases present");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		List<WebElement> totallist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(totallist.size());
		List<String> totaltexts = totallist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(totaltexts);	
	}
}
