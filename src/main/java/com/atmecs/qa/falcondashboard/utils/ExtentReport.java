package com.atmecs.qa.falcondashboard.utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport{
	static ExtentTest test;
	static ExtentReports extentreport;
	protected Browser browser;
	
	public ExtentReport(Browser browser) {
		this.browser=browser;
	}
	
	@BeforeClass
	public static void startTest() {
		extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		test = extentreport.startTest("DashboardPage");
	}
	
	public String extentReport(String message) {
	
	if (browser.getDriver().getTitle().equals(message)) {
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	} else {
		test.log(LogStatus.FAIL, "Test Failed");
	}
	return message;

}
	@AfterClass
	public static void endTest() {
		extentreport.endTest(test);
		extentreport.flush();
	}
}
