package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
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
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;

//In this class dash board page is tested

public class TC01_DashBoardPage extends SampleTestSuiteBase {

	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	ReadingData data = new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;
	@SuppressWarnings("static-access")
	@Test
	/*
	 * In this method we test whether the user landed on the dash board page by
	 * validating the title of the page, dash board text, falcon text validation and
	 * clicking on the refresh option
	 */
	public void dashboardPage() throws Exception {
		Waits wait = new Waits(browser);
		Pageactions page = new Pageactions(browser);
		DashboardPageValidation validate = new DashboardPageValidation(browser);
		wait.isElementVisible(browser.getDriver(), "loc.refresh.btn");
		log.info("STEP#1: Page title validation");
		String actualtitle = browser.getCurrentPageTitle();
		String expectedtitle = data.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "Page URL");
		Verify.verifyString(actualtitle, expectedtitle, "Verifying String Message ");
		report.info("successfully validated page title");
		log.info("STEP#2: Dashboard Text validation");
		validate.validateDashboard();
		report.info("Successfully validated the dashboard text");
		log.info("STEP#3: Clicking on the refresh option");
		page.clickOnElement(read.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		log.info("STEP#4: Atmecs Text validation");
		validate.validatefalconlogo();
		report.info("Successfully validated falcon");
	}

}