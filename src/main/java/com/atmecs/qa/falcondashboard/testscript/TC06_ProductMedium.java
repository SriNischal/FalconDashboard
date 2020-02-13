package com.atmecs.qa.falcondashboard.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
//In this class the medium of the product is displayed and validated
public class TC06_ProductMedium extends SampleTestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	LoadProperties load =new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the splitting of the product name,medium and the date and time
	 * of product is done and validate the medium data
	 */
	@SuppressWarnings("static-access")
	@Test
	public void mediumOfProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Splitting the array and displaying the medium of the product");
		String product = propReader.getValue("loc.product.txt");
		String value = browser.getTextField().readTextByXPath(LocatorType.XPATH, product);
		String[] arrOfStr = value.split(":", 3);
		String medium=arrOfStr[1];
		System.out.println(medium);
		report.info("Successfully displayed medium of product");
	log.info("STEP#3: validating the medium of the project");
        String expectedmedium=page.getdata_fromExcel("TC04_Product Page", "Validation Text", "Medium"); 
        Verify.verifyString(medium, expectedmedium, "Successfully validated the medium of the product");
        System.out.println(expectedmedium);
        report.info("Successfully validated the medium of the product"); 
	}
}