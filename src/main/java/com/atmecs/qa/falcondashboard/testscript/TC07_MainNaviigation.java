package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;
import com.google.common.collect.Range;

public class TC07_MainNaviigation extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
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
	public void mainnavigation() throws Exception {
		MainNavigationValidation validate=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
		page.clickOnElement(read.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		page.clickOnElement(read.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		validate.validateDashboard();
		report.info("Successfully validated dashboard");  
		validate.validateRecentruns();
		report.info("Successfully validated recent runs");
	    page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    browser.getWait().safeWait(2000);
		validate.validaterecentrunstext();
		report.info("Successfully validated recentruns");
		validate.validaterecentrunspaneltitle();
		report.info("Successfully validated recent runs panel title");
		validate.validateView();
		report.info("Successfully validated View");
		page.clickOnElement(read.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getWait().safeWait(2000);
		validate.validateviewpaneltitle();
		report.info("Successfully validated panelview");
		validate.validateProductSnapshot();
		report.info("Successfully validated product snapshot");
	}

}
