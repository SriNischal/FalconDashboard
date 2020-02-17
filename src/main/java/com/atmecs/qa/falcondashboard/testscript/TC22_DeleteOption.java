package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;
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
//In this class the delete option is validated
public class TC22_DeleteOption extends SampleTestSuiteBase{
	ReadLocators read=new ReadLocators();
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the recent runs option is clicked and mouse hovered over the
	 * delete option and displayed the tool tip message and validated the tooltip
	 * message
	 */
	@SuppressWarnings("static-access")
	@Test
	public void deleteOption() throws Exception {
		 Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the recent runs option");	
	     page.clickOnElement(read.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		 report.info("Successfully clicked on recent runs");
		 browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Mouse hovering over the delete option");	 
		 page.mouseOver(read.getPropertyvalue("loc.deleteoption.btn",ProjectBaseConstantPaths.LOCATORS_FILE));
		 report.info("Successfully mouse hovered over the delete option");
	log.info("STEP#3: Displaying the delete run message for the products");	
	     String actualtooltipmessage=propReader.getValue("loc.delete.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     page.writedata_toExcel("TC01_DasBoardPage", "Validation Text", 35, message);
	     String expectedtooltipmessage=page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Delete option");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	}
}
