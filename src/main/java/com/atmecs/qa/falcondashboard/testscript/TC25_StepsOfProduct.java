package com.atmecs.qa.falcondashboard.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.falcondashboard.constants.ProjectBaseConstantPaths;
import com.atmecs.qa.falcondashboard.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.falcondashboard.utils.LoadProperties;
import com.atmecs.qa.falcondashboard.utils.LogReport;
import com.atmecs.qa.falcondashboard.utils.Pageactions;
import com.atmecs.qa.falcondashboard.utils.PropReader;
import com.atmecs.qa.falcondashboard.utils.ReadLocators;
import com.atmecs.qa.falcondashboard.validationresults.ProductStepsValidation;

public class TC25_StepsOfProduct extends SampleTestSuiteBase{
	LoadProperties load=new LoadProperties();
	LogReport log=new LogReport();
	ReadLocators read=new ReadLocators();
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
	public void stepsOfProduct() throws Exception {
		Pageactions page=new Pageactions(browser);
		ProductStepsValidation validate=new ProductStepsValidation(browser);
	log.info("STEP#1: Clicking on the product");	
		page.clickOnElement(read.getPropertyvalue("loc.product.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the product");
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	log.info("STEP#2: Selecting the pass option from the status dropdown");	
		page.clickOnElement(read.getPropertyvalue("loc.passselectstatus.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected pass option");
	log.info("STEP#3: Creating the list for the test cases and duration of each test case of the product");	
	    String duration=propReader.getValue("loc.duration.txt");
		List<WebElement> list = browser.getFindFromBrowser().findElementsByXpath(duration);
		log.dateinfo(list.size());
		List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(texts);
	log.info("STEP#4: Creating the list for the status of the product");
	     String passtestcases=propReader.getValue("loc.passtestcases.txt");
		List<WebElement> statuslist = browser.getFindFromBrowser().findElementsByXpath(passtestcases);
		log.dateinfo(statuslist.size());
		List<String> statustexts = statuslist.stream().map(WebElement::getText).collect(Collectors.toList());
		log.info(statustexts);
	log.info("STEP#5: Clicking on the test case of the product");
		page.clickOnElement(read.getPropertyvalue("loc.testcase.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully selected the testcase");
		browser.getWait().safeWait(2000);
	log.info("STEP#6: Validating the status option");
		validate.validateStatusOption();
		report.info("Successfully validated Status option");
	log.info("STEP#7: Validating the details option");
		validate.validateDetailsOption();
		report.info("Successfully validated Details option");
	log.info("STEP#8: Validating the test case option");
		validate.validateTestCase();
		report.info("Successfully validated the test case");
	log.info("STEP#9: Validating the Request bpody text");
		validate.validateRequestBody();
		report.info("Successfully validated Request Body");
		
		
	}

}