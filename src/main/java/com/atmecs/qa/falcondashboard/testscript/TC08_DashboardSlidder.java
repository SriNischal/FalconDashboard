package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

//In this class dashboard slidder is checked
public class TC08_DashboardSlidder extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	//In this method the browser is invoked and url is opened
	
	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url=load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	/* In this method checked whether the dashboard slidder is clicked or not */
	@SuppressWarnings("static-access")
	@Test
	public void dashboardSlidder() throws Exception {
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	}

}