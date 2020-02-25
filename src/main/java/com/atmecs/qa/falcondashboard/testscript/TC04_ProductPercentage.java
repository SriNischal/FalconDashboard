package com.atmecs.qa.falcondashboard.testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.Waits;

//In this class tool tip message is validated and color of the pass and fail percentages

public class TC04_ProductPercentage extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	RandomNumber random = new RandomNumber();
	LogReport log=new LogReport();
	ReadLocators read = new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	WebDriver driver = null;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method a list is created to display the tooltip message by mouse
	 * hovering and validate the message and display the color of the pass
	 * percentage and the fail percentage
	 */
	@SuppressWarnings( "static-access" )
	@Test
	public void percentageOfProduct() throws Exception {
		Waits wait=new Waits(browser);
		ValidationHelper helper=new ValidationHelper(browser);
		Pageactions page = new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.pass%trend.btn");
	log.info("STEP#1: Mouse hovering over the pass%Trend of the product");
	     page.mouseOver(read.getPropertyvalue("loc.pass%trend.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the pass%trend");
	     wait.implicitWait();
	log.info("STEP#2: Displaying and validating the pass%trend message for the products");	
	     String product=helper.getData();
	     String actualtooltipmessage=page.getText(read.getPropertyvalue("loc.pass%trendmessage.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	     page.writedata_toExcel(product, "Validation Text", 14, actualtooltipmessage);
	     String expectedtooltipmessage=page.getdata_fromExcel(product, "Validation Text", "Pass%Trend");
	     Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Successfully displayed the test cases message");
	log.info("STEP#3: Mouse hovering the pass percent of the product and diplayed the value");
		 page.mouseOver(read.getPropertyvalue("loc.passpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	   	 report.info("Successfully mouse hovered over the pass percent");
	log.info("STEP#4: Displaying the color of the pass pecrntage");
		 String actualcolor=page.getCssValue(read.getPropertyvalue("loc.passpercent.txt", ProjectBaseConstantPaths.LOCATORS_FILE),"background-color");
		 report.info(actualcolor);
	log.info("STEP#5: Veifying the color of the pass percentage"); 
	     page.writedata_toExcel(product, "Validation Text", 15, actualcolor);
		 String expectedcolor= page.getdata_fromExcel(product, "Validation Text", "Pass percent color");
		 Verify.verifyString(actualcolor, expectedcolor, "Successfully validated the color of the pass percentage");
		 report.info("Successfully validated the color of the pass percentage");  
		 wait.isElementVisible(browser.getDriver(), "loc.failpercent.btn");
	log.info("STEP#6: Mouse hovering the fail percent of the product");
	     page.mouseOver(read.getPropertyvalue("loc.failpercent.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered over the fail percent and displayed the value");
    log.info("STEP#7: Displaying the color of the fail pecrntage");
	     String actualfailcolor=page.getCssValue(read.getPropertyvalue("loc.failpercentcolor.txt", ProjectBaseConstantPaths.LOCATORS_FILE), "background-color");
	     report.info(actualfailcolor);
    log.info("STEP#8: Veifying the color of the pass percentage"); 
         page.writedata_toExcel(product, "Validation Text", 16, actualfailcolor);
	     String expectedfailcolor= page.getdata_fromExcel(product, "Validation Text", "Fail percent color");
	     Verify.verifyString(actualfailcolor, expectedfailcolor, "Successfully validated the color of the fail percentage");
	     report.info("Successfully validated the color of the fail percentage"); 
	     page.windowHandle();
	}
}
