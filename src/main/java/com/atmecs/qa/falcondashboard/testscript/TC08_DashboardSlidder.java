package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

//In this class dash board slider is checked
public class TC08_DashboardSlidder extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	/* In this method checked whether the dash board slider is clicked or not */
	@SuppressWarnings("static-access")
	@Test
	public void dashboardSlidder() throws Exception {
		Waits wait=new Waits(browser);
		Pageactions page=new Pageactions(browser);
		Thread.sleep(7000);
		log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		Thread.sleep(5000);
		log.info("STEP#2: Selecting the dashboard slider option");
		String locatorValue = read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE);
		System.out.println("locator value ------ " + locatorValue);
		page.clickOnElement(locatorValue);
		report.info("Successfully selected dashboard option");
		wait.safeWait();
	}

}
