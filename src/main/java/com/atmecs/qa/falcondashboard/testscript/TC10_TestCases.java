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
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.TestCasesValidation;

public class TC10_TestCases extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void testcasesofProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		TestCasesValidation validate=new TestCasesValidation(browser);
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked pn product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked dashboard slider");
		page.clickOnElement(read.getPropertyvalue("loc.totaltestcases.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked total test cases");
		browser.getWait().safeWait(2000);
		List<WebElement> totallist = browser.getFindFromBrowser()
				.findElementsByXpath("//tr[@class='ng-scope']");
		log.dateinfo(totallist.size());
		List<String> totaltexts = totallist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(totaltexts);
		page.clickOnElement(read.getPropertyvalue("loc.failedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		List<WebElement> faillist = browser.getFindFromBrowser()
				.findElementsByXpath("//tr[@class='ng-scope']");
		log.dateinfo(faillist.size());
		List<String> failtexts = faillist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(failtexts);
		validate.validateFailedTestCase();
		page.clickOnElement(read.getPropertyvalue("loc.passedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		List<WebElement> passlist = browser.getFindFromBrowser()
				.findElementsByXpath("//tr[@class='ng-scope']");
		log.dateinfo(passlist.size());
		List<String> passtexts = passlist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(passtexts);
		validate.validatePassedTestCase();
		page.clickOnElement(read.getPropertyvalue("loc.skipedtestcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		List<WebElement> skiplist = browser.getFindFromBrowser()
				.findElementsByXpath("//tr[@class='ng-scope']");
		log.dateinfo(skiplist.size());
		List<String> skiptexts = skiplist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(skiptexts);
	}
}
