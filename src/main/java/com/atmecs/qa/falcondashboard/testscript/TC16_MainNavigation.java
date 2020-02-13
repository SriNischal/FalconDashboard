package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.MainNavigationValidation;
import com.google.common.collect.Range;
//In this class the main navigation is clicked and validated 
public class TC16_MainNavigation extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	ReadingData data=new ReadingData();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	//In this method the main navigation option is clicked and validated the contents present in the main navigation 
	
	@SuppressWarnings("static-access")
	@Test
	public void mainNavigation() throws Exception {
		MainNavigationValidation validate=new MainNavigationValidation(browser);
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the main navigation bar");	
		page.clickOnElement(read.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		page.clickOnElement(read.getPropertyvalue("loc.mainnavigation.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Validating the dashboard text");	
		validate.validateDashboard();
		report.info("Successfully validated dashboard");  
	log.info("STEP#3: Validating on the recent runs option");	
		validate.validateRecentruns();
		report.info("Successfully validated recent runs");
	log.info("STEP#4: Clicking on the recent runs option");	
	    page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    browser.getWait().safeWait(2000);
	log.info("STEP#5: Validating the recent runs text");	
		validate.validateRecentRunsText();
		report.info("Successfully validated recentruns");
	log.info("STEP#6: Validating the recent runs panel title");	
		validate.validateRecentRunsPanelTitle();
		report.info("Successfully validated recent runs panel title");
	log.info("STEP#7: Validating the view option in main navigation");		
		validate.validateView();
		report.info("Successfully validated View");
	log.info("STEP#8: Clicking on the views option");	
		page.clickOnElement(read.getPropertyvalue("loc.view.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	log.info("STEP#9: Validating the views panel title");	
		validate.validateViewPanelTitle();
		report.info("Successfully validated panelview");
	log.info("STEP#10: Validating the product snapshot text");	
		validate.validateProductSnapshot();
		report.info("Successfully validated product snapshot");
	}

}
