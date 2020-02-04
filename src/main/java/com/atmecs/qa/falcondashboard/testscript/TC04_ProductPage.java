package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.Filters;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.ProductPageValidation;

public class TC04_ProductPage extends SampleTestSuiteBase {
	LoadProperties load=new LoadProperties();
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url=load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void productPage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ProductPageValidation validate = new ProductPageValidation(browser);
	log.info("STEP#1: Validating the product name");
		validate.validateProduct();
		report.info("Successfully validated product");
	log.info("STEP#2: Clicking on the product");	
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#3: Validating the product page panel title");
		validate.validatePanelTitle();
		report.info("Successfully validated panel title");
	log.info("STEP#4: Clicking on the download option");
		page.clickOnElement(read.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");
	log.info("STEP#5: Selecting the dashboard slider option");
	    page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");
	log.info("STEP#6: Validating the environment of the product");
		validate.validateEnvironment();
		report.info("Successfully validated environment");
	log.info("STEP#7: Validating the test phase of the product");	
		validate.validateTestPhase();
		report.info("Successfully validated test phase");
	log.info("STEP#8: List to display number of test cases present for a product");			
	    String testcases=propReader.getValue("loc.numberoftestcases.txt");
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(testcases);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// logic

		/*
		 * String productName = "read from ui"; ReadDataFromExcel readData = new
		 * ReadDataFromExcel(); Filters
		 * filters=readData.getFiltersData(browser).get(productName);
		 * filters.getCustomerName();
		 */

	}
}
