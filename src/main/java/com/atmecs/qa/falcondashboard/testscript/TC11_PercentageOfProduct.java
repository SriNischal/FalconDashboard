package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
import com.atmecs.qa.falcondashboard.validationresults.RecentrunsValidation;

public class TC11_PercentageOfProduct extends SampleTestSuiteBase{
	RandomNumber random=new RandomNumber();
	ReadLocators read=new ReadLocators();
	WebDriver driver=null;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
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
	public void percentageofproduct() throws Exception {
		RecentrunsValidation validate=new RecentrunsValidation(browser);
		DashboardPageValidation validation=new DashboardPageValidation(browser);
		Pageactions page=new Pageactions(browser);
		page.clickOnElement(read.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The percentage of product completed and pass % trend are displayed");
		browser.getWait().safeWait(3000);
		page.clickOnElement(read.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The pass percentage of the product is displayed");
		page.clickOnElement(read.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("The fail percentage of the product is displayed");
		page.clickOnElement(read.getPropertyvalue("loc.snapshotbar.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product snapshot bar");
		validation.validateproductsnapshot();
		report.info("Successfully validated the product snapshot");
		page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on recent runs");
		browser.getWait().safeWait(2000);
		validate.validatetext();
		report.info("Successfully validated recent runs");
		validate.validatepasspercent();
		report.info("Successfully validated pass percent");
		validate.validatepercentagecompleted();
		report.info("Successfully validated percentage completed");
		page.clickOnElement(read.getPropertyvalue("loc.recentpasspercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on pass percent");
		validate.validatesortingpasspercent();
		report.info("Successfully validated the data after sorting");
	}
}
