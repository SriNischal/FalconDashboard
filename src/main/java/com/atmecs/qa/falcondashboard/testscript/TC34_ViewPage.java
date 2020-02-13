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
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;
import com.atmecs.qa.falcondashboard.validationresults.ViewPageValidation;
//In this class the view page is clicked and validated 
public class TC34_ViewPage extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this the views is clicked and validated the user landed on the page and
	 * validated the panel title and clicked on the dpwnload and the dashboard
	 * slider option
	 */
	@SuppressWarnings("static-access")
	@Test
	public void viewPage() throws Exception {
		ViewPageValidation validate=new ViewPageValidation(browser);
		MainNavigationValidation validation=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Validating the view  option");	
		validate.validateText();
		report.info("Successfully validated views");
	log.info("STEP#2: Clicking on the views option");	
		page.clickOnElement(read.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#3: Validating the panel title of the views page");
	    validation.validateViewPanelTitle();
	    report.info("Successfully validated the views panel title");
	log.info("STEP#4: Clicking on the download option");
		page.clickOnElement(read.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");	
	log.info("STEP#5: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");

	}
}
