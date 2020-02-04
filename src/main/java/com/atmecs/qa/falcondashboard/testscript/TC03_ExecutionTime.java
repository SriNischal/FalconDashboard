package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;

public class TC03_ExecutionTime extends SampleTestSuiteBase {
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	LogReport log = new LogReport();
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;

	@BeforeTest
	@Parameters({ "os", "osVersion", "browser", "browserVersion" })
	public void setup(String os, String osVersion, String br, String browserVersion) throws Exception {
		report.info("Opening browser: " + br);
		@SuppressWarnings("static-access")
		String url = load.readConfigfile("Dashboard_URL", ProjectBaseConstantPaths.CONFIG_FILE);
		browser.openURL(url, os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void executionTimeOfProduct() throws Exception {
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: To get size and list of products on dashboard page");
	    String product=propReader.getValue("loc.products.txt");
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(product);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
	log.info("STEP#2: To get size and list of components of product on dashboard page");
	    String component=propReader.getValue("loc.componentofproduct.btn");
		List<WebElement> number = browser.getFindFromBrowser()
				.findElementsByXpath(component);
		log.dateinfo(number.size());
		List<String> products = number.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(products);
		report.info("Latest execution and medium of the product are displayed");
	log.info("STEP#3: To get size and list of recent execution time of product on dashboard page");
	    String recentexecutiontime=propReader.getValue("loc.recentexectiontime.txt");
		List<WebElement> time = browser.getFindFromBrowser().findElementsByXpath(recentexecutiontime);
		log.dateinfo(number.size());
		List<String> recenttime = time.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(recenttime);
		report.info("Latest execution and medium of the product are displayed");	
	log.info("STEP#3: Displaying the testcases for the products");
		page.clickOnElement(read.getPropertyvalue("number_of_testcases", ProjectBaseConstantPaths.LOCATORS_FILE));
		log.info("Test cases are displayed");
	log.info("STEP#4: Clicking on the product");
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully cilcked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
