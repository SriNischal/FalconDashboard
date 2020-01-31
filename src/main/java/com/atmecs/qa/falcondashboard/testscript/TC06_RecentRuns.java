package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC06_RecentRuns extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}
	@SuppressWarnings("static-access")
	@Test
	public void recentrun() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		Pageactions page=new Pageactions(browser);
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		browser.getWait().safeWait(2000);
	    validate.validatetext();
		report.info("Successfully validated recentruns");
	    validate.validatepaneltitle();
		report.info("Successfully validated reports");
		validate.validatepaneltitle();
		report.info("Successfully validated product name");
		validate.validatecomponent();
		report.info("Successfully validated the component text");
		validate.validatetestcase();
		report.info("Successfully validated textcases with # symbol");
		validate.validatepasspercent();
		report.info("Successfully validated the passpercent with % symbol");
		validate.validatelastrun();
		report.info("Successfully validated lastruns");
		@SuppressWarnings("deprecation")
		List<WebElement> list = browser.getFindFromBrowser()
				.findElementsByXpath("(//tr[@class='ng-scope'])");
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
	}
}
