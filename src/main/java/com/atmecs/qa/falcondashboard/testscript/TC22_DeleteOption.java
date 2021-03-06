package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 23-01-2020
 * @updatedDate : 14-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T22]
 *  
 */

//In this class the delete option is mouse hovered and validated the tool tip message 
public class TC22_DeleteOption extends TestSuiteBase{
	ReadLocators read=new ReadLocators();
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String message;
	String actualtooltipmessage;
	String expectedtooltipmessage;
	/* 
	 * This test script covers the following functionalities of recent runs page.
	 * 1. Verifying whether the recent runs is clicked or not 
	 * 2. Mouse hovering over the delete option 
	 * 3. Displaying the delete run message by  mouse hovering
	 */  
	@Test
	public void deleteOption() throws Exception {
		 Pageactions page=new Pageactions(browser);
		 Waits.isElementVisible(browser.getDriver(), "loc.recentruns.btn");
	log.info("STEP#1: Clicking on the recent runs option");	
	     page.clickOnElement(ReadLocators.getPropertyvalue("loc.recentruns.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		 report.info("Successfully clicked on recent runs");
		 Waits.isElementVisible(browser.getDriver(), "loc.deleteoption.btn");
	log.info("STEP#2: Mouse hovering over the delete option");	 
		 page.mouseOver(ReadLocators.getPropertyvalue("loc.deleteoption.btn",ProjectBaseConstantPaths.LOCATORS_FILE));
		 report.info("Successfully mouse hovered over the delete option");
	log.info("STEP#3: Displaying the delete run message for the products");	
	     actualtooltipmessage=propReader.getValue("loc.delete.txt");
	     message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     page.writedata_toExcel(sheetname, columnname, 35, message);
	     expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Delete Product");
	     Verify.verifyString(message, expectedtooltipmessage, "Validating the delete run message is same as expected or not");
		}
	}
