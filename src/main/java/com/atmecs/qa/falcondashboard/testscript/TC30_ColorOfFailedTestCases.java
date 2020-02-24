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
//In this class the color of the failed test cases is displayed 
public class TC30_ColorOfFailedTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the product is clicked and the dash board slider is selected and
	 * displayed the color of the failed test cases and validated the color of the
	 * test cases
	 */
	@SuppressWarnings("static-access")
	@Test
	public void colorofFailedTestCases() throws Exception {
		Waits wait=new Waits(browser);
		Splitting split=new Splitting(browser);
	    Pageactions page=new Pageactions(browser);
	    wait.isElementVisible(browser.getDriver(), "loc.product.btn");
    log.info("STEP#1: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		wait.isElementVisible(browser.getDriver(), "loc.dashboardslider.btn");
	log.info("STEP#2: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#3: Displaying the color of the total test case box");
	    wait.implicitWait();
	    String color=propReader.getValue("validate.coloroffailtestcases.txt");
	    String actualcolor=browser.getFindFromBrowser().findElementByXpath(color).getCssValue("background-color");
	    System.out.println("Color:"+actualcolor);
	log.info("STEP#4: Veifying the color of the total test case box"); 
	    String productname = split.splitofarray(0).trim();
	    page.writedata_toExcel(productname, "Validation Text", 33, actualcolor);
	    String expectedcolor= page.getdata_fromExcel(productname, "Validation Text", "Color of fail test cases");
	    Verify.verifyString(actualcolor, expectedcolor, "Successfully validated the color of the fail test cases box");
	    report.info("Successfully validated the color of the fail test cases box");
	}
}
