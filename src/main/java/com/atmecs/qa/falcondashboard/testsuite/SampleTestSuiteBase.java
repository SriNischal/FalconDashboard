/***
 *
 */
package com.atmecs.qa.falcondashboard.testsuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
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
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class SampleTestSuiteBase {
	
	protected Browser browser;
	LoadProperties load = new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	// In this method the browser is invoked and url is opened
    @BeforeSuite
    @Parameters({ "os", "osVersion", "browser", "browserVersion" })
    public void preSetup(String os, String osVersion, String br, String browserVersion) throws Exception {
        browser = new Browser();
        LogManager.setLogLevel(LogLevel.valueOf(PropertyParser.readEnvOrConfigProperty("LOG_LEVEL")));
        report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
    }

    @AfterSuite
    public void teardown() {
        browser.closeBrowser();
    }

}