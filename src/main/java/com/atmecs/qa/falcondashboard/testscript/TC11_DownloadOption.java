package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 10-01-2020
 * @updatedDate : 07-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T11]
 *  
 */

//In this class download option is clicked and validated 
public class TC11_DownloadOption extends TestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	 String actualtooltipmessage;
	 String message;
	 String expectedtooltipmessage;
	 static ExtentTest test;
	static ExtentReports extentreport;
    String actualtitle;		
		@BeforeClass
		public static void startTest() {
			extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
			test = extentreport.startTest("DownloadOption");
		}
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the download option  is selected or not 
	 * 3. Displaying and validating the download message of the product
	 */
	@Test
	public void downloadOption() throws Exception {
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
		actualtitle = browser.getCurrentPageTitle();
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		Waits.isElementVisible(browser.getDriver(), "loc.download.btn");
	log.info("STEP#2: Clicking on the download option");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");	
	log.info("STEP#3: Displaying the Download message for the products");	
	    actualtooltipmessage=propReader.getValue("loc.downloadmessage.txt");
	    message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	    page.writedata_toExcel(sheetname, columnname, 36, message);
	    expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Download Message");
	    Verify.verifyString(message, expectedtooltipmessage, "Validating the download message of the product is same as expected or not");
	    report.info("Sucessfully validated the tooltip message");
	    if (browser.getDriver().getTitle().equals(actualtitle)) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endTest() {
		extentreport.endTest(test);
		extentreport.flush();
	}
	}