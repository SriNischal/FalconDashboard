package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.TestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 02-01-2020
 * @updatedDate : 31-01-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T02]
 *  
 */

//In this the list of products and the recent execution times are validated and clicked on the product
public class TC02_ClickingProduct extends TestSuiteBase {
	ReadingData data = new ReadingData();
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String result;
	String expedctedproducts;
	String time;
	String timeofexecution;
	String products;
	String expedctedtime;
	String actualtitle;
	/* 
	 * This test script covers the following functionalities of dashboard page.
	 * 1. List of the products available and the size of the products
	 * 2. The list of products converted into string of products
	 * 3. Verifying the list of products 
	 * 4. List of the recent execution times of the products
	 * 5. Verifying whether the product is clicked or not 
	 */
	@Test
	public void clickingProduct() throws Exception {
		ElementsList lists = new ElementsList(browser);
		Pageactions page = new Pageactions(browser);
	    Waits.isElementVisible(browser.getDriver(), "loc.products.txt");
	log.info("STEP#1: List to get all the products and size of products  present on the dashboard page");
		products = propReader.getValue("loc.products.txt");
		lists.listofElements(products);
	log.info("STEP#2: Converting the list of products into string products");
		lists.separatingElements(products);
	log.info("STEP#3: Verifying the list of products");
		result = lists.separatingElements(products);
		page.writedata_toExcel(sheetname, columnname, 11, result);
		expedctedproducts = page.getdata_fromExcel(sheetname, columnname, "Products Texts");
		Verify.verifyString(result, expedctedproducts, "Validating the product names is same as expected or not");
		report.info("Successfully valdated all the products");
	log.info("STEP#4: To get list of product on dashboard page according to the recent execution time");
		time = propReader.getValue("loc.executiontime.txt");
		lists.listofElements(time);
		timeofexecution=lists.separatingElements(time);
		report.info("Successfully displayed the execution times");
		page.writedata_toExcel(sheetname, columnname, 12, timeofexecution);
		expedctedtime = page.getdata_fromExcel(sheetname, columnname, "Products Recent Execution time");
		Verify.verifyString(timeofexecution, expedctedtime, "Validating the recent execution times of the products is same as expected or not");
		report.info("Successfully valdated all the recent execution times");
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
	log.info("STEP#5: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		page.windowHandle();
	}
		/*
		 * log.info("STEP#7: Clicking on each every product "); for (int x = 0; x <
		 * index; x++) { WebElement client = list.get(x); client.click();
		 * page.clickOnElement(read.getPropertyvalue("loc.product.txt",
		 * ProjectBaseConstantPaths.LOCATORS_FILE));
		 * report.info("Successfully clicked on product");
		 * browser.getWait().safeWait(3000);
		 * page.clickOnElement(read.getPropertyvalue("loc.dashboard.btn",
		 * ProjectBaseConstantPaths.LOCATORS_FILE)); browser.getWait().safeWait(2000);
		 */

	}

/*
 * log.info("STEP#6: Clicking on the product"); //for (int x = 0; x < index;
 * x++) { //WebElement client = list.get(x); //client.click();
 * page.clickOnElement(read.getPropertyvalue("loc.product.txt",
 * ProjectBaseConstantPaths.LOCATORS_FILE));
 * report.info("Successfully clicked on product");
 * //browser.getWait().safeWait(3000);
 * //page.clickOnElement(read.getPropertyvalue("loc.dashboard.btn",
 * ProjectBaseConstantPaths.LOCATORS_FILE)); //browser.getWait().safeWait(2000);
 */