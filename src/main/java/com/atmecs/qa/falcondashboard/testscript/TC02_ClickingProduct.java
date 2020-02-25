package com.atmecs.qa.falcondashboard.testscript;

import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.helper.ValidationHelper;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.ElementsList;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.utils.Waits;

//In this class we test the product is clicked or not 
public class TC02_ClickingProduct extends SampleTestSuiteBase {
	ReadingData data = new ReadingData();
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;

	/*
	 * In this we generate a list to see whether all the products are present
	 * according to the recent execution times and click on the project
	 */
	@SuppressWarnings("static-access")
	@Test
	public void clickingProduct() throws Exception {
		Waits wait=new Waits(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		ElementsList lists = new ElementsList(browser);
		Pageactions page = new Pageactions(browser);
		wait.isElementVisible(browser.getDriver(), "loc.products.txt");
	log.info("STEP#1: List to get all the products and size of elements  present on the dashboard page");
		String products = propReader.getValue("loc.products.txt");
		lists.listofElements(products);
	log.info("STEP#2: Converting the list of products into string products");
		lists.separatingElements(products);
	log.info("STEP#3: Verifying the list of products");
		String product = helper.getData();
		String result = lists.separatingElements(products);
		page.writedata_toExcel(product, "Validation Text", 11, result);
		String expedctedproducts = page.getdata_fromExcel(product, "Validation Text", "Products Texts");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the products");
		report.info("Successfully valdated all the products");
	log.info("STEP#4: To get list of product on dashboard page according to the recent execution time");
		String time = propReader.getValue("loc.executiontime.txt");
		lists.listofElements(time);
		String timeofexecution=lists.separatingElements(time);
		report.info("Successfully displayed the execution times");
		page.writedata_toExcel(product, "Validation Text", 12, timeofexecution);
		String expedctedtime = page.getdata_fromExcel(product, "Validation Text", "Products Recent Execution time");
		Verify.verifyString(timeofexecution, expedctedtime, "Successfully validaetd the products");
		report.info("Successfully valdated all the recent execution times");
	log.info("STEP#5: Clicking on the product");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		page.windowHandle();
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
