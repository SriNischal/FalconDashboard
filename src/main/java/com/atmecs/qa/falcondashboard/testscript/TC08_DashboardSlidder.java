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

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 08-01-2020
 * @updatedDate : 05-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T08]
 *  
 */

//In this class dash board slider is checked
public class TC08_DashboardSlidder extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	ReadLocators read=new ReadLocators();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	
	/* In this method checked whether the dash board slider is clicked or not */
	@Test
	public void dashboardSlidder() throws Exception {
		Waits wait=new Waits(browser);
		ReadLocators read=new ReadLocators();
		Pageactions page=new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
		log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
		log.info("STEP#2: Selecting the dashboard slider option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
		page.windowHandle();
	}

}