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
import com.atmecs.qa.falcondashboard.validationresults.TestCasesValidation;

public class TC20_TestCases extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
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
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void testCasesOfProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		TestCasesValidation validate=new TestCasesValidation(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
	log.info("STEP#3: Clicking on the total test cases option");
		page.clickOnElement(read.getPropertyvalue("loc.totaltestcases.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked total test cases");
		browser.getWait().safeWait(2000);
	log.info("STEP#4: Creating a list to display all the test cases present");
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		List<WebElement> totallist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(totallist.size());
		List<String> totaltexts = totallist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(totaltexts);
		log.info("STEP#5: Clicking on the failed test case");
		page.clickOnElement(read.getPropertyvalue("loc.failedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		log.info("STEP#6: Creating a list to display the failed test cases");
		List<WebElement> faillist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(faillist.size());
		List<String> failtexts = faillist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(failtexts);
	log.info("STEP#7: Validating the failed test case");
		validate.validateFailedTestCase();
	log.info("STEP#8: Clicking on the passed test cases");
		page.clickOnElement(read.getPropertyvalue("loc.passedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
	log.info("STEP#9: Creating a list to display the passed test cases");
		List<WebElement> passlist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(passlist.size());
		List<String> passtexts = passlist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(passtexts);
	log.info("STEP#10: Validating the pass test cases ");
		validate.validatePassedTestCase();
	log.info("STEP#11: Clicking on the skiped test cases");
		page.clickOnElement(read.getPropertyvalue("loc.skipedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
	log.info("STEP#9: Creating a list to display the skipped test cases");
		List<WebElement> skiplist = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(skiplist.size());
		List<String> skiptexts = skiplist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(skiptexts);
	}
}
