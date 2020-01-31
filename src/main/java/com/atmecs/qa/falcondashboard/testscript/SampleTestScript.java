package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;

public class SampleTestScript extends SampleTestSuiteBase{
	
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void sampleTest(String os, String osVersion, String br, String browserVersion) {
		// write your first test script here
		// sample
		report.info("Opening browser: "+ br);
		browser.openURL("http://www.google.com", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		report.info("entering text: "+"Selenium");
		browser.getTextField().enterTextField(LocatorType.NAME, "q", "Selenium");
		Verify.verifyTrue(browser.getTextField().enterTextField(LocatorType.NAME, "q", "Selenium"), browserVersion);
		report.info("pressing enter key");
		browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		report.info("waiting for 2 second");
		browser.getWait().safeWait(2000);
		String text = browser.getCurrentPageTitle();
		report.info("verifying page title");
		Verify.verifyString(text, "Selenium - Google Search", "Verifying String Message ");
		browser.getClick().performClick(null, "loc.refresh.btn");
	}

}
