package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;

public class TC24_ProductSnapShot extends SampleTestSuiteBase{
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
	@SuppressWarnings("static-access")
	public void productSnapShot() throws Exception {
		MainNavigationValidation validate=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#4: Clicking on the product snapshot option");
		page.clickOnElement(read.getPropertyvalue("loc.snapshotbar.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product snapshot bar");
	log.info("STEP#10: Validating the product snapshot text");	
		validate.validateProductSnapshot();
		report.info("Successfully validated product snapshot");
	
	}
}
