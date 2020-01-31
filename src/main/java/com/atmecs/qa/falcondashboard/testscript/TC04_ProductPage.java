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
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.ProductPageValidation;

public class TC04_ProductPage extends SampleTestSuiteBase {
	ReadLocators read = new ReadLocators();
	ReadingData data = new ReadingData();
	LogReport log = new LogReport();
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: " + br);
		browser.openURL("http://10.10.10.231:8082/#/app/dashboard", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings("static-access")
	@Test
	public void productpage() throws Exception {
		Pageactions page = new Pageactions(browser);
		ProductPageValidation validate = new ProductPageValidation(browser);
		validate.validateproduct();
		report.info("Successfully validated product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		validate.validatepanelitle();
		report.info("Successfully validated panel title");
		page.clickOnElement(read.getPropertyvalue("loc.download.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Clicked on download option");
		page.clickOnElement(read.getPropertyvalue("loc.dashboardslider.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected dashboard option");

		validate.validateEnvironment();
		report.info("Successfully validated environment");
		validate.validateTestPhase();
		report.info("Successfully validated test phase");

		@SuppressWarnings("deprecation")
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath("//tr[@class='ng-scope']");
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
