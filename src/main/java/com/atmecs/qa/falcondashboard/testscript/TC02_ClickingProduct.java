package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.springframework.data.domain.Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.RandomNumber;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.utils.ReadingData;
import com.atmecs.qa.falcondashboard.validationresults.DashboardPageValidation;
//In this class we test the product is clicked or not 
public class TC02_ClickingProduct extends SampleTestSuiteBase {
	ReadLocators read=new ReadLocators();
	ReadingData data=new ReadingData();
	LoadProperties load=new LoadProperties();
	LogReport log = new LogReport();
	PropReader propReader = new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	final String moduleName = "Publish";
	XlsReader xlsReader = null;
	String adminUsername = null;
	String adminPassword = null;
	int row = 0;

	//In this method the browser is invoked and url is opened
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
	
	/*
	 * In this we generate a list to see whether all the products are persent
	 * according to the recent execution times and click on the project
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void clickingProduct() throws Exception{
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: List to get all the products and size of elements  present on the dashboard page");
	    String products=propReader.getValue("loc.products.txt");
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(products);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
	log.info("STEP#2: Converting the list of products into string products");	
		String separate = ",";
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (index < texts.size() - 1) {
			sb.append(texts.get(index));
			sb.append(separate);
			index++;
		}
		sb.append(texts.get(index));
   log.info("STEP#3: Verifying the list of products");
		String result = sb.toString();
		String expedctedproducts=page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Number of products");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the products");
		report.info("Successfully valdated all the products");
	log.info("STEP#4: To get list of product on dashboard page according to the recent execution time");
	    String time=propReader.getValue("loc.executiontime.txt");
		List<WebElement> executiontime = browser.getFindFromBrowser()
				.findElementsByXpath(time);
		log.dateinfo(executiontime.size());
		List<String> executedtime = executiontime.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(executedtime);
	log.info("STEP#5: Verifying the list of execution time");
	    String actualresult = sb.toString();
		String expedctedexecutiontime=page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Number of products");
		Verify.verifyString(actualresult, expedctedexecutiontime, "Successfully validaetd the products");
		report.info("Successfully valdated all the execution times");
	log.info("STEP#6: Clicking on the product");
        page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
