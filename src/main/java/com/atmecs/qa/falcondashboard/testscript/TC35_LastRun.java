package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.List;
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
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC35_LastRun extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	WebDriver driver; 
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
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
	public void lastRun() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the Recentruns");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the recent runs");
		browser.getWait().safeWait(2000);
	log.info("STEP#2: Validating the last run");
	    validate.validateLastRun();
	    report.info("Successfully validated the last run");
	log.info("STEP#3: Creating a list to display the last run of the product");
	    String lastruns=propReader.getValue("loc.lastrun.txt");
		List<WebElement> lastrunslist = browser.getFindFromBrowser().findElementsByXpath(lastruns);
		log.dateinfo(lastrunslist.size());
		List<String> lastrunstext = lastrunslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(lastrunstext);
		browser.getWait().safeWait(2000);
	log.info("STEP#4 Clicking on the last run");
	    page.clickOnElement(read.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(read.getPropertyvalue("loc.lastruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully clicked on the last runs");
	    browser.getWait().safeWait(2000);
	log.info("STEP#5: Creating the list to display the last runs after sorting");
	    String lastrunsaftersorting=propReader.getValue("loc.lastrun.txt");
	    List<WebElement> lastrunlist = browser.getFindFromBrowser().findElementsByXpath(lastrunsaftersorting);
	    log.dateinfo(lastrunlist.size());
	    List<String> lastruntext = lastrunlist.stream().map(WebElement::getText).collect(Collectors.toList());
	    log.info(lastruntext);
	log.info("STEP#6: Comparing the last runs before and after sorting");
	    boolean compare=lastruntext.equals(lastrunstext);
	    System.out.println(compare);
	}
}
