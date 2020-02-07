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
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC21_PassPercentage extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void rececntPassPercentage() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Validating the pass percent");
	    validate.validatePassPercent();
	    report.info("Successfully validated the pass percent");
	log.info("STEP#3: Creating a list to display the test cases of the product");
	    String productnames=propReader.getValue("loc.passpercentage.txt");
		List<WebElement> productnameslist = browser.getFindFromBrowser().findElementsByXpath(productnames);
		log.dateinfo(productnameslist.size());
		List<String> productnamestext = productnameslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(productnamestext);
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#4 Clicking on the pass percentage");
	    page.clickOnElement(read.getPropertyvalue("loc.recentpasspercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the pass percentage");
	log.info("STEP#6: Creating the list to display the product names after sorting");
	    String productnamesaftersorting=propReader.getValue("loc.passpercentage.txt");
	    List<WebElement> productnamelist = browser.getFindFromBrowser().findElementsByXpath(productnamesaftersorting);
	    log.dateinfo(productnamelist.size());
	    List<String> productnametext = productnamelist.stream().map(WebElement::getText).collect(Collectors.toList());
	    log.info(productnametext);
	log.info("STEP#7: Comparing the product names before and after sorting");
	    boolean compare=productnametext.equals(productnamestext);
	    System.out.println(compare);
	}

}
