package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

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
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;

public class TC08_ViewPage extends SampleTestSuiteBase{
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
	public void view() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		validate.validatetext();
		report.info("Successfully validated views");
		page.clickOnElement(read.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		validate.validatetestcases();
		report.info("Successfully validated test cases");
		validate.validatetime();
		report.info("Successfully validated the run time");
		validate.validatepasstestcases();
		report.info("Successfully validated passed test cases");
		validate.validatepasspercent();
		report.info("Successfully validated pass percentage");
		validate.validatefailtestcases();
		report.info("Successfully validated Failed test cases");
		validate.validatefailmessage();
		report.info("Successfully validated fail message");
		validate.validateskiptestcases();
		report.info("Successfully validated Skipped test cases");
	    validate.validateskipmessage();
		report.info("Successfully validated skip message");

	}
}
