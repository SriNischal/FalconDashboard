package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
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
//In this class the content of total test cases is displayed
public class TC27_TotalTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this the product is clicked and the dash board slider is selected and
	 * clicked on the total test cases and validated the time taken to run and
	 * validate total test cases and list to display all the test cases
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void totalTestCases() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on total test cases");
		page.clickOnElement(read.getPropertyvalue("loc.totaltestcases.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked total test cases");
	log.info("STEP#4: Validating the test cases text");	
		validate.validateTestCases();
		report.info("Successfully validated test cases");
	log.info("STEP#5: Validating the time taken to run the product");	
		validate.validateTime();
		report.info("Successfully validated the run time");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#6: Creating a list to display all the test cases present");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		List<WebElement> totallist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(totallist.size());
		List<String> totaltexts = totallist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(totaltexts);	
	}
}
