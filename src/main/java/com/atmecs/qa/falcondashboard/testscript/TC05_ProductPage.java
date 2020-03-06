package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
import com.atmecs.qa.falcondashboard.validationresults.ProductPageValidation;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * 
 * @Author : srinischal.thiparani
 * @createdDate : 07-01-2020
 * @updatedDate : 04-02-2020
 * @updatedBy : T Sri Nischal
 * @testCasesCovered[Falcon-T05]
 *  
 */



//In this class the product name is validated and clicked and list of total test cases is displayed and dash board slider is selected
public class TC05_ProductPage extends TestSuiteBase {
	LoadProperties load=new LoadProperties();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	String sheetname="REST API TEST RESULT";
	String columnname="Validation Text";
	String testcases;
	String result;
	String expedctedproducts;
	static ExtentTest test;
	static ExtentReports extentreport;
	String actualtitle;
	@BeforeClass
	public static void startTest() {
		extentreport = new ExtentReports(ProjectBaseConstantPaths.EXTENT_REPORTFILE);
		test = extentreport.startTest("ProductPage");
	}
	/* 
	 * This test script covers the following functionalities of product page.
	 * 1. Validating the product name
	 * 2. Clicking on the product
	 * 3. Verifying the product page panel title 
	 * 4. List of the total test cases of the products is displayed  
	 * 5. List of products is converted into the string products
	 * 6. Verifying the list of test cases of the product
	 * 7. Dash board slider option of the product is selected or not 
	 */
	
	@Test
	public void productPage() throws Exception {
		Pageactions page=new Pageactions(browser);
		ProductPageValidation validate=new ProductPageValidation(browser);
		Waits.isElementVisible(browser.getDriver(), "loc.product.btn");
		actualtitle = browser.getCurrentPageTitle();
		ElementsList lists=new ElementsList(browser);
	log.info("STEP#1: Validating and displaying the product name");
		validate.validateProduct();
		report.info("Successfully validated product");
	log.info("STEP#2: Clicking on the product");	
        page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		Waits.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#3: Validating the product page panel title");
		validate.validatePanelTitle();
		report.info("Successfully validated panel title");
	log.info("STEP#4: List to display number of test cases present for a product");			
	    testcases=propReader.getValue("loc.numberoftestcases.txt");
        lists.listofElements(testcases);
    log.info("STEP#5: Converting the list of products into string products");	
		lists.separatingElements(testcases);
   log.info("STEP#6: Verifying the list of products");
		result = lists.separatingElements(testcases);
		page.writedata_toExcel(sheetname, columnname, 20, result);
		expedctedproducts=page.getdata_fromExcel(sheetname, columnname, "List of Test Cases");
		Verify.verifyString(result, expedctedproducts, "Validating the test cases of the product is same as expected or not");
		report.info("Successfully valdated all the test cases");
	log.info("STEP#7: Selecting the dashboard slider option");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");	
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
		// logic

		
		/*
		 * String productName = "read from ui"; ReadDataFromExcel readData = new
		 * ReadDataFromExcel(); Filters
		 * filters=readData.getFiltersData(browser).get(productName);
		 * filters.getEnvironmentName();
		 */

	}