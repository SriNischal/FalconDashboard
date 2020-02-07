package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
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

public class TC03_TestCases extends SampleTestSuiteBase {
	public static WebDriver driver;
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

	@SuppressWarnings( { "static-access", "deprecation" } )
	@Test
	public void numberofTestCasesOfProduct() throws Exception {
		Pageactions page = new Pageactions(browser);
	log.info("STEP#1: Creating list to display total test cases of the products");	
		String products=propReader.getValue("loc.totaltestcase.txt");
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
		String expedctedproducts=page.getdata_fromExcel("TC01_DasBoardPage", "Validation Text", "Total test cases");
		Verify.verifyString(result, expedctedproducts, "Successfully validaetd the test cases");
		report.info("Successfully valdated all the test cases");
	log.info("STEP#4: Mouse hovering the testcases for the products");
	     page.mouseOver(read.getPropertyvalue("loc.testcases.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	     report.info("Successfully mouse hovered the test cases");
	log.info("STEP#5: Displaying the testcases message for the products");	
	     String actualtooltipmessage=propReader.getValue("loc.testcasemessage.txt");
	     String message=browser.getFindFromBrowser().findElementByXpath(actualtooltipmessage).getText();
	     System.out.println(message);
	     String expectedtooltipmessage=page.getdata_fromExcel("TC10_TestCases", "Validation Text", "Tooltip message");
	     Verify.verifyString(message, expectedtooltipmessage, "Successfully displayed the test cases message");
	     System.out.println(expectedtooltipmessage);
	}

}
