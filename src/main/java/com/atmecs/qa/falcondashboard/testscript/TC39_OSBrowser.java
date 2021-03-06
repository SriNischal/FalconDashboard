package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

public class TC39_OSBrowser extends TestSuiteBase {
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String values;
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	int index;
	@Test
	public void osBrowser() throws Exception {
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the recent runs");
		  page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		  report.info("Successfully clicked on the recent runs option");
		  Waits.isElementVisible(browser.getDriver(), "loc.next.btn");
	log.info("STEP#2: Clicking on the last page");
	for(int index=0;index<=10;index++) {
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.next.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	}
		  Waits.isElementVisible(browser.getDriver(), "loc.trashbox.btn");
	log.info("STEP#3: Creating the list to display the components of the products");
	    	  for(;;) {
	    		  String number = Integer.toString(index);
	    		  String locatorvalues = ReadLocators.getPropertyvalue("loc.next.btn", ProjectBaseConstantPaths.LOCATORS_FILE);
	    		  String Locator = locatorvalues.replace("*", number);
	    		  System.out.println(Locator);
	    		  browser.getPageScroll().up(5000);
	    		  page.clickOnElement(ReadLocators.getPropertyvalue("loc.trashbox.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    		  report.info("Successfully deleted the last item in the list");
	    		  Waits.isElementVisible(browser.getDriver(), "loc.confirm.btn");
	    		  page.clickOnElement(ReadLocators.getPropertyvalue("loc.confirm.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    		  Waits.isElementVisible(browser.getDriver(), "loc.next.btn");
	    		  page.clickOnElement(ReadLocators.getPropertyvalue("loc.next.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    		  report.info("Successfully clicked on the last page of the recent runs");
	    	  }
		}
}
