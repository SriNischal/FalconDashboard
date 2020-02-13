package com.atmecs.qa.falcondashboard.testscript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
//In this the color of the skiped test cases is displayed 
public class TC32_ColorOfSkippedTestCases extends SampleTestSuiteBase{
	LoadProperties load = new LoadProperties();
	ReadLocators read = new ReadLocators();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	/*
	 * In this method the product is clicked and dash board slider is selected and
	 * displayed the color of the skip test case and validated the color of the
	 * skipped test case
	 */
	@SuppressWarnings("static-access")
	@Test
	public void colorofSkippedTestCases() throws Exception {
	    Pageactions page=new Pageactions(browser);
    log.info("STEP#1: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#3: Displaying the color of the total test case box");
	browser.getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	    String color=propReader.getValue("validate.colorofskiptestcases.txt");
	    String actualcolor=browser.getFindFromBrowser().findElementByXpath(color).getCssValue("background-color");
	    System.out.println("Color:"+actualcolor);
	log.info("STEP#4: Veifying the color of the total test case box"); 
	    String expectedcolor= page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Color of skip test cases");
	    Verify.verifyString(actualcolor, expectedcolor, "Successfully validated the color of the skip test cases box");
	    System.out.println(expectedcolor);
	    report.info("Successfully validated the color of the skip test cases box");
	}
}
