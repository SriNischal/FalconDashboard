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
import com.atmecs.qa.falcondashboard.utils.Splitting;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 07-01-2020
 * @updatedDate : 04-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T06]
 *  
 */

//In this class the medium of the product is displayed and validated
public class TC06_ProductMedium extends TestSuiteBase{
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	LoadProperties load =new LoadProperties();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String product;
	String expectedmedium;
	/* 
	 * This test script covers the following functionalities of product  page.
	 * 1. The product is clicked
	 * 2. The medium of the product is displayed
	 * 3. Verifying the medium of the products
	 */
	@Test
	public void mediumOfProduct() throws Exception {
		Splitting split=new Splitting(browser);
		Pageactions page=new Pageactions(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#1: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		Waits.isElementVisible(browser.getDriver(),"loc.product.txt");
	log.info("STEP#2: Splitting the array and displaying the medium of the product");
		product = split.splitofarray(1);
		System.out.println(product);
		report.info("Successfully displayed medium of product");
	log.info("STEP#3: validating the medium of the project");
	    page.writedata_toExcel(sheetname, columnname, 19, product);
        expectedmedium=page.getdata_fromExcel(sheetname, columnname, "Medium"); 
        Verify.verifyString(product, expectedmedium, "Validating the medium of the product is same as expected or not");
        report.info("Successfully validated the medium of the product"); 
        page.windowHandle();
	}
	}