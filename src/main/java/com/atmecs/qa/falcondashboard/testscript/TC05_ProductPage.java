package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;
import com.atmecs.qa.falcondashboard.validationresults.ProductPageValidation;

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
public class TC05_ProductPage extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
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
		Waits wait=new Waits(browser);
		Pageactions page=new Pageactions(browser);
		ProductPageValidation validate=new ProductPageValidation(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
		ElementsList lists=new ElementsList(browser);
	log.info("STEP#1: Validating and displaying the product name");
		validate.validateProduct();
		report.info("Successfully validated product");
	log.info("STEP#2: Clicking on the product");	
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		wait.isElementVisible(browser.getDriver(), "loc.numberoftestcases.txt");
	log.info("STEP#3: Validating the product page panel title");
		validate.validatePanelTitle();
		report.info("Successfully validated panel title");
	log.info("STEP#4: List to display number of test cases present for a product");			
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
        lists.listofElements(testcases);
    log.info("STEP#5: Converting the list of products into string products");	
		lists.separatingElements(testcases);
   log.info("STEP#6: Verifying the list of products");
		String result = lists.separatingElements(testcases);
		page.writedata_toExcel("REST API TEST RESULT", "Validation Text", 20, result);
		String expedctedproducts=page.getdata_fromExcel("REST API TEST RESULT", "Validation Text", "List of Test Cases");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the test cases");
		report.info("Successfully valdated all the test cases");
	log.info("STEP#7: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");	
		// logic

		
		/*
		 * String productName = "read from ui"; ReadDataFromExcel readData = new
		 * ReadDataFromExcel(); Filters
		 * filters=readData.getFiltersData(browser).get(productName);
		 * filters.getEnvironmentName();
		 */

	}
}