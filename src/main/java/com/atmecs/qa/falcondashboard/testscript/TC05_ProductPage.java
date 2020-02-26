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
//In this class product page is tested
public class TC05_ProductPage extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	/*
	 * In this method the product name is validated and clicked on the product and
	 * checking user landed on the product page and validate the list of products
	 */
	@SuppressWarnings("static-access")
	@Test
	public void productPage() throws Exception {
		Waits wait=new Waits(browser);
		ElementsList lists=new ElementsList(browser);
		Pageactions page = new Pageactions(browser);
		ProductPageValidation validate = new ProductPageValidation(browser);
		wait.isElementVisible(browser.getDriver(), "loc.product.btn");
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