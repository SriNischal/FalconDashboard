package com.atmecs.qa.falcondashboard.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.logging.LogLevel;
import com.atmecs.falcon.automation.util.logging.LogManager;
import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testscript.SampleTestScript;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestSuiteBase {

	protected Browser browser;
	LoadProperties load = new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	public static ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public static void startTest() {
		htmlReporter = new ExtentHtmlReporter(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		htmlReporter.loadConfig(ProjectBaseConstantPaths.EXTENT_CONFIGFILE);
	}

	// In this method the browser is invoked and url is opened
	@BeforeMethod
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void preSetup(String os, String osVersion, String br, String browserVersion) throws Exception {
		browser = new Browser();
		LogManager.setLogLevel(LogLevel.valueOf(PropertyParser.readEnvOrConfigProperty("LOG_LEVEL")));
		report.info("Opening browser: " + br);
		String url = LoadProperties.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@AfterClass
	public void teardown() {
		browser.closeBrowser();
	}

}