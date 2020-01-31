package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;

public class TC01_DashBoardPage extends SampleTestSuiteBase {
	
	ReadLocators read=new ReadLocators();
	LoadProperties properties = new LoadProperties();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log=new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;
	

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
	public void dashboardpage() throws Exception {
		
		Pageactions page=new Pageactions(browser);
		DashboardPageValidation validate=new DashboardPageValidation(browser);
		
		String actualtitle = browser.getCurrentPageTitle();
		String expectedtitle=data.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Page URL");
		Verify.verifyString(actualtitle, expectedtitle, "Verifying String Message ");
		report.info("successfully validated page title");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickOnElement(read.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		validate.validateDashboardtext();
		report.info("Successfully validated dashboard text");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
	}

}
