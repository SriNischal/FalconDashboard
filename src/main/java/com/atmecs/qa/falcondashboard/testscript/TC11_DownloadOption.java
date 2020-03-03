package com.atmecs.qa.falcondashboard.testscript;

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
import com.atmecs.qa.falcondashboard.utils.Splitting;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 10-01-2020
 * @updatedDate : 07-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T11]
 *  
 */

//In this class download option is verified
public class TC11_DownloadOption extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	LoadProperties load=new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	
	
	
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. Verifying whether the product is clicked or not 
	 * 2. Verifying the download option  is selected or not 
	 * 3. Displaying and validating the download message of the product
	 */
	@Test
	public void downloadOption() throws Exception {
		Splitting split=new Splitting(browser);
		Pageactions page=new Pageactions(browser);
		Waits wait=new Waits(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		wait.isElementVisible(browser.getDriver(), "loc.download.btn");
	log.info("STEP#2: Clicking on the download option");
		page.clickOnElement(read.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");	
	log.info("STEP#3: Displaying the Download message for the products");	
	    String actualtooltipmessage=propReader.getValue("loc.downloadmessage.txt");
	    String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	    String productname=split.splitofarray(0).trim();
	    page.writedata_toExcel(productname, "Validation Text", 36, message);
	    String expectedtooltipmessage=page.getdata_fromExcel(productname, "Validation Text", "Download Message");
	    Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	    report.info("Sucessfully validated the tooltip message");
	}

}