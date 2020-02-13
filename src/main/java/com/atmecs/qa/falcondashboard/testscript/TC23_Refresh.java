package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
//In this class the refresh option is verified
public class TC23_Refresh extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the the dashboard text is validated and the refresh option is
	 * successfully clicked
	 */
	@SuppressWarnings("static-access")
	@Test
	public void refresh() throws Exception {
		DashboardPageValidation validate=new DashboardPageValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Dashboard Text validation");
		validate.validateDashboard();
		report.info("Successfully validated dashboard text");
	log.info("STEP#2: Clicking on the refresh option");
		page.clickOnElement(read.getPropertyvalue("loc.refresh.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("clicked on refresh option");
		report.info("Successfully clicked on the refresh option");
	}

}
