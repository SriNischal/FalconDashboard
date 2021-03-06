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
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 03-01-2020
 * @updatedDate : 03-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T04]
 *  
 */

//In this class tool tip message of the pass%Trend is validated and color of the pass and fail percentages are displayed and validated 

public class TC04_ProductPercentage extends TestSuiteBase {
	LoadProperties load=new LoadProperties();
	RandomNumber random = new RandomNumber();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String actualfailcolor;
	String expectedfailcolor;
	String actualtooltipmessage;
	String expectedtooltipmessage;
	String actualcolor;
	String expectedcolor;
	/* 
	 * This test script covers the following functionalities of dash board page.
	 * 1. The pass%Trend is mouse hovered to display the tool tip message 
	 * 2. Validating the pass%Trend message of the products
	 * 3. Mouse hovering over the pass percent of the product 
	 * 4. Displaying the color of the pass percent of the product
	 * 5. Verifying the color of the pass percentage of the product
	 * 6. Mouse hovering over the fail percent of the product
	 * 7. Displaying the color of the fail percent of the product 
	 * 8. Verifying the color of the fail percentage of the product
	 */
	@Test
	public void percentageOfProduct() throws Exception {
		Waits wait=new Waits(browser);
		Pageactions page = new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.pass%trend.btn");
	log.info("STEP#1: Mouse hovering over the pass%Trend of the product");
	     page.mouseOver(ReadLocators.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the pass%trend");
	     wait.implicitWait();
	log.info("STEP#2: Displaying and validating the pass%trend message for the products");	
	     actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("loc.pass%trendmessage.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	     page.writedata_toExcel(sheetname, columnname, 14, actualtooltipmessage);
	     expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Pass%Trend");
	     Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
	log.info("STEP#3: Mouse hovering the pass percent of the product and diplayed the value");
		 page.mouseOver(ReadLocators.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	   	 report.info("Successfully mouse hovered over the pass percent");
	   	 Waits.isElementVisible(browser.getDriver(), "loc.passpercent.txt");
	log.info("STEP#4: Displaying the color of the pass pecrntage");
		 actualcolor=page.getCssValue(ReadLocators.getPropertyvalue("loc.passpercent.txt", ProjectBaseConstantPaths.LOCATORS_FILE),"background-color");
		 report.info(actualcolor);
	log.info("STEP#5: Veifying the color of the pass percentage"); 
	     page.writedata_toExcel(sheetname, columnname, 15, actualcolor);
		 expectedcolor= page.getdata_fromExcel(sheetname, columnname, "Pass percent color");
		 Verify.verifyString(actualcolor, expectedcolor, "Validating the color of the pass percentage is same as expected or not");
		 report.info("Successfully validated the color of the pass percentage");  
		 Waits.isElementVisible(browser.getDriver(), "loc.failpercent.btn");
	log.info("STEP#6: Mouse hovering the fail percent of the product");
	     page.mouseOver(ReadLocators.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered over the fail percent and displayed the value");
    log.info("STEP#7: Displaying the color of the fail pecrntage");
	     actualfailcolor=page.getCssValue(ReadLocators.getPropertyvalue("loc.failpercentcolor.txt", ProjectBaseConstantPaths.LOCATORS_FILE), "background-color");
	     report.info(actualfailcolor);
    log.info("STEP#8: Veifying the color of the pass percentage"); 
         page.writedata_toExcel(sheetname, columnname, 16, actualfailcolor);
	     expectedfailcolor= page.getdata_fromExcel(sheetname, columnname, "Fail percent color");
	     Verify.verifyString(actualfailcolor, expectedfailcolor, "Validating the color of the fail percentage is same as expected or not");
	     report.info("Successfully validated the color of the fail percentage"); 
	     page.windowHandle();
	}
}