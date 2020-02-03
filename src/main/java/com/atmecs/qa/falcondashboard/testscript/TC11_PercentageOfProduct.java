package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
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
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC11_PercentageOfProduct extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	RandomNumber random = new RandomNumber();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	WebDriver driver = null;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url=load.readConfig("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL("Dashboard_URL", os, osVersion, browser, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void percentageofproduct() throws Exception {
		RecentrunsValidation validate = new RecentrunsValidation(browser);
		DashboardPageValidation validation = new DashboardPageValidation(browser);
		Pageactions page = new Pageactions(browser);
		page.clickOnElement(read.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The percentage of product completed and pass % trend are displayed");
		browser.getWait().safeWait(3000);
		page.clickOnElement(read.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The pass percentage of the product is displayed");
		page.clickOnElement(read.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The fail percentage of the product is displayed");
		page.clickOnElement(read.getPropertyvalue("loc.snapshotbar.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product snapshot bar");
		validation.validateproductsnapshot();
		report.info("Successfully validated the product snapshot");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		browser.getWait().safeWait(2000);
		validate.validatetext();
		report.info("Successfully validated recent runs");
		validate.validatepasspercent();
		report.info("Successfully validated pass percent");
		validate.validatepercentagecompleted();
		report.info("Successfully validated percentage completed");
		page.clickOnElement(read.getPropertyvalue("loc.recentpasspercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on pass percent");
		validate.validatesortingpasspercent();
		report.info("Successfully validated the data after sorting");
		List<WebElement> passpercentagelist = browser.getFindFromBrowser()
				.findElementsByXpath("//td[@data-title=\"'Testcases #'\"]");
		log.dateinfo(passpercentagelist.size());
		page.clickOnElement(read.getPropertyvalue("loc.tests.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on testcases");
		List<String> passpercentagetext = passpercentagelist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(passpercentagetext);
		page.clickOnElement(read.getPropertyvalue("loc.tests.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on test cases");
		List<WebElement> passpercentlist = browser.getFindFromBrowser()
				.findElementsByXpath("//td[@data-title=\"'Testcases #'\"]");
		log.dateinfo(passpercentlist.size());
		List<String> passpercenttext = passpercentlist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(passpercenttext);
		boolean compare=passpercentagetext.equals(passpercenttext);
		System.out.println(compare);
	}
}
